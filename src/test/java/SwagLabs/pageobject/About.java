package SwagLabs.pageobject;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

public class About extends PageObject {

    public void checkAboutPage(){
        String currentUrl = getDriver().getCurrentUrl();
        String expectedUrl = "https://saucelabs.com/";
        Assert.assertEquals(expectedUrl,currentUrl);
    }

    public void returnToMainPage(){
        getDriver().navigate().back();
    }
}
