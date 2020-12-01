import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Comment_Photo extends System_Controller_Class {

	
	@BeforeMethod
	public void LoginAccount() throws InterruptedException {
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
	// Click on Album title to go to the Album area
	public void ClickAlbumTitle() throws InterruptedException {
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

	@Test(priority = 2)
	//Waiting for the list appear
	public void WaitTheListAlbum() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".albums-list-container.fluid-centered")));
		Thread.sleep(5000);
	}


	@Test(priority = 3)
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

	@Test(priority = 4)
	// Choose any photo then write a comment
	public void ChoosePhoto() throws InterruptedException {
		WebElement ChoosePhoto = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[3]/div[4]/div/div/a"));
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(ChoosePhoto)
				.click()
				.build();
		seriesOfActions.perform();
	}

	@AfterMethod
	public void CloseBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}
}

