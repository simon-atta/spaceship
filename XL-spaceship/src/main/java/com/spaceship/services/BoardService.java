package com.spaceship.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.spaceship.exceptions.SpaceshipBoardException;
import com.spaceship.model.board.SpaceShipShape;
import com.spaceship.model.board.Spaceship;
import com.spaceship.model.board.SpaceshipBoard;
import com.spaceship.model.constants.SpaceShipQuadrant;
import com.spaceship.model.constants.SpaceShipQuadrantMapping;
import com.spaceship.model.vo.board.SpaceshipBoardBaseResponse;
import com.spaceship.model.vo.board.SpaceshipBoardRequest;
import com.spaceship.model.vo.board.SpaceshipBoardResponse;
import com.spaceship.model.vo.board.SpaceshipSalvoShotsResponse;
import com.spaceship.model.vo.shot.SalvoShotRequest;
import com.spaceship.model.vo.shot.SalvoShotResponse;
import com.spaceship.util.SpaceshipBoardUtil;
import com.spaceship.util.SpaceshipFactory;

/**
 * This is concert implementation of
 * {@link com.spaceship.services.IBoardService}
 *
 * @author Simon Ghobreil.
 */
@Component
public class BoardService implements IBoardService {

    private static final Logger LOGGER = Logger.getLogger(BoardService.class);

    private static final int BOARD_COL = 16;
    private static final int BOARD_ROW = 16;
    private static final String SALVO_SHOT_DELIMITER = "x";
    private static final String DELIMITER = ",";

    private SpaceshipBoard spaceshipBoard;

    public BoardService() {
        spaceshipBoard = new SpaceshipBoard();
    }

    /**
     * @see com.spaceship.services.IBoardService#initializeGrid()
     */
    @Override
    public void initializeGrid() {
        LOGGER.debug("BoardService - initializeGrid started");
        spaceshipBoard.setBoard(new int[BOARD_ROW][BOARD_COL]);
        for (int i = 0; i < BOARD_ROW; i++) {
            for (int j = 0; j < BOARD_COL; j++) {
                resetCell(i, j);
            }
        }
    }

    /**
     * @see com.spaceship.services.IBoardService#lockGameBoard()
     */
    @Override
    public void lockGameBoard() {
        spaceshipBoard.setBoardLocked(true);
    }

    /**
     * @see com.spaceship.services.IBoardService#unLockGameBoard()
     */
    @Override
    public void unLockGameBoard() {
        spaceshipBoard.setBoardLocked(false);
    }

    /**
     * @see com.spaceship.services.IBoardService#addSpaceshipToBoard(SpaceshipBoardRequest)
     */
    @Override
    public SpaceshipBoardBaseResponse addSpaceshipToBoard(SpaceshipBoardRequest spaceshipRequest) throws SpaceshipBoardException {

        LOGGER.debug("BoardService - addSpaceshipIntoBoard started");

        Spaceship spaceship = SpaceshipFactory.getSpaceships(spaceshipRequest.getSpaceShipName());

        // Check if spaceship already drawn before
        if (!spaceshipBoard.isBoardLocked()) {
            if (!searchForSpaceship(spaceship.getId())) {
                // Check if spaceship area is busy
                return handleCountCheck(spaceshipRequest, spaceship);
            }

            throw new SpaceshipBoardException(new SpaceshipBoardBaseResponse(getBoardDetails().getBoard()), HttpStatus.FOUND);
        } else {
            throw new SpaceshipBoardException(new SpaceshipBoardBaseResponse(getBoardDetails().getBoard()), HttpStatus.FORBIDDEN);
        }
    }

