package com.spaceship.model.board;

public class Spaceship {

    private Integer id;
    private String name;
    private String[][] board;
    private Integer rows;
    private Integer cols;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     *        the id to set
     */
    public void setId(Integer id) {
        this.id = id;
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
