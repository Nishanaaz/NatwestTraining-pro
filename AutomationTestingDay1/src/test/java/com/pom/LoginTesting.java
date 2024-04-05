package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTesting {
        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\RBS\\Documents\\AutomationTestingDay1\\src\\test\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            LoginPage loginPage = new LoginPage(driver);
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            loginPage.enterUsername("Admin");
            loginPage.enterPassword("admin123");
            loginPage.clickLogin();
        }
}
