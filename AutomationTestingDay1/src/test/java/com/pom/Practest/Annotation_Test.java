package com.pom.Practest;

import org.testng.annotations.Test;

public class Annotation_Test {
    @Test
    public void OrangeHRMVerifyLogin(){
        System.out.println("Login Validate");
    }

    @Test(groups = {"OrangeHRMVerifyLogin","TestNGVerifyLogin"})
    public void TestNGVerifyLogin(){
        System.out.println("Test Login Validate");
    }

    @Test(dependsOnGroups = {"OrangeHRMVerifyLogin","TestNGVerifyLogin"})
    public void AmazonVerifyLogout(){
        System.out.println("Logout Validated");
    }
}
