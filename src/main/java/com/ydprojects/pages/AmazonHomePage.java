package com.ydprojects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {

    private static final String HOME_PAGE_URL = "http://www.amazon.co.uk";

    protected WebDriver driver;

    @FindBy(id = "twotabsearchtextbox")
    protected WebElement searchBox;

    @FindBy(id = "nav-search-submit-text")
    protected WebElement searchButton;

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void open() {
        driver.get(HOME_PAGE_URL);
    }

    public void searchForProduct(String name) {
        searchBox.sendKeys(name);
        searchButton.click();
    }
}