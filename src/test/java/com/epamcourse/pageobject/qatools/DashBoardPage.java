package com.epamcourse.pageobject.qatools;

import com.epamcourse.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage extends BasePage {

    @FindBy(xpath = "//h5[text()='Interactions']/ancestor::div[@class='card mt-4 top-card']")
    WebElement interactionButton;

    @FindBy(xpath = "//h5[text()='Widgets']/ancestor::div[@class='card mt-4 top-card']")
    WebElement witgetsButton;




    public DashBoardPage(WebDriver driver) {
        super(driver);
    }

    public void goInteraction(){
        interactionButton.click();
    }

    public void goWitgetsButton(){
        witgetsButton.click();
    }
}
