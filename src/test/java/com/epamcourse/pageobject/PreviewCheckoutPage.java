package com.epamcourse.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PreviewCheckoutPage extends  BasePage{



    @FindBy(id = "nav-cart-count")
    WebElement goToCart;


    public PreviewCheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void goToCart(){
        goToCart.click();
    }
}
