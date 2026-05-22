// ─── CONTACT FORM TEST: Tab switch + captcha flow ───
package BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.*;
public class ContactFormTest extends BaseTest {
    @Test
    public void fillContactFormWithCaptcha() throws Exception {
        // Open demoqa — click banner image to open new tab
        page.navigateTo("https://demoqa.com/login");
        page.clickElement(By.xpath("//div//img[@alt='Selenium Online Training']"));
        // Switch to new tab
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        
        page.clickElement(By.xpath("//a[contains(text(),'Registration')]"));
        page.typeIntoField(By.id("first-name"),  "john");
        page.typeIntoField(By.id("last-name"),   "doe");
        page.typeIntoField(By.id("email"),       "john@gmail.com");
        page.typeIntoField(By.id("mobile"),      "1234567890");
        page.selectCountry(By.xpath("//select[@id='country']"), "Ireland");
        page.typeIntoField(By.name("city"), "Dublin");
        page.typeIntoField(By.id("message"),
            "I am doing master's in Cybersecurity in Ireland");
        // OCR captcha solve
        page.handleCaptcha(
            By.xpath("//img[@alt='Captcha for submitting form']"),
            By.id("code")
        );
    }
}

