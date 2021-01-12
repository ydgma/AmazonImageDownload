package com.ydprojects.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SharedClass {

    private WebDriver driver;

    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/chromedriver.exe");
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }
}
