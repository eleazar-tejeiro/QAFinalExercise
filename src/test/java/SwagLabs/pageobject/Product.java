package SwagLabs.pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Product extends PageObject {
    @FindBy(xpath = "//span[@class='title' and text()='Products']")
    private WebElementFacade productTitle;

    @FindBy(id = "react-burger-menu-btn")
    private WebElementFacade menuButton;

    @FindBy(id = "about_sidebar_link")
    private WebElementFacade aboutLink;
    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElementFacade productSortDropdown;
    @FindBy(xpath = "//select[@class='product_sort_container']/option")
    private List<WebElementFacade> productSortOptions;

    // Add to cart button list
    @FindBy(className = "btn_inventory")
    private List<WebElementFacade> addToCartButtons;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElementFacade shoppingCartBadge;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElementFacade shoppingCart;

    public boolean isProductTitleDisplayed() {
        return productTitle.isDisplayed();
    }

    public boolean isAboutLinkDisplayed() {
        return aboutLink.isDisplayed();
    }

    public void checkProductTab() {
        String currentUrl = getDriver().getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(expectedUrl, currentUrl);
    }

    public void selectAboutLink() {
        menuButton.click();
        if (aboutLink.isDisplayed())
            aboutLink.click();
    }

    public void selectSortOption(String productSort) {
        productSortDropdown.click();
        for (WebElementFacade option : productSortOptions) {
            if (option.getText().equals(productSort)) {
                option.click();
                break;
            }
        }
    }

    public void selectLastProducts(int numberOfProducts) {
        int totalProducts = addToCartButtons.size();
        int startIndex = Math.max(totalProducts - numberOfProducts, 0);
        for (int i = startIndex; i < totalProducts; i++) {
            WebElement button = addToCartButtons.get(i);
            if (button.getText().equals("Add to cart")) {
                button.click();
            }
        }
    }

    public Boolean isShoppingCartBadgeDisplayed() {
        return shoppingCartBadge.isDisplayed();
    }

    public void verifyShoppingCartBadge(int expectedCount) {
        if (isShoppingCartBadgeDisplayed()) {
            String actualCount = shoppingCartBadge.getText();
            Assert.assertEquals(expectedCount, Integer.parseInt(actualCount));
        }
    }

    public void clickShoppingCart() {
        shoppingCart.click();
    }



}
