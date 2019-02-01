package com.spaceship.model.board;

public class SpaceShipShape {

    private String name;
    private String shape;

    public SpaceShipShape(String name, String shape) {
        super();
        this.name = name;
        this.shape = shape;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *        the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the shape
     */
    public String getShape() {
        return shape;
    }

    /**
     * @param shape
     *        the shape to set
     */
    public void setShape(String shape) {
        this.shape = shape;
    }

}
