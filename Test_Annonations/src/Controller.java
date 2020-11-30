import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Controller {
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
