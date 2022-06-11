package test.task.fluix;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import test.task.fluix.pageobjects.HomePage;

import static org.testng.Assert.assertTrue;
import static test.task.fluix.utils.DataProvider.SEARCH_VALUE;

public class RozetkaTest extends BaseTest {

    @Test
    @Description("Verify expected product is added to the shopping cart")
    public void verifyProductIsAddedToTheShoppingCart() {
        var isProductAdded = new HomePage()
                .openHomePage()
                .setSearchValue(SEARCH_VALUE)
                .chooseOptionFromSuggestList(SEARCH_VALUE)
                .addProductToShoppingCart()
                .closeShoppingCartPopUp()
                .goToHomePage()
                .openShoppingCart()
                .isCertainProductAddedToShoppingCart(SEARCH_VALUE);

        assertTrue(isProductAdded, "Product " + SEARCH_VALUE + " should be added to the shopping cart");
    }
}
