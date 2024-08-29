Feature: Create Account

  In order to login
  As an interested person
  I wish to be able to create an account

  @Happy
  Scenario: Create account with valid information
    Given I am on the account creation page
    When I input my first name as "John"
    And I input my last name as "Doe"
    And I input my email as "jossiedee123@gmail.com"
    And I input my password as "JohnDoe!23"
    And I confirm my password as "JohnDoe!23"
    #use a datatable here please and thank you ^^ - convert to class from table and such and such
    Then I should have successfully created an account