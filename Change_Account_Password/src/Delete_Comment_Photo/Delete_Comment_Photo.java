package Delete_Comment_Photo;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Delete_Comment_Photo {
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
	  	//Check title
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
  	public void LoginInToAccount() throws InterruptedException {
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
		driver.findElement(By.id("login-email")).sendKeys("sakurakinomoto185@gmail.com");
		driver.findElement(By.cssSelector("form > button")).click();		
		
		// Click on 'Next'
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-password")));		
		
		// Send 'Password' value to the field
		driver.findElement(By.id("login-password")).sendKeys("Sakuraandusagi*01041996");		
		
		// Click 'Log in' button
		driver.findElement(By.cssSelector("form > button")).click();
		ViewAlbumsPhoto();
	}
	
	
	// Click on Album title to go to the Album area
	public void ViewAlbumsPhoto() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".moola-container.feed-ba.upsell-fallback")));
		
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
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".gn-title.you")));
		WebElement titleYou = driver.findElement(By.cssSelector(".gn-title.you"));
		
		//Click on Title You 
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(titleYou)
				.build();
		seriesOfActions.perform();
		
		// Then select Album
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".gn-submenu li:nth-of-type(3)")));	
		WebElement Album = driver.findElement(By.cssSelector(".gn-submenu li:nth-of-type(3)"));
		Actions builder2 = new Actions(driver);
		Action seriesOfActions2 = builder2
				.moveToElement(Album)
				.click()
				.build();
		seriesOfActions2.perform();
		driver.navigate().refresh();
		WaitTheListAlbum();
	}
		
	//Waiting for the list appear
	public void WaitTheListAlbum() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String expectedTitle2 = "Sakura Ayame Kinomoto （アヤメ）’s albums | Flickr";
	  	String actualTitle2 = driver.getTitle();
	  	if (actualTitle2.contains(expectedTitle2)) {
	  		System.out.println("\n===============================================");
	  		System.out.println("Move to Album list has been successfully.");
	  		System.out.println("===============================================");
	  	}
	  	else {
	  		System.out.println("\n===============================================");
	  		System.out.println("Move to Album list has been failed.");
	  		System.out.println("===============================================");
	  	}
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".albums-list-container.fluid-centered")));
		driver.navigate().refresh();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/photos/148306764@N02/albums/72157705255288235']")));	
		ChooseAlbum();
	}
	
	// Choose any Album you want
	public void ChooseAlbum() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		WebElement ChooseAlbum = driver.findElement(By.xpath("//a[@href='/photos/148306764@N02/albums/72157705255288235']"));
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(ChooseAlbum)
				.click()
				.build();
		seriesOfActions.perform();
		driver.navigate().refresh();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/photos/148306764@N02/46596544032/in/album-72157705255288235/']")));
		String expectedTitle = "Kizuna Festival 30 -12 -2018 | Flickr";
		String actualTitle = driver.getTitle();
		if (actualTitle.contains(expectedTitle)) {
			System.out.println("\n===============================================");
	  		System.out.println("Select Album has been successfully.");
	  		System.out.println("===============================================");
	  	}
	  	else {
	  		System.out.println("\n===============================================");
	  		System.out.println("Select Album has been failed.");
	  		System.out.println("===============================================");
		}
		ChoosePhoto();
	}
	
	// Choose any photo
	public void ChoosePhoto() throws InterruptedException {
		WebElement ChoosePhoto = driver.findElement(By.xpath("//a[@href='/photos/148306764@N02/46596544032/in/album-72157705255288235/']"));
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(ChoosePhoto)
				.click()
				.build();
		seriesOfActions.perform();
		Thread.sleep(5000);
		String expectedTitle = "4 | Sakura Ayame Kinomoto （アヤメ） albums | Flickr";
		String actualTitle = driver.getTitle();
		if (actualTitle.contains(expectedTitle)) {
			System.out.println("\n===============================================");
	  		System.out.println("Select photo has been successfully.");
	  		System.out.println("===============================================");
	  	}
	  	else {
	  		System.out.println("\n===============================================");
	  		System.out.println("Select photo has been failed.");
	  		System.out.println("===============================================");
		}
	}
}
