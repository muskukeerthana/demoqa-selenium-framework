package BaseTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Elements extends BaseTest {
	
	@Test
	public void ElementTab () throws InterruptedException {
		
		driver.get("https://demoqa.com/text-box");
		Thread.sleep(2000);
		
        page.typeIntoField(By.xpath("//input[@id='userName']"), "Keerthi22@");
        page.typeIntoField(By.xpath("//input[@id='userEmail']"), "keerthi22@yahoo.com");
        page.typeIntoField(By.xpath("//textarea[@id='currentAddress']"), "Dublin Ireland");
        page.typeIntoField(By.xpath("//textarea[@id='permanentAddress']"),"I am in the Final Year of my master's in cybersecurity in Ireland ");
        WebElement submit =
        		driver.findElement(By.id("submit"));

        		JavascriptExecutor js =
        		(JavascriptExecutor) driver;

        		js.executeScript(
        		"arguments[0].scrollIntoView(true);",
        		submit);

        		Thread.sleep(1000);

        		js.executeScript(
        		"arguments[0].click();",
        		submit);page.clickElement(By.xpath("//button[@id='submit']"));
        String actualName =
        		driver.findElement(By.id("name")).getText();

        		System.out.println(actualName);
				
	}
		
}


