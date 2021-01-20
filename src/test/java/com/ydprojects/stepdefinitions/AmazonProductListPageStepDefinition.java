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

    @And("I click on the item number {int}")
    public void iClickOnTheItemNumber(int number) {
        amazonProductListPage = new AmazonProductListPage(driver);
        amazonProductListPage.clickOnItemNumber(number);
    }

    @Then("all images for are successfully downloaded for item number {int}")
    public void allImagesForAreSuccessfullyDownloadedForItemNumber(int productListNumber) {
        amazonProductDetailPage = new AmazonProductDetailPage(driver);
        Assert.assertTrue(amazonProductDetailPage.downloadAllImages(productListNumber));
    }
}
