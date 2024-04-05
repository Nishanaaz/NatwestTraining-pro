package com.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    //Declaration
    @FindBy(name = "username")
    WebElement txtUsername;
    @FindBy(xpath = "//input[@name = 'password']")
    WebElement textPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement buttonLogin;


    //Intialization
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }



    //Utilization
    public void enterUsername(String str){
        txtUsername.sendKeys(str);
    }

    public void enterPassword(String str){
        textPassword.sendKeys(str);
    }

    public void clickLogin(){
        buttonLogin.click();
    }
}
