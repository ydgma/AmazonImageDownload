package com.ydprojects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AmazonProductListPage extends AmazonHomePage {

    private static final Logger LOG = LoggerFactory.getLogger(AmazonProductListPage.class);

    @FindBy(xpath = "//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")
    protected WebElement searchResultInfo;

    public AmazonProductListPage(WebDriver driver) {
        super(driver);
    }

    public boolean areProductsWithNameDisplayed(String productName) {
        return searchResultInfo.getText().contains(productName);
    }

    //TODO need to improve on this
    public void clickOnItemNumber(int number) {
        clickAcceptCookiesButton();
        try {
            clickOnStandardItem(number);
        } catch (NoSuchElementException e) {
            LOG.info(e.getMessage());
            clickOnSponsoredItem(number);
        }
    }

    private void clickOnStandardItem(int number) {
        WebElement item = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div["+number+"]/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a"));
        item.click();
    }

    private void clickOnSponsoredItem(int number) {
        WebElement item = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div["+number+"]/div/span/div/div/div/div/div[2]/div[2]/div/div[1]/div/div/div/h2/a"));
        item.click();
    }


}
