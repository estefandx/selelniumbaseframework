package com.epamcourse.pageobject;

import com.epamcourse.pagecomponent.CartItem;
import com.epamcourse.pagecomponent.Product;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage  extends  BasePage{

    @FindBy(className = "cart_item")
    List<WebElement> cartItemList;

    @FindBy(className = "checkout_button")
    WebElement checkoutButton;


    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("get list of items in the cart")
    public List<CartItem> getListCartItems(){
        List<CartItem> cartItems = new ArrayList<>();
        for(WebElement product: cartItemList){
            cartItems.add(new CartItem(product));
        }
        return  cartItems;
    }

    @Step("get item by name: {0} ")
    public CartItem getItem(String itemName) {

        List<CartItem> cartItems = getListCartItems();
        for (CartItem cartItem : cartItems) {
            if (cartItem.getItemName().equals(itemName)) {
                return cartItem;
            }
        }
        throw new NoSuchElementException("item not found: " + itemName);
    }

    public  YourInformationPage checkout(){
        checkoutButton.click();
        return new YourInformationPage(driver);
    }
}
