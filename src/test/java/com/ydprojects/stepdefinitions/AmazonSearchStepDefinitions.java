package com.ydprojects.stepdefinitions;

import com.ydprojects.pages.AmazonHomePage;
import com.ydprojects.pages.AmazonProductSearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearchStepDefinitions {

    private AmazonHomePage homePage;
    private WebDriver driver;

    public AmazonSearchStepDefinitions(SharedClass sharedClass) {
        driver = sharedClass.getDriver();
    }

    @When("I navigate to amazon home page")
    public void iNavigateToAmazonHomePage() {
        homePage = new AmazonHomePage(driver);
        homePage.open();
    }

    @And("I search for {string}")
    public void iSearchFor(String productName) {
        homePage.searchForProduct(productName);
    }

}
