package com.epamcourse.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckoutPage  extends  BasePage{

    @FindBy(className = "summary_subtotal_label")
    WebElement sumaryPrice;

    @FindBy(css = ".btn_action.cart_button")
    WebElement finishCheckout;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("get summary total price")
    public BigDecimal getSumaryTotalPrice(){
        String value = sumaryPrice.getText();
        Pattern pattern = Pattern.compile("\\$([\\d,]+\\.\\d{2})");
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()) {
            return new BigDecimal(matcher.group(1));
        }
        throw new RuntimeException("Could not extract the item total.");
    }

    public void finishCheckout(){
        finishCheckout.click();
    }
}
