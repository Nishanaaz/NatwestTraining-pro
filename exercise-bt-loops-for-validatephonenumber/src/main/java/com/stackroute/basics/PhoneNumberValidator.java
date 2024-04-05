package com.stackroute.basics;

import java.util.Scanner;

public class PhoneNumberValidator {
    //Create Scanner object as instance variable
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //call the functions in the required sequence
        PhoneNumberValidator validator = new PhoneNumberValidator();

        // Get input
        String phoneNumber = validator.getInput();

        // Validate phone number
        int validationResult = validator.validatePhoneNumber(phoneNumber);

        // Display result
        validator.displayResult(validationResult);

        // Close scanner
        validator.closeScanner();
    }

    public String getInput() {
        return scanner.nextLine();
    }

    public void displayResult(int result) {
        //displays the result
        if (result == 1) {
            System.out.println("Valid");
        } else if(result ==0 ){
            System.out.println("Invalid");
        }else System.out.println("Empty String");
    }

    public int validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return -1; // Empty or null input
        }

        // Remove dashes and check if remaining characters are digits
        String digitsOnly = phoneNumber.replaceAll("-", "");
        if (!digitsOnly.matches("\\d{10}")) {
            return 0; // Not exactly 10 digits after removing dashes
        }

        // If all conditions are met, return 1
        return 1;
    }
    public void closeScanner(){
        //close the Scanner object
        scanner.close();
    }
}
