package com.ydprojects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonProductSearchPage extends AmazonHomePage {

    @FindBy(xpath = "//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")
    protected WebElement searchResultInfo;

    public AmazonProductSearchPage(WebDriver driver) {
        super(driver);
    }

    public boolean areProductsWithNameDisplayed(String productName) {
        return searchResultInfo.getText().contains(productName);
    }
}
