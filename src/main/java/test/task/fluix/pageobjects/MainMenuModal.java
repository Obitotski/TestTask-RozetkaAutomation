package test.task.fluix.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.PageFactory.initElements;
import static test.task.fluix.utils.WebElementUtil.jsClick;

// Main menu (header) is common for all pages
public class MainMenuModal extends BasePage {

    @FindBy(name = "search")
    private WebElement searchInputField;
    @FindBy(xpath = "//ul[@class='suggest-list']")
    private WebElement suggestList;
    @FindBy(xpath = "//rz-cart/button")
    private WebElement shoppingCartButton;

    private final String SUGGEST_OPTION_LOCATOR_TEMPLATE = "//span[contains(text(),'%s')]";

    public MainMenuModal() {
        initElements(driver, this);
    }

    @Step("Main Menu: Set search value: {searchValue} in the search input field")
    public MainMenuModal setSearchValue(String searchValue) {
        searchInputField.sendKeys(searchValue);

        return this;
    }

    @Step("Main Menu: Chosen option: {optionValue} from suggest list")
    public ProductPage chooseOptionFromSuggestList(String optionValue) {

        if (isSuggestListPresent()) {
            if (isOptionPresent(optionValue)) {
                driver
                        .findElement(xpath(format(SUGGEST_OPTION_LOCATOR_TEMPLATE, optionValue)))
                        .click();
            } else {
                throw new AssertionError("No option (suggestion) for search value");
            }
        } else {
            throw new AssertionError("Suggest list is missing");
        }

        return new ProductPage();
    }

    @Step("Main Menu: Opened shopping cart")
    public ShoppingCartPopUp openShoppingCart() {
        jsClick(shoppingCartButton);

        return new ShoppingCartPopUp();
    }

    private boolean isOptionPresent(String searchValue) {

        try {
            return driver
                    .findElement(xpath(format(SUGGEST_OPTION_LOCATOR_TEMPLATE, searchValue)))
                    .isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            return false;
        }
    }

    private boolean isSuggestListPresent() {

        try {
            return suggestList.isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            return false;
        }
    }
}
