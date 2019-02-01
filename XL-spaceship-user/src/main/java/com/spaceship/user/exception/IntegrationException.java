package com.spaceship.user.exception;

import org.springframework.http.HttpStatus;

public class IntegrationException extends Exception {

    private static final long serialVersionUID = 1L;
    private HttpStatus httpStatus;

    public IntegrationException() {
        super();
    }

    public IntegrationException(HttpStatus httpStatus) {
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
