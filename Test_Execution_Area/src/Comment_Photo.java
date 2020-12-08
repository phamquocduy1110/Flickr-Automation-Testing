import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Comment_Photo {

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
	public void Login() throws InterruptedException {
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
	public void WaitHomePage() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".c-account-menu")));	
	}

	@BeforeMethod
	// Click on Album title to go to the Album area
	public void ClickAlbumTitle() throws InterruptedException {
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".moola-container.feed-ba.upsell-fallback")));
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

	@Test(priority = 0)
	//Waiting for the list appear
	public void WaitTheListAlbum() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".albums-list-container.fluid-centered")));
		Thread.sleep(5000);
	}


	@Test(priority = 1)
	// Choose any Album you want
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
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[3]/div[4]/div/div/a")));
	}

//	@Test(priority = 2)
//	// Choose any photo then write a comment
//	public void ChoosePhoto() throws InterruptedException {
//		Thread.sleep(9000);
//		WebElement ChoosePhoto = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[3]/div[4]/div/div/a"));
//		Actions builder = new Actions(driver);
//		Action seriesOfActions = builder
//				.moveToElement(ChoosePhoto)
//				.click()
//				.build();
//		seriesOfActions.perform();
//	}
//
//	@AfterMethod
//	// Write the text comment
//	public void CommentPhoto() throws InterruptedException {
//		Thread.sleep(9000);
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".new-comment-text.emoji-flipper-set")));
//		WebElement txtComment = driver.findElement(By.cssSelector(".new-comment-text.emoji-flipper-set"));
//		Actions builder2 = new Actions(driver);
//		Action seriesOfActions2 = builder2
//				.moveToElement(txtComment)
//				.doubleClick(txtComment)
//				.sendKeys(txtComment, "A beautiful lovely angel <3 <3")
//				.click()
//				.build();
//		seriesOfActions2.perform();
//	}
//
//	@AfterClass
//	public void SaveComment() throws InterruptedException {
//		// Click on Comment button to save the data
//		Thread.sleep(9000);
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ui-button.ui-button-cta.comment")));
//		WebElement CommentButton = driver.findElement(By.cssSelector(".ui-button.ui-button-cta.comment"));
//		Actions builder3 = new Actions(driver);
//		Action seriesOfActions3 = builder3
//				.moveToElement(CommentButton)
//				.click()
//				.build();
//		seriesOfActions3.perform();
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("comment-content")));
//		Thread.sleep(5000);
//		driver.navigate().refresh();
//	}


//	@AfterTest
//	public void CloseBrowser() throws InterruptedException {
//		Thread.sleep(20000);
//		driver.close();
//	}
}

