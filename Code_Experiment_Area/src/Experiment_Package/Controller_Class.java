package Experiment_Package;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Controller_Class {

	@BeforeMethod
	public void activateSystem() {
		// TODO Auto-generated method stub
		System.out.println("Activate system");
	}
	
	@AfterMethod
	public void shutDownSystem() {
		System.out.println("Deactivate system");
	}

}
