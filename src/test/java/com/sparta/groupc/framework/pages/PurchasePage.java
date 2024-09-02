package com.sparta.groupc.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchasePage {
    private final WebDriver webDriver;

    private final By productItem = new By.ByClassName("product-item-photo");
    private final By sizeOption = new By.ById("option-label-size-143-item-166");
    private final By colorOption = new By.ById("option-label-color-93-item-50");
    private final By addToCart = new By.ById("product-addtocart-button");

    private final By cart = new By.ByClassName("showcart");
    private final By checkout = new By.ById("top-cart-btn-checkout");

    public static final By emailField = By.id("customer-email");
    public static final By firstNameField = By.id("VDVGJ9M");
    public static final By lastNameInput = By.id("LOS0PM5");
    public static final By streetAddressLine1Input = By.id("B5RRM8F");
    public static final By cityInput = By.id("E980UC2");
    public static final By stateProvinceDropdown = By.id("PLRMX0R");
    public static final By zipPostalCodeInput = By.id("S2Q13N1");
    public static final By countryDropdown = By.id("UH50JQM");
    public static final By phoneNumberInput = By.id("KL92BJ3");

    public static final By fixedShippingMethodRadio = By.cssSelector("input[value='flatrate_flatrate']");
    public static final By nextButton = By.cssSelector("button[data-role='opc-continue']");

    public static final By placeOrderButton = By.cssSelector("button.action.primary.checkout[title='Place Order']");

    public PurchasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickProduct() {
        webDriver.findElement(productItem).click();
    }

    public void selectSize() {
        webDriver.findElement(sizeOption).click();
    }

    public void selectColor() {
        webDriver.findElement(colorOption).click();
    }

    public void clickAddToCart() {
        webDriver.findElement(addToCart).click();
    }

    public void clickCart() {
        webDriver.findElement(cart).click();
    }

    public void clickCheckout() {
        webDriver.findElement(checkout).click();
    }

    public void enterEmail(String email) {
        webDriver.findElement(emailField).sendKeys(email);
    }

    public void enterFirstName(String firstName) {
        webDriver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        webDriver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void enterStreetAddressLine1(String streetAddressLine1) {
        webDriver.findElement(streetAddressLine1Input).sendKeys(streetAddressLine1);
    }

    public void enterCity(String city) {
        webDriver.findElement(cityInput).sendKeys(city);
    }

    public void enterStateProvince(String stateProvince) {
        webDriver.findElement(stateProvinceDropdown).sendKeys(stateProvince);
    }

    public void enterZipPostalCode(String zipPostalCode) {
        webDriver.findElement(zipPostalCodeInput).sendKeys(zipPostalCode);
    }

    public void enterCountry(String country) {
        webDriver.findElement(countryDropdown).sendKeys(country);
    }

    public void enterPhoneNumber(String phoneNumber) {
        webDriver.findElement(phoneNumberInput).sendKeys(phoneNumber);
    }

    public void clickFixedShippingMethod() {
        webDriver.findElement(fixedShippingMethodRadio).click();
    }

    public void clickNextButton() {
        webDriver.findElement(nextButton).click();
    }

    public void clickPlaceOrderButton() {
        webDriver.findElement(placeOrderButton).click();
    }
}
