package com.sparta.groupc.framework.stepdefs;

import com.sparta.groupc.framework.pages.ProductFilterPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ProductFilterStepDefs {
    private ProductFilterPage productFilterPage;
    private final String BASE_URL = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup() throws IOException {
        TestSetup.startChromeService();
        TestSetup.createWebDriver();
    }

    @After
    public void afterEach() {
        TestSetup.quitWebDriver();
        TestSetup.stopService();
    }

    @Given("I am on the products page")
    public void iAmOnTheProductsPage() {
        productFilterPage = new ProductFilterPage(TestSetup.getWebsite(BASE_URL).getWebDriver());
    }

    @When("I select the following category:")
    public void iSelectTheFollowingCategory(DataTable table) {
        List<Map<String, String>> categoryList = table.asMaps(String.class, String.class);
        String category = categoryList.get(0).get("category");
        productFilterPage.selectCategory(category);
    }

    @Then("I should see products in the {string} category")
    public void iShouldSeeProductsInTheCategory(String category) {
        MatcherAssert.assertThat(productFilterPage.getProductCategory(), Matchers.containsString(category));
    }

    @When("I select an invalid filter:")
    public void iSelectAnInvalidFilter(DataTable table) {
        List<Map<String, String>> filterList = table.asMaps(String.class, String.class);
        String invalidCategory = filterList.get(0).get("category");
        productFilterPage.selectCategory(invalidCategory);
    }

    @Then("I should see a no products found message")
    public void iShouldSeeANoProductsFoundMessage() {
        MatcherAssert.assertThat(productFilterPage.getNoProductsMessage(), Matchers.containsString("No products found"));
    }

    @Given("I have applied some filters")
    public void iHaveAppliedSomeFilters() {
        // Implement this step as necessary
    }

    @When("I click the reset filters button")
    public void iClickTheResetFiltersButton() {
        productFilterPage.clickResetFilters();
    }

    @Then("I should see all products without any filters applied")
    public void iShouldSeeAllProductsWithoutAnyFiltersApplied() {
        MatcherAssert.assertThat(productFilterPage.getProductCount(), Matchers.greaterThan(0));
    }

    @When("I select a price range:")
    public void iSelectAPriceRange(DataTable table) {
        List<Map<String, String>> priceRangeList = table.asMaps(String.class, String.class);
        String minPrice = priceRangeList.get(0).get("min_price");
        String maxPrice = priceRangeList.get(0).get("max_price");
        productFilterPage.selectPriceRange(minPrice, maxPrice);
    }

    @Then("I should see products priced between $50 and $200")
    public void iShouldSeeProductsPricedBetweenAnd() {
        List<Integer> prices = productFilterPage.getProductPrices();
        MatcherAssert.assertThat(prices, Matchers.allOf(
                Matchers.everyItem(Matchers.greaterThanOrEqualTo(50)),
                Matchers.everyItem(Matchers.lessThanOrEqualTo(200))
        ));
    }
}
