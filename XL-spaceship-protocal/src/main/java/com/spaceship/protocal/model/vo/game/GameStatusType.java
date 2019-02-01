package com.spaceship.protocal.model.vo.game;

public enum GameStatusType {

    CREATED("created"), STARTED("started"), FINISHED("finished");

    private String gameStatus;

    private GameStatusType(String gameStatus) {
        this.gameStatus = gameStatus;
    }

    /**
     * @return the gameStatus
     */
    public String getGameStatus() {
        return gameStatus;
    }

    /**
     * @param gameStatus
     *        the gameStatus to set
     */
    public void setGameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }

    @Override
    public String toString() {
        return gameStatus;
    }

}
