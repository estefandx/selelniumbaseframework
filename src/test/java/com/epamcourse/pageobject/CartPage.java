package com.epamcourse.pageobject;

import com.epamcourse.pagecomponent.CartItem;
import com.epamcourse.pagecomponent.Product;
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

    public List<CartItem> getListCartItems(){
        List<CartItem> cartItems = new ArrayList<>();
        for(WebElement product: cartItemList){
            cartItems.add(new CartItem(product));
        }
        return  cartItems;
    }

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
