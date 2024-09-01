package com.sparta.groupc.framework.stepdefs;

import com.sparta.groupc.framework.pages.Website;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs {
    private Website website;
    private final String BASE_URL = "https://magento.softwaretestingboard.com/";

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
    }

    @And("I have an account")
    public void iHaveAnAccount() {
    }

    @When("I input the following information:")
    public void iInputHeFollowingInformation() {
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
    }

    @Then("I should see a login error message")
    public void iShouldSeeALoginErrorMessage() {
    }

    @When("I click forgot password")
    public void iClickForgotPassword() {
    }

    @Then("I should be taken to the forgotten password page")
    public void iShouldBeTakenToTheForgottenPasswordPage() {
    }
}
