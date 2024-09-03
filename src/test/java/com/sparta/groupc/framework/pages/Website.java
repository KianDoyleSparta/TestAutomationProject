package com.sparta.groupc.framework.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebDriver;

public class Website {
    private final WebDriver webDriver;
    private final LoginPage loginPage;
    private final CreateAccountPage createAccountPage;
    private final PurchasePage purchasePage;

    public Website (WebDriver webDriver) {
        this.webDriver = webDriver;
        loginPage = new LoginPage(webDriver);
        createAccountPage = new CreateAccountPage(webDriver);
        purchasePage = new PurchasePage(webDriver);
}

    public LoginPage getLoginPage() {
        return loginPage;
    }

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
