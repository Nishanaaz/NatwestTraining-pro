package com.natwest.exception;

import lombok.Getter;

@Getter
public class InvalidEmailIDException extends Exception {

    private String msg;
    public InvalidEmailIDException(String msg) {
        this.msg = msg;
    }
}
