package com.spaceship.model.vo.board;

import java.util.List;

public class SpaceshipBoardResponse {

    private List<List<String>> board;
    private List<String> spaceships;
    private Boolean boardLocked;



    /**
     * @return the board
     */
    public List<List<String>> getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(List<List<String>> board) {
        this.board = board;
    }

    /**
     * @return the boardLocked
     */
    public Boolean isBoardLocked() {
        return boardLocked;
    }

    /**
     * @param boardLocked
     *        the boardLocked to set
     */
    public void setBoardLocked(Boolean boardLocked) {
        this.boardLocked = boardLocked;
    }

    /**
     * @return the boardLocked
     */
    public Boolean getBoardLocked() {
        return boardLocked;
    }

    /**
     * @return the spaceships
     */
    public List<String> getSpaceships() {
        return spaceships;
    }

    /**
     * @param spaceships
     *        the spaceships to set
     */
    public void setSpaceships(List<String> spaceships) {
        this.spaceships = spaceships;
    }

}
