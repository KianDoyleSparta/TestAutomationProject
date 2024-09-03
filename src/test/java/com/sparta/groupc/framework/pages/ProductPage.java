package com.magento.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class ProductPage {

    private WebDriver driver;

    // Locators
    private By sizeOption = By.id("option-label-size-143-item-171");  // Use the appropriate selector for size
    private By colorOption = By.id("option-label-color-93-item-50"); // Use the appropriate selector for color
    private By quantityField = By.id("qty");
    private By addToCartButton = By.id("#product-addtocart-button");
    private By confirmationMessage = By.cssSelector("maincontent > div.page.messages > div:nth-child(2) > div > div");
    private By cartIconCount = By.cssSelector("body > div.page-wrapper > header > div.header.content > div.minicart-wrapper > a > span.counter.qty > span.counter-number");
    private By outOfStockMessage = By.cssSelector(".stock.unavailable");
    private By removeProductLink = By.cssSelector(".action.delete"); // Correct selector for removing a product
    private By errorMessage = By.id("#product-addtocart-button");

    // Constructor
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void selectSize(String size) {
//        driver.findElement(sizeOption).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement sizeElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#option-label-size-143-item-171")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sizeElement);

    }

    public void takeScreenshot(String filePath) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(screenshot.toPath(), Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void selectColor(String color) {
//        driver.findElement(colorOption).click();
        driver.findElement(By.id("option-label-color-93-item-50")).click();
    }

    public void enterQuantity(String quantity) {
        WebElement qtyField = driver.findElement(quantityField);
        qtyField.clear();
        qtyField.sendKeys(quantity);
    }

    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(confirmationMessage).getText();
    }

    public String getCartIconCount() {
        return driver.findElement(cartIconCount).getText();
    }

    public boolean isAddToCartButtonEnabled() {
        return driver.findElement(addToCartButton).isEnabled();
    }

    public boolean isProductOutOfStock() {
        return driver.findElements(outOfStockMessage).size() > 0;
    }

    public void clickRemoveLinkForProduct() {
        driver.findElement(removeProductLink).click();
    }

    public boolean isCartEmpty() {
        return driver.findElement(cartIconCount).getText().equals("0");
    }

    public boolean isProductInCart() {
        // Check for presence of product in the cart
        return driver.findElements(By.cssSelector(".cart-item")).size() > 0;
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
