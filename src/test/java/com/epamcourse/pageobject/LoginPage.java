package com.epamcourse.pageobject;

import com.epamcourse.data.loginuser.LoginUser;
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


    public ProductPage loginAs(LoginUser loginUser) {
        userNameInput.sendKeys(loginUser.getUsername());
        passwordInput.sendKeys(loginUser.getPassword());
        loginButton.click();
        return new ProductPage(driver);
    }

    public void loginBlockUser(LoginUser loginUser) {
        userNameInput.sendKeys(loginUser.getUsername());
        passwordInput.sendKeys(loginUser.getPassword());
        loginButton.click();
    }

    public String getErrorMessage(){
        return  errormessage.getText();
    }


}
