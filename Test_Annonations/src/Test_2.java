import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_2 extends Controller {

	@BeforeMethod
	public void BeforeMethod() throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("This is Before Method of Test 2");
	}
	
	@AfterMethod
	public void AfterMethod() throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("This is After Method of Test 2");
	}
	
	@Test	
	public void test2()
	{
		System.out.println("Test 2");
	}
}
