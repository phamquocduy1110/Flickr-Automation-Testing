package SearchExistAccount;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public abstract class SearchExistAccount {

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

	@AfterTest
	public void CloseBrowse() throws InterruptedException {
		Thread.sleep(10000);
		driver.close();
	}
}

class Execute extends SearchExistAccount {
	// Access to Flickr Webiste
	@Test(priority = 0)
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

	@Test(priority = 1)
	// Select title Explore
	public void ViewRecentPhotos() throws InterruptedException {
		Thread.sleep(8000);
		//.Check point for logged in successfully 
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
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".gn-title.explore")));
		WebElement titleExplore = driver.findElement(By.cssSelector(".gn-title.explore"));

		//Click on title Explore 
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(titleExplore)
				.build();
		seriesOfActions.perform();
		Thread.sleep(9000);

		// Then select Recent Photos
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@role='menubar' and  contains(@class,'nav-menu')]/li[position()=2]/ul/li[position()=1]/a")));	
		WebElement RecentPhotos = driver.findElement(By.xpath("//ul[@role='menubar' and  contains(@class,'nav-menu')]/li[position()=2]/ul/li[position()=1]/a"));
		Actions builder2 = new Actions(driver);
		Action seriesOfActions2 = builder2
				.moveToElement(RecentPhotos)
				.click()
				.build();
		seriesOfActions2.perform();
		Thread.sleep(9000);
	}

	// Choose a specific photo
	@Test (priority = 2)
	public void ChoosePhoto() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='view photo-list-view']/div[position()=2]/div/div/a")));	
		WebElement ChoosePhoto = driver.findElement(By.xpath("//div[@class='view photo-list-view']/div[position()=2]/div/div/a"));
		Actions builder2 = new Actions(driver);
		Action seriesOfActions2 = builder2
				.moveToElement(ChoosePhoto)
				.click()
				.build();
		seriesOfActions2.perform();
		Thread.sleep(9000);
	}

	@Test (priority = 3)
	public void LikePhoto() throws InterruptedException {
		WebElement ChoosePhoto = driver.findElement(By.xpath("//div[@class='view photo-engagement-view']/div[position()=1]/div[@class='button']/a[@class='fave-star star_control  ']"));
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(ChoosePhoto)
				.click()
				.build();
		seriesOfActions.perform();
	}
}

