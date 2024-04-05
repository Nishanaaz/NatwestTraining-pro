package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;
    BasePage(){
        driver = com.utils.DriverUtils.getDriver();
        PageFactory.initElements(driver,this);
    }
}
