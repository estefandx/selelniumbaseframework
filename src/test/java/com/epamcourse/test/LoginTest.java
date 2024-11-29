package com.epamcourse.test;

import com.epamcourse.data.loginuser.LoginUser;
import com.epamcourse.data.loginuser.LoginUserBuilder;
import com.epamcourse.hook.BaseTest;
import com.epamcourse.pageobject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {



    @Test
    public void blockUserTest(){
        LoginPage loginPage = new LoginPage(driver);
        LoginUser blockUser = LoginUserBuilder.blockUser();
        loginPage.loginBlockUser(blockUser);
        String actualMessage = loginPage.getErrorMessage();
        String expectedMessage = "Epic sadface: Sorry, this user has been locked out.";
        Assert.assertEquals(actualMessage,expectedMessage);
    }
}
