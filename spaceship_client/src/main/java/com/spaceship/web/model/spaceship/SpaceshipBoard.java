package com.spaceship.web.model.spaceship;

import java.util.List;

public class SpaceshipBoard {

    private List<String> spaceshipsType;

    private List<List<String>> board;

    /**
     * @return the spaceshipsType
     */
    public List<String> getSpaceshipsType() {
        return spaceshipsType;
    }

    /**
     * @param spaceshipsType
     *        the spaceshipsType to set
     */
    public void setSpaceshipsType(List<String> spaceshipsType) {
        this.spaceshipsType = spaceshipsType;
    }

    /**
     * @return the board
     */
    public List<List<String>> getBoard() {
        return board;
    }

    /**
     * @param board
     *        the board to set
     */
    public void setBoard(List<List<String>> board) {
        this.board = board;
    }

}
