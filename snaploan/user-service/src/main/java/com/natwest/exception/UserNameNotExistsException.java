package com.natwest.exception;

import lombok.Getter;

@Getter
public class UserNameNotExistsException extends Exception{

    private String msg;
    public UserNameNotExistsException(String msg) {
        this.msg = msg;
    }
}
