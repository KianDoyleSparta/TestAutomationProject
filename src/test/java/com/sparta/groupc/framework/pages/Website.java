package com.sparta.groupc.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Website {
    private final WebDriver webDriver;
    private final LoginPage loginPage;
    private final ProductPage productPage;
    private final CreateAccountPage createAccountPage;
    private final PurchasePage purchasePage;

    public Website(WebDriver webDriver) {
        this.webDriver = webDriver;
        loginPage = new LoginPage(webDriver);
        productPage = new ProductPage(webDriver);
    }
        createAccountPage = new CreateAccountPage(webDriver);
        purchasePage = new PurchasePage(webDriver);
}

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public ProductPage getProductPage() {
        return productPage;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void selectFirstProduct() {
        webDriver.findElement(By.cssSelector(".product-item-link")).click(); 

    public CreateAccountPage getCreateAccountPage() {
        return createAccountPage;
    }

    public PurchasePage getPurchasePage() {
        return purchasePage;

    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public String getPageTitle() {
        return webDriver.getTitle();
    }
}
