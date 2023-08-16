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

    @And("^user signs in as standard user$")
    public void userSignsInAsStandardUser() {
        user.userLogin();
        
    }

    @Then("^user is on the inventory page$")
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


    @When("^user order the products by (.*)$")
    public void userOrderTheProductsByFilterOption(String filterOption) {
        user.userLogged();
        user.userSortProductsLowToHigh(filterOption);
    }

    @When("^user adds (.*) products most expensive to the cart$")
    public void userAddsProductQuantityProductsMostExpensiveToTheCart(String quantity) {
        user.userAddMostExpensive(quantity);
    }

    @Then("^the cart should have (.*) products$")
    public void theCartShouldHaveExpectedQuantityProducts(String expectedQuantity) {
        user.expectedCartBadge(expectedQuantity);
    }

    @When("^user clicks on the cart button$")
    public void userClicksOnTheCartButton() {
        user.userClicksShoppingCart();
    }

    @Then("^user goes to Checkout$")
    public void userGoesToCheckout() {
        user.userClicksCheckout();
    }

    @When("^user fills (.*), (.*) and (.*) fields$")
    public void userFillsFirst_nameLast_nameAndZip_codeFields(String name, String last_name, String zip_code) {
        user.userFillsFields(name, last_name, zip_code);
    }

    @Then("^user checks purchase and finishes the purchase$")
    public void userChecksPurchaseAndFinishesThePurchase() {
        user.userClicksFinish();
    }

    @And("^a success message is displayed$")
    public void aSuccessMessageIsDisplayed() {
        user.userCheckThankYouMessage();
    }
}
