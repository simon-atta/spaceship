package com.spaceship.user.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spaceship.protocal.client.ProtocalApiException;
import com.spaceship.protocal.client.api.GameresourceApi;
import com.spaceship.user.exception.IntegrationException;
import com.spaceship.user.model.entities.User;
import com.spaceship.user.model.vo.SalvoShotRequest;
import com.spaceship.user.model.vo.SalvoShotResponse;
import com.spaceship.user.services.IGameService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This is game resource will handle all user games.
 *
 * @author Simon Ghobreil.
 */
@RepositoryRestController
@RequestMapping("/xl-spaceship/user/game")
@Api(value = "GameResource", produces = "application/json")
public class GameResource {

    private static final Logger LOGGER = Logger.getLogger(GameResource.class);

    @Autowired
    private IGameService gameService;

    @ApiOperation(value = "Fire against opponent")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "request processed successfully"), @ApiResponse(code = 404, message = "Game finished can't fire anymore!"),
            @ApiResponse(code = 500, message = "Somthing went wrong!"), @ApiResponse(code = 503, message = "Service is down!"),
            @ApiResponse(code = 509, message = "Salvoshot is more than your spaceships") })
    @RequestMapping(method = RequestMethod.PUT, path = "/{gameId}/fire", produces = "application/json")
    public ResponseEntity<SalvoShotResponse> fireSalvoShots(@PathVariable("gameId") String id, @Valid @RequestBody SalvoShotRequest salvoShot) {

        LOGGER.info("Entered fire against opponent");

        try {
            return new ResponseEntity<>(gameService.fireSalvoShots(salvoShot, id), HttpStatus.OK);
        } catch (IntegrationException exception) {
            LOGGER.error(exception);
            return new ResponseEntity<>(exception.getHttpStatus());
        } catch (Exception exception) {
            LOGGER.error(exception);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Auto pilot fire against opponent")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "request processed successfully"), @ApiResponse(code = 404, message = "Game finished can't fire anymore!"),
            @ApiResponse(code = 500, message = "Somthing went wrong!"), @ApiResponse(code = 503, message = "Service is down!"),
            @ApiResponse(code = 509, message = "Salvoshot is more than your spaceships") })
    @RequestMapping(method = RequestMethod.POST, path = "/game/{gameId}/auto", produces = "application/json")
    public ResponseEntity<SalvoShotResponse> fireAutoPilotSalvoShots(@PathVariable("gameId") String gameId) {

        LOGGER.info("Entered autp pilot fire against opponent");

        try {

            return new ResponseEntity<>(gameService.fireSalvoShots(getSalvoShots(gameId), gameId), HttpStatus.OK);
        } catch (IntegrationException exception) {
            LOGGER.error(exception);
            return new ResponseEntity<>(exception.getHttpStatus());
        } catch (Exception exception) {
            LOGGER.error(exception);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private SalvoShotRequest getSalvoShots(String gameId) {

        try {
            SalvoShotRequest salvoShotRequest = new SalvoShotRequest();
            List<String> salvoShots = new ArrayList<>();
            GameresourceApi gameResourceApi = new GameresourceApi();
            Integer numberOfShots = gameResourceApi.getSalvoShotsNumberUsingGET(gameId);

            for (int index = 0; index < numberOfShots; index++) {
                salvoShots.add(getRandomNumberInRange());
            }

            salvoShotRequest.setSalvo(salvoShots);
            return salvoShotRequest;

        } catch (ProtocalApiException e) {
            LOGGER.error(e);
        }

        return null;
    }

    private String getRandomNumberInRange() {
        int min = 0;
        int max = 16;
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        int x = r.nextInt((max - min) + 1) + min;
        int y = r.nextInt((max - min) + 1) + min;

        StringBuilder salvoShot = new StringBuilder();

        salvoShot.append(Integer.toHexString(x));
        salvoShot.append("x");
        salvoShot.append(Integer.toHexString(y));
        return salvoShot.toString();
    }

    @ApiOperation(value = "Get game status")
    @RequestMapping(method = RequestMethod.GET, path = "/{gameId}", produces = "application/json")
    public ResponseEntity<User> getGameStatus(@PathVariable("gameId") String id) {

        LOGGER.info("Entered get game status");

        try {

            return new ResponseEntity<User>(HttpStatus.OK);

        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
