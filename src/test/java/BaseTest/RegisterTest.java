package BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class RegisterTest extends BaseTest {
	
	
	@Test
	public void loginOrRegisterTest() throws InterruptedException {

	    page.navigateTo("https://demoqa.com/login");

	    page.typeIntoField(By.id("userName"), "keerthi");
	    page.typeIntoField(By.id("password"), "keerthi22@");

	    page.clickElement(By.id("login"));

	    Thread.sleep(2000);

	    String loginUrl = driver.getCurrentUrl();

	    if (loginUrl.contains("profile")) {

	        System.out.println("Login Successful");

	    } else {
                 
	    	    page.navigateTo("https://demoqa.com/register");
	    	    
	    	    driver.manage().window().maximize();

	    	    JavascriptExecutor js =
	    	            (JavascriptExecutor) driver;

	    	    js.executeScript(
	    	            "document.body.style.zoom='80%'");

	    	    js.executeScript(
	    	            "window.scrollBy(0,500)");
	    	    
                Thread.sleep(2000);

                page.typeIntoField(By.id("firstname"), "Keerthi23443@233");

                Thread.sleep(2000);

                page.typeIntoField(By.id("lastname"), "Tester");

                Thread.sleep(2000);

                page.typeIntoField(By.id("userName"), "BetaTester01");

                Thread.sleep(2000);

                page.typeIntoField(By.id("password"), "Falcon@123");

	        System.out.println("Solve CAPTCHA manually");

	        //Thread.sleep(15000);

	        page.clickElement(By.id("register"));
	        
	        Thread.sleep(200);
	        
	        page.clickElement(By.id("gotologin"));
	        Thread.sleep(2000);
	        page.typeIntoField(By.id("userName"), "BetaTester01");
	        page.typeIntoField(By.id("password"),
	        		"Falcon@123");
	        page.clickElement(By.id("login"));
	        Thread.sleep(2000);
	        System.out.println("Registration successful, now Login successful");

	    }
	  }
	}


