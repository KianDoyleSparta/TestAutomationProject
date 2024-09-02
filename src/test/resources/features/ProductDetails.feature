Feature: View Product Details

  In order to make an informed purchase
  As a user
  I wish to be able to view detailed information about a product

  @Happy
  Scenario: View details of a specific product
    Given I am on the product listing page
    And I have selected a product
    When I click on the product
    Then I should see the product details page
    And I should see the following product details:
      | detail                 | value              |
      | Name                   | Example Product     |
      | Price                  | $100.00             |
      | Description            | A detailed description of the product. |
      | Availability           | In Stock            |

  @Sad
  Scenario: Product details not available
    Given I am on the product listing page
    And I have selected a product
    When I click on the product
    Then I should see a message saying "Product details are not available"

  @Alternative
  Scenario: No product selected
    Given I am on the product listing page
    When I do not select a product
    Then I should see a message saying "Please select a product to view details"
