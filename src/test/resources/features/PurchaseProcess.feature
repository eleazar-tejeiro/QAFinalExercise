Feature: Order products by price and buy 4 products

  Background:
    Given user navigates to https://www.saucedemo.com/
    And user logs in as standard user

  Scenario Outline: Order products and verify shopping cart
    Given user is on the inventory page
    And user orders the products by <filterOption>
    And user adds <productQuantity> of the most expensive products to the cart
    Then cart should contain <expectedQuantity> products
    And user clicks on the cart button
    And user is redirected to the Checkout page
    When user fills in the <first_name>, <last_name>, and <zip_code> fields
    And user checks the purchase and completes the purchase
    Then a success message is displayed

    Examples:
      | filterOption        | productQuantity | expectedQuantity | first_name | last_name | zip_code |
      | Price (low to high) | 4               | 4                | John       | Doe       | 12345    |