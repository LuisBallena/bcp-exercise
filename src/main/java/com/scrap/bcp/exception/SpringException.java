package com.scrap.bcp.exception;

import org.springframework.http.HttpStatus;

/**
 * SpringException.
 *
 * @author Luis Alonso Ballena Garcia
 */

public class SpringException extends RuntimeException {
    private static final long serialVersionUID = -7729039942125112209L;
    private final HttpStatus httpStatus;
    private final String customMessage;

    public SpringException(HttpStatus httpStatus, String customMessage) {
        this.httpStatus = httpStatus;
        this.customMessage = customMessage;
    }

    public SpringException(String message, HttpStatus httpStatus, String customMessage) {
        super(message);
        this.httpStatus = httpStatus;
        this.customMessage = customMessage;
    }

    public SpringException(String message, Throwable cause, HttpStatus httpStatus, String customMessage) {
        super(message, cause);
        this.httpStatus = httpStatus;
        this.customMessage = customMessage;
    }

    public SpringException(Throwable cause, HttpStatus httpStatus, String customMessage) {
        super(cause);
        this.httpStatus = httpStatus;
        this.customMessage = customMessage;
    }

    public SpringException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, HttpStatus httpStatus, String customMessage) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.httpStatus = httpStatus;
        this.customMessage = customMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getCustomMessage() {
        return customMessage;
    }
}
