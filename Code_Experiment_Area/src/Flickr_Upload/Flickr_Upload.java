package Flickr_Upload;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebElement;

import java.awt.AWTException; 
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.util.concurrent.TimeUnit;
  
  
public class Flickr_Upload { 
    static String driverPath = "D:\\Flickr-Automation-Testing\\ChromeDriver\\ChromeDriver.exe";

	public static void main(String[] args) throws AWTException, InterruptedException
	{
		UploadNewPhotosByChooseBtn();
		//UploadNewPhotosByDragAndDrop(); 
		//UploadNewVideosByChooseBtn();
		

	}
	
	public static void UploadNewPhotosByDragAndDrop() throws AWTException, InterruptedException
	{
//		  Declare variables for Username and Password
//		  Assign them with a valid Flickr account
		  String usn = "ax4409h@gmail.com"; 
	      String pwd = "123456789thy";
	      
//		  Setup path of executable file "Chromedriver.exe"
		  System.setProperty("webdriver.chrome.driver", driverPath); 

//		  Instantiate a WebDriver instance  
		  WebDriver driver = new ChromeDriver();

	  
		  
//	      Navigate to Flickr Website (at http://www.flickr.com) and login with valid account
		  String baseURL = "https://www.flickr.com";
		  driver.get(baseURL);  

//		  Maximize the browser window
		  driver.manage().window().maximize();
		  WebDriverWait wait = new WebDriverWait(driver, 15);

//		  Click on 'Log In' button
		  driver.findElement(By.className("gn-title")).click();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  
//		  Send 'Username' value to the field
		  driver.findElement(By.id("login-email")).sendKeys(usn);
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

//		  Click on 'Next' button
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login-form > button")));
		  driver.findElement(By.cssSelector("#login-form > button")).click();

//		  Send 'Password' value to the field	
		  driver.findElement(By.id("login-password")).sendKeys(pwd);

//		  Click on 'Log in' button and observe the displayed result
		  driver.findElement(By.cssSelector("#login-form > button")).click();
		  
//		  Click on 'Upload' button and observe the displayed result
		  driver.findElement(By.cssSelector(".gn-tools li:nth-of-type(2)")).click();
		  
//		  Click on 'Choose' button photo(s) and choose a photo  
//		  final StringSelection ss = new StringSelection(fileName);
//		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
//		  Robot rb = new Robot();
		  WebElement droparea = driver.findElement(By.id("drop-files-here"));
		  DropFile(new File("D:\\120464640_184307409885822_2128520164424704742_n.jpg"), droparea, 0, 0);

		  //driver.findElement(By.cssSelector(".browse-button-wrapper input")).sendKeys("C:\\Users\\augus\\Pictures\\this-photo.png");
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-publish")));
		  //if(ExpectedConditions.visibilityOfElementLocated(By.id("action-publish")))
//		  Click ''Upload' at the right top of the website and observe the displayed result
		  driver.findElement(By.id("action-publish")).click();
		  
//		  Check on 'Public' checkbox to make sure it's public available and observe the displayed result
//		  Click ''Upload' at the right top of the website and observe the displayed result
		  				  				  
		 // driver.findElement(By.id("confirm-publish")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirm-publish")));
		  driver.findElement(By.id("confirm-publish")).click();
		  if(driver.getCurrentUrl().toString().contains("190432720@N06")) {
			  driver.close();

		  }
	}

	public static void DropFile(File filePath, WebElement target, int offsetX, int offsetY) {
	    if(!filePath.exists())
	        throw new WebDriverException("File not found: " + filePath.toString());

	    WebDriver driver = ((RemoteWebElement)target).getWrappedDriver();
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
	    WebDriverWait wait = new WebDriverWait(driver, 30);

	    String JS_DROP_FILE =
	        "var target = arguments[0]," +
	        "    offsetX = arguments[1]," +
	        "    offsetY = arguments[2]," +
	        "    document = target.ownerDocument || document," +
	        "    window = document.defaultView || window;" +
	        "" +
	        "var input = document.createElement('INPUT');" +
	        "input.type = 'file';" +
	        "input.style.display = 'none';" +
	        "input.onchange = function () {" +
	        "  var rect = target.getBoundingClientRect()," +
	        "      x = rect.left + (offsetX || (rect.width >> 1))," +
	        "      y = rect.top + (offsetY || (rect.height >> 1))," +
	        "      dataTransfer = { files: this.files };" +
	        "" +
	        "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {" +
	        "    var evt = document.createEvent('MouseEvent');" +
	        "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);" +
	        "    evt.dataTransfer = dataTransfer;" +
	        "    target.dispatchEvent(evt);" +
	        "  });" +
	        "" +
	        "  setTimeout(function () { document.body.removeChild(input); }, 25);" +
	        "};" +
	        "document.body.appendChild(input);" +
	        "return input;";

	    WebElement input =  (WebElement)jse.executeScript(JS_DROP_FILE, target, offsetX, offsetY);
	    input.sendKeys(filePath.getAbsoluteFile().toString());
	    wait.until(ExpectedConditions.stalenessOf(input));
	}
	
