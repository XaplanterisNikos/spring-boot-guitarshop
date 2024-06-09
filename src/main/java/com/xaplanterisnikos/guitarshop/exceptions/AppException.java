package com.xaplanterisnikos.guitarshop.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Exception class representing application-specific exceptions.
 * This class extends RuntimeException and includes an HttpStatus field to indicate the status of the exception.
 */
public class AppException extends RuntimeException {

    /**
     * The HTTP status associated with the exception.
     */
    private final HttpStatus status;


    /**
     * Constructs a new AppException with the specified error message and HTTP status.
     *
     * @param message the error message
     * @param status  the HTTP status
     */
    public AppException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }


    /**
     * Retrieves the HTTP status associated with the exception.
     *
     * @return the HTTP status
     */
    public HttpStatus getStatus() {
        return status;
    }
}
