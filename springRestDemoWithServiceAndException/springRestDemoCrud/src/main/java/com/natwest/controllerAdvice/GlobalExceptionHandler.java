package com.natwest.controllerAdvice;

import com.natwest.exception.IdNotFoundException;
import com.natwest.exception.InValidAmountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InValidAmountException.class)
    public ResponseEntity<ErrorInfo> handleExceptionForBalance(InValidAmountException exception){
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setHttpStatus(HttpStatus.BAD_REQUEST);
        errorInfo.setErrorMessage(exception.getMessage());
        errorInfo.setLocalDate(LocalDateTime.now());

        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(IdNotFoundException.class)
    public String handleExceptionForIdNotFound(IdNotFoundException exception){
        return exception.getMessage();
    }
}
