package com.epamcourse.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FinishPage extends  BasePage{

    @FindBy(className = "complete-header")
    WebElement successfulPurchase;

    public FinishPage(WebDriver driver) {
        super(driver);
    }


    public boolean  successfulPurchase(){
        return successfulPurchase.isDisplayed();
    }
}
