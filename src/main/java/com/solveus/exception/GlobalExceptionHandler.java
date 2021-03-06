package com.solveus.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public String handlerRuntimeException(final RuntimeException e) {
        log.error("handleRuntimeException : {}", e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler(UserIDDuplicateException.class)
    public ResponseEntity<ErrorResponse> handlerUserIDDuplicateException(UserIDDuplicateException ex){
        log.error("handlerUerIDDuplicateException", ex);
        ErrorResponse response = new ErrorResponse(ex.getErrorCode());
        return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getErrorCode().getStatus().value()));
    }
}
