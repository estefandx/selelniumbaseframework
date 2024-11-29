package com.epamcourse.test;

import com.epamcourse.data.loginuser.LoginUser;
import com.epamcourse.data.loginuser.LoginUserBuilder;
import com.epamcourse.hook.BaseTest;
import com.epamcourse.pagecomponent.CartItem;
import com.epamcourse.pagecomponent.Product;
import com.epamcourse.pageobject.CartPage;
import com.epamcourse.pageobject.LoginPage;
import com.epamcourse.pageobject.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class CartTest extends BaseTest {

    @Test
    public void testItemsAddcartSaccesfully() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        LoginUser validUser = LoginUserBuilder.validUser();
        ProductPage productPage =  loginPage.loginAs(validUser);
        Product product1 = productPage.getProduct("Sauce Labs Backpack");
        Product product2 = productPage.getProduct("Sauce Labs Onesie");
        BigDecimal  priceProduct1 = product1.getPrice();
        BigDecimal  priceProduct2 = product2.getPrice();

        product1.addToCart();
        product2.addToCart();
        CartPage cartPage = productPage.cartItemsButton();

        CartItem cartItem1 = cartPage.getItem("Sauce Labs Backpack");
        CartItem cartItem2 = cartPage.getItem("Sauce Labs Onesie");

        Assert.assertEquals(cartItem1.getItemPrice(),priceProduct1);
        Assert.assertEquals(cartItem2.getItemPrice(),priceProduct2);



    }
}
