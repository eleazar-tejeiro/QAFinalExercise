package SwagLabs.pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

public class Checkout extends PageObject {

    @FindBy(id = "first-name")
    private WebElementFacade firstName;
    @FindBy(id = "last-name")
    private WebElementFacade lastName;
    @FindBy(id = "postal-code")
    private WebElementFacade postalCode;
    @FindBy(id = "continue")
    private WebElementFacade continueButton;
    @FindBy(id = "finish")
    private WebElementFacade finishButton;
    @FindBy(xpath = "//h2[contains(text(),'Thank you for your order!')]")
    private WebElementFacade thankYouMessage;


    public void checkCheckoutFirstStep() {
        String currentUrl = getDriver().getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
        Assert.assertEquals(expectedUrl, currentUrl);
    }

    public void checkCheckoutSecondStep() {
        String currentUrl = getDriver().getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/checkout-step-two.html";
        Assert.assertEquals(expectedUrl, currentUrl);
    }

    public void checkCheckoutFinished() {
        String currentUrl = getDriver().getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/checkout-complete.html";
        Assert.assertEquals(expectedUrl, currentUrl);
    }

    public void checkThankYouMessage() {
        Assert.assertTrue(thankYouMessage.isDisplayed());
    }

    public void checkFinishButton() {
        Assert.assertTrue(finishButton.isDisplayed());
    }

    public void fillFields(String name, String lastName, String zipCode) {
        this.firstName.sendKeys(name);
        this.lastName.sendKeys(lastName);
        this.postalCode.sendKeys(zipCode);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void clickFinishButton() {
        finishButton.click();
    }
}
