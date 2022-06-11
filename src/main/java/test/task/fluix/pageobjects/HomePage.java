package test.task.fluix.pageobjects;

import io.qameta.allure.Step;

import static org.openqa.selenium.support.PageFactory.initElements;
import static test.task.fluix.utils.DataProvider.URL_ROZETKA_HOMEPAGE;

public class HomePage extends MainMenuModal {

    public HomePage() {
        initElements(driver, this);
    }

    @Step("Opened https://rozetka.com.ua/")
    public HomePage openHomePage() {
        driver.get(URL_ROZETKA_HOMEPAGE);

        return this;
    }
}
