package com.spaceship.model.constants;

public enum SpaceShipQuadrantMapping {

    Winger(1), Angle(2), AClass(3), BClass(4), SClass(5), EMPTY(0), MISSED(-1), HIT(7), KILL(7);

    private SpaceShipQuadrantMapping(Integer spaceShipStatus) {
        this.spaceShipStatus = spaceShipStatus;
    }

    private Integer spaceShipStatus;

    /**
     * @return the spaceShipStatus
     */
    public Integer getSpaceShipType() {
        return spaceShipStatus;
    }

    /**
     * @param spaceShipStatus
     *        the spaceShipStatus to set
     */
    public void setSpaceShipType(Integer spaceShipStatus) {
        this.spaceShipStatus = spaceShipStatus;
    }

}
