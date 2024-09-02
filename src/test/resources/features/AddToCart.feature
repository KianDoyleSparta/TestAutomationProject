Feature: Add a product to the shopping cart

  As a user,
  I want to add a product to my shopping cart,
  So that I can save items for purchase.

  Background:
    Given I am on the Magento demo site homepage
    And I navigate to a product category page

  Scenario: Successfully adding a product to the cart
    Given I have selected a product on the product category page
    When I click on the product name to view the product details
    And I select the required product options (like size and color)
    And I click on the "Add to Cart" button
    Then the product should be added to my cart
    And I should see a confirmation message "You added [Product Name] to your shopping cart."
    And the cart icon should display the correct number of items

  Scenario: Adding an out-of-stock product to the cart
    Given I am on a product details page for a product labeled as "Out of Stock"
    When I attempt to click the "Add to Cart" button
    Then the "Add to Cart" button should be disabled or not available
    And I should see a message indicating that the product is out of stock


  Scenario: Adding a configurable product to the cart without selecting required options
    Given I am on a product details page for a configurable product
    When I attempt to click the "Add to Cart" button without selecting size or color
    Then I should see an error message prompting me to select the required options


  Scenario Outline: Adding multiple quantities of the same product to the cart
    Given I am on the product details page
    And I have selected a product
    When I enter "<quantity>" in the quantity field
    And I click on the "Add to Cart" button
    Then the product should be added to my cart with a quantity of <quantity>
    And the cart icon should display "<totalItems>" total number of items

    Examples:
      | quantity | totalItems |
      | 1        | 1          |
      | 3        | 3          |
      | 5        | 5          |
      | 10       | 10         |
      | 100      | 100        |


  Scenario: Verifying the cart after adding a product
    Given I have successfully added a product to my cart
    When I click on the shopping cart icon
    Then I should see the product listed in the cart
    And the product details (name, size, color, quantity) should be correct
    And the total price should be accurately calculated based on the quantity

  Scenario: Removing a product from the cart
    Given I have one or more products in my shopping cart
    When I navigate to the shopping cart page
    And I click on the "Remove" link for a product
    Then the product should be removed from my cart
    And the cart icon should update to show the correct number of items

  Scenario: Add an out-of-stock product to the cart
    Given I navigate to a product details page for an out-of-stock product
    When I attempt to click the "Add to Cart" button
    Then I should see a message "This product is out of stock"
    And the "Add to Cart" button should be disabled

  Scenario Outline: Add a product to the cart with invalid quantity
    Given I am on the product details page
    When I enter an invalid quantity "<invalidQuantity>"
    And I click the "Add to Cart" button
    Then I should see an error message "Invalid quantity"

    Examples:
      | invalidQuantity |
      | -1              |
      | 0               |
      | 9999999         |
      | abc             |
      | !@#             |



  Scenario Outline: Add a product to the cart when not logged in (guest user)
    Given I am a guest user on the Magento demo site homepage
    When I navigate to a product category page
    And I select a configurable product
    And I choose "<size>" as the size
    And I choose "<color>" as the color
    And I click on the "Add to Cart" button
    Then the product should be added to my cart
    And I should see a confirmation message "You added [Product Name] to your shopping cart."
    And the cart icon should display "1" item in the cart
    And the cart should retain the product when navigating to another page

    Examples:
      | size | color |
      | M    | Red   |
      | L    | Blue  |
      | S    | Green |
      | XL   | Black |


