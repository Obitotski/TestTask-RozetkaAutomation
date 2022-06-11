package test.task.fluix.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;
import static test.task.fluix.utils.WebElementUtil.jsClick;

public class ProductPage extends MainMenuModal {

    @FindBy(xpath = "//ul[@class='product-buttons']//button[contains(@class,'buy-button')]")
    private WebElement buyButton;
    @FindBy(xpath = "//ul[@class='product-buttons']//button[contains(@class,'buy-button')]")
    private WebElement logoButton;

    public ProductPage() {
        initElements(driver, this);
    }

    @Step("ProductPage: Added product to the shopping cart")
    public ShoppingCartPopUp addProductToShoppingCart() {
        buyButton.click();

        return new ShoppingCartPopUp();
    }

    @Step("ProductPage: Opened home (main) page")
    public HomePage goToHomePage() {
        jsClick(logoButton);

        return new HomePage();
    }
}
