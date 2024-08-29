Feature: Login

  In order to gain access to certain features
  As a registered user
  I wish to be able to login using my credentials

  @Happy
  Scenario: Login with valid credentials
    Given I am on the login page
    And I have an account
    When I input my email as "jossiedee123@gmail.com"
    And I input my password as "JohnDoe!23"
    Then I should be logged in