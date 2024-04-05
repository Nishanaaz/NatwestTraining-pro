package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverUtils {
    static WebDriver driver;
    public static void createWebDriver(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\RBS\\Documents\\Task_SeleniumTesting_TestNG\\src\\test\\java\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver(){
        if(driver==null){
            createWebDriver();
        }return driver;
    }
}
