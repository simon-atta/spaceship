package com.spaceship.protocal.model.vo.game.create;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerRequest {

    private String userId;
    private String fullName;
    private SpaceShipProtocalRequest spaceShipProtocal;
    private PlayerType playerType;

    /**
     * @return the playerType
     */
    public PlayerType getPlayerType() {
        return playerType;
    }

    /**
     * @param playerType
     *        the playerType to set
     */
    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
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

    /**
     * @return the fullName
     */
    @JsonProperty("full_name")
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
     * @return the spaceShipProtocal
     */
    @JsonProperty("spaceship_protocol")
    public SpaceShipProtocalRequest getSpaceShipProtocal() {
        return spaceShipProtocal;
    }

    /**
     * @param spaceShipProtocal
     *        the spaceShipProtocal to set
     */
    public void setSpaceShipProtocal(SpaceShipProtocalRequest spaceShipProtocal) {
        this.spaceShipProtocal = spaceShipProtocal;
    }

}
