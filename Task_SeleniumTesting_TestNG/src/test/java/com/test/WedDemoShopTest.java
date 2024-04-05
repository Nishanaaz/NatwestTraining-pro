package com.test;

import com.google.common.base.Verify;
import com.pom.AddToCart;
import com.pom.LoginPage;
import com.pom.Registration;
import com.pom.SelectBook;
import com.utils.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class WedDemoShopTest {
    @Test
    public void Verify(){
        Registration registration = new Registration();
        DriverUtils.getDriver().get("https://demowebshop.tricentis.com/register");
        registration.enterGender();
        registration.enterFirstname("Nisha");
        registration.enterLastName("Armani");
        registration.enterEmail("nisha@gmail.com");
        registration.enterPassword("nisha123");
        registration.enterConfirmPassword("nisha123");
        registration.clickRegisterButton();
    }

    @Test
    public void verifyLogin(){
        LoginPage loginPage = new LoginPage();
        DriverUtils.getDriver().get("https://demowebshop.tricentis.com");
        loginPage.clickLoginIcon();
        loginPage.enterEmail("john@11123.gmail.com");
        loginPage.enterPassword("john12");
        loginPage.clickLoginPage();
    }
    @Test
    public void verifySelectingBook(){
        SelectBook selectBook = new SelectBook();
//        DriverUtils.getDriver().get("https://demowebshop.tricentis.com");
        selectBook.clickOnBooks();
        selectBook.selectPriceRange();
        selectBook.selectComputingAndInternet();
    }
    @Test
    public void verifyAddToCart(){
        AddToCart addToCart = new AddToCart();
//        DriverUtils.getDriver().get("https://demowebshop.tricentis.com");
        addToCart.clickAddToCart();
        addToCart.clickOnCartLabel();
        addToCart.clickTermOfService();
        addToCart.clickOnCheckOut();
    }
}
