package com.natwest.exception;

import lombok.Getter;

@Getter
public class InvalidContactNumberException extends Exception{

    private  String msg;
    public InvalidContactNumberException(String msg) {
        this.msg = msg;
    }
}
