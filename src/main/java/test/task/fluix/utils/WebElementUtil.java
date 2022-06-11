package test.task.fluix.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static test.task.fluix.pageobjects.BasePage.getDriver;

public class WebElementUtil {

    public static void jsClick(WebElement webElement) {
        var jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].click()", webElement);
    }
}
