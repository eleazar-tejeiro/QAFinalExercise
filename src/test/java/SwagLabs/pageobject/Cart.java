package SwagLabs.pageobject;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;


public class Cart extends PageObject {

    @FindBy(id = "checkout")
    private WebElementFacade checkoutButton;

    public void checkShoppingCart() {
        String currentUrl = getDriver().getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/cart.html";
        Assert.assertEquals(expectedUrl, currentUrl);
    }

    public void selectCheckoutButton() {
        checkoutButton.click();
    }
}
