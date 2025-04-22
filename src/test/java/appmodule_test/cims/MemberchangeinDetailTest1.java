package appmodule_test.cims;

import java.awt.AWTException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MemberchangeinDetailTest1 extends Base.cims.TestBase {
	
	Appmodule.cims.LoginPage loginpage;
	Appmodule.cims.MemberchangeinDetailPage1 memberchangeindetail;
	
	public MemberchangeinDetailTest1() {
		super();
	}
	@BeforeMethod
	public void setup() throws InterruptedException {
		intialization(); // Launch Browser
		loginpage = new Appmodule.cims.LoginPage(); // To use loginpage methods
		memberchangeindetail = new Appmodule.cims.MemberchangeinDetailPage1(); // To use Detailpage Methods
	}
	@Test(priority = 1)
	public void MemberChangeInDetailFlow() throws InterruptedException, AWTException {
		memberchangeindetail.Memberchangeindetail();
	}
	
	@AfterMethod
    public void tearDown() {
        driver.quit();
} 
	
	
	
}

