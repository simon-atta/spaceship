package com.spaceship.user.resources;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spaceship.user.model.entities.User;
import com.spaceship.user.model.vo.UserVo;
import com.spaceship.user.services.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * This is User end point will be responable for operations .
 *
 * @author Simon Ghobreil.
 */
@RepositoryRestController
@RequestMapping("/xl-spaceship/user")
@Api(value = "UserResource", produces = "application/json")
public class UserResource {

    private static final Logger LOGGER = Logger.getLogger(UserResource.class);

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "Get user by username")
    @RequestMapping(method = RequestMethod.GET, path = "/getUserByUserName", produces = "application/json")
    public ResponseEntity<User> getUserByUserName(@RequestParam String userId) {

        LOGGER.info("Entered get user by username");

        try {
            return new ResponseEntity<User>(userService.getUserByUserName(userId), HttpStatus.OK);
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Get all users")
    @RequestMapping(method = RequestMethod.GET, path = "/getAllUsers", produces = "application/json")
    public ResponseEntity<List<UserVo>> getAllUsers() {

        LOGGER.info("Entered get all user");

        try {

            return new ResponseEntity<List<UserVo>>(userService.getAllUsers(), HttpStatus.OK);
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
            return new ResponseEntity<List<UserVo>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "get all opponent users")
    @RequestMapping(method = RequestMethod.GET, path = "/getAllOpponentUsers", produces = "application/json")
    public ResponseEntity<List<UserVo>> getAllOpponentUsers(@RequestParam String userId) {

        LOGGER.info("Entered get all opponent users");

        try {

            return new ResponseEntity<List<UserVo>>(userService.getAllOpponentUsers(userId), HttpStatus.OK);
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
            return new ResponseEntity<List<UserVo>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Create User")
    @RequestMapping(method = RequestMethod.POST, path = "/createUser", produces = "application/json")
    public ResponseEntity<User> createUser(@Valid @RequestBody User pUser) {

        LOGGER.info("Entered create user");

        try {
            userService.createUser(pUser);
            return new ResponseEntity<User>(HttpStatus.OK);
        } catch (DataIntegrityViolationException exception) {
            LOGGER.error(exception.getMessage());
            return new ResponseEntity<User>(HttpStatus.CONFLICT);
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
