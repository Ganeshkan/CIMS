package appmodule_test.cims;
import java.awt.AWTException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CooperativeAppDetailTest extends Base.cims.TestBase{
	
	Appmodule.cims.CooperativeAppDetailPage CooperativeAppDetailpg;
	Appmodule.cims.LoginPage loginpage;
	public CooperativeAppDetailTest() {
	super();
	}
	@BeforeMethod
	public void setup() throws InterruptedException {
		intialization(); // Launch Browser
		loginpage = new Appmodule.cims.LoginPage(); // To use loginpage methods
		loginpage.NewCooperativeAppLogin(); // To login as CAO
		CooperativeAppDetailpg = new Appmodule.cims.CooperativeAppDetailPage(); // To use Detailpage Methods
	}
	@Test(priority = 1)
	public void CoopApplicationDetails() throws InterruptedException, AWTException {
		CooperativeAppDetailpg.Cooperativeinfo();
	}
	@AfterMethod
    public void tearDown() {
        driver.quit();
} 
}	


