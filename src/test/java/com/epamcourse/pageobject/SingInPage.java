package com.epamcourse.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SingInPage  extends  BasePage{


    @FindBy(name = "email")
    WebElement emailField;


    public SingInPage(WebDriver driver) {
        super(driver);
    }

    public boolean emailFieldIspresent(){
        wait.until(ExpectedConditions.visibilityOf(emailField));
        return  emailField.isDisplayed();
    }
}
