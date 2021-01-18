package com.ydprojects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AmazonProductDetailPage extends AmazonHomePage {

    @FindBy(xpath = "//*[@id=\"altImages\"]/ul")
    protected WebElement listOfImages;

    public AmazonProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnFirstImage(){
        List<WebElement> images = listOfImages.findElements(By.tagName("li"))
                .stream()
                .filter(webElement -> webElement.getAttribute("innerHTML").contains("img src"))
                .filter(webElement -> !webElement.getAttribute("innerHTML").contains("video"))
                .collect(Collectors.toList());
        images.get(1).click();
    }
}
