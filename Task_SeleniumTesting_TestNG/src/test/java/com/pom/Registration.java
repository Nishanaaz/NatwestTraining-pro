package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.reporters.jq.BaseMultiSuitePanel;

public class Registration extends BasePage {
    @FindBy(xpath = "//input[@id=\"gender-female\"]")
    WebElement gender;

    @FindBy (id = "FirstName")
    WebElement firstname;
    @FindBy(id = "LastName")
    WebElement lastname;

    @FindBy (id = "Email")
    WebElement email;
    @FindBy (id = "Password")
    WebElement password;
    @FindBy (id = "ConfirmPassword")
    WebElement confirmPassword;
    @FindBy  (xpath = "//input[@id='register-button']")
    WebElement registerButton;

    public void enterGender(){
        gender.click();
    }
    public void enterFirstname(String str){
        firstname.sendKeys(str);
    }
    public void enterLastName(String str){
        lastname.sendKeys(str);
    }
    public void enterEmail(String str){
        email.sendKeys(str);
    }
    public void enterPassword(String str){
        password.sendKeys(str);
    }
    public void enterConfirmPassword(String str){
        confirmPassword.sendKeys(str);
    }
    public void clickRegisterButton(){
        registerButton.click();
    }
}
