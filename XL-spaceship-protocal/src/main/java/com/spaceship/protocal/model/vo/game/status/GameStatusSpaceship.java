package com.spaceship.protocal.model.vo.game.status;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameStatusSpaceship {

    private List<List<String>> board;
    private String userId;

    public GameStatusSpaceship() {
        super();
    }

    public GameStatusSpaceship(List<List<String>> board, String userId) {
        super();
        this.board = board;
        this.userId = userId;
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

    /**
     * @return the userId
     */
    @JsonProperty("user_id")
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     *        the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

}
