package Test_Execution_Area1_Package;

import org.testng.AssertJUnit;
import java.util.ResourceBundle.Control;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Comment_Photo_Class extends System{
	@BeforeTest
  	public void LoginInToAccount() throws InterruptedException {
	  	// Click on 'Log In' button
	  	WebDriverWait wait = new WebDriverWait(driver, 30);
	  	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".gn-signin")));
	  	driver.findElement(By.cssSelector(".gn-signin")).click();	  	
	  	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-email")));
	  	
	  	// Send 'Username' value to the field
	    driver.findElement(By.id("login-email")).sendKeys("sakurakinomoto185@gmail.com");
		driver.findElement(By.cssSelector("form > button")).click(); 
		
		// Click on 'Next'
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-password")));	
		
		// Send 'Password' value to the field
		driver.findElement(By.id("login-password")).sendKeys("Sakuraandusagi*01041996");
		
		// Click 'Log in' button
		driver.findElement(By.cssSelector("form > button")).click(); 	
	}
	
	
	// Method 2: Click on Album title to go to the Album area
	@Test(priority = 1) 
	public void ViewAlbumsPhoto() throws InterruptedException {
		//.Check title 
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".moola-container.feed-ba.upsell-fallback")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".gn-title.you")));
		
	  	String expectedTitle = "Home | Flickr";
	  	String actualTitle = driver.getTitle();
	  	AssertJUnit.assertEquals(expectedTitle, actualTitle);
		WebElement titleYou = driver.findElement(By.cssSelector(".gn-title.you"));
		
		//Click on Title You 
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(titleYou)
				.build();
		seriesOfActions.perform();
		System.out.println("===============================================");
		System.out.println("Title 'You' has been clicked on successfullly");
		System.out.println("===============================================");
		
		// Then select Album
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".gn-submenu li:nth-of-type(3)")));	
		WebElement Album = driver.findElement(By.cssSelector(".gn-submenu li:nth-of-type(3)"));
		Actions builder2 = new Actions(driver);
		Action seriesOfActions2 = builder2
				.moveToElement(Album)
				.click()
				.build();
		seriesOfActions2.perform();
		Thread.sleep(10000);
	}
	
	@AfterTest
	public void CloseBrowser() {
	
	}
}
