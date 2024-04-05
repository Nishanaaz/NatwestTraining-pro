package com.natwest.exception;

import lombok.Getter;

@Getter
public class InvalidAgeException extends Exception {

    private String msg;
    public InvalidAgeException(String msg) {
        this.msg = msg;
    }
}
