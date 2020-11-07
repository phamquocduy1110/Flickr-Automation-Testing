package View_Account_Information;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class View_Account_Information {
	public String baseUrl = "https://flickr.com/";
	String driverPath = "D:\\Flickr-Automation-Testing\\ChromeDriver\\ChromeDriver.exe";
	public WebDriver driver;
	
	// Access to Flickr Webiste
	@Test
  	public void HomePageFlickr() throws InterruptedException {
		//1.Navigate to Flickr Website (at http://www.flickr.com)
		System.out.println("launching chrome browser"); 
	  	System.setProperty("webdriver.chrome.driver", driverPath);
	  	System.out.println("Openning chrome browsers");
	  	driver = new ChromeDriver();
	  	driver.manage().window().maximize();
	  	driver.get(baseUrl);
	  	String expectedTitle = "Find your inspiration. | Flickr";
	  	String actualTitle = driver.getTitle();
	  	
	  	//2.Click on 'Log In' button
	  	driver.findElement(By.cssSelector(".gn-signin")).click();
	  	WebDriverWait wait = new WebDriverWait(driver, 30);
	  	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-email")));
	  	//3.Send 'Username' value to the field
		driver.findElement(By.id("login-email")).sendKeys("sakurakinomoto185@gmail.com");
		driver.findElement(By.cssSelector("form > button")).click();		
		//4.Click on 'Next'
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-password")));		
		//5.Send 'Password' value to the field
		driver.findElement(By.id("login-password")).sendKeys("Sakuraandusagi*123");		
		//6.Click 'Log in' button
		driver.findElement(By.cssSelector("form > button")).click();		
		//7.Click the avatar icon
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".c-account-menu")));	
		WebElement Avatar = driver.findElement(By.cssSelector(".c-account-menu"));
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(Avatar)
				//.moveToElement(titleAlbum)
				.click()
				.build();
		seriesOfActions.perform();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".menu-section li:nth-of-type(2)")));	
		WebElement Settings = driver.findElement(By.cssSelector(".menu-section li:nth-of-type(2)"));
		Actions builder2 = new Actions(driver);
		Action seriesOfActions2 = builder2
				.moveToElement(Settings)
				.click()
				.build();
		seriesOfActions2.perform();
	}
}
