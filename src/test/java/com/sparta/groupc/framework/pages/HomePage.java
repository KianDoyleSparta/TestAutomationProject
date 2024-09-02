package com.sparta.groupc.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By yogaProductPage = By.linkText("Shop New Yoga");

    public void hoverOverTrainingLink() {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(yogaProductPage);
        actions.moveToElement(element).perform();
    }

    // Locator for the button (Assuming it's part of the "Training" link dropdown)
    private By button = By.cssSelector(".button");

    public void clickButton() {
        driver.findElement(button).click();
    }
}