    private SpaceshipBoardBaseResponse handleCountCheck(SpaceshipBoardRequest spaceshipRequest, Spaceship spaceship) throws SpaceshipBoardException {
        Integer countCheck = SpaceshipBoardUtil.checkQuadrant(spaceshipRequest.getxCoordinate(), spaceshipRequest.getyCoordinate(), spaceshipBoard.getBoard(), spaceship);
        if (countCheck == 0) {
            addSpaceShipToGameBoard(spaceshipRequest, spaceship);
            return new SpaceshipBoardBaseResponse(getBoardDetails().getBoard());
        } else if (countCheck == -1) {
            throw new SpaceshipBoardException(new SpaceshipBoardBaseResponse(getBoardDetails().getBoard()), HttpStatus.LENGTH_REQUIRED);
        } else {
            throw new SpaceshipBoardException(new SpaceshipBoardBaseResponse(getBoardDetails().getBoard()), HttpStatus.CONFLICT);
        }
    }

    /**
     * @see com.spaceship.services.IBoardService#getSpaceshipBoard()
     */
    @Override
    public SpaceshipBoardResponse getSpaceshipBoard() throws SpaceshipBoardException {
        return getBoardDetails();
    }

    /**
     * @see com.spaceship.services.IBoardService#getSpaceshipsShape()
     */
    @Override
    public List<SpaceShipShape> getSpaceshipsShape() {

        List<SpaceShipShape> spaceShipShapes = new ArrayList<>();
        Map<String, Spaceship> spaceshipsShapes = SpaceshipFactory.getSpaceships();

        for (Map.Entry<String, Spaceship> entry : spaceshipsShapes.entrySet()) {
            spaceShipShapes.add(new SpaceShipShape(entry.getKey(), getShapeAsString(entry.getValue().getRows(), entry.getValue().getCols(), entry.getValue().getBoard())));
        }

        return spaceShipShapes;
    }

    /**
     * @see com.spaceship.services.IBoardService#receiveSalvoShots(SalvoShotRequest))
     */
    @Override
    public SpaceshipSalvoShotsResponse receiveSalvoShots(SalvoShotRequest salvoShots) {
        SpaceshipSalvoShotsResponse spaceshipSalvoShotsResponse = new SpaceshipSalvoShotsResponse();
        List<SalvoShotResponse> salvoShotResponseList = new ArrayList<>();

        // Translation Coordinates
        for (String shot : salvoShots.getSalvo()) {
            SalvoShotResponse salvoShotResponse = new SalvoShotResponse();
            salvoShotResponse.setBullet(shot);
            Integer x = Integer.parseInt(shot.substring(0, shot.indexOf(SALVO_SHOT_DELIMITER)), 16);
            Integer y = Integer.parseInt(shot.substring(shot.indexOf(SALVO_SHOT_DELIMITER) + 1), 16);

            // Update board
            handleUpdateBoard(salvoShotResponse, x, y);
            salvoShotResponseList.add(salvoShotResponse);
        }

        spaceshipSalvoShotsResponse.setSalvoShots(salvoShotResponseList);
        if (spaceshipBoard.getSpaceShips().isEmpty()) {
            spaceshipSalvoShotsResponse.setIsAlive(false);
        }

        return spaceshipSalvoShotsResponse;
    }

    private void handleUpdateBoard(SalvoShotResponse salvoShotResponse, Integer x, Integer y) {
        if (spaceshipBoard.getBoard()[x][y] == 0) {
            spaceshipBoard.getBoard()[x][y] = SpaceShipQuadrantMapping.MISSED.getSpaceShipType();
            salvoShotResponse.setResult(SpaceShipQuadrantMapping.MISSED.toString());
        } else if (spaceshipBoard.getBoard()[x][y] == SpaceShipQuadrantMapping.HIT.getSpaceShipType() || spaceshipBoard.getBoard()[x][y] == SpaceShipQuadrantMapping.MISSED.getSpaceShipType()) {
            salvoShotResponse.setResult(SpaceShipQuadrantMapping.MISSED.toString());
        } else {
            handleHitBullet(salvoShotResponse, x, y);
        }
    }

    private void handleHitBullet(SalvoShotResponse salvoShotResponse, Integer x, Integer y) {
        if (isShipKilled(spaceshipBoard.getBoard()[x][y], x, y)) {
            removeKilledSpaceshipFromBoard(spaceshipBoard.getBoard()[x][y]);
            spaceshipBoard.getBoard()[x][y] = SpaceShipQuadrantMapping.HIT.getSpaceShipType();
            salvoShotResponse.setResult(SpaceShipQuadrantMapping.KILL.toString());
        } else {
            spaceshipBoard.getBoard()[x][y] = SpaceShipQuadrantMapping.HIT.getSpaceShipType();
            salvoShotResponse.setResult(SpaceShipQuadrantMapping.HIT.toString());
        }
    }

    private SpaceshipBoardResponse getBoardDetails() {
        SpaceshipBoardResponse spaceshipBoardResponse = new SpaceshipBoardResponse();
        List<String> spaceships = new ArrayList<>();
        List<List<String>> boardView = new ArrayList<>();
        List<String> rows = new ArrayList<>();

        for (int i = 0; i < BOARD_ROW; i++) {
            StringBuilder results = new StringBuilder();
            for (int j = 0; j < BOARD_COL; j++) {

                results.append(spaceshipBoard.getBoard()[i][j]);
                checkSpaceShipType(spaceshipBoard.getBoard()[i][j], spaceships);

            }
            results.append(DELIMITER);
            getRowAsList(results.toString(), rows);
        }
        boardView.add(rows);

        spaceshipBoardResponse.setBoard(boardView);
        spaceshipBoardResponse.setSpaceships(spaceships);
        spaceshipBoardResponse.setBoardLocked(spaceshipBoard.isBoardLocked());

        return spaceshipBoardResponse;
    }

    private void getRowAsList(String rowStr, List<String> rows) {

        String rowNewValue = rowStr.substring(0, rowStr.indexOf(DELIMITER));

        if (rowStr.contains(SpaceShipQuadrantMapping.EMPTY.getSpaceShipType().toString())) {
            rowNewValue = rowNewValue.replace(SpaceShipQuadrantMapping.EMPTY.getSpaceShipType().toString(), SpaceShipQuadrant.UNKNOWN.toString());
        }
        if (rowStr.contains(SpaceShipQuadrantMapping.HIT.getSpaceShipType().toString())) {
            rowNewValue = rowNewValue.replaceAll(SpaceShipQuadrantMapping.HIT.getSpaceShipType().toString(), SpaceShipQuadrant.HIT.toString());
        }
        if (rowStr.contains(SpaceShipQuadrantMapping.MISSED.getSpaceShipType().toString())) {
            rowNewValue = rowNewValue.replaceAll(SpaceShipQuadrantMapping.MISSED.getSpaceShipType().toString(), SpaceShipQuadrant.MISSED.toString());
        }
        if (rowStr.contains(SpaceShipQuadrantMapping.Winger.getSpaceShipType().toString())) {
            rowNewValue = rowNewValue.replaceAll(SpaceShipQuadrantMapping.Winger.getSpaceShipType().toString(), SpaceShipQuadrant.STAR.toString());
        }
        if (rowStr.contains(SpaceShipQuadrantMapping.Angle.getSpaceShipType().toString())) {
            rowNewValue = rowNewValue.replaceAll(SpaceShipQuadrantMapping.Angle.getSpaceShipType().toString(), SpaceShipQuadrant.STAR.toString());
        }
        if (rowStr.contains(SpaceShipQuadrantMapping.BClass.getSpaceShipType().toString())) {
            rowNewValue = rowNewValue.replaceAll(SpaceShipQuadrantMapping.BClass.getSpaceShipType().toString(), SpaceShipQuadrant.STAR.toString());
        }
        if (rowStr.contains(SpaceShipQuadrantMapping.AClass.getSpaceShipType().toString())) {
            rowNewValue = rowNewValue.replaceAll(SpaceShipQuadrantMapping.AClass.getSpaceShipType().toString(), SpaceShipQuadrant.STAR.toString());
        }
        if (rowStr.contains(SpaceShipQuadrantMapping.SClass.getSpaceShipType().toString())) {
            rowNewValue = rowNewValue.replaceAll(SpaceShipQuadrantMapping.SClass.getSpaceShipType().toString(), SpaceShipQuadrant.STAR.toString());
        }

        rows.add(rowNewValue);
    }

    private void checkSpaceShipType(int i, List<String> spaceships) {
        String spaceShipType = null;
        if (i == SpaceShipQuadrantMapping.Winger.getSpaceShipType()) {
            spaceShipType = SpaceShipQuadrantMapping.Winger.name();
        } else if (i == SpaceShipQuadrantMapping.Angle.getSpaceShipType()) {
            spaceShipType = SpaceShipQuadrantMapping.Angle.name();
        } else if (i == SpaceShipQuadrantMapping.BClass.getSpaceShipType()) {
            spaceShipType = SpaceShipQuadrantMapping.BClass.name();
        } else if (i == SpaceShipQuadrantMapping.AClass.getSpaceShipType()) {
            spaceShipType = SpaceShipQuadrantMapping.AClass.name();
        } else if (i == SpaceShipQuadrantMapping.SClass.getSpaceShipType()) {
            spaceShipType = SpaceShipQuadrantMapping.SClass.name();
        }

        if (null != spaceShipType && !spaceships.contains(spaceShipType)) {
            spaceships.add(spaceShipType);
        }
    }

    private void addSpaceShipToGameBoard(SpaceshipBoardRequest spaceshipRequest, Spaceship spaceship) {
        Integer xCoordinate = spaceshipRequest.getxCoordinate();
        Integer yCoordinate = spaceshipRequest.getyCoordinate();

        for (int i = 0; i < spaceship.getRows(); i++) {
            for (int j = 0; j < spaceship.getCols(); j++) {
                if (SpaceShipQuadrant.STAR.toString().equals(spaceship.getBoard()[i][j])) {
                    spaceshipBoard.getBoard()[xCoordinate][yCoordinate] = spaceship.getId();
                } else {
                    spaceshipBoard.getBoard()[xCoordinate][yCoordinate] = 0;
                }
                yCoordinate++;
            }
            xCoordinate++;
            yCoordinate = spaceshipRequest.getyCoordinate();
        }
        spaceshipBoard.getSpaceShips().add(spaceship.getName());
    }

    private Boolean searchForSpaceship(Integer spaceshipId) {
        for (int i = 0; i < BOARD_COL; i++) {
            for (int j = 0; j < BOARD_ROW; j++) {
                if (spaceshipBoard.getBoard()[i][j] == spaceshipId) {
                    return true;
                }
            }
        }
        return false;
    }

    private void resetCell(int i, int j) {
        spaceshipBoard.getBoard()[i][j] = 0;
    }

    private String getShapeAsString(int row, int col, String[][] shape) {
        StringBuilder results = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                results.append(shape[i][j]);
            }
            results.append(DELIMITER);
        }
        return results.toString();
    }

    private void removeKilledSpaceshipFromBoard(int spaceshipId) {

        for (SpaceShipQuadrantMapping spaceshipTypes : SpaceShipQuadrantMapping.values()) {
            if (spaceshipTypes.getSpaceShipType() == spaceshipId) {
                removeSpaceship(spaceshipTypes);
            }
        }

    }

    private void removeSpaceship(SpaceShipQuadrantMapping spaceshipTypes) {
        for (String spaceShipBoard : spaceshipBoard.getSpaceShips()) {
            if (spaceShipBoard.equalsIgnoreCase(spaceshipTypes.name())) {
                spaceshipBoard.getSpaceShips().remove(spaceShipBoard);
            }
        }
    }

    private boolean isShipKilled(int spaceShipId, int x, int y) {
        Integer count = 0;
        for (int i = 0; i < BOARD_COL; i++) {
            for (int j = 0; j < BOARD_ROW; j++) {
                if (spaceshipBoard.getBoard()[i][j] == spaceShipId) {
                    count++;
                }
            }
        }

        if (count == 1) {
            return true;
        }
        return false;

    }

}
