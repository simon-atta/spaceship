package com.spaceship.protocal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.spaceship.client.ApiException;
import com.spaceship.client.api.SpaceshipsresourceApi;
import com.spaceship.client.api.XlspaceshipresourceApi;
import com.spaceship.client.model.InlineResponse200;
import com.spaceship.client.model.InlineResponse2002;
import com.spaceship.client.model.InlineResponse2002SalvoShots;
import com.spaceship.protocal.exception.ProtocalException;
import com.spaceship.protocal.model.entities.Game;
import com.spaceship.protocal.model.entities.Player;
import com.spaceship.protocal.model.entities.SpaceShipProtocal;
import com.spaceship.protocal.model.vo.game.GameStatusType;
import com.spaceship.protocal.model.vo.game.create.GameRequest;
import com.spaceship.protocal.model.vo.game.create.GameResponse;
import com.spaceship.protocal.model.vo.game.create.PlayerType;
import com.spaceship.protocal.model.vo.game.fire.SalvoShotRequest;
import com.spaceship.protocal.model.vo.game.fire.SalvoShotResponse;
import com.spaceship.protocal.model.vo.game.status.GameStatusResponse;
import com.spaceship.protocal.model.vo.game.status.GameStatusSpaceship;
import com.spaceship.protocal.repositories.GameRepo;
import com.spaceship.protocal.repositories.PlayerRepo;

@Service
public class GameService implements IGameService {

    private static final Logger LOGGER = Logger.getLogger(GameService.class);

    @Autowired
    private GameRepo gameRepo;

    @Autowired
    private PlayerRepo playerRepo;

    @Autowired
    private GameServiceRepo gameServiceRepo;

    @Autowired
    private AutoPilotService autoPilotService;

    @Override
    @Transactional
    public GameResponse createNewGame(GameRequest pGameRequest) {
        LOGGER.debug("GameService - createNewGame start");
        Game vGame = gameServiceRepo.createNewGame(pGameRequest);
        return getCreateNewGameResponse(vGame);
    }

    @Override
    public List<GameResponse> getGameList(String userId) {
        LOGGER.debug("GameService - getGameList start");
        List<GameResponse> gameResponseList = new ArrayList<>();
        List<Game> gameList = gameServiceRepo.getGameListByUserId(userId);
        for (Game game : gameList) {

            GameResponse gameResponse = new GameResponse();

            Player assessmentPlayer = getAssessmentPlayer(game);

            gameResponse.setGameId(game.getGameName());
            gameResponse.setStarting(game.getPlayerTurn());
            gameResponse.setStatus(game.getGameStatus());
            gameResponse.setFullName(assessmentPlayer.getFullName());
            gameResponse.setUserId(assessmentPlayer.getUserId());

            if (null != game.getWinner() && !game.getWinner().isEmpty()) {
                gameResponse.setWinner(game.getWinner());
            }

            gameResponseList.add(gameResponse);
        }
        return gameResponseList;
    }

    @Override
    @Transactional
    public SalvoShotResponse receiveSalvoShot(SalvoShotRequest salvoShot, String gameId) throws ProtocalException {
        LOGGER.debug("GameService - receiveSalvoShot start");
        Game game = gameRepo.findByGameName(gameId);

        if (game.getGameStatus().equals(GameStatusType.CREATED.toString())) {
            startGame(game, salvoShot);
        } else if (game.getGameStatus().equals(GameStatusType.FINISHED.toString())) {
            throw new ProtocalException(HttpStatus.NOT_FOUND);
        }
        return handleSalvoShot(salvoShot, game);
    }

