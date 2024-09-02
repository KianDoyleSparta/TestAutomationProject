Feature: Create Account

  In order to login
  As an interested person
  I wish to be able to create an account

  @happy
  Scenario: Create account with valid information
    Given I am on the account creation page
    When I create an account with the following information:
      | firstName | lastName | email              | password        | password_confirmation |
      | Group     | C        | groupc@groupc.com  | Password!GroupC | Password!GroupC       |
    Then I should have successfully created an account

  @sad
  Scenario: Create account with duplicate information
    Given I am on the account creation page
    When I create an account with the following information:
      | firstName | lastName | email              | password        | password_confirmation |
      | Group     | C        | groupc@groupc.com  | Password!GroupC | Password!GroupC       |
    Then I should see a duplicate email error message