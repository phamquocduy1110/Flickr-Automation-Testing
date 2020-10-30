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
import org.testng.annotations.Test;

public class Comment_Photo {
	public String baseUrl = "https://flickr.com/";
	String driverPath = "D:\\Flickr-Automation-Testing\\ChromeDriver\\ChromeDriver.exe";
	public WebDriver driver;
	
	// Access to Flickr Webiste
	@Test
  	public void LoginInToAccount() throws InterruptedException {
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
		driver.findElement(By.id("login-password")).sendKeys("Sakuraandusagi*123");		
		//6.Click 'Log in' button
		driver.findElement(By.cssSelector("form > button")).click();
		ViewAlbumsPhoto();
	}
	
	
	// Click on Album title to go to the Album area
	public void ViewAlbumsPhoto() throws InterruptedException {
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
		WaitTheListAlbum();
	}
	
	//Waiting for the list appear
	public void WaitTheListAlbum() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".albums-list-container.fluid-centered")));
		driver.navigate().refresh();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[5]/div/div[4]/a/div")));	
		ChooseAlbum();
	}
	
	// Choose any Album you want
	public void ChooseAlbum() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		WebElement ChooseAlbum = driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div/div[4]/a/div"));
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(ChooseAlbum)
				.click()
				.build();
		seriesOfActions.perform();
		driver.navigate().refresh();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[3]/div[4]/div/div/a")));
		ChoosePhoto();
	}
	
	// Choose any photo then write a comment
	public void ChoosePhoto() throws InterruptedException {
		WebElement ChoosePhoto = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[3]/div[4]/div/div/a"));
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(ChoosePhoto)
				.click()
				.build();
		seriesOfActions.perform();
		CommentPhoto();
	}
		
	// Write the text comment
	public void CommentPhoto() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".new-comment-text.emoji-flipper-set")));
		WebElement txtComment = driver.findElement(By.cssSelector(".new-comment-text.emoji-flipper-set"));
		Actions builder2 = new Actions(driver);
		Action seriesOfActions2 = builder2
				.moveToElement(txtComment)
				.doubleClick(txtComment)
				.sendKeys(txtComment, "A beautiful girl, the best friend, the best Sakura's sister")
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
	}
}
