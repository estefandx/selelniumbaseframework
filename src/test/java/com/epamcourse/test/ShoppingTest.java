package com.epamcourse.test;

import com.epamcourse.data.loginuser.LoginUser;
import com.epamcourse.data.loginuser.LoginUserBuilder;
import com.epamcourse.data.userinfo.UserInfo;
import com.epamcourse.data.userinfo.UserInfoBuilder;
import com.epamcourse.hook.BaseTest;
import com.epamcourse.pagecomponent.Product;
import com.epamcourse.pageobject.*;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class ShoppingTest  extends BaseTest {


    @Test
    public  void testInventoryItemsShowed(){
        LoginPage loginPage = new LoginPage(driver);
        LoginUser validUser = LoginUserBuilder.validUser();
        ProductPage productPage =  loginPage.loginAs(validUser);
        int amountItemsActual = productPage.getListProducts().size();
        Assert.assertEquals(amountItemsActual,6);

    }


    @Test
    @Description("This test attempts to validate that the total price is correct in the checkout")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Bryan Moreno")
    public void TestShoppingSuccessfully() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        UserInfo userInfo = UserInfoBuilder.validUser();
        LoginUser validUser = LoginUserBuilder.validUser();

        ProductPage productPage =  loginPage.loginAs(validUser);

        Product product1 = productPage.getProduct("Sauce Labs Backpack");
        Product product2 = productPage.getProduct("Sauce Labs Onesie");
        BigDecimal priceProduct1 = product1.getPrice();
        BigDecimal priceProduct2 = product2.getPrice();

        product1.addToCart();
        product2.addToCart();
        CartPage cartPage = productPage.cartItemsButton();

        YourInformationPage yourInformationPage = cartPage.checkout();

        yourInformationPage.fillInformation(userInfo);
        CheckoutPage checkoutPage = yourInformationPage.completeInformation();

        BigDecimal totalPriceActual  = checkoutPage.getSumaryTotalPrice();
        BigDecimal totalPriceExpect = priceProduct1.add(priceProduct2);
        Assert.assertEquals(totalPriceActual,totalPriceExpect);

    }
}
