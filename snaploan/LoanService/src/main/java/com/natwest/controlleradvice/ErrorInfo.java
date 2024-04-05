package com.natwest.controlleradvice;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


public class ErrorInfo {

    private String errorMessage;
    private HttpStatus httpStatus;
    private LocalDateTime localDateTime;


    public ErrorInfo() {
    }

    public ErrorInfo(String errorMessage, HttpStatus httpStatus, LocalDateTime localDateTime) {
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
        this.localDateTime = localDateTime;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
