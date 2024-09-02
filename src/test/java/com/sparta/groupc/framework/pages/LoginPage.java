package com.sparta.groupc.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver webDriver;

    private final By userNameField = new By.ById("email");
    private final By passwordField = new By.ById("pass");
    private final By sendButton = new By.ById("send2");
    private final By forgotPassword = new By.ByClassName("remind");
    private final By errorMessage = new By.ByClassName("message-error");

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterEmail(String email) {
        webDriver.findElement(userNameField).sendKeys(email);
    }

    public void enterPassword(String password) {
        webDriver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        webDriver.findElement(sendButton).click();
    }

    public void clickForgotPassword() {
        webDriver.findElement(forgotPassword).click();
    }

    public String getErrorMessage() {
        return webDriver.findElement(errorMessage).findElement(By.tagName("div")).getText();
    }
}
