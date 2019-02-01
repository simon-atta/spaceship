package com.spaceship.web.services.game;

import java.util.List;

import com.spaceship.protocal.client.ProtocalApiException;
import com.spaceship.protocal.client.model.GameResponse;
import com.spaceship.protocal.client.model.GameStatusResponse;
import com.spaceship.user.client.UserApiException;
import com.spaceship.user.client.model.FireSalvoShots;
import com.spaceship.user.client.model.SalvoShot;

public interface IGameService {

    GameResponse createNewGame(String userId, String spaceshipId) throws UserApiException, com.spaceship.client.ApiException, ProtocalApiException;

    GameResponse createNewGame(String userId, String spaceshipId, String assmentSpaceshipId) throws UserApiException, com.spaceship.client.ApiException, ProtocalApiException;

    List<GameResponse> getAllGamesByUserId(String id) throws ProtocalApiException;

    GameStatusResponse getGameStatus(String gameId) throws ProtocalApiException;

    Integer getSalvoShotsNumber(String gameId) throws ProtocalApiException;

    FireSalvoShots fireSalvoShots(String gameId, SalvoShot salvoShot) throws UserApiException;

    void enableDiableAutoPilot(String value, String gameId, String userId) throws ProtocalApiException;
    
    Boolean getAutoPilotStatus(String gameId, String userId) throws ProtocalApiException;

}
