package com.natwest.exception;

import lombok.Getter;

@Getter
public class UserProfileAlreadyExistsException extends Exception {

    private  String msg;
    public UserProfileAlreadyExistsException(String msg) {
        this.msg = msg;
    }
}
