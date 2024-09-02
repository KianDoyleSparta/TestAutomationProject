package com.sparta.groupc.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private final WebDriver webDriver;

    private final By productName = By.cssSelector(".page-title > h1");
    private final By productPrice = By.cssSelector(".price");
    private final By productDescription = By.cssSelector(".product-description");
    private final By productAvailability = By.cssSelector(".availability");
    private final By errorMessage = By.cssSelector(".message-error");

    public ProductPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getProductName() {
        return webDriver.findElement(productName).getText();
    }

    public String getProductPrice() {
        return webDriver.findElement(productPrice).getText();
    }

    public String getProductDescription() {
        return webDriver.findElement(productDescription).getText();
    }

    public String getProductAvailability() {
        return webDriver.findElement(productAvailability).getText();
    }

    public String getErrorMessage() {
        return webDriver.findElement(errorMessage).getText();
    }
}
