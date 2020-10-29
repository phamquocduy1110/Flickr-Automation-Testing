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
import org.testng.annotations.Test;

public class Change_Account_Password {
	public String baseUrl = "https://flickr.com/";
	String driverPath = "D:\\Flickr-Automation-Testing\\ChromeDriver\\ChromeDriver.exe";
	public WebDriver driver;
	
	// Access to Flickr Webiste
	@Test
  	public void ViewAccountInformation() throws InterruptedException {
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
	  	WebDriverWait wait = new WebDriverWait(driver, 60);
	  	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-email")));
	  	//3.Send 'Username' value to the field
		driver.findElement(By.id("login-email")).sendKeys("sakurakinomoto185@gmail.com");
		driver.findElement(By.cssSelector("form > button")).click();		
		//4.Click on 'Next'
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-password")));		
		//5.Send 'Password' value to the field
		driver.findElement(By.id("login-password")).sendKeys("Sakuraandusagi*01041996");		
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
		Settings();
	}
	
	public void Settings() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".menu-section li:nth-of-type(2)")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[4]/div/div[2]/div/div/div/section[3]/ul/li[2]/a")));
		//WebElement Settings = driver.findElement(By.cssSelector(".menu-section li:nth-of-type(2)"));
		WebElement Settings = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div/div/section[3]/ul/li[2]/a"));
		Actions builder2 = new Actions(driver);
		Action seriesOfActions2 = builder2
				.moveToElement(Settings)
				.click()
				.build();
		seriesOfActions2.perform();
		ChangeAccountPassword();
	}
	
	// Click on Edit your password
	public void ChangeAccountPassword() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[4]/div/div[2]/div[1]/div[2]/div[1]/div/div[2]/p[2]/a")));
		WebElement ChangePassword = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div[2]/div[1]/div[2]/div[1]/div/div[2]/p[2]/a"));
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
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("current-password")));
		WebElement txtCurrentPassword = driver.findElement(By.id("current-password"));
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(txtCurrentPassword)
				.click()
				.sendKeys(txtCurrentPassword, "Sakuraandusagi*01041996")
				.build();
		seriesOfActions.perform();
		
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
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[2]/form/button")));
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/form/button")).click();
		WebDriverWait wait2 = new WebDriverWait(driver, 60);
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button")));
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button")).click();
	}
}
