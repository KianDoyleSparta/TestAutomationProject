package com.sparta.groupc.framework.stepdefs;

import com.magento.pages.ProductPage;
import com.sparta.groupc.framework.pages.Website;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class AddToCartStepDefs {
    private WebDriver driver;
    private Website website;
    private ProductPage productPage;

    @Before
    public void setup() throws IOException {
        TestSetup.startChromeService();
        TestSetup.createWebDriver();  // Initialize WebDriver
        driver = TestSetup.webDriver; // Access static WebDriver from TestSetup

        if (driver == null) {
            throw new IllegalStateException("WebDriver could not be initialized");
        }

        website = new Website(driver);
        productPage = new ProductPage(driver); // Ensure ProductPage is properly initialized
    }

    @After
    public void tearDown() {
        if (driver != null) {
            TestSetup.quitWebDriver(); // Quit WebDriver using TestSetup
        }
        TestSetup.stopService(); // Stop the ChromeDriver service
    }

    @Given("I am on the product details page")
    public void iAmOnTheProductDetailsPage() {
        TestSetup.getWebsite("https://magento.softwaretestingboard.com/gwen-drawstring-bike-short.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("I select the following product options:")
    public void iSelectTheFollowingProductOptions(DataTable dataTable) {
        List<Map<String, String>> options = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> option : options) {
            productPage.selectSize(option.get("Size"));
            productPage.selectColor(option.get("Color"));
        }
    }

    @And("I enter quantity {string}")
    public void iEnterQuantity(String quantity) {
        productPage.enterQuantity(quantity);
    }

    @And("I click the {string} button")
    public void iClickTheButton(String buttonName) {
        if (buttonName.equalsIgnoreCase("Add to Cart")) {
            productPage.clickAddToCart();
        }
    }

    @Then("the product should be added to the cart")
    public void theProductShouldBeAddedToTheCart() {
        Assert.assertNotNull(productPage.getSuccessMessage());
    }

    @And("I should see a confirmation message {string}")
    public void iShouldSeeAConfirmationMessage(String expectedMessage) {
        String actualMessage = productPage.getSuccessMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @And("the cart icon should display {string} item")
    public void theCartIconShouldDisplayItem(String expectedCount) {
        String actualCount = productPage.getCartIconCount();
        Assert.assertEquals(expectedCount, actualCount);
    }

    @When("I do not select any product options")
    public void iDoNotSelectAnyProductOptions() {
        // No action needed to simulate not selecting any options
    }

    @Then("I should see an error message prompting me to select the required options")
    public void iShouldSeeAnErrorMessagePromptingToSelectRequiredOptions() {
        Assert.assertNotNull(productPage.getErrorMessage());
    }

    @Given("the product is labeled as {string}")
    public void theProductIsLabeledAs(String status) {
        Assert.assertTrue(productPage.isProductOutOfStock());
    }

    @When("I attempt to click the {string} button")
    public void iAttemptToClickTheButton(String buttonName) {
        if (buttonName.equalsIgnoreCase("Add to Cart")) {
            productPage.clickAddToCart();
        }
    }

    @Then("the {string} button should be disabled")
    public void theButtonShouldBeDisabled(String buttonName) {
        boolean isEnabled = productPage.isAddToCartButtonEnabled();
        Assert.assertFalse(isEnabled);
    }

    @And("I should see a message indicating that the product is out of stock")
    public void iShouldSeeAMessageIndicatingThatTheProductIsOutOfStock() {
        Assert.assertTrue(productPage.isProductOutOfStock());
    }

    @Given("I have one or more products in my shopping cart")
    public void iHaveOneOrMoreProductsInMyShoppingCart() {
        // Assuming there is a method to check cart count is greater than zero
        Assert.assertTrue(Integer.parseInt(productPage.getCartIconCount()) > 0);
    }

//    @When("I navigate to the shopping cart page")
//    public void iNavigateToTheShoppingCartPage() {
//        driver.get("https://magento.softwaretestingboard.com/shopping-cart-page-url"); // Replace with actual URL
//    }
//
//    @And("I click on the {string} link for a product")
//    public void iClickOnTheLinkForAProduct(String linkName) {
//        if (linkName.equalsIgnoreCase("Remove")) {
//            productPage.clickRemoveLinkForProduct();
//        }
//    }
//
//    @Then("the product should be removed from my cart")
//    public void theProductShouldBeRemovedFromMyCart() {
//        // Verify the cart is empty or the product is no longer listed
//        Assert.assertTrue(productPage.isCartEmpty() || !productPage.isProductInCart());
//    }
//
//    @And("the cart icon should update to show the correct number of items")
//    public void theCartIconShouldUpdateToShowTheCorrectNumberOfItems() {
//        String cartCount = productPage.getCartIconCount();
//        Assert.assertEquals("0", cartCount);  // Assuming the cart should be empty
//    }
}
