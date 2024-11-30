package com.epamcourse.pageobject;

import com.epamcourse.pagecomponent.Product;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;



public class ProductPage extends  BasePage{

    @FindBy(className = "inventory_item")
    List<WebElement> productList;

    @FindBy(xpath = "//div[@id='shopping_cart_container']/a")
    WebElement cartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Step("get list products")
    public List<Product> getListProducts(){
        List<Product> products = new ArrayList<>();
        for(WebElement product: productList){
            products.add(new Product(product));
        }
        return  products;
    }
    @Step("get product by name {0}")
    public Product getProduct(String productName) {

        List<Product> products = getListProducts();
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        throw new NoSuchElementException("product not found: " + productName);
    }

    @Step("go to Cart Page")
    public CartPage cartItemsButton(){
        cartButton.click();
        return  new CartPage(driver);
    }
}
