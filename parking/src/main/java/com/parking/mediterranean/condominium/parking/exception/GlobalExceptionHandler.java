package com.parking.mediterranean.condominium.parking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private ErrorResponse buildError(HttpStatus status, String error, String message, WebRequest request) {
        return new ErrorResponse(
                LocalDateTime.now(),
                status.value(),
                error,
                message,
                request.getDescription(false).replace("uri=", "")
        );
    }

    //400 - Bad Request
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequest(BadRequestException ex, WebRequest request) {
        ErrorResponse body = buildError(
                HttpStatus.BAD_REQUEST,
                "Bad Request",
                ex.getMessage(),
                request
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
    }

    //400 or 422 - Bad Request - Validation Errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationErrors(MethodArgumentNotValidException ex, WebRequest request) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));

        ErrorResponse body = buildError(
                HttpStatus.BAD_REQUEST,
                "Validation Error",
                "One or more fields are invalid",
                request
        );

        Map<String, Object> response = new HashMap<>();
        response.put("error", body);
        response.put("fields", errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    //400 - Malformed/Invalid JSON
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleInvalidJson(HttpMessageNotReadableException ex, WebRequest request) {
        ErrorResponse body = buildError(
                HttpStatus.BAD_REQUEST,
                "malformed JSON",
                "Invalid JSON input",
                request
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    //404 Not Found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleNotFound(ResourceNotFoundException ex, WebRequest request) {
        ErrorResponse body = buildError(
                HttpStatus.NOT_FOUND,
                "Not Found",
                ex.getMessage(),
                request
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    //409 Conflict
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<Object> handleDuplicate(DuplicateResourceException ex, WebRequest request) {
        ErrorResponse body = buildError(
                HttpStatus.CONFLICT,
                "Conflict",
                ex.getMessage(),
                request
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
    }

    // 409 Primary Resident Conflict
    @ExceptionHandler(PrimaryResidentConflictException.class)
    public ResponseEntity<ErrorResponse> handlePrimaryConflict(PrimaryResidentConflictException ex, WebRequest request) {
        ErrorResponse body = buildError(
                HttpStatus.CONFLICT,
                "Primary Resident Conflict",
                ex.getMessage(),
                request
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
    }

    //500 - Generic/unexpected
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneric(Exception ex, WebRequest request) {
        ErrorResponse body = buildError(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Internal Server Error",
                "Unexpected server error",
                request
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }
}
