import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
	// Click on Album title to go to the Album area
	public void ClickAlbumTitle() throws InterruptedException {
		//.Check title 
		String expectedTitle = "Home | Flickr";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);

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
		System.out.println("===============================================");
		System.out.println("Title 'You' has been clicked on successfullly");
		System.out.println("===============================================");

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

	@Test
	//Waiting for the list appear
	public void WaitTheListAlbum() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".albums-list-container.fluid-centered")));
		Thread.sleep(5000);
		ChooseAlbum();
	}


	// Choose any Album you want
	public void ChooseAlbum() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/photos/148306764@N02/albums/72157705255288235']")));
		WebElement ChooseAlbum = driver.findElement(By.xpath("//a[@href='/photos/148306764@N02/albums/72157705255288235']"));
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(ChooseAlbum)
				.click()
				.build();
		seriesOfActions.perform();
		driver.navigate().refresh();
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[3]/div[4]/div/div/a")));
		Thread.sleep(5000);
	}

	@AfterMethod
	// Write the text comment
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
}

