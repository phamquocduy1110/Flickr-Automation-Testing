package Comment_Photo;

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

public class Comment_Photo {
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
	  	Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	// Access to Flickr Webiste
	@Test (priority = 0)
  	public void LoginInToAccount() throws InterruptedException {
	  	// Click on 'Log In' button
	  	WebDriverWait wait = new WebDriverWait(driver, 3000);
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
	
	
	// Click on Album title to go to the Album area
	@Test (priority = 1)
	public void ViewAlbumsPhoto() throws InterruptedException {
		Thread.sleep(8000);
		// Check point for accessed account successfully 
	  	String expectedTitle = "Home | Flickr";
	  	String actualTitle = driver.getTitle();
	  	Assert.assertEquals(expectedTitle, actualTitle);
	  	if(actualTitle.contains(expectedTitle)) {
	  		System.out.println("===============================================");
			System.out.println("Logged in successfully");
			System.out.println("===============================================");
	  	}
	  	else {
	  		System.out.println("===============================================");
			System.out.println("Login failed");
			System.out.println("===============================================");
	  	}
	  	
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".moola-container.feed-ba.upsell-fallback")));
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
	}
	
	//Waiting for the list appear
	@Test (priority = 2)
	public void WaitTheListAlbum() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".albums-list-container.fluid-centered")));
		driver.navigate().refresh();
	}
	
	// Choose any Album you want
	@Test (priority = 3)
	public void ChooseAlbum() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-albumid='72157705255288235']/a")));
		WebElement ChooseAlbum = driver.findElement(By.xpath("//div[@data-albumid='72157705255288235']/a"));
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(ChooseAlbum)
				.click()
				.build();
		seriesOfActions.perform();
		driver.navigate().refresh();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/photos/148306764@N02/46596544032/in/album-72157705255288235/']")));
	}
	
	// Choose any photo then write a comment
	@Test (priority = 4)
	public void ChoosePhoto() throws InterruptedException {
		WebElement ChoosePhoto = driver.findElement(By.xpath("//a[@href='/photos/148306764@N02/46596544032/in/album-72157705255288235/']"));
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(ChoosePhoto)
				.click()
				.build();
		seriesOfActions.perform();
	}
		
	// Write the text comment
	@Test (priority = 5)
	public void CommentPhoto() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".new-comment-text.emoji-flipper-set")));
		WebElement txtComment = driver.findElement(By.cssSelector(".new-comment-text.emoji-flipper-set"));
		Actions builder2 = new Actions(driver);
		Action seriesOfActions2 = builder2
				.moveToElement(txtComment)
				.doubleClick(txtComment)
				.sendKeys(txtComment, "A beautiful lovely angel <3 <3")
				.click()
				.build();
		seriesOfActions2.perform();

		// Click on Comment button to save the data
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ui-button.ui-button-cta.comment")));
		WebElement CommentButton = driver.findElement(By.cssSelector(".ui-button.ui-button-cta.comment"));
		Actions builder3 = new Actions(driver);
		Action seriesOfActions3 = builder3
				.moveToElement(CommentButton)
				.click()
				.build();
		seriesOfActions3.perform();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("comment-content")));
		Thread.sleep(5000);
		driver.navigate().refresh();
	}
	
//	@AfterTest
//	public void endSession() {
//		
//	}
}
