package Update_Account_Information;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyUpAction;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Update_Account_Information {
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
		UpdateAccountInformation();
	}
	
	
	// Change real name and information
	public void UpdateAccountInformation() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".change-real-name")));
		driver.findElement(By.cssSelector(".change-real-name")).click();
		InputData();
		
	}
	
	// Input new personal information for account
	public void InputData() throws InterruptedException {
		// Input first name
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("firstname")));
		WebElement txtFirstName = driver.findElement(By.name("firstname"));
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(txtFirstName)
				.doubleClick(txtFirstName)
				.sendKeys(txtFirstName, "Kinomoto")
				.build();
		seriesOfActions.perform();
		
		//Input last name
		WebDriverWait wait2 = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("lastname")));
		WebElement txtLastName = driver.findElement(By.name("lastname"));
		Actions builder2 = new Actions(driver);
		Action seriesOfActions2 = builder2
				.moveToElement(txtLastName)
				.doubleClick(txtLastName)
				.sendKeys(txtLastName, "Sakura")
				.build();
		seriesOfActions2.perform();
		
		// Select time zone
		Select timezone = new Select(driver.findElement(By.name("timezone")));
		timezone.selectByValue("55");
		
		// Select a gender
		driver.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr/td/table[1]/tbody/tr[4]/td[2]/input[1]")).click();
		
		// Select Singleness
		driver.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr/td/table[1]/tbody/tr[4]/td[4]/input[1]")).click();
		
		// Input introduction about yourselft
		WebElement txtDescription = driver.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr/td/table[1]/tbody/tr[5]/td[2]/textarea"));
		Actions builder3 = new Actions(driver);
		Action seriesOfActions3 = builder3
				.moveToElement(txtDescription)
				.doubleClick(txtDescription)
				.sendKeys(txtDescription, "My name is Sakura Kinomoto")
				.build();
		seriesOfActions3.perform();
		
		// Input website address
		WebElement txtWebsite = driver.findElement(By.name("website"));
		Actions builder4 = new Actions(driver);
		Action seriesOfActions4 = builder4
				.moveToElement(txtWebsite)
				.doubleClick(txtWebsite)
				.sendKeys(txtWebsite, "https://www.flickr.com/photos/148306764@N02/albums")
				.build();
		seriesOfActions4.perform();
		
		// Input Website name
		WebElement txtWebsite2 = driver.findElement(By.name("website2"));
		Actions builder5 = new Actions(driver);
		Action seriesOfActions5 = builder5
				.moveToElement(txtWebsite2)
				.doubleClick(txtWebsite2)
				.sendKeys(txtWebsite2, "Sakura Ayame Kinomoto")
				.build();
		seriesOfActions5.perform(); 
		
		// Input occupation
		WebElement txtOccupation = driver.findElement(By.name("occupation"));
		Actions builder6 = new Actions(driver);
		Action seriesOfActions6 = builder6
				.moveToElement(txtOccupation)
				.doubleClick(txtOccupation)
				.sendKeys(txtOccupation, "Photographer")
				.build();
		seriesOfActions6.perform();
		
		// Input hometonw
		
		WebElement txtHometown = driver.findElement(By.name("hometown"));
		Actions builder7= new Actions(driver);
		Action seriesOfActions7 = builder7
				.moveToElement(txtHometown)
				.doubleClick(txtHometown)
				.sendKeys(txtHometown, "Viet Nam")
				.build();
		seriesOfActions7.perform();
		
		// Input the city live in now
		WebElement txtCity = driver.findElement(By.name("city"));
		Actions builder8= new Actions(driver);
		Action seriesOfActions8 = builder8
				.moveToElement(txtCity)
				.doubleClick(txtCity)
				.sendKeys(txtCity, "San Francisco")
				.build();
		seriesOfActions8.perform();
		
		// Input country
		WebElement txtCountry = driver.findElement(By.name("country"));
		Actions builder9= new Actions(driver);
		Action seriesOfActions9 = builder9
				.moveToElement(txtCountry)
				.doubleClick(txtCountry)
				.sendKeys(txtCountry, "America")
				.build();
		seriesOfActions9.perform();
		SaveInformationAndCheckAgain();
		
	}
	
	public void SaveInformationAndCheckAgain() throws InterruptedException {
		driver.findElement(By.name("Submit")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".change-real-name")));
		driver.findElement(By.cssSelector(".change-real-name")).click();
	}
}
