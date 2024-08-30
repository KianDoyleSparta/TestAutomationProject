Feature: Create Account

  In order to login
  As an interested person
  I wish to be able to create an account

  @Happy
  Scenario: Create account with valid information
    Given I am on the account creation page
    When I create an account with the following information:
      | firstName | lastName | email                       | password |
      | John      | Doe      | johndoe@example.com         | password1 |
    Then I should have successfully created an account

  @Sad
  Scenario: Create account with invalid information
    Given I am on the account creation page
    When I create an account with the following information:
      | firstName | lastName | email | password |
      | John      | Doe      | ----  | -        |
    Then I should see a creation error message