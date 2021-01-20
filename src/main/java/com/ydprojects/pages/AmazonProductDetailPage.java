package com.ydprojects.pages;

import com.ydprojects.util.ImageDownloadUtil;
import com.ydprojects.util.RegexUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AmazonProductDetailPage extends AmazonHomePage {

    private List<WebElement> imageThumbnailLinks = new ArrayList<>();
    private List<WebElement> mainImageList = new ArrayList<>();

    @FindBy(xpath = "//*[@id=\"altImages\"]/ul")
    protected WebElement listOfImageThumbnails;

    @FindBy(xpath = "//*[@id=\"main-image-container\"]/ul")
    protected WebElement listOfMainImages;

    public AmazonProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean downloadAllImages(int productListNumber) {
        boolean downloaded = false;
        populateImageList();
        int counter = 0;
        for(WebElement element : mainImageList){
            String src = RegexUtil.extractSrcFromElement(element.getAttribute("innerHTML"));
            ImageDownloadUtil.downloadImage(src,String.valueOf(counter),String.valueOf(productListNumber));
            counter++;
            if (Files.isDirectory(Paths.get("src/test/resources/images/"+productListNumber+""))) {
                downloaded = true;
            }
        }
        return downloaded;
    }

    public void downloadImage(int imageNumber, int productListNumber) {
        populateImageList();
        WebElement image = mainImageList.get(imageNumber);
        String src = RegexUtil.extractSrcFromElement(image.getAttribute("innerHTML"));
        ImageDownloadUtil.downloadImage(src,String.valueOf(imageNumber),String.valueOf(productListNumber));
    }

    private void populateImageList() {
        clickOnThumbnails();
        mainImageList = listOfMainImages.findElements(By.tagName("li"))
                .stream()
                .filter(webElement -> webElement.getAttribute("innerHTML").contains("src"))
                .collect(Collectors.toList());
    }

    private void clickOnThumbnails() {
        populateThumbnailList();
        for(WebElement thumbNail : imageThumbnailLinks){
            thumbNail.click();
        }
    }

    private void populateThumbnailList() {
        imageThumbnailLinks = listOfImageThumbnails.findElements(By.tagName("li"))
                .stream()
                .filter(webElement -> webElement.getAttribute("innerHTML").contains("img src"))
                .filter(webElement -> !webElement.getAttribute("innerHTML").contains("video"))
                .collect(Collectors.toList());
    }



}
