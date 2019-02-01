package com.spaceship.exceptions;

import org.springframework.http.HttpStatus;

public class XLSpaceshipException extends Exception {

    private static final long serialVersionUID = 1L;
    private HttpStatus httpStatus;

    public XLSpaceshipException() {
        super();
    }

    public XLSpaceshipException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
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
