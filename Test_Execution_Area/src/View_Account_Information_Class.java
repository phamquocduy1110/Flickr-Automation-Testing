import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class View_Account_Information_Class extends System_Controller_Class {

	@BeforeMethod
	public void WaitHomePage() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".c-account-menu")));	
	}

	@Test(priority = 1)
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

	@Test(priority = 2)
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
	
	@AfterMethod
	public void CloseBrowser() throws InterruptedException {
		Thread.sleep(6000);
		driver.close();
	}
}
