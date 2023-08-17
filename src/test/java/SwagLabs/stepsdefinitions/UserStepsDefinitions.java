package SwagLabs.stepsdefinitions;

import SwagLabs.steps.UserSwagLabs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class UserStepsDefinitions {
    @Steps(shared = true)
    UserSwagLabs user;

    @Given("^user navigates to https://www.saucedemo.com/$")
    public void userNavigatesLogin() {
        user.navigatesTo();
    }

    @And("^user logs in as standard user$")
    public void userSignsInAsStandardUser() {
        user.userLogin();
        
    }

    @Given("^user is on the inventory page$")
    public void userIsOnTheInventoryPage() {
        user.userLogged();
    }

    @Given("^user is on the Products page$")
    public void userIsOnTheProductsPage() {
        user.navigatesTo();
        user.userLogin();
        user.userLogged();
    }

    @When("^user navigates to the About tab$")
    public void userNavigatesToTheAboutTab() {
        user.userGoToAbout();
    }

    @Then("^user should be on the About page$")
    public void userShouldBeOnTheAboutPage() {
        user.userIsOnAboutPage();
    }

    @And("^user goes back to the Product page$")
    public void userGoesBackToTheProductPage() {
        user.userReturnToMainPage();
    }


    @And("^user orders the products by (.*)$")
    public void userOrderTheProductsByFilterOption(String filterOption) {
        user.userLogged();
        user.userSortProductsLowToHigh(filterOption);
    }

    @And("^user adds (.*) of the most expensive products to the cart$")
    public void userAddsProductQuantityProductsMostExpensiveToTheCart(String quantity) {
        user.userAddMostExpensive(quantity);
    }

    @Then("^cart should contain (.*) products$")
    public void theCartShouldHaveExpectedQuantityProducts(String expectedQuantity) {
        user.expectedCartBadge(expectedQuantity);
    }

    @And("^user clicks on the cart button$")
    public void userClicksOnTheCartButton() {
        user.userClicksShoppingCart();
    }

    @And("^user is redirected to the Checkout page$")
    public void userGoesToCheckout() {
        user.userClicksCheckout();
    }

    @When("^user fills in the (.*), (.*) and (.*) fields$")
    public void userFillsFirst_nameLast_nameAndZip_codeFields(String name, String last_name, String zip_code) {
        user.userFillsFields(name, last_name, zip_code);
    }

    @And("^user checks the purchase and completes the purchase$")
    public void userChecksPurchaseAndFinishesThePurchase() {
        user.userClicksFinish();
    }

    @Then("^a success message is displayed$")
    public void aSuccessMessageIsDisplayed() {
        user.userCheckThankYouMessage();
    }
}
