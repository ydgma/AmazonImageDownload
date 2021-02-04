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

    public void clickOnItemNumber(int number) {
        clickAcceptCookiesButton();
        clickOnItemWithNumber(number);
    }

    private void clickOnItemWithNumber(int itemNumber) {
        checkAndReturnIfVerticalElementIsAvailable(itemNumber).click();
    }

    private WebElement checkAndReturnIfVerticalElementIsAvailable(int itemNumber){

        String verticalNormal = "//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div["+itemNumber+"]/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a";
        String verticalSponsored = "//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div["+itemNumber+"]/div/span/div/div/div/div/div[2]/div[2]/div/div[1]/div/div/div/h2/a";
        String verticalSponsored2 = "//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div["+itemNumber+"]/div/span/div/div/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a";
        String horizontalNormal = "//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div["+itemNumber+"]/div/span/div/div/div/div/div[2]/h2/a";

        if(!driver.findElements(By.xpath(verticalNormal)).isEmpty()){

            return driver.findElement(By.xpath(verticalNormal));

        } else if (!driver.findElements(By.xpath(verticalSponsored)).isEmpty()){

            return driver.findElement(By.xpath(verticalSponsored));

        } else if (!driver.findElements(By.xpath(verticalSponsored2)).isEmpty()) {

            return driver.findElement(By.xpath(verticalSponsored2));

        }else if (!driver.findElements(By.xpath(horizontalNormal)).isEmpty()){

            return driver.findElement(By.xpath(horizontalNormal));
        } else{
            throw new NoSuchElementException("The item selector cannot be found");
        }

    }

}
