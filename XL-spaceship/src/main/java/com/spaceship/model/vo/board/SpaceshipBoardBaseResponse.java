package com.spaceship.model.vo.board;

import java.util.List;

public class SpaceshipBoardBaseResponse {

    private List<List<String>> board;

    public SpaceshipBoardBaseResponse() {
        super();
    }

    public SpaceshipBoardBaseResponse(List<List<String>> board) {
        super();
        this.board = board;
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
