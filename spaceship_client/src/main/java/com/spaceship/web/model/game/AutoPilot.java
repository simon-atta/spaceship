package com.spaceship.web.model.game;

public class AutoPilot {

    String value;
    String gameId;

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     *        the value to set
     */
    public void setValue(String value) {
        this.value = value;
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

    @Override
    public String toString() {
        return "SearchCriteria [value=" + value + ", gameId=" + gameId + "]";
    }

}
