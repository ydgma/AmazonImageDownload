package com.ydprojects.stepdefinitions;

import com.ydprojects.pages.AmazonHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class AmazonSearchStepDefinitions {

    private AmazonHomePage homePage = new AmazonHomePage();

    @When("I navigate to amazon home page")
    public void iNavigateToAmazonHomePage() {
        homePage.open();
    }

    @And("I search for {string}")
    public void iSearchFor(String productName) {
        homePage.searchForProduct(productName);
    }
}
