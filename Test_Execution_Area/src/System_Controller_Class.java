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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class System_Controller_Class {
	public String baseUrl = "https://flickr.com/";
	String driverPath = "D:\\Flickr-Automation-Testing\\ChromeDriver\\ChromeDriver.exe";
	public WebDriver driver;

	@BeforeSuite
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

	@BeforeTest
	public void Flickr() throws InterruptedException {
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

	@BeforeClass
	public void BeforeCLass() throws InterruptedException {
		Thread.sleep(6000);
	}
	
	@AfterClass
	public void AfterClass() throws InterruptedException {
		Thread.sleep(5000);
	}
}
