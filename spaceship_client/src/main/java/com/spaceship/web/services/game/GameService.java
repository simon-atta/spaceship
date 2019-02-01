package com.spaceship.web.services.game;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spaceship.client.model.InlineResponse2001;
import com.spaceship.protocal.client.ProtocalApiException;
import com.spaceship.protocal.client.api.GameresourceApi;
import com.spaceship.protocal.client.model.GamePlayer;
import com.spaceship.protocal.client.model.GamePlayer.PlayerTypeEnum;
import com.spaceship.protocal.client.model.GameRequest;
import com.spaceship.protocal.client.model.GameResponse;
import com.spaceship.protocal.client.model.GameStatusResponse;
import com.spaceship.protocal.client.model.XLSpaceshipProtocol;
import com.spaceship.user.client.UserApiException;
import com.spaceship.user.client.model.FireSalvoShots;
import com.spaceship.user.client.model.PUser;
import com.spaceship.user.client.model.SalvoShot;
import com.spaceship.web.services.spaceships.ISpaceshipService;
import com.spaceship.web.services.user.IUserService;

@Component
public class GameService implements IGameService {

    private GameresourceApi gameResourceApi = new GameresourceApi();

    @Autowired
    private IUserService userService;

    @Autowired
    private ISpaceshipService spaceshipService;

    @Override
    public GameResponse createNewGame(String userId, String spaceshipId) throws UserApiException, com.spaceship.client.ApiException, com.spaceship.protocal.client.ProtocalApiException {
        GameRequest gameRequest = new GameRequest();

        gameRequest.addPlayersItem(getChallengerPlayer(userId));
        gameRequest.addPlayersItem(getSecondPlayer(spaceshipId));
        return gameResourceApi.createNewGameUsingPOST(gameRequest);
    }

    @Override
    public GameResponse createNewGame(String userId, String spaceshipId, String assmentSpaceshipId)
            throws UserApiException, com.spaceship.client.ApiException, com.spaceship.protocal.client.ProtocalApiException {
        GameRequest gameRequest = new GameRequest();

        gameRequest.addPlayersItem(getChallengerPlayer(userId, spaceshipId));
        gameRequest.addPlayersItem(getSecondPlayer(assmentSpaceshipId));
        return gameResourceApi.createNewGameUsingPOST(gameRequest);
    }

    @Override
    public List<GameResponse> getAllGamesByUserId(String userId) throws com.spaceship.protocal.client.ProtocalApiException {
        return gameResourceApi.getAllGamesByUserIdUsingGET(userId);
    }

    private GamePlayer getSecondPlayer(String spaceshipId) throws com.spaceship.client.ApiException, UserApiException {
        InlineResponse2001 spaceship = spaceshipService.getSpaceshipById(Long.parseLong(spaceshipId));
        PUser user = userService.getUserByUserName(spaceship.getUserId());

        return getPlayer(user, spaceship, PlayerTypeEnum.ASSESSMENT);
    }

    private GamePlayer getChallengerPlayer(String userId, String spaceshipId) throws UserApiException, com.spaceship.client.ApiException {
        PUser user = userService.getUserByUserName(userId);
        InlineResponse2001 spaceship = spaceshipService.getSpaceshipById(Long.valueOf(spaceshipId));
        return getPlayer(user, spaceship, PlayerTypeEnum.OPPONENT);
    }

    private GamePlayer getChallengerPlayer(String userId) throws UserApiException, com.spaceship.client.ApiException {
        PUser user = userService.getUserByUserName(userId);
        List<InlineResponse2001> spaceships = spaceshipService.getSpaceshipsByUserName(userId);
        return getPlayer(user, spaceships.get(0), PlayerTypeEnum.OPPONENT);
    }

    private GamePlayer getPlayer(PUser user, InlineResponse2001 spaceship, PlayerTypeEnum playerType) {
        GamePlayer player = new GamePlayer();
        player.setFullName(user.getFullName());
        player.setPlayerType(playerType);
        player.setUserId(user.getUserId());
        player.setSpaceshipProtocol(getSpaceShipProtocal(spaceship.getSpaceshipAddress()));
        return player;
    }

    private XLSpaceshipProtocol getSpaceShipProtocal(String spaceshipAddress) {
        XLSpaceshipProtocol spaceShipProtocal = new XLSpaceshipProtocol();
        spaceShipProtocal.setHostname(spaceshipAddress.substring(0, spaceshipAddress.indexOf(':')));
        spaceShipProtocal.setPort(spaceshipAddress.substring(spaceshipAddress.indexOf(':') + 1));

        return spaceShipProtocal;
    }

    @Override
    public GameStatusResponse getGameStatus(String gameId) throws com.spaceship.protocal.client.ProtocalApiException {
        return gameResourceApi.getGameStatusUsingGET(gameId);
    }

    @Override
    public Integer getSalvoShotsNumber(String gameId) throws ProtocalApiException {
        return gameResourceApi.getSalvoShotsNumberUsingGET(gameId);
    }

    @Override
    public FireSalvoShots fireSalvoShots(String gameId, SalvoShot salvoShot) throws UserApiException {
        com.spaceship.user.client.api.GameresourceApi gameResource = new com.spaceship.user.client.api.GameresourceApi();
        return gameResource.fireSalvoShotsUsingPUT(gameId, salvoShot);
    }

    @Override
    public void enableDiableAutoPilot(String value, String gameId, String userId) throws ProtocalApiException {
        if ("enable".equals(value)) {
            gameResourceApi.enableAutoPilotUsingPUT(userId, gameId);
        } else {
            gameResourceApi.disableAutoPilotUsingPUT(userId, gameId);
        }
    }

    @Override
    public Boolean getAutoPilotStatus(String gameId, String userId) throws ProtocalApiException {
        return gameResourceApi.getAutoPilotStatusUsingGET(userId, gameId);
    }

}
