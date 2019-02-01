package com.spaceship.protocal.resources;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spaceship.protocal.exception.ProtocalException;
import com.spaceship.protocal.model.vo.game.fire.SalvoShotRequest;
import com.spaceship.protocal.model.vo.game.fire.SalvoShotResponse;
import com.spaceship.protocal.service.IGameService;
import com.spaceship.protocal.validator.SalvoShotValidator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This is salvo shot resources handle all fire operation in protocal API.
 *
 * @author Simon Ghobreil.
 */
@RepositoryRestController
@RequestMapping("/xl-spaceship/protocol/game")
@Api(value = "GameResource", produces = "application/json")
public class SalvoShotsResource {

    private static final Logger LOGGER = Logger.getLogger(SalvoShotsResource.class);

    private static final String EXCEPTION_MESSAGE = "Something went wrong!";

    @Autowired
    private IGameService gameService;

    @Autowired
    private SalvoShotValidator salvoShotValidator;

    @InitBinder
    protected void gameRequestValidator(WebDataBinder binder) {
        binder.addValidators(salvoShotValidator);
    }

    @ApiOperation(value = "Receive fire")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "request processed successfully"), @ApiResponse(code = 404, message = "Game finished can't fire anymore!"),
            @ApiResponse(code = 500, message = "Somthing went wrong!"), @ApiResponse(code = 503, message = "Service is down!"),
            @ApiResponse(code = 509, message = "Salvoshot is more than your spaceships") })
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json", value = "/{id}")
    public ResponseEntity<SalvoShotResponse> receiveFire(@Valid @RequestBody SalvoShotRequest salvoShot, @PathVariable("id") String gameId) {

        LOGGER.debug("SalvoShotsResource - receiveFire start");

        try {
            Assert.hasText(gameId, "game id is empty!");
            return new ResponseEntity<>(gameService.receiveSalvoShot(salvoShot, gameId), HttpStatus.OK);

        } catch (IllegalArgumentException exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ProtocalException exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            return new ResponseEntity<>(exception.getHttpStatus());
        } catch (Exception exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Get Salvo Shots Number")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "request processed successfully"), @ApiResponse(code = 500, message = "Somthing went wrong!") })
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "getsalvoshotcount/{id}")
    public ResponseEntity<Integer> getSalvoShotsNumber(@PathVariable("id") String gameId) {

        LOGGER.debug("SalvoShotsResource - getSalvoShotsNumber start");

        try {
            Assert.hasText(gameId, "game id is empty!");
            return new ResponseEntity<>(gameService.getSalvoShotCount(gameId), HttpStatus.OK);

        } catch (IllegalArgumentException exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ProtocalException exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            return new ResponseEntity<>(exception.getHttpStatus());
        } catch (Exception exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

}
