package com.spaceship.web.model.spaceship;

public class SpaceshipShape {

    private String spaceshipsType;

    private String[][] board;

    private Integer cols;
    private Integer rows;

    public SpaceshipShape(String spaceshipsType, String[][] board, Integer cols, Integer rows) {
        super();
        this.spaceshipsType = spaceshipsType;
        this.board = board;
        this.cols = cols;
        this.rows = rows;
    }

    /**
     * @return the cols
     */
    public Integer getCols() {
        return cols;
    }

    /**
     * @param cols
     *        the cols to set
     */
    public void setCols(Integer cols) {
        this.cols = cols;
    }

    /**
     * @return the rows
     */
    public Integer getRows() {
        return rows;
    }

    /**
     * @param rows
     *        the rows to set
     */
    public void setRows(Integer rows) {
        this.rows = rows;
    }

    /**
     * @return the spaceshipsType
     */
    public String getSpaceshipsType() {
        return spaceshipsType;
    }

    /**
     * @param spaceshipsType
     *        the spaceshipsType to set
     */
    public void setSpaceshipsType(String spaceshipsType) {
        this.spaceshipsType = spaceshipsType;
    }

    /**
     * @return the board
     */
    public String[][] getBoard() {
        return board;
    }

    /**
     * @param board
     *        the board to set
     */
    public void setBoard(String[][] board) {
        this.board = board;
    }

}
