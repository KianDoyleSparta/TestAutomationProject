package com.sparta.groupc.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductFilterPage {
    private final WebDriver webDriver;

    private final By categoryDropdown = new By.ById("category");
    private final By priceMinField = new By.ById("price-min");
    private final By priceMaxField = new By.ById("price-max");
    private final By applyFiltersButton = new By.ById("apply-filters");
    private final By resetFiltersButton = new By.ById("reset-filters");
    private final By noProductsMessage = new By.ByClassName("no-products");
    private final By productsCategory = new By.ByClassName("product-category");
    private final By productCount = new By.ByClassName("product-count");

    public ProductFilterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void selectCategory(String category) {
        webDriver.findElement(categoryDropdown).sendKeys(category);
        webDriver.findElement(applyFiltersButton).click();
    }

    public void selectPriceRange(String minPrice, String maxPrice) {
        webDriver.findElement(priceMinField).sendKeys(minPrice);
        webDriver.findElement(priceMaxField).sendKeys(maxPrice);
        webDriver.findElement(applyFiltersButton).click();
    }

    public String getProductCategory() {
        return webDriver.findElement(productsCategory).getText();
    }

    public String getNoProductsMessage() {
        return webDriver.findElement(noProductsMessage).getText();
    }

    public void clickResetFilters() {
        webDriver.findElement(resetFiltersButton).click();
    }

    public int getProductCount() {
        return Integer.parseInt(webDriver.findElement(productCount).getText());
    }

}
