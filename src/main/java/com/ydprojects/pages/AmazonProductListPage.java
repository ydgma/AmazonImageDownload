package com.ydprojects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonProductListPage extends AmazonHomePage {

    @FindBy(xpath = "//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")
    protected WebElement searchResultInfo;

    @FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[2]")
    protected WebElement firstItem;

    @FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[1]/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a")
    protected WebElement firstItemLink;

    public AmazonProductListPage(WebDriver driver) {
        super(driver);
    }

    public boolean areProductsWithNameDisplayed(String productName) {
        return searchResultInfo.getText().contains(productName);
    }

    public void clickOnItemNumber(int number) {
        clickAcceptCookiesButton();
        WebElement item = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div["+number+"]/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a"));
        item.click();

    }
}
