Feature: Product Filtering

  In order to find products that meet specific criteria
  As a shopper
  I wish to be able to filter products by various attributes

  @happy
  Scenario: Filter products by category
    Given I am on the products page
    When I select the following category:
      | category    |
      | Electronics |
    Then I should see products in the Electronics category

  @happy
  Scenario: Filter products by price range
    Given I am on the products page
    When I select a price range:
      | min_price | max_price |
      | 50        | 200       |
    Then I should see products priced between $50 and $200

  @sad
  Scenario: Apply an invalid filter
    Given I am on the products page
    When I select an invalid filter:
      | category    |
      | Invalid     |
    Then I should see a no products found message

  @alternative
  Scenario: Reset filters
    Given I have applied some filters
    When I click the reset filters button
    Then I should see all products without any filters applied
