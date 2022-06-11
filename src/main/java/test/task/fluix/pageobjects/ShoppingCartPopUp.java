package test.task.fluix.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.PageFactory.initElements;
import static test.task.fluix.utils.WebElementUtil.jsClick;

public class ShoppingCartPopUp extends BasePage {

    @FindBy(xpath = "//button[@class='modal__close']")
    private WebElement closePopUpButton;
    @FindBy(xpath = "//div[contains(@class,'modal__content')]")
    private WebElement popUpModal;

    private final By PRODUCT_TITLE_LOCATOR = xpath("//a[@class='cart-product__title']");

    public ShoppingCartPopUp() {
        initElements(driver, this);
    }

    @Step("Shopping Cart PopUp: Closed popup window")
    public ProductPage closeShoppingCartPopUp() {
        if (isPopUpWindowOpened())
            jsClick(closePopUpButton);

        return new ProductPage();
    }

    //List is used in case we have more than one product in the shopping cart
    public boolean isCertainProductAddedToShoppingCart(String searchValue) {
        if (isProductAddedToShoppingCart()) {
            return driver
                    .findElements(PRODUCT_TITLE_LOCATOR)
                    .stream()
                    .map(WebElement::getText)
                    .anyMatch(result -> result.contains(searchValue));
        } else {
            return false;
        }
    }

    public boolean isProductAddedToShoppingCart() {
        try {
            return driver
                    .findElement(PRODUCT_TITLE_LOCATOR)
                    .isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            return false;
        }
    }

    private boolean isPopUpWindowOpened() {
        try {
            return popUpModal.isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            return false;
        }
    }
}
