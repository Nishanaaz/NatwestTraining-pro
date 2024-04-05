package com.stackroute.basics;

import java.util.Scanner;

public class StringFinder {
    //Create Scanner object as instance variable
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Get three strings from the user
        String s1= getInput();
        String s2= getInput();
        String s3= getInput();

        int result = Integer.parseInt(String.valueOf((findString(s1,s2,s3))));
        displayResult(result);

    }

    public static String getInput() {
        String string= sc.next();
        return string;
    }

    public static void displayResult(int result) {
        //displays the result
        if(result==1) System.out.println("Found as expected");
        else if (result==-1) {
            System.out.println("Empty string or null");
        }else System.out.println("Not found");
    }

    public static int findString(String searchString, String firstString, String secondString) {
        if(searchString.isEmpty() || firstString.isEmpty() || secondString.isEmpty())
        return -1;
        if(firstString.contains(searchString) || secondString.contains(searchString))
            return 1;
        else return 0;
    }

    public void closeScanner() {
        closeScanner();
    }
}
