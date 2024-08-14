package com.challenge.springboot.api.water_bucket.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler class for the application.
 * This class centralizes the handling of exceptions across the entire application,
 * providing a consistent way to manage errors and return appropriate HTTP responses.
 *
 * @author Ronald Socorro
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Handles {@link IllegalArgumentException} exceptions by returning a custom error message
     * and an HTTP status code indicating a bad request.
     *
     * @param ex The {@link IllegalArgumentException} caught during execution.
     * @return A {@link ResponseEntity} containing the exception message and an HTTP status code of BAD_REQUEST.
    */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
