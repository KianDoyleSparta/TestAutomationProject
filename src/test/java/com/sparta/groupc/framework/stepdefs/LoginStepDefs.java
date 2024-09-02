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

public class LoginStepDefs {
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

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        website = TestSetup.getWebsite(BASE_URL + "customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");
    }

    @And("I have an account")
    public void iHaveAnAccount() {
    }

    @When("I input the following information:")
    public void iInputHeFollowingInformation(DataTable table) {
        List<Map<String, String>> credentials = table.asMaps(String.class, String.class);
        Map<String, String> row = credentials.get(0);

        website.getLoginPage().enterEmail(row.get("email"));
        website.getLoginPage().enterPassword(row.get("password"));
        website.getLoginPage().clickLogin();
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        MatcherAssert.assertThat(website.getCurrentUrl(), Matchers.containsString(BASE_URL));
    }

    @Then("I should see a login error message")
    public void iShouldSeeALoginErrorMessage() {
        MatcherAssert.assertThat(website.getLoginPage().getErrorMessage(), Matchers.containsString("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later."));
    }

    @When("I click forgot password")
    public void iClickForgotPassword() {
        website.getLoginPage().clickForgotPassword();
    }

    @Then("I should be taken to the forgotten password page")
    public void iShouldBeTakenToTheForgottenPasswordPage() {
        MatcherAssert.assertThat(website.getCurrentUrl(), Matchers.containsString("/customer/account/forgotpassword/"));
    }
}
