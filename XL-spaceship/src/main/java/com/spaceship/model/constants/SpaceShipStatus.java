package com.spaceship.model.constants;

public enum SpaceShipStatus {

    ACTIVE("ACTIVE"), INACTIVE("INACTIVE");

    private SpaceShipStatus(String spaceShipStatus) {
        this.spaceShipStatus = spaceShipStatus;
    }

    private String spaceShipStatus;

    public String getSpaceShipStatus() {
        return spaceShipStatus;
    }

    public void setSpaceShipStatus(String spaceShipStatus) {
        this.spaceShipStatus = spaceShipStatus;
    }

}
