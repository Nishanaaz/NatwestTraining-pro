package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectBook extends BasePage{
    @FindBy (xpath = "(//a[contains(text(),'Books')])[1]")
    WebElement books;
    @FindBy  (xpath = "(//span[@class='PriceRange'])[1]")
    WebElement priceRange;

    @FindBy (xpath = "//img[@alt='Picture of Computing and Internet']")
    WebElement computingAndInternet;

    public void clickOnBooks(){
        books.click();
    }
    public void selectPriceRange(){
        priceRange.click();
    }
    public void selectComputingAndInternet(){
        computingAndInternet.click();
    }
}
