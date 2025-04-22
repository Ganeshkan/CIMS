package appmodule_test.cims;

import java.awt.AWTException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CoopChangeindetailTest1 extends Base.cims.TestBase{
	Appmodule.cims.CoopChangeindetailPage1 CoopChangeindetailpage1;
	Appmodule.cims.LoginPage loginpage;

	public CoopChangeindetailTest1() throws InterruptedException {
	super();
	}
	@BeforeMethod
	public void setup() throws InterruptedException {
		intialization(); // Launch Browser
		loginpage = new Appmodule.cims.LoginPage(); // To use loginpage methods
		CoopChangeindetailpage1 = new Appmodule.cims.CoopChangeindetailPage1(); // To use UserSearchPage Methods
	}
	@Test(priority = 1)
	public void CoopApplicationChangeInDetails() throws InterruptedException, AWTException {
		CoopChangeindetailpage1.CooperativeChangeInDetail();
	
	}
	@AfterMethod
    public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
        driver.quit();
}
}