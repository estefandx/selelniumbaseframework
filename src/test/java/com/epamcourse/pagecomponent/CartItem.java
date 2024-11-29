package com.epamcourse.pagecomponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CartItem extends  BaseComponent {

    public CartItem(WebElement root) {
        super(root);
    }

    public String getItemName() {

        return root.findElement(By.className("inventory_item_name")).getText();
    }

    public BigDecimal getItemPrice() {
        return new BigDecimal(
                root.findElement(By.className("inventory_item_price"))
                        .getText()
                        .replace("$", "")
        ).setScale(2, RoundingMode.UNNECESSARY);
    }
}
