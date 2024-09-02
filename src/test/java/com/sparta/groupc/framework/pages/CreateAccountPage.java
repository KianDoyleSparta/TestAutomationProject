package com.sparta.groupc.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage {
    private final WebDriver webDriver;

    private final By firstNameField = new By.ByName("firstname");
    private final By lasttNameField = new By.ByName("lastname");
    private final By emailField = new By.ByName("email");
    private final By passwordField = new By.ByName("password");
    private final By passwordConfirmationField = new By.ByName("password_confirmation");
    private final By createAccountButton = new By.ByClassName("submit");
    private final By errorMessage = new By.ByClassName("message-error");


    public CreateAccountPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterFirstName(String firstName) {
        webDriver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        webDriver.findElement(lasttNameField).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        webDriver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        webDriver.findElement(passwordField).sendKeys(password);
    }

    public void enterPasswordConfirmation(String passwordConfirmation) {
        webDriver.findElement(passwordConfirmationField).sendKeys(passwordConfirmation);
    }

    public void clickCreateAccountButton() {
        webDriver.findElement(createAccountButton).click();
    }

    public String getErrorMessage() {
        return webDriver.findElement(errorMessage).findElement(By.tagName("div")).getText();
    }

}
