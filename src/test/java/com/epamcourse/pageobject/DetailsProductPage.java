package com.epamcourse.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailsProductPage  extends  BasePage{

    @FindBy(id = "add-to-cart-button")
    WebElement addProductCart;

    @FindBy(id = "productTitle")
    WebElement productTitle;

    @FindBy(id = "add-to-cart-confirmation-image")
    WebElement confirmationProduct;

    public DetailsProductPage(WebDriver driver) {
        super(driver);
    }

    public void addProductCart(){
        addProductCart.click();
    }

    public String getProductTitle(){
        return  productTitle.getText();
    }

    public boolean isVisibleProductConfirmation(){
        return  confirmationProduct.isDisplayed();
    }
}
