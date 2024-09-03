Feature: Purchase

  @happy
  Scenario: Clicking purchase brings up payment and shipping information fields
    Given I am on the home page
    And I have an item in my cart
    When I click checkout
    Then I should be taken to the shipping page

  @happy
  Scenario: Successfully confirming shipping with valid details
    Given I am on the shipping page
    When I enter these shipping details:
      | email | firstname | lastname | address | city | state | zip | country | phone |
      |       |           |          |         |      |       |     |         |       |
    Then I should be taken to the payment page

  @sad
  Scenario: Unsuccessfully confirming payment and shipping with invalid details
    Given I am on the shipping page
    When I enter these shipping details:
      | email | firstname | lastname | address | city | state | zip | country | phone |
      |       |           |          |         |      |       |     |         |       |
    Then I should be given a shipping error message

  @happy
  Scenario: Successfully confirming payment
    Given I am on the payment page
    When I click place order
    Then I should be sent to a confirmation page
