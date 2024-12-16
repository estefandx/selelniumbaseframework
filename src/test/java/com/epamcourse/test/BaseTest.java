package com.epamcourse.test;

import com.epamcourse.config.ConfigReader;
import com.epamcourse.hook.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;


    @BeforeMethod
    @Parameters("url")
    public void setup(String urlKey) {
        driver = DriverManager.getDriver();
        driver.get(ConfigReader.getUrl(urlKey));
    }

    @AfterMethod
   public void tearDown(){DriverManager.quitDriver();}

}
