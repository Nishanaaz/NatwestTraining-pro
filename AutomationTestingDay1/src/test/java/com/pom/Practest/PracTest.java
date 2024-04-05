package com.pom.Practest;
import org.testng.annotations.Test;
//import org.testng.annotations.tests;

public class PracTest {
   @Test(priority=2)
    public void Addition(){
        System.out.println("This is Addition");
    }
    @Test(priority=1)
    public void Subtraction(){
        System.out.println("This is Subtraction ");
    }
    @Test(enabled = false)
    public void Multiplication(){
        System.out.println("This is Multplication");
    }


    @Test(dependsOnMethods = "Subtraction")
    public void Division(){
        System.out.println("This is Division");
    }
}
