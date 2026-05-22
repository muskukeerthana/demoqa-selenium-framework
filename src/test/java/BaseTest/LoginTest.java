package BaseTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	@Test
	public void loginWithValidCredentials() throws InterruptedException {
		
		page.navigateTo("https://demoqa.com/login");
		page.typeIntoField(By.id("userName"), "keerthi");
		page.typeIntoField(By.id("password"),"keerthi22@");
		page.clickElement(By.xpath("//button[text()='Login']"));
		
		Thread.sleep(200);
		String url = driver.getCurrentUrl();
		//Assert.assertTrue(url.contains("profile"), "Login failed");
		
}
	
//	
//		@Test
//	    public void loginWithInvalidCredentials() {
//	        page.navigateTo("https://demoqa.com/login");
//	        page.typeIntoField(By.id("userName"), "wronguser");
//	        page.typeIntoField(By.id("password"), "wrongpass");
//	        page.clickElement(By.xpath("//button[text()='Login']"));
//	        String url = driver.getCurrentUrl();
//	        Assert.assertFalse(url.contains("profile"), "Should have failed");
//	}

}
