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
import org.springframework.web.bind.annotation.RequestParam;

import com.spaceship.exceptions.XLSpaceshipException;
import com.spaceship.model.entities.Spaceship;
import com.spaceship.model.vo.board.SpaceshipBoardResponse;
import com.spaceship.model.vo.ship.XLSpaceshipRequest;
import com.spaceship.services.IBoardService;
import com.spaceship.services.ISpaceshipService;
import com.spaceship.validator.XLSpaceshipRequestValidator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This is XL-Spaceship resource will handle all operations for XL-Spaceship.
 *
 * @author Simon Ghobreil.
 */
@RepositoryRestController
@RequestMapping("/xl-spaceship")
@Api(value = "XLSpaceshipResource", produces = "application/json")
public class XLSpaceshipResource {

    private static final Logger LOGGER = Logger.getLogger(XLSpaceshipResource.class);
    private static final String EXCEPTION_MESSAGE = "Something wrong happened!";

    @Autowired
    private ISpaceshipService spaceshipService;

    @Autowired
    private IBoardService boardService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new XLSpaceshipRequestValidator());
    }

    @ApiOperation(value = "Initialize XL-spaceship")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 500, message = "Something wrong happened!"),
            @ApiResponse(code = 403, message = "Spaceship already assigned!") })
    @RequestMapping(method = RequestMethod.POST, path = "/initialize", produces = "application/json")
    public ResponseEntity<Void> initializeSpaceship(@Valid @RequestBody XLSpaceshipRequest xLSpaceshipRequest) {

        LOGGER.debug("XLSpaceshipResource - initializeSpaceship : Started");

        try {
            spaceshipService.assignUserToSpaceship(xLSpaceshipRequest);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (XLSpaceshipException exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            return new ResponseEntity<>(exception.getHttpStatus());
        } catch (Exception exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "List of all XL-spaceship")
    @RequestMapping(method = RequestMethod.GET, path = "/getxlspaceshipslist", produces = "application/json")
    public ResponseEntity<List<Spaceship>> getSpaceshipsList() {
        LOGGER.debug("XLSpaceshipResource - getSpaceshipsList : Started");
        try {
            return new ResponseEntity<>(spaceshipService.getSpaceshipsList(), HttpStatus.OK);
        } catch (Exception exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Get XL-Spaceship by user id")
    @RequestMapping(method = RequestMethod.GET, path = "/getxlspaceshipsbyuserId", produces = "application/json")
    public ResponseEntity<List<Spaceship>> getSpaceshipsByUserId(@RequestParam String userId) {
        LOGGER.debug("XLSpaceshipResource - getSpaceshipsByUserId : Started");
        try {
            return new ResponseEntity<>(spaceshipService.getSpaceshipsByUserId(userId), HttpStatus.OK);
        } catch (Exception exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Get XL-Spaceship board")
    @RequestMapping(method = RequestMethod.GET, path = "/getspaceshipboard", produces = "application/json")
    public ResponseEntity<SpaceshipBoardResponse> getSpaceShipBoard() {
        LOGGER.debug("XLSpaceshipResource - getSpaceShipBoard : Started");
        try {
            return new ResponseEntity<>(boardService.getSpaceshipBoard(), HttpStatus.OK);
        } catch (Exception exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Get XL-Spaceship by id")
    @RequestMapping(method = RequestMethod.GET, path = "/getxlspaceshipbyid", produces = "application/json")
    public ResponseEntity<Spaceship> getSpaceshipByid(@RequestParam Long spaceshipId) {

        LOGGER.debug("XLSpaceshipResource - getSpaceshipByid : Started");

        try {
            return new ResponseEntity<>(spaceshipService.getSpaceshipsById(spaceshipId), HttpStatus.OK);
        } catch (Exception exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
