package com.spaceship.exceptions;

import org.springframework.http.HttpStatus;

import com.spaceship.model.vo.board.SpaceshipBoardBaseResponse;

public class SpaceshipBoardException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private SpaceshipBoardBaseResponse board;
    private HttpStatus httpStatus;

    public SpaceshipBoardException() {
        super();
    }

    public SpaceshipBoardException(SpaceshipBoardBaseResponse board, HttpStatus httpStatus) {
        super();
        this.board = board;
        this.httpStatus = httpStatus;
    }

    /**
     * @return the board
     */
    public SpaceshipBoardBaseResponse getBoard() {
        return board;
    }

    /**
     * @param board
     *        the board to set
     */
    public void setBoard(SpaceshipBoardBaseResponse board) {
        this.board = board;
    }

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * @return the httpStatus
     */
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    /**
     * @param httpStatus
     *        the httpStatus to set
     */
    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

}
