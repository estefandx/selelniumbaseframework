package com.epamcourse.pageobject;

import com.epamcourse.data.loginuser.LoginUser;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends  BasePage {

    @FindBy(name = "user-name")
    WebElement userNameInput;

    @FindBy(name = "password")
    WebElement passwordInput;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errormessage;



    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Enter valid user with username: {0.username} and password: {0.password}")
    public ProductPage loginAs(LoginUser loginUser) {
        userNameInput.sendKeys(loginUser.getUsername());
        passwordInput.sendKeys(loginUser.getPassword());
        loginButton.click();
        return new ProductPage(driver);
    }

    @Step("Enter block user with username: {0.username} and password: {0.password}")
    public void loginBlockUser(LoginUser loginUser) {
        userNameInput.sendKeys(loginUser.getUsername());
        passwordInput.sendKeys(loginUser.getPassword());
        loginButton.click();
    }
    @Step("check error message")
    public String getErrorMessage(){
        return  errormessage.getText();
    }


}
