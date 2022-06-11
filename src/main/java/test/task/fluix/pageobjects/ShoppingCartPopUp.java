package test.task.fluix.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;
import static test.task.fluix.utils.WebElementUtil.jsClick;

public class ShoppingCartPopUp extends BasePage {

    @FindBy(xpath = "//button[@class='modal__close']")
    private WebElement closePopUpButton;
    @FindBy(xpath = "//a[@class='cart-product__title']")
    private WebElement productTitle;
    @FindBy(xpath = "//div[contains(@class,'modal__content')]")
    private WebElement popUpModal;

    public ShoppingCartPopUp() {
        initElements(driver, this);
    }

    @Step("Shopping Cart PopUp: Closed popup window")
    public ProductPage closeShoppingCartPopUp() {
        if (isPopUpWindowOpened())
            jsClick(closePopUpButton);

        return new ProductPage();
    }

    public boolean isCertainProductAddedToShoppingCart(String searchValue) {
        if (isProductAddedToShoppingCart()) {
            return productTitle
                    .getText()
                    .contains(searchValue);
        } else {
            return false;
        }
    }

    public boolean isProductAddedToShoppingCart() {
        try {
            return productTitle.isDisplayed();
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
