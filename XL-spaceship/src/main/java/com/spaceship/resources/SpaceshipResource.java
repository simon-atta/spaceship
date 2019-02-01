package com.spaceship.resources;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spaceship.exceptions.SpaceshipBoardException;
import com.spaceship.model.board.SpaceShipShape;
import com.spaceship.model.vo.board.SpaceshipBoardBaseResponse;
import com.spaceship.model.vo.board.SpaceshipBoardRequest;
import com.spaceship.model.vo.board.SpaceshipSalvoShotsResponse;
import com.spaceship.model.vo.shot.SalvoShotRequest;
import com.spaceship.services.IBoardService;
import com.spaceship.validator.SpaceshipRequestValidator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Spaceship resource handle all operations for spaceship.
 *
 * @author Simon Ghobreil.
 */
@RepositoryRestController
@RequestMapping("/xl-spaceship/spaceships")
@Api(value = "SpaceshipsResource", produces = "application/json")
public class SpaceshipResource {

    private static final Logger LOGGER = Logger.getLogger(SpaceshipResource.class);

    private static final String EXCEPTION_MESSAGE = "Something wrong happened!";

    @Autowired
    private IBoardService boardService;

    @InitBinder(value="spaceshipBoardRequest")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new SpaceshipRequestValidator());
    }

    @ApiOperation(value = "Place spaceship into game board")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Game created successfully"), @ApiResponse(code = 403, message = "Spaceship is locked!"),
            @ApiResponse(code = 409, message = "Coordinates is busy by anther spaceship"), @ApiResponse(code = 302, message = "Spaceship already placed on board"),
            @ApiResponse(code = 500, message = "Something wrong happened!") })
    @RequestMapping(method = RequestMethod.POST, path = "/placespaceship", produces = "application/json")
    public ResponseEntity<SpaceshipBoardBaseResponse> placeSpaceship(@Valid @RequestBody SpaceshipBoardRequest spaceshipRequest) {
        LOGGER.debug("SpaceshipResource -  placeSpaceship : started");
        try {
            return new ResponseEntity<>(boardService.addSpaceshipToBoard(spaceshipRequest), HttpStatus.CREATED);
        } catch (SpaceshipBoardException exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            return new ResponseEntity<>(exception.getBoard(), exception.getHttpStatus());
        } catch (Exception exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Get spaceships shapes")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 500, message = "Something wrong happened!") })
    @RequestMapping(method = RequestMethod.GET, path = "/getspaceshipsshapes", produces = "application/json")
    public ResponseEntity<List<SpaceShipShape>> getSpaceShipsShapes() {
        LOGGER.debug("SpaceshipResource -  getSpaceShipsShapes : started");
        try {
            return new ResponseEntity<>(boardService.getSpaceshipsShape(), HttpStatus.OK);
        } catch (Exception exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Receive salvo shot")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 500, message = "Something wrong happened!") })
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<SpaceshipSalvoShotsResponse> receiveSalvoShot(@Valid @RequestBody SalvoShotRequest salvoShot) {
        LOGGER.debug("SpaceshipResource -  receiveSalvoShot : started");

        try {
            return new ResponseEntity<>(boardService.receiveSalvoShots(salvoShot), HttpStatus.OK);
        } catch (Exception exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Lock game board")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 500, message = "Something wrong happened!") })
    @RequestMapping(method = RequestMethod.PUT, path = "/lockboard", produces = "application/json")
    public ResponseEntity<Void> lockGameBoard() {
        LOGGER.debug("SpaceshipResource -  lockGameBoard : started");

        try {
            boardService.lockGameBoard();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Unlock game board")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 500, message = "Something wrong happened!") })
    @RequestMapping(method = RequestMethod.PUT, path = "/unlockboard", produces = "application/json")
    public ResponseEntity<Void> unLockGameBoard() {
        LOGGER.debug("SpaceshipResource -  unLockGameBoard : started");

        try {
            boardService.unLockGameBoard();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
