package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCart extends BasePage{
    @FindBy (xpath = "//input[@id='add-to-cart-button-13']")
    WebElement addToCartButton;
    @FindBy (xpath = "//span[@class=\"cart-label\"]")
    WebElement cartLabel;
    @FindBy (xpath = "//input[@id='termsofservice']")
    WebElement termOfService;
    @FindBy (xpath = "//button[@id='checkout']")
    WebElement checkOut;

    public void clickAddToCart(){
        addToCartButton.click();
    }
    public void clickOnCartLabel(){
        cartLabel.click();
    }
    public void clickTermOfService(){
        termOfService.click();
    }
    public void clickOnCheckOut(){
        checkOut.click();
    }

}
