Feature: Order products by price and buy 4 products

  Background: User logs in to Sauce Demo Website
    Given user navigates to https://www.saucedemo.com/
    And user signs in as standard user

  Scenario Outline: Order products and verify cart shopping
    Given user is on the inventory page
    When user order the products by <filterOption>
    When user adds <productQuantity> products most expensive to the cart
    Then the cart should have <expectedQuantity> products
    When user clicks on the cart button
    Then user goes to Checkout
    When user fills <first_name>, <last_name> and <zip_code> fields
    Then user checks purchase and finishes the purchase
    And a success message is displayed

    Examples:
      | filterOption        | productQuantity | expectedQuantity | first_name | last_name | zip_code |
      | Price (low to high) | 4               | 4                | John       | Doe       | 12345    |