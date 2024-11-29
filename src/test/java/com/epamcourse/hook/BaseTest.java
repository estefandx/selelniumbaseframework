package com.epamcourse.hook;

import com.epamcourse.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;


    @BeforeMethod
    public void setup() {
        driver = DriverManager.getDriver();
        driver.get(ConfigReader.getUrl());
    }


    @AfterMethod
    public void tearDown(){
        DriverManager.quitDriver();
    }

}
