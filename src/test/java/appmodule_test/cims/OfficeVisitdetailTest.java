package appmodule_test.cims;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OfficeVisitdetailTest extends Base.cims.TestBase{
	Appmodule.cims.Officevisitdetailpage Officevisitdetailpage;
	Appmodule.cims.LoginPage loginpage;

	public OfficeVisitdetailTest() throws InterruptedException {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		intialization(); // Launch Browser
		loginpage = new Appmodule.cims.LoginPage(); // To use loginpage methods
		Officevisitdetailpage = new Appmodule.cims.Officevisitdetailpage(); // To use UserSearchPage Methods
}
	@Test(priority=1)
	public void Officevisit() throws InterruptedException {
		Officevisitdetailpage.createofficevisit();
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	
}