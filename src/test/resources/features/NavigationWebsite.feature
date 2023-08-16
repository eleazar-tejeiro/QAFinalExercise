Feature: Sauce Demo Shopping Cart

  Scenario: User logs in to Sauce Demo Website
    Given user navigates to https://www.saucedemo.com/
    And user signs in as standard user
    Then user is on the inventory page

  Scenario: User go to About Tab Navigation and back to Product page
    Given user is on the Products page
    When user navigates to the About tab
    Then user should be on the About page
    And user goes back to the Product page
