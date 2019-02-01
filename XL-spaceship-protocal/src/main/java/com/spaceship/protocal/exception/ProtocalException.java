package com.spaceship.protocal.exception;

import org.springframework.http.HttpStatus;

public class ProtocalException extends Exception {

    private static final long serialVersionUID = 1L;
    private HttpStatus httpStatus;

    public ProtocalException() {
        super();
    }

    public ProtocalException(HttpStatus httpStatus) {
        super();
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
