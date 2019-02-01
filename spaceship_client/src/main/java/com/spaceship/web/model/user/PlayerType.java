package com.spaceship.web.model.user;

public enum PlayerType {

    OPPONENT("OPPONENT"), ASSESSMENT("ASSESSMENT");

    private PlayerType(String playerType) {
        this.playerType = playerType;
    }

    private String playerType;

    /**
     * @return the playerType
     */
    public String getPlayerType() {
        return playerType;
    }

    /**
     * @param playerType
     *        the playerType to set
     */
    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

}
