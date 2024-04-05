package com.natwest.controlleradvice;


import com.natwest.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({UserProfileAlreadyExistsException.class})
    public ResponseEntity<ApiResponse> handleUserProfileAlreadyExistsException(UserProfileAlreadyExistsException exception) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
        apiResponse.setErrorMessage(exception.getMsg());
        apiResponse.setLocalDateTime(LocalDateTime.now());
        return new ResponseEntity(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({UserNameNotExistsException.class})
    public ResponseEntity<ApiResponse> handleUserProfileNotExistsException(UserNameNotExistsException exception) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
        apiResponse.setErrorMessage(exception.getMsg());
        apiResponse.setLocalDateTime(LocalDateTime.now());
        return new ResponseEntity(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InvalidAgeException.class})
    public ResponseEntity<ApiResponse> handleInvalidAgeException(InvalidAgeException exception) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
        apiResponse.setErrorMessage(exception.getMsg());
        apiResponse.setLocalDateTime(LocalDateTime.now());
        return new ResponseEntity(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidContactNumberException.class)
    public ResponseEntity<ApiResponse> handleInvalidContactNumberException(InvalidContactNumberException exception) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
        apiResponse.setErrorMessage(exception.getMsg());
        apiResponse.setLocalDateTime(LocalDateTime.now());
        return new ResponseEntity(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InvalidEmailIDException.class})
    public ResponseEntity<ApiResponse> handleInvalidEmailException(InvalidEmailIDException exception) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
        apiResponse.setErrorMessage(exception.getMsg());
        apiResponse.setLocalDateTime(LocalDateTime.now());
        return new ResponseEntity(apiResponse, HttpStatus.BAD_REQUEST);
    }



}
