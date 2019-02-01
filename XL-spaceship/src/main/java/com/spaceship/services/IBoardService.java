package com.spaceship.services;

import java.util.List;

import com.spaceship.exceptions.SpaceshipBoardException;
import com.spaceship.model.board.SpaceShipShape;
import com.spaceship.model.vo.board.SpaceshipBoardBaseResponse;
import com.spaceship.model.vo.board.SpaceshipBoardRequest;
import com.spaceship.model.vo.board.SpaceshipBoardResponse;
import com.spaceship.model.vo.board.SpaceshipSalvoShotsResponse;
import com.spaceship.model.vo.shot.SalvoShotRequest;

public interface IBoardService {

    /**
     * Initialize XL spaceship grid.
     * <p>
     * It will be in boot of XL spaceship.
     */
    void initializeGrid();

    /**
     * This method will be used to lock spaceship when game will be start.
     */
    void lockGameBoard();

    /**
     * This method will be used to unlock spaceship when game if finished and
     * player want to place new spaceships.
     */
    void unLockGameBoard();

    /**
     * Adding spaceship to XL spaceship board.
     *
     * @param spaceshipRequest
     *        SpaceshipBoardRequest
     * @return SpaceshipBoardBaseResponse which will contains board after adding
     *         spaceship.
     * @throws SpaceshipBoardException
     */
    SpaceshipBoardBaseResponse addSpaceshipToBoard(SpaceshipBoardRequest spaceshipRequest) throws SpaceshipBoardException;

    /**
     * Get XL spaceship board.
     *
     * @return SpaceshipBoardResponse which will contains all info about board.
     * @throws SpaceshipBoardException
     */
    SpaceshipBoardResponse getSpaceshipBoard() throws SpaceshipBoardException;

    /**
     * Get spaceship shapes.
     * <p>
     * This method will read from
     * {@link com.spaceship.util.SpaceshipFactory#getSpaceships()}
     *
     * @return list of spaceship shapes.
     * @throws SpaceshipBoardException
     */
    List<SpaceShipShape> getSpaceshipsShape();

    /**
     * Receive salvo shots and handle all operation for bullets.
     *
     * @param salvoShots
     *        SalvoShotRequest
     * @return bullets status and board progress if true mean you can still play
     *         if false mean board is empty.
     */
    SpaceshipSalvoShotsResponse receiveSalvoShots(SalvoShotRequest salvoShots);

}
