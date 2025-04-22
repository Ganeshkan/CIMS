package appmodule_test.cims;

import java.awt.AWTException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewMemberApplicationdetailTest extends Base.cims.TestBase{
	Appmodule.cims.NewMemberApplicationdetailPage NewMemberApplicationDetailPage;
	Appmodule.cims.LoginPage loginpage;

	public NewMemberApplicationdetailTest() throws InterruptedException {
		super();
	} 
	@BeforeMethod
	public void setup() throws InterruptedException {
		intialization(); // Launch Browser
		loginpage = new Appmodule.cims.LoginPage(); // To use loginpage methods
		NewMemberApplicationDetailPage = new Appmodule.cims.NewMemberApplicationdetailPage(); // To use UserSearchPage Methods

	}
	@Test(priority=1)
	public void NewMemApp() throws InterruptedException, AWTException {
		NewMemberApplicationDetailPage.NewMemberRegistration();
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	
	
}

