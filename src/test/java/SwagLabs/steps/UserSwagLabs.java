package SwagLabs.steps;

import SwagLabs.pageobject.*;
import net.serenitybdd.core.steps.ScenarioActor;
import net.thucydides.core.annotations.Steps;

public class UserSwagLabs extends ScenarioActor {

    String actor;
    @Steps(shared = true)
    Login login;
    Product product;
    About about;

    Cart cart;
    Checkout checkout;

    public void navigatesTo() {
        login.setDefaultBaseUrl("https://www.saucedemo.com/");
        login.open();
    }

    public void userLogin() {
        String username = "standard_user";
        String pass = "secret_sauce";
        login.signIn(username, pass);
    }

    public void userLogged() {
        product.isProductTitleDisplayed();
        product.checkProductTab();
    }

    public void userGoToAbout() {
        product.selectAboutLink();
    }

    public void userIsOnAboutPage() {
        about.checkAboutPage();
    }

    public void userReturnToMainPage() {
        about.returnToMainPage();
        product.checkProductTab();
    }

    public void userSortProductsLowToHigh(String sortOption) {
        product.selectSortOption(sortOption);
    }

    public void userAddMostExpensive(String numberItems) {
        product.selectLastProducts(Integer.parseInt(numberItems));
    }

    public void expectedCartBadge(String expectedCount) {
        product.verifyShoppingCartBadge(Integer.parseInt(expectedCount));
    }

    public void userClicksShoppingCart() {
        product.clickShoppingCart();
    }

    public void userClicksCheckout() {
        cart.checkShoppingCart();
        cart.selectCheckoutButton();
    }

    public void userFillsFields(String name, String lastName, String zipCode) {
        checkout.checkCheckoutFirstStep();
        checkout.fillFields(name, lastName, zipCode);
        checkout.clickContinueButton();
    }

    public void userClicksFinish() {
        checkout.checkCheckoutSecondStep();
        checkout.checkFinishButton();
        checkout.clickFinishButton();
    }

    public void userCheckThankYouMessage() {
        checkout.checkCheckoutFinished();
        checkout.checkThankYouMessage();
    }
}
