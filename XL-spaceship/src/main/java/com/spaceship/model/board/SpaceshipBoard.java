package com.spaceship.model.board;

import java.util.ArrayList;
import java.util.List;

public class SpaceshipBoard {

    private int[][] board;
    private Boolean boardLocked = false;
    private List<String> spaceShips;
    public static final int BOARD_COL = 16;
    public static final int BOARD_ROW = 16;

    /**
     * @return the spaceShips
     */
    public List<String> getSpaceShips() {
        if(null == spaceShips) {
            spaceShips = new ArrayList<>();
        }
        return spaceShips;
    }

    /**
     * @param spaceShips
     *        the spaceShips to set
     */
    public void setSpaceShips(List<String> spaceShips) {
        this.spaceShips = spaceShips;
    }

    /**
     * @return the board
     */
    public int[][] getBoard() {
        return board;
    }

    /**
     * @param board
     *        the board to set
     */
    public void setBoard(int[][] board) {
        this.board = board;
    }

    /**
     * @return the boardLocked
     */
    public Boolean isBoardLocked() {
        return boardLocked;
    }

    /**
     * @param boardLocked the boardLocked to set
     */
    public void setBoardLocked(Boolean boardLocked) {
        this.boardLocked = boardLocked;
    }



}
