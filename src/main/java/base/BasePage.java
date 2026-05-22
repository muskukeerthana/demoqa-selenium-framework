// ─── BASE PAGE: Reusable actions shared by ALL test pages ───
package base;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import net.sourceforge.tess4j.Tesseract;

import java.io.File;
import java.lang.reflect.Field;
import java.time.Duration;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class BasePage {
    private WebDriver driver;
    // Constructor — injects driver from test
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    
    // VOID — navigate to URL
    public void navigateTo(String url) {
        driver.get(url);
    }
    
    // STRING — return page title
    public String getPageTitle() {
        return driver.getTitle();
    }
    
    // BOOLEAN — check element visible
    public boolean isElementVisible(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) { return false; }
    }
    
    
    // VOID — clear + type into field
    public void typeIntoField(By locator, String text) {
    	WebDriverWait wait =
                new WebDriverWait(driver,
                Duration.ofSeconds(10));

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(locator));

        element.click();

        element.sendKeys(Keys.CONTROL + "a");

        element.sendKeys(Keys.DELETE);

        element.sendKeys(text);
    }
    
    
    // VOID — explicit wait + click
    public void clickElement(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    
    
    // VOID — dropdown selection
    public void selectCountry(By locator, String country) {
        new Select(driver.findElement(locator)).selectByVisibleText(country);
    }
    
    
    // VOID — OCR captcha handler
    public void handleCaptcha(By imgLoc, By inputLoc) throws Exception {
        File src = driver.findElement(imgLoc).getScreenshotAs(OutputType.FILE);
        Tesseract t = new Tesseract();
        t.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        String text = t.doOCR(src).replaceAll("[^a-zA-Z0-9]", "");
        typeIntoField(inputLoc, text);
    }
    
    public void waitForElement(By locator, String text) {

        WebDriverWait wait = new WebDriverWait(driver,
                Duration.ofSeconds(10));

        WebElement element = wait.until(
                ExpectedConditions
                .visibilityOfElementLocated(locator));

        element.click();

        element.clear();

        element.sendKeys(text);
    }
    
    public void typeUsingJS(By locator, String text) {

        WebElement element = driver.findElement(locator);

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
            "arguments[0].value=arguments[1]",
            element,
            text
        );
    }
    
    
}


