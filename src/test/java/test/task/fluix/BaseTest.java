package test.task.fluix;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static java.time.Duration.ofSeconds;
import static test.task.fluix.pageobjects.BasePage.setDriver;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));
        setDriver(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
