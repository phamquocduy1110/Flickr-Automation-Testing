package Test_Execution_Area1_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class System_Controller_Class {
	public String baseUrl = "https://flickr.com/";
	String driverPath = "D:\\Flickr-Automation-Testing\\ChromeDriver\\ChromeDriver.exe";
	public WebDriver driver;
	
	@BeforeTest
	public void LaunchBrowser() throws InterruptedException{
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
	  	
	  	Comment_Photo_Class t = new Comment_Photo_Class();
		t.LoginInToAccount();
	}

	
	@AfterMethod
	public void CloseBrowser() throws InterruptedException {
	
	}
}