package com.spaceship.services;

import java.util.List;

import com.spaceship.exceptions.XLSpaceshipException;
import com.spaceship.model.entities.Spaceship;
import com.spaceship.model.vo.ship.XLSpaceshipRequest;

public interface ISpaceshipService {

    /**
     * This method used to assign user to XL spaceship.
     *
     * @param spaceshipRequest
     *        XLSpaceshipRequest
     * @throws XLSpaceshipException
     */
    void assignUserToSpaceship(XLSpaceshipRequest spaceshipRequest) throws XLSpaceshipException;

    /**
     * This method used to load all XL spaceships registered into DB.
     *
     * @return list of spaceship.
     */
    List<Spaceship> getSpaceshipsList();

    /**
     * This method used to get all spaceship by user id, it will be used by web
     * client.
     *
     * @return list of spaceship.
     */
    List<Spaceship> getSpaceshipsByUserId(String userId);

    /**
     * This method used get spaceship by id.it will be used by web
     * client.
     *
     * @param spaceshipId
     *        Long
     * @return spaceship.
     */
    Spaceship getSpaceshipsById(Long spaceshipId);
}
