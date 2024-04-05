package com.natwest.exception;

public class AlreadyAppliedForLoan extends Exception {
    public AlreadyAppliedForLoan(String message) {
        super( message );
    }
}
