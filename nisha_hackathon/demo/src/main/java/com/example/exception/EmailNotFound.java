package com.example.exception;

public class EmailNotFound extends Exception{
    public EmailNotFound(String message){
        super (message);
    }
}
