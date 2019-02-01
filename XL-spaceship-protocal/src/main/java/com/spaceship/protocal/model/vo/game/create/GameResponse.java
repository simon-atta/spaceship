package com.spaceship.protocal.model.vo.game.create;

public class GameResponse {

    private String userId;
    private String fullName;
    private String gameId;
    private String starting;
    private String winner;
    private String status;

    public GameResponse() {
    }

    public GameResponse(String gameId, String starting) {
        super();
        this.gameId = gameId;
        this.starting = starting;
    }

    public GameResponse(String userId, String fullName, String gameId, String starting) {
        super();
        this.userId = userId;
        this.fullName = fullName;
        this.gameId = gameId;
        this.starting = starting;
    }

    public GameResponse(String userId, String fullName, String gameId, String starting, String status) {
        super();
        this.userId = userId;
        this.fullName = fullName;
        this.gameId = gameId;
        this.starting = starting;
        this.status = status;
    }

    /**
     * @return the winner
     */
    public String getWinner() {
        return winner;
    }

    /**
     * @param winner
     *        the winner to set
     */
    public void setWinner(String winner) {
        this.winner = winner;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     *        the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the userId
     */
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

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName
     *        the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the gameId
     */
    public String getGameId() {
        return gameId;
    }

    /**
     * @param gameId
     *        the gameId to set
     */
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    /**
     * @return the starting
     */
    public String getStarting() {
        return starting;
    }

    /**
     * @param starting
     *        the starting to set
     */
    public void setStarting(String starting) {
        this.starting = starting;
    }

}
