package com.natwest.exception;

public class IdNotFoundException extends Exception{
    String message;
    public IdNotFoundException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
