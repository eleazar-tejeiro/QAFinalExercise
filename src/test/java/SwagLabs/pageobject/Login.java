package SwagLabs.pageobject;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class Login extends PageObject {
    @FindBy(id="login-button")
    private WebElementFacade loginButton;

    @FindBy(id="user-name")
    private WebElementFacade usernameInput;

    @FindBy(id="password")
    private WebElementFacade passwordInput;

    @FindBy(xpath = "//*[@class='error-message-container']//h3/button")
    private WebElementFacade errorMessage;
    
    /**
     * This method will sign in to the application
     * @param username
     * @param password
     */
    public void signIn(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    private void clickLoginButton() {
        loginButton.click();
    }

    private void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    private void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public boolean isErrorDisplayed() {
        return errorMessage.isDisplayed();
    }
}
