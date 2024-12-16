package com.epamcourse.pageobject.qatools;

import com.epamcourse.pageobject.BasePage;
import com.epamcourse.test.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class ElementsPage extends BasePage {

    @FindBy(xpath = "//span[text()='Droppable']/ancestor::li[@id='item-3']")
    WebElement droppableButton;

    @FindBy(xpath = "//span[text()='Select Menu']/ancestor::li[@id='item-8']")
    WebElement selecMenuButton;

    @FindBy(id = "draggable")
    WebElement draggableElement;

    @FindBy(id = "droppable")
    WebElement droppableElement;

    @FindBy(id = "cars")
    WebElement selectElement;


    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public void droppablemenu(){
        droppableButton.click();
    }

    public void selectmenu(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", selecMenuButton);
    }

    public void DragAndDrop(){
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(draggableElement));
        wait.until(ExpectedConditions.elementToBeClickable(draggableElement));
        wait.until(ExpectedConditions.visibilityOf(droppableElement));
        wait.until(ExpectedConditions.elementToBeClickable(droppableElement));
        actions.dragAndDrop(draggableElement, droppableElement).perform();
    }

    public String getDroppableElemntText(String expectedText){
        wait.until(ExpectedConditions.textToBe(By.id("droppable"), expectedText));
        return droppableElement.getText();
    }

    public  List<WebElement> getselectOptionCars(){
         return  selectElement.findElements(By.tagName("option"));

    }

    public void selectOptionCars(){
        Actions actions = new Actions(driver);

        List<WebElement> options = selectElement.findElements(By.tagName("option"));

        for (WebElement option : options) {
            wait.until(ExpectedConditions.visibilityOf(option));
            wait.until(ExpectedConditions.elementToBeClickable(option));
        }


        actions.keyDown(Keys.CONTROL)
                .moveToElement(options.get(0))
                .click(options.get(0))
               .moveToElement(options.get(2))
                .click(options.get(2))
                .moveToElement(options.get(3))
                .click(options.get(3))
                .perform();
    }
}
