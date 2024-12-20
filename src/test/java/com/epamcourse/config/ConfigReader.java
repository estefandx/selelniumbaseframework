package com.epamcourse.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file", e);
        }
    }

    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }

    public static int getImplicitWait() {
        return Integer.parseInt(properties.getProperty("implicit.wait"));
    }
}