package com.epamcourse.hook;


import com.epamcourse.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager {


    private static WebDriver driver;


    private DriverManager() {}


    public static WebDriver getDriver() {
        if (driver == null) {
            synchronized (DriverManager.class) {
                if (driver == null) {
                    initializeDriver();
                }
            }
        }
        return driver;
    }


    private static void initializeDriver() {
        String browser = ConfigReader.getBrowser(); // Lee el navegador de la configuración
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("not support browser: " + browser);
        }
        configureDriver();
    }

    private static void configureDriver() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getImplicitWait()));
    }
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
