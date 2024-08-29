package com.sparta.groupc.framework.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountStepDefs {
    @Given("I am on the account creation page")
    public void iAmOnTheAccountCreationPage() {
    }

    @When("I input my first name as {string}")
    public void iInputMyFirstNameAs(String arg0) {
    }

    @And("I input my last name as {string}")
    public void iInputMyLastNameAs(String arg0) {
    }

    @And("I input my email as {string}")
    public void iInputMyEmailAs(String arg0) {
    }

    @And("I input my password as {string}")
    public void iInputMyPasswordAs(String arg0) {
    }

    @And("I confirm my password as {string}")
    public void iConfirmMyPasswordAs(String arg0) {
    }

    @Then("I should have successfully created an account")
    public void iShouldHaveSuccessfullyCreatedAnAccount() {
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
    }

    @And("I have an account")
    public void iHaveAnAccount() {
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
    }
}
