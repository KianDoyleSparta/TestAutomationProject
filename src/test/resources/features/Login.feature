Feature: Login

  In order to gain access to certain features
  As a registered user
  I wish to be able to login using my credentials

  @happy
  Scenario: Login with valid credentials
    Given I am on the login page
    And I have an account
    When I input the following information:
      | email                       | password |
      | kd@kd.com         | Password!Kd |
    Then I should be logged in

  @sad
  Scenario: Login with invalid credentials
    Given I am on the login page
    And I have an account
    When I input the following information:
      | email                       | password |
      | johndoe@example.com         | ----- |
    Then I should see a login error message

  @alternative
  Scenario: Forgotten password
    Given I am on the login page
    When I click forgot password
    Then I should be taken to the forgotten password page