package com.epamcourse.test;

import com.epamcourse.pageobject.qatools.DashBoardPage;
import com.epamcourse.pageobject.qatools.ElementsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.DoubleAccumulator;

public class MouseActionsTest  extends  BaseTest{

    @Test
    public void dragDRopMouseTest() {
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        ElementsPage elementsPage = new ElementsPage(driver);
        String expectedText = "Dropped!";

        dashBoardPage.goInteraction();
        elementsPage.droppablemenu();
        elementsPage.DragAndDrop();
        String droppableElementText =  elementsPage.getDroppableElemntText(expectedText);
        Assert.assertEquals(droppableElementText,expectedText);

    }

    @Test
    public void selectOptionsTest() throws InterruptedException {
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        ElementsPage elementsPage = new ElementsPage(driver);

        dashBoardPage.goWitgetsButton();
        elementsPage.selectmenu();
        Thread.sleep(5000);
        elementsPage.selectOptionCars();
        List<WebElement> options = elementsPage.getselectOptionCars();

        List<String> expectedSelectedOptions = List.of("Volvo", "Opel", "Audi");

        List<String> actualSelectedOptions = new ArrayList<>();
        for (WebElement option : options) {
            if (option.isSelected()) {
                actualSelectedOptions.add(option.getText());
            }
        }
        Assert.assertEquals(actualSelectedOptions, expectedSelectedOptions, "Selected options do not match");

    }

}
