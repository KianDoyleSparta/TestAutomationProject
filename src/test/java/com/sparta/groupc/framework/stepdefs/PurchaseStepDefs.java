package com.sparta.groupc.framework.stepdefs;

import com.sparta.groupc.framework.pages.Website;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PurchaseStepDefs {
    private Website website;
    private final String BASE_URL = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup () throws IOException {
        TestSetup.startChromeService();
        TestSetup.createWebDriver();
    }

    @After
    public void afterEach () {
        TestSetup.createWebDriver();
//        TestSetup.stopService();
    }

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        website = TestSetup.getWebsite(BASE_URL);
    }

    @And("I have an item in my cart")
    public void iHaveAnItemInMyCart() {
        website.getPurchasePage().selectSize();
        website.getPurchasePage().selectColor();
        website.getPurchasePage().clickAddToCart();
    }

    @When("I click checkout")
    public void iClickCheckout() {
        website.getPurchasePage().clickCart();
        website.getPurchasePage().clickCheckout();
    }

    @Then("I should be taken to the shipping page")
    public void iShouldBeTakenToTheShippingPage() {
        MatcherAssert.assertThat(website.getCurrentUrl(), Matchers.containsString("/checkout/shipping/"));
    }

    @Given("I am on the shipping page")
    public void iAmOnTheShippingPage() {
        website = TestSetup.getWebsite(BASE_URL + "checkout/shipping/");
    }

    @When("I enter these shipping details:")
    public void iEnterTheseShippingDetails(DataTable table) {
        List<Map<String, String>> credentials = table.asMaps(String.class, String.class);

        website.getPurchasePage().enterEmail(credentials.get(0).get("email"));
        website.getPurchasePage().enterFirstName(credentials.get(0).get("firstName"));
        website.getPurchasePage().enterLastName(credentials.get(0).get("lastName"));
        website.getPurchasePage().enterStreetAddressLine1(credentials.get(0).get("address"));
        website.getPurchasePage().enterCity(credentials.get(0).get("city"));
        website.getPurchasePage().enterStateProvince(credentials.get(0).get("state"));
        website.getPurchasePage().enterZipPostalCode(credentials.get(0).get("zip"));
        website.getPurchasePage().enterCountry(credentials.get(0).get("country"));
        website.getPurchasePage().enterPhoneNumber(credentials.get(0).get("phone"));
        website.getPurchasePage().clickFixedShippingMethod();

        website.getPurchasePage().clickNextButton();
    }

    @Then("I should be taken to the payment page")
    public void iShouldBeTakenToThePaymentPage() {
        MatcherAssert.assertThat(website.getCurrentUrl(), Matchers.containsString("/checkout/payment/"));
    }

    @Then("I should be given a shipping error message")
    public void iShouldBeGivenAShippingErrorMessage() {
    }

    @Given("I am on the payment page")
    public void iAmOnThePaymentPage() {
        website = TestSetup.getWebsite(BASE_URL + "checkout/payment/");
    }

    @When("I click place order")
    public void iClickPlaceOrder() {
        website.getPurchasePage().clickPlaceOrderButton();
    }

    @Then("I should be sent to a confirmation page")
    public void iShouldBeSentToAConfirmationPage() {
        MatcherAssert.assertThat(website.getCurrentUrl(), Matchers.containsString("/checkout/onepage/success/"));
    }
}
