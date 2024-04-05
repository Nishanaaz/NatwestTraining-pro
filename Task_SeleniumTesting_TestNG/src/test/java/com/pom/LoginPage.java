package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy (className = "ico-login")
    WebElement iconLogin;
    @FindBy (id = "Email")
    WebElement email;

    @FindBy (id = "Password")
    WebElement password;
    @FindBy (xpath = "//input[@class=\"button-1 login-button\"]")
    WebElement loginButton;

    public void clickLoginIcon(){
        iconLogin.click();
    }
    public void enterEmail(String str){
        email.sendKeys(str);
    }
    public void enterPassword(String str){
        password.sendKeys(str);
    }
    public void clickLoginPage(){
        loginButton.click();
    }
}
