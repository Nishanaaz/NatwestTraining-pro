package com.natwest.exception;

public class InValidAmountException extends Exception{
    String message;

    public InValidAmountException(String message) {
        super(message);
        this.message=message;

    }

    @Override
    public String getMessage() {
        return message;
    }
}
