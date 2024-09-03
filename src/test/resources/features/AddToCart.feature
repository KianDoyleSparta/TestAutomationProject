Feature: Add a product to the shopping cart

  As a user,
  I want to add a product to my shopping cart,
  So that I can save items for purchase.

  Background:
    Given I am on the product details page

  @happy
  Scenario: Successfully adding a configurable product to the cart
    When I select the following product options:
      | Size | Color |
      | 28   | Blue  |
    And I enter quantity "1"
    And I click the "Add to Cart" button
    Then the product should be added to the cart
    And I should see a confirmation message "You added Gwen Drawstring Bike Short to your shopping cart."
    And the cart icon should display "1" item

  @sad
  Scenario: Adding a product to the cart without selecting required options
    When I do not select any product options
    And I click the "Add to Cart" button
    Then I should see an error message prompting me to select the required options

  @sad
  Scenario: Adding an out-of-stock product to the cart
    Given the product is labeled as "Out of Stock"
    When I attempt to click the "Add to Cart" button
    Then the "Add to Cart" button should be disabled
    And I should see a message indicating that the product is out of stock

  @sad
  Scenario Outline: Adding a product with invalid quantity
    When I enter quantity "<quantity>"
    And I click the "Add to Cart" button
    Then I should see an error message "Invalid quantity"

    Examples:
      | quantity |
      | -1       |
      | 0        |
      | abc      |
      | !@#      |

#  @happy
#  Scenario: Removing a product from the cart
#    Given I click the shopping cart in
#    When I navigate to the shopping cart page
#    And I click on the "Remove" link for a product
#    Then the product should be removed from my cart
#    And the cart icon should update to show the correct number of items
