package com.spaceship.model.constants;

public enum SpaceShipQuadrant {

    STAR("*"), MISSED("-"), HIT("X"), UNKNOWN(".");

    private String quadrant;

    private SpaceShipQuadrant(String quadrant) {
        this.quadrant = quadrant;
    }

    /**
     * @return the spaceShipQuadrant
     */
    public String getSpaceShipQuadrant() {
        return quadrant;
    }


    @Override
    public String toString() {
        return quadrant;
    }

}
