package com.sparta.groupc.framework.stepdefs;

import com.sparta.groupc.framework.pages.Website;
import com.sparta.groupc.framework.pages.ProductPage;
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

public class ProductDetailsStepDefs {
    private Website website;
    private final String BASE_URL = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup() throws IOException {
        TestSetup.startChromeService();
        TestSetup.createWebDriver();
    }

    @After
    public void afterEach() {
        TestSetup.stopService();
    }

    @Given("I am on the product listing page")
    public void iAmOnTheProductListingPage() {
        website = TestSetup.getWebsite(BASE_URL + "catalog/category/view/id/5");
    }

    @And("I have selected a product")
    public void iHaveSelectedAProduct() {
        website.selectFirstProduct();
    }

    @When("I click on the product")
    public void iClickOnTheProduct() {
    }

    @Then("I should see the product details page")
    public void iShouldSeeTheProductDetailsPage() {
        MatcherAssert.assertThat(website.getCurrentUrl(), Matchers.containsString("/catalog/product/view/id/"));
    }

    @Then("I should see the following product details:")
    public void iShouldSeeTheFollowingProductDetails(DataTable table) {
        List<Map<String, String>> details = table.asMaps(String.class, String.class);
        Map<String, String> row = details.get(0);

        ProductPage productPage = website.getProductPage();

        MatcherAssert.assertThat(productPage.getProductName(), Matchers.equalTo(row.get("Name")));
        MatcherAssert.assertThat(productPage.getProductPrice(), Matchers.equalTo(row.get("Price")));
        MatcherAssert.assertThat(productPage.getProductDescription(), Matchers.equalTo(row.get("Description")));
        MatcherAssert.assertThat(productPage.getProductAvailability(), Matchers.equalTo(row.get("Availability")));
    }

    @Then("I should see a message saying {string}")
    public void iShouldSeeAMessageSaying(String message) {
        ProductPage productPage = website.getProductPage();
        MatcherAssert.assertThat(productPage.getErrorMessage(), Matchers.containsString(message));
    }

    @When("I do not select a product")
    public void iDoNotSelectAProduct() {
    }
}
