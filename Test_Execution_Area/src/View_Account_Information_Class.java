import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public abstract class View_Account_Information_Class {
	
	public String baseUrl = "https://flickr.com/";
	String driverPath = "D:\\Flickr-Automation-Testing\\ChromeDriver\\ChromeDriver.exe";
	public WebDriver driver;

	@BeforeTest
	public void FlickrAutomationTesting() throws InterruptedException {
		System.out.println("launching chrome browser"); 
		System.setProperty("webdriver.chrome.driver", driverPath);
		System.out.println("Openning chrome browsers");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Navigate to Flickr Website (at http://www.flickr.com)
		driver.get(baseUrl);

		String expectedTitle = "Find your inspiration. | Flickr";
		String actualTitle = driver.getTitle();
		if (expectedTitle.contains(actualTitle)) {
			System.out.println("===============================================");
			System.out.println("Accessed website's link successfully ");
			System.out.println("===============================================");
		}
		else {
			System.out.println("===============================================");
			System.out.println("Accessed website's link failed ");
			System.out.println("===============================================");
		}
	}
	
	@AfterTest
	public void CloseBrowser() throws InterruptedException {
		Thread.sleep(20000);
		// Close Browser
		driver.close();
		
		// Execute another function
		
	}
}

class TestExecution extends View_Account_Information_Class {
	@Test(priority = 0)
	public void LoginFlickr() throws InterruptedException {
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
	public void WaitHomePage() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".c-account-menu")));	
	}

	@Test(priority = 2)
	public void ClickAvatarIcon() throws InterruptedException {
		WebElement Avatar = driver.findElement(By.cssSelector(".c-account-menu"));
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(Avatar)
				//.moveToElement(titleAlbum)
				.click()
				.build();
		seriesOfActions.perform();
	}

	@Test(priority = 3)
	public void ClickOnSettings() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
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
