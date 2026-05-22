package BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import base.BasePage;

public class BaseTest {

    protected WebDriver driver;
    protected BasePage page;

    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        page = new BasePage(driver);
    }

    @AfterClass
    public void tearDown() {

        if (driver != null)
            driver.quit();
    }
}