    @Override
    public GameStatusResponse getGameStatus(String gameId) throws ProtocalException {
        LOGGER.debug("GameService - getGameStatus start");

        try {
            Game game = gameRepo.findByGameName(gameId);

            XlspaceshipresourceApi xlSpaceshipresourceApi = new XlspaceshipresourceApi();

            GameStatusResponse gameStatusResponse = new GameStatusResponse();

            for (Player player : game.getPlayers()) {
                String address = getSpaceshipAddress(player.getSpaceShipProtocal());
                xlSpaceshipresourceApi.getApiClient().setBasePath(address);
                InlineResponse200 response = xlSpaceshipresourceApi.getSpaceShipBoardUsingGET();
                getSpaceshipStatus(gameStatusResponse, player, response.getBoard());
            }

            if (game.getGameStatus().equals(GameStatusType.FINISHED.toString())) {
                gameStatusResponse.setGame(getPlayerTurnMap("won", game.getWinner()));
            } else {
                gameStatusResponse.setGame(getPlayerTurnMap("player_turn", game.getPlayerTurn()));
            }

            return gameStatusResponse;

        } catch (ApiException e) {
            LOGGER.error("Something went wrong!", e);
            throw new ProtocalException(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @Override
    public Integer getSalvoShotCount(String gameId) throws ProtocalException {
        try {
            Game game = gameRepo.findByGameName(gameId);
            Player player = getPlayer(game);

            XlspaceshipresourceApi xlspaceshipresourceApi = new XlspaceshipresourceApi();
            xlspaceshipresourceApi.getApiClient().setBasePath(getSpaceshipAddress(player.getSpaceShipProtocal()));

            return xlspaceshipresourceApi.getSpaceShipBoardUsingGET().getSpaceships().size();
        } catch (ApiException e) {
            LOGGER.error("Something went wrong!", e);
            throw new ProtocalException(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    private SalvoShotResponse handleSalvoShot(SalvoShotRequest salvoShot, Game game) throws ProtocalException {

        try {
            Player receiverPlayer = getReceiverPlayer(game);
            LOGGER.info("Handle fire for player : " + receiverPlayer.getUserId());

            validateSalvoShotNumbers(game, salvoShot);

            // Route shots for user spaceship
            SpaceshipsresourceApi spaceshipsresourceApi = new SpaceshipsresourceApi();
            spaceshipsresourceApi.getApiClient().setBasePath(getSpaceshipAddress(receiverPlayer.getSpaceShipProtocal()));
            com.spaceship.client.model.SalvoShot salvoShotSpaceship = new com.spaceship.client.model.SalvoShot();
            salvoShotSpaceship.setSalvo(salvoShot.getSalvo());
            InlineResponse2002 results = spaceshipsresourceApi.receiveFireUsingPUT(salvoShotSpaceship);

            // Prepare response
            if (results.getIsAlive()) {
                return getInProgressResponse(results, game, salvoShot);
            } else {
                return getGameOverResponse(results, game, salvoShot);
            }

        } catch (ApiException e) {
            LOGGER.error("Something went wrong!", e);
            throw new ProtocalException(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    private SalvoShotResponse getGameOverResponse(InlineResponse2002 results, Game game, SalvoShotRequest salvoShot) {
        SalvoShotResponse salvoShotResponse = new SalvoShotResponse();
        Player turnPlayer = getPlayer(game);
        salvoShotResponse.setGame(getPlayerTurnMap("won", turnPlayer.getUserId()));
        salvoShotResponse.setSalvo(getBullets(results.getSalvoShots()));
        game.setWinner(turnPlayer.getUserId());
        game.setGameStatus(GameStatusType.FINISHED.toString());
        gameRepo.save(game);
        return salvoShotResponse;
    }

    private Map<String, String> getPlayerTurnMap(String operation, String player) {
        Map<String, String> map = new HashMap<>();
        map.put(operation, player);
        return map;
    }

    private void startGame(Game game, SalvoShotRequest salvoShot) throws ProtocalException {

        try {
            validateSalvoShotNumbers(game, salvoShot);

            game.setGameStatus(GameStatusType.STARTED.toString());
            // Lock game board
            for (Player player : game.getPlayers()) {
                SpaceshipsresourceApi spaceshipsresourceApi = new SpaceshipsresourceApi();
                spaceshipsresourceApi.getApiClient().setBasePath(getSpaceshipAddress(player.getSpaceShipProtocal()));
                spaceshipsresourceApi.lockGameBoardUsingPUT();
            }
            gameRepo.save(game);
        } catch (ApiException e) {
            LOGGER.error("Something went wrong!", e);
            throw new ProtocalException(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    private void validateSalvoShotNumbers(Game game, SalvoShotRequest salvoShot) throws ApiException, ProtocalException {
        Player player = getPlayer(game);
        XlspaceshipresourceApi spaceshipsresourceApi = new XlspaceshipresourceApi();
        spaceshipsresourceApi.getApiClient().setBasePath(getSpaceshipAddress(player.getSpaceShipProtocal()));
        InlineResponse200 result = spaceshipsresourceApi.getSpaceShipBoardUsingGET();
        if (salvoShot.getSalvo().size() > result.getSpaceships().size()) {
            throw new ProtocalException(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
        }
    }

    private SalvoShotResponse getInProgressResponse(InlineResponse2002 results, Game game, SalvoShotRequest salvoShot) {
        SalvoShotResponse salvoShotResponse = new SalvoShotResponse();
        Player receiverPlayer = getReceiverPlayer(game);
        salvoShotResponse.setGame(getPlayerTurnMap("player_turn", receiverPlayer.getUserId()));
        salvoShotResponse.setSalvo(getBullets(results.getSalvoShots()));
        game.setPlayerTurn(receiverPlayer.getUserId());
        gameRepo.save(game);

        if (receiverPlayer.getAutoPilot()) {
            autoPilotService.fireAutoPoilte(game, receiverPlayer);
        }

        return salvoShotResponse;
    }

    private Map<String, String> getBullets(List<InlineResponse2002SalvoShots> results) {
        Map<String, String> bullets = new HashMap<>();
        for (InlineResponse2002SalvoShots result : results) {
            bullets.put(result.getBullet(), result.getResult());
        }
        return bullets;
    }

    private String getSpaceshipAddress(SpaceShipProtocal spaceShipProtocal) {
        StringBuilder url = new StringBuilder();
        url.append("http://");
        url.append(spaceShipProtocal.getHostName());
        url.append(":");
        url.append(spaceShipProtocal.getPort());
        return url.toString();
    }

    private Player getReceiverPlayer(Game game) {
        for (Player player : game.getPlayers()) {
            if (!player.getUserId().equals(game.getPlayerTurn())) {
                return player;
            }
        }
        return null;
    }

    private Player getPlayer(Game game) {
        for (Player player : game.getPlayers()) {
            if (player.getUserId().equals(game.getPlayerTurn())) {
                return player;
            }
        }
        return null;
    }

    private GameResponse getCreateNewGameResponse(Game vGame) {
        GameResponse gameResponse = new GameResponse();
        gameResponse.setGameId(vGame.getGameName());
        gameResponse.setStarting(vGame.getPlayerTurn());
        Player assessmentPlayer = getAssessmentPlayer(vGame);
        if (null != assessmentPlayer) {
            gameResponse.setFullName(assessmentPlayer.getFullName());
            gameResponse.setUserId(assessmentPlayer.getUserId());
        }
        return gameResponse;
    }

    private Player getAssessmentPlayer(Game vGame) {
        for (Player player : vGame.getPlayers()) {
            if (player.getPlayerType().equals(PlayerType.ASSESSMENT.toString())) {
                return player;
            }
        }
        return null;
    }

    private void getSpaceshipStatus(GameStatusResponse gameStatusResponse, Player player, List<List<String>> board) {

        if (PlayerType.ASSESSMENT.toString().equals(player.getPlayerType())) {
            gameStatusResponse.setSelf(new GameStatusSpaceship(board, player.getUserId()));
        } else {
            gameStatusResponse.setOpponent(new GameStatusSpaceship(board, player.getUserId()));
        }
    }

    @Override
    public void enableDisableAutoPilot(String gameId, String userId, Boolean status) {
        Game game = gameRepo.findByGameName(gameId);
        for (Player player : game.getPlayers()) {
            if (player.getUserId().equals(userId)) {
                player.setAutoPilot(status);
                playerRepo.save(player);
            }
        }
    }

	@Override
	public Boolean getAutoPilotStatus(String gameId, String userId) {
		Game game = gameRepo.findByGameName(gameId);
        for (Player player : game.getPlayers()) {
            if (player.getUserId().equals(userId)) {
                return player.getAutoPilot();
            }
        }
        return false;
	}

}
