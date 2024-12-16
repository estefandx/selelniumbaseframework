package com.epamcourse.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShoppingCartPage extends  BasePage{

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "a-truncate-cut")
    List<WebElement> productCartList;

    @FindBy(id = "sc-subtotal-label-activecart")
    WebElement subTotalItems;

    private final By actionLinksItems = By.xpath("//span[@data-action= 'quantity']");

    @FindBy(name = "proceedToRetailCheckout")
    WebElement proceedCheckout;


    public int itemsCartList(){
        return productCartList.size();
    }

    public int getItemCount() throws InterruptedException {
        Thread.sleep(500);
        String text = subTotalItems.getText();
        Pattern pattern = Pattern.compile("\\((\\d+) items\\)");
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        } else {

            return 0;
        }
    }

    public void deleteItem(int positionItem){
        List<WebElement> deleteActionButton  = driver.findElements(By.xpath(".//input[@value='Delete']"));
        WebElement item = deleteActionButton.get(positionItem);
        item.click();
    }

    public void addNumberItems(int numberItems, int positionItem) throws InterruptedException {
        for (int i = 1; i < numberItems; i++) {
            try {

                List<WebElement> itemlist = driver.findElements(actionLinksItems);
                WebElement item = itemlist.get(positionItem).findElement(By.xpath(".//button[@data-a-selector='increment']"));
                wait.until(ExpectedConditions.elementToBeClickable(item));
                item.click();
                Thread.sleep(500);

            } catch (StaleElementReferenceException e) {
                System.out.println("Obsolete item found, retrying...");
                i--;
            }
        }
    }

    public void proceedCheckout(){
        proceedCheckout.click();
    }
}
