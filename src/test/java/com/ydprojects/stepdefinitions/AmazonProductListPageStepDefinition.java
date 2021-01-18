package com.ydprojects.stepdefinitions;

import com.ydprojects.pages.AmazonProductDetailPage;
import com.ydprojects.pages.AmazonProductListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AmazonProductListPageStepDefinition {

    AmazonProductListPage amazonProductListPage;
    AmazonProductDetailPage amazonProductDetailPage;
    WebDriver driver;

    public AmazonProductListPageStepDefinition (SharedClass sharedClass) {
        driver = sharedClass.getDriver();
    }

    @Then("items of {string} are displayed")
    public void itemsOfAreDisplayed(String productName) {
        amazonProductListPage = new AmazonProductListPage(driver);
        Assert.assertTrue(amazonProductListPage.areProductsWithNameDisplayed(productName));
    }

    @And("images for of the items are successfully downloaded")
    public void imagesForOfTheItemsAreSuccessfullyDownloaded() {
        amazonProductListPage = new AmazonProductListPage(driver);
        amazonProductDetailPage = new AmazonProductDetailPage(driver);
        amazonProductListPage.clickOnItemNumber(8);
        amazonProductDetailPage.clickOnFirstImage();
    }
}
