package com.epamcourse.pagecomponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product extends BaseComponent {


    public Product(WebElement root) {
        super(root);
    }

    public String getName() {
        // Locating an element begins at the root of the component
        return root.findElement(By.className("inventory_item_name")).getText();
    }

    public BigDecimal getPrice() {
        return new BigDecimal(
                root.findElement(By.className("inventory_item_price"))
                        .getText()
                        .replace("$", "")
        ).setScale(2, RoundingMode.UNNECESSARY); // Sanitation and formatting
    }

    public void addToCart() {
        root.findElement(By.className("btn_primary")).click();
    }

    public void removeToCart() {
        root.findElement(By.className("btn_secondary")).click();

    }


}
