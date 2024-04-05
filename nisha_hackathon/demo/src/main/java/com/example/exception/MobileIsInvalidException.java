package com.example.exception;

public class MobileIsInvalidException extends Exception{
    public MobileIsInvalidException(String message){
        super(message);
    }
}
