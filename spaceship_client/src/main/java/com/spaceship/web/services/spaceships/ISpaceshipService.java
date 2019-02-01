package com.spaceship.web.services.spaceships;

import java.util.List;

import com.spaceship.client.ApiException;
import com.spaceship.client.model.InlineResponse2001;
import com.spaceship.client.model.SpaceshipRequest;
import com.spaceship.web.model.spaceship.SpaceshipBoard;
import com.spaceship.web.model.spaceship.SpaceshipShape;

public interface ISpaceshipService {

    List<InlineResponse2001> getSpaceshipsByUserName(String userName) throws ApiException;

    InlineResponse2001 getSpaceshipById(Long spaceshipId) throws ApiException;

    List<InlineResponse2001> getAllSpaceships() throws ApiException;

    void assignXLSpaceshipToUser(String spaceshipId, String userId) throws ApiException;

    void addSpaceship(SpaceshipRequest spaceshipRequest, Long spaceshipAddress) throws ApiException;

    SpaceshipBoard getSpaceships(Long spaceshipId) throws ApiException;

    List<SpaceshipShape> getSpaceshipsShape(Long spaceshipId) throws ApiException;

}
