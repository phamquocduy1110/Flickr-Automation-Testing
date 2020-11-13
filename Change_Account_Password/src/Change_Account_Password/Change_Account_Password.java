package Change_Account_Password;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyUpAction;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Change_Account_Password {
	public String baseUrl = "https://flickr.com/";
	String driverPath = "D:\\Flickr-Automation-Testing\\ChromeDriver\\ChromeDriver.exe";
	public WebDriver driver;
	
	@BeforeTest
	public void setBaseUrl() {
		System.out.println("launching chrome browser"); 
	  	System.setProperty("webdriver.chrome.driver", driverPath);
	  	System.out.println("Openning chrome browsers");
	  	driver = new ChromeDriver();
	  	driver.manage().window().maximize();
	  	// Navigate to Flickr Website (at http://www.flickr.com)
	  	driver.get(baseUrl);
	  	// Check title
	  	String expectedTitle = "Find your inspiration. | Flickr";
	  	String actualTitle = driver.getTitle();
	  	if (actualTitle.contains(expectedTitle)) {
	  		System.out.println("===============================================");
	  		System.out.println("Website accessed successfully.");
	  		System.out.println("===============================================");
	  	}
	  	else {
	  		System.out.println("===============================================");
	  		System.out.println("Website accesssed failed");
	  		System.out.println("===============================================");
	  	}
	}
	
	// Access to Flickr Webiste
	@Test
  	public void LoginIntoAccount() throws InterruptedException {
	  	// Click on 'Log In' button
	  	driver.findElement(By.cssSelector(".gn-signin")).click();
	  	WebDriverWait wait = new WebDriverWait(driver, 60);
	  	
	  	// Check title
	  	String expectedTitle = "Flickr Login";
	  	String actualTitle = driver.getTitle();
	  	Assert.assertEquals(expectedTitle, actualTitle);
	  	if (actualTitle.contains(expectedTitle)) {
	  		System.out.println("===============================================");
	  		System.out.println("Move to login page has been successfully.");
	  		System.out.println("===============================================");
	  	}
	  	else {
	  		System.out.println("===============================================");
	  		System.out.println("Move to login page has been failed");
	  		System.out.println("===============================================");
	  	}
	  	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-email")));
	  	
	  	// Send 'Username' value to the field
		driver.findElement(By.id("login-email")).sendKeys("phamquocduy1110@gmail.com");
		driver.findElement(By.cssSelector("form > button")).click();
		
		// Click on 'Next'
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-password")));
		
		// Send 'Password' value to the field
		driver.findElement(By.id("login-password")).sendKeys("Sakuraandusagi*01041996");
		
		// Click 'Log in' button
		driver.findElement(By.cssSelector("form > button")).click();
		CheckPoint();
	}
	
	public void CheckPoint() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".c-account-menu")));	
		// Check point 
	  	String expectedTitle = "Home | Flickr";
	  	String actualTitle = driver.getTitle();
	  	if (actualTitle.contains(expectedTitle)) {
	  		System.out.println("\n===============================================");
	  		System.out.println("Account has been logined successfully.");
	  		System.out.println("===============================================");
	  	}
	  	else {
	  		System.out.println("\n===============================================");
	  		System.out.println("Login failed");
	  		System.out.println("===============================================");
	  	}
	  	ClickAvtarIcon();
	}
	
	public void ClickAvtarIcon() throws InterruptedException {
		// Click the avatar icon
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".c-account-menu")));	
		WebElement Avatar = driver.findElement(By.cssSelector(".c-account-menu"));
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(Avatar)
				//.moveToElement(titleAlbum)
				.click()
				.build();
		seriesOfActions.perform();
		Settings();
	}
		
	public void Settings() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".menu-section li:nth-of-type(2)")));
		WebElement Settings = driver.findElement(By.cssSelector(".menu-section li:nth-of-type(2)"));
		Actions builder2 = new Actions(driver);
		Action seriesOfActions2 = builder2
				.moveToElement(Settings)
				.click()
				.build();
		seriesOfActions2.perform();
		driver.navigate().refresh();
		ChangeAccountPassword();
	}
	
	// Click on Edit your password
	public void ChangeAccountPassword() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 600);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='https://identity.flickr.com/change-password']")));
		String expectedTitle = "Account settings | Flickr";
	  	String actualTitle = driver.getTitle();
	  	if (actualTitle.contains(expectedTitle)) {
	  		System.out.println("\n===============================================");
	  		System.out.println("Move to Settings has been successfully");
	  		System.out.println("===============================================");
	  	}
	  	else {
	  		System.out.println("\n===============================================");
	  		System.out.println("Move to Settings has been failed");
	  		System.out.println("===============================================");
	  	}
	  	Thread.sleep(5000);
	  	WebElement ChangePassword = driver.findElement(By.xpath("//a[@href='https://identity.flickr.com/change-password']"));
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(ChangePassword)
				.click()
				.build();
		seriesOfActions.perform();
		InputNewPassword();
	}
	
	public void InputNewPassword() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		String expectedTitle = "Flickr Login";
	  	String actualTitle = driver.getTitle();
	  	if (actualTitle.contains(expectedTitle)) {
	  		System.out.println("\n===============================================");
	  		System.out.println("Move to (Edit your password)'s page has been successfully");
	  		System.out.println("===============================================");
	  	}
	  	else {
	  		System.out.println("\n===============================================");
	  		System.out.println("Move to (Edit your password)'s page has been failed");
	  		System.out.println("===============================================");
	  	}
	  	
	  	// Input current password in txtCurrentPassword
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("current-password")));
		WebElement txtCurrentPassword = driver.findElement(By.id("current-password"));
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(txtCurrentPassword)
				.click()
				.sendKeys(txtCurrentPassword, "Sakuraandusagi*01041996")
				.build();
		seriesOfActions.perform();
		
		// Input new password in txtNewPassword
		WebElement txtNewPassword = driver.findElement(By.id("new-password"));
		Actions builder2 = new Actions(driver);
		Action seriesOfActions2 = builder2
				.moveToElement(txtNewPassword)
				.click()
				.sendKeys(txtNewPassword, "Sakuraandusagi*123")
				.build();
		seriesOfActions2.perform();
		ChangeYourFlickrPassword();
	}
	
	public void ChangeYourFlickrPassword() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='mt-5 c-white bg-blue flickr-button flex align-center justify-center f-size-3 f-weight-bold over-y-hidden block w-100 b-rad-1 py-2 px-4']")));
		// Click on "Change your Flickr password" button
		driver.findElement(By.xpath("//button[@class='mt-5 c-white bg-blue flickr-button flex align-center justify-center f-size-3 f-weight-bold over-y-hidden block w-100 b-rad-1 py-2 px-4']")).click();
		WebDriverWait wait2 = new WebDriverWait(driver, 60);
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='c-white bg-blue flickr-button flex align-center justify-center f-size-3 f-weight-bold over-y-hidden block w-100 b-rad-1 py-2 px-4']")));
		String expectedTitle = "Flickr Login";
	  	String actualTitle = driver.getTitle();
	  	if (actualTitle.contains(expectedTitle)) {
	  		System.out.println("\n===============================================");
	  		System.out.println("Password has been changed successfully");
	  		System.out.println("===============================================");
	  	}
	  	else {
	  		System.out.println("\n===============================================");
	  		System.out.println("Changed password has been failed");
	  		System.out.println("===============================================");
	  	}
	  	Thread.sleep(6000);
		driver.findElement(By.xpath("//button[@class='c-white bg-blue flickr-button flex align-center justify-center f-size-3 f-weight-bold over-y-hidden block w-100 b-rad-1 py-2 px-4']")).click();
		Thread.sleep(8000);
	}
	
	@AfterTest
	public void endSession() throws InterruptedException {
		System.out.println("\n===============================================");
  		System.out.println("Quit browser");
  		System.out.println("===============================================");
		driver.quit();
	}
}