	public static void UploadNewVideosByChooseBtn() {
//		  Declare variables for Username and Password
//		  Assign them with a valid Flickr account
		  String usn = "ax4409h@gmail.com"; 
	      String pwd = "123456789thy";
	      
//		  Setup path of executable file "Chromedriver.exe"
		  System.setProperty("webdriver.chrome.driver", driverPath); 

//		  Instantiate a WebDriver instance  
		  WebDriver driver = new ChromeDriver();
	  
		  
//	      Navigate to Flickr Website (at http://www.flickr.com) and login with valid account
		  String baseURL = "https://www.flickr.com";
		  driver.get(baseURL);  
		  
//		  Maximize the browser window
		  driver.manage().window().maximize();
		  WebDriverWait wait = new WebDriverWait(driver, 15);

//		  Click on 'Log In' button
		  driver.findElement(By.className("gn-title")).click();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  
//		  Send 'Username' value to the field
		  driver.findElement(By.id("login-email")).sendKeys(usn);
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

//		  Click on 'Next' button
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login-form > button")));
		  driver.findElement(By.cssSelector("#login-form > button")).click();

//		  Send 'Password' value to the field	
		  driver.findElement(By.id("login-password")).sendKeys(pwd);

//		  Click on 'Log in' button and observe the displayed result
		  driver.findElement(By.cssSelector("#login-form > button")).click();
		  
//		  Click on 'Upload' button and observe the displayed result
		  driver.findElement(By.cssSelector(".gn-tools li:nth-of-type(2)")).click();
		  
//		  Click on 'Choose' button photo(s) and choose a photo  
		  driver.findElement(By.cssSelector(".browse-button-wrapper input")).sendKeys("C:\\Users\\duy.187pm13901\\Pictures\\Camera Roll\\WIN_20201030_18_22_19_Pro.mp4");
		  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		  //driver.wait(30,TimeUnit.SECONDS);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-publish")));
		  //driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

//		  Click ''Upload' at the right top of the website and observe the displayed result
		  driver.findElement(By.id("action-publish")).click();
		  
//		  Click ''Upload' at the right top of the website and observe the displayed result
	  
		 // driver.findElement(By.id("confirm-publish")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirm-publish")));
		  driver.findElement(By.id("confirm-publish")).click();
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		  
		  if(driver.getCurrentUrl().toString().contains("190432720@N06")) {
			  driver.navigate().refresh();

		  }
		  //driver.navigate().refresh();
		  //driver.close();
		//
	}
	
	
	public static void UploadNewPhotosByChooseBtn()
	{
//		  Declare variables for Username and Password
//		  Assign them with a valid Flickr account
		  String usn = "ax4409h@gmail.com"; 
	      String pwd = "123456789thy";
	      
//		  Setup path of executable file "Chromedriver.exe"
		  System.setProperty("webdriver.chrome.driver",driverPath); 

//		  Instantiate a WebDriver instance  
		  WebDriver driver = new ChromeDriver();
	  
		  
//	      Navigate to Flickr Website (at http://www.flickr.com) and login with valid account
		  String baseURL = "https://www.flickr.com";
		  driver.get(baseURL);  
		  
//		  Maximize the browser window
		  driver.manage().window().maximize();
		  WebDriverWait wait = new WebDriverWait(driver, 15);

//		  Click on 'Log In' button
		  driver.findElement(By.className("gn-title")).click();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  
//		  Send 'Username' value to the field
		  driver.findElement(By.id("login-email")).sendKeys(usn);
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

//		  Click on 'Next' button
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login-form > button")));
		  driver.findElement(By.cssSelector("#login-form > button")).click();

//		  Send 'Password' value to the field	
		  driver.findElement(By.id("login-password")).sendKeys(pwd);

//		  Click on 'Log in' button and observe the displayed result
		  driver.findElement(By.cssSelector("#login-form > button")).click();
		  
//		  Click on 'Upload' button and observe the displayed result
		  driver.findElement(By.cssSelector(".gn-tools li:nth-of-type(2)")).click();
		  
//		  Click on 'Choose' button photo(s) and choose a photo  
		  driver.findElement(By.cssSelector(".browse-button-wrapper input")).sendKeys("D:\\120062749_357479865610945_4153027505164241120_o.jpg");
		  
		  
//		  Click ''Upload' at the right top of the website and observe the displayed result
		  driver.findElement(By.id("action-publish")).click();
		  
//		  Click ''Upload' at the right top of the website and observe the displayed result
	  
		 // driver.findElement(By.id("confirm-publish")).click();
		  driver.findElement(By.id("confirm-publish")).click();

		  //driver.close();
	}
}
