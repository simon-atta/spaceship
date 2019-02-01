package com.spaceship.protocal.service;

import java.util.List;

import com.spaceship.protocal.exception.ProtocalException;
import com.spaceship.protocal.model.vo.game.create.GameRequest;
import com.spaceship.protocal.model.vo.game.create.GameResponse;
import com.spaceship.protocal.model.vo.game.fire.SalvoShotRequest;
import com.spaceship.protocal.model.vo.game.fire.SalvoShotResponse;
import com.spaceship.protocal.model.vo.game.status.GameStatusResponse;

/**
 * This is interface for game service which will have all service contracts.
 */
public interface IGameService {

    /**
     * This method will be responsible for create new game.
     *
     * @param pGameRequest
     *        GameRequest
     * @return game response with assessment player details and game id.
     */
    GameResponse createNewGame(GameRequest pGameRequest);

    /**
     * List all games by user id.
     *
     * @param userId
     *        String
     * @return list of games.
     */
    List<GameResponse> getGameList(String userId);

    /**
     * Receive salvo shots from players.
     * <p>
     * 1. Check if game start or not, if not started yet it update database and
     * lock corresponding boards and validate for salvoshots.
     * <p>
     * 2. Check if game finished then it will return 404.
     * <p>
     * 3. handle shoting logic by forward shots to specific XL spaceship and get
     * response from it.
     * <p>
     * this method will receive request and
     * then route shots for correct player and then return results.
     *
     * @param salvoShot
     *        SalvoShotRequest
     * @param gameId
     *        String
     * @return SalvoShotResponse
     * @throws ProtocalException
     */
    SalvoShotResponse receiveSalvoShot(SalvoShotRequest salvoShot, String gameId) throws ProtocalException;

    /**
     * This method will get game status.
     *
     * @param gameId
     *        String
     * @return
     * @throws ProtocalException
     */
    GameStatusResponse getGameStatus(String gameId) throws ProtocalException;

    /**
     * This method will return turn player how many salvo shot he can fire.
     *
     * @param gameId
     *        String
     * @return int number of how many shots he can send.
     * @throws ProtocalException
     */
    Integer getSalvoShotCount(String gameId) throws ProtocalException;

    /**
     * This method will enable auto pilot.
     *
     * @param gameId
     *        String
     * @param userId
     *        String
     */
    void enableDisableAutoPilot(String gameId, String userId, Boolean status);
    
    /**
     * This method will enable auto pilot.
     *
     * @param gameId
     *        String
     * @param userId
     *        String
     */
    Boolean getAutoPilotStatus(String gameId, String userId);


}
