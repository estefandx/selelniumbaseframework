package com.epamcourse.pageobject;

import com.epamcourse.data.userinfo.UserInfo;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class YourInformationPage extends BasePage {

    @FindBy(id = "first-name")
    WebElement firstNameInput;

    @FindBy(id = "last-name")
    WebElement lastNameInput;

    @FindBy(id = "postal-code")
    WebElement zipCodeInput;

    @FindBy(xpath = "//input[@value='CONTINUE']")
    WebElement continueButton;


    public YourInformationPage(WebDriver driver) {
        super(driver);
    }

    @Step("fill information with first Name:  {0}.firstName  lastName: {0}.lastName  zipcode: {0}.postalCode")
    public void fillInformation(UserInfo userInfo) {
        firstNameInput.sendKeys(userInfo.getFirstName());
        lastNameInput.sendKeys(userInfo.getLastName());
        zipCodeInput.sendKeys(userInfo.getPostalCode());
    }

    public CheckoutPage   completeInformation() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
       return  new CheckoutPage(driver);
    }
}
