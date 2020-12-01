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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Controller {
	public String baseUrl = "https://flickr.com/";
	String driverPath = "D:\\Flickr-Automation-Testing\\ChromeDriver\\ChromeDriver.exe";
	public WebDriver driver;
	
	@BeforeSuite
	public void  BeforeSuit() throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("This is Test Before Suite");
	}
	
	@AfterSuite
	public void AfterSuite() throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("This is Test After Suit");
	}

	@BeforeTest
	public void BeforeTest() throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("This is Test Before Test");
	}
	
	@AfterTest
	public void AfterTest() throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("This is Test After Test");
	}
	
	@BeforeMethod
	public void BeforeMethod() throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("This is Test Before Method");
	}
	
	@AfterMethod
	public void AfterMethod() throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("This is Test After Method");
	}
	
	@BeforeClass
	public void BeforeClass() throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("This is Test Before Class");
	}
	
	@AfterClass
	public void AfterClass() throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("This is Test After Class");
	}
}
