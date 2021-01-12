package com.ydprojects.stepdefinitions;

import com.ydprojects.pages.AmazonProductSearchPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AmazonProductListPageStepDefinition {

    AmazonProductSearchPage productSearchPage;
    WebDriver driver;

    public AmazonProductListPageStepDefinition (SharedClass sharedClass) {
        driver = sharedClass.getDriver();
    }

    @Then("items of {string} are displayed")
    public void itemsOfAreDisplayed(String productName) {
        productSearchPage = new AmazonProductSearchPage(driver);
        Assert.assertTrue(productSearchPage.areProductsWithNameDisplayed(productName));
    }
}
