package com.spaceship.protocal.resources;

import java.util.List;

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

import com.spaceship.protocal.model.vo.game.create.GameRequest;
import com.spaceship.protocal.model.vo.game.create.GameResponse;
import com.spaceship.protocal.model.vo.game.status.GameStatusResponse;
import com.spaceship.protocal.service.IGameService;
import com.spaceship.protocal.validator.GameRequestValidator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This is game resource will be handle all operations for game in protocal API.
 *
 * @author Simon Ghobreil.
 */
@RepositoryRestController
@RequestMapping("/xl-spaceship/protocol/game")
@Api(value = "GameResource", produces = "application/json")
public class GameResource {

    private static final Logger LOGGER = Logger.getLogger(GameResource.class);
    private static final String EXCEPTION_MESSAGE = "Something went wrong!";

    @Autowired
    private IGameService gameService;

    @Autowired
    private GameRequestValidator gameRequestValidator;

    @InitBinder
    protected void gameRequestValidator(WebDataBinder binder) {
        binder.addValidators(gameRequestValidator);
    }

    @ApiOperation(value = "Create new game")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Game created successfully"),
            @ApiResponse(code = 500, message = "Somthing went wrong!") })
    @RequestMapping(method = RequestMethod.POST, path = "/new", produces = "application/json")
    public ResponseEntity<GameResponse> createNewGame(@Valid @RequestBody GameRequest pGameRequest) {

        LOGGER.debug("GameResource - createNewGame start");
        try {
            return new ResponseEntity<>(gameService.createNewGame(pGameRequest), HttpStatus.CREATED);
        } catch (Exception exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Get game status")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "request processed successfully"),
            @ApiResponse(code = 204, message = "game id is empty"),
            @ApiResponse(code = 500, message = "Somthing went wrong!") })
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/{id}")
    public ResponseEntity<GameStatusResponse> getGameStatus(@PathVariable("id") String gameId) {

        LOGGER.debug("GameResource - getGameStatus start");

        try {
            Assert.hasText(gameId, "game id is empty!");
            return new ResponseEntity<>(gameService.getGameStatus(gameId), HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Get all games by user id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "request processed successfully"),
            @ApiResponse(code = 204, message = "game id is empty"),
            @ApiResponse(code = 500, message = "Somthing went wrong!") })
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/getallgames/{id}")
    public ResponseEntity<List<GameResponse>> getAllGamesByUserId(@PathVariable("id") String userId) {

        LOGGER.debug("GameResource - getAllGamesByUserId start");

        try {
            Assert.hasText(userId, "user id is empty!");
            return new ResponseEntity<>(gameService.getGameList(userId), HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Enable auto pilot")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "request processed successfully"),
            @ApiResponse(code = 500, message = "Somthing went wrong!") })
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json", value = "/enableautopilot/{userid}/{gameId}")
    public ResponseEntity<Void> enableAutoPilot(@PathVariable("userid") String userId, @PathVariable("gameId") String gameId) {

        LOGGER.debug("GameResource - enableAutoPilot start");

        try {
            Assert.hasText(userId, "user id is empty!");
            Assert.hasText(gameId, "game id is empty!");
            gameService.enableDisableAutoPilot(gameId, userId, true);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Disable auto pilot")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "request processed successfully"),
            @ApiResponse(code = 500, message = "Somthing went wrong!") })
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json", value = "/disableautopilot/{userid}/{gameId}")
    public ResponseEntity<Void> disableAutoPilot(@PathVariable("userid") String userId, @PathVariable("gameId") String gameId) {

        LOGGER.debug("GameResource - disableAutoPilot start");

        try {
            Assert.hasText(userId, "user id is empty!");
            Assert.hasText(gameId, "game id is empty!");
            gameService.enableDisableAutoPilot(gameId, userId, false);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ApiOperation(value = "Get auto pilot")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "request processed successfully"),
            @ApiResponse(code = 500, message = "Somthing went wrong!") })
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/getAutoPilotStatus/{userid}/{gameId}")
    public ResponseEntity<Boolean> getAutoPilotStatus(@PathVariable("userid") String userId, @PathVariable("gameId") String gameId) {

        LOGGER.debug("GameResource - disableAutoPilot start");

        try {
            Assert.hasText(userId, "user id is empty!");
            Assert.hasText(gameId, "game id is empty!");
			return new ResponseEntity<>(gameService.getAutoPilotStatus(gameId, userId),HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
