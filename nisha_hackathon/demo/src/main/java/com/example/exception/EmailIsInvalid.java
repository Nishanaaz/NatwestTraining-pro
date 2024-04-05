package com.example.exception;

public class EmailIsInvalid extends Exception{
    public EmailIsInvalid (String message){
        super(message);
    }
}
