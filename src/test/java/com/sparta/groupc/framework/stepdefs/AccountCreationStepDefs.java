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

public class AccountCreationStepDefs {

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
        TestSetup.stopService();
    }

    @Given("I am on the account creation page")
    public void iAmOnTheAccountCreationPage() {
        website = TestSetup.getWebsite(BASE_URL + "customer/account/create/");
    }

    @When("I create an account with the following information:")
    public void iCreateAnAccountWithTheFollowingInformation(DataTable table) {
        List<Map<String, String>> credentials = table.asMaps(String.class, String.class);
        Map<String, String> row = credentials.get(0);

        website.getCreateAccountPage().enterFirstName(row.get("firstName"));
        website.getCreateAccountPage().enterLastName(row.get("lastName"));
        website.getCreateAccountPage().enterEmail(row.get("email"));
        website.getCreateAccountPage().enterPassword(row.get("password"));
        website.getCreateAccountPage().enterPasswordConfirmation(row.get("password_confirmation"));
        website.getCreateAccountPage().clickCreateAccountButton();
    }

    @Then("I should have successfully created an account")
    public void iShouldHaveSuccessfullyCreatedAnAccount() {
        MatcherAssert.assertThat(website.getCurrentUrl(), Matchers.containsString(BASE_URL + "customer/account/"));
    }

    @Then("I should see a duplicate email error message")
    public void iShouldSeeADuplicateEmailErrorMessage() {
        MatcherAssert.assertThat(website.getCreateAccountPage().getErrorMessage(), Matchers.containsString("There is already an account with this email address."));
    }
}
