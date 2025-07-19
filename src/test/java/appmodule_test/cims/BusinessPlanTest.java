package appmodule_test.cims;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//9899823923997239724234
import Base.cims.XLS_Reader;

public class BusinessPlanTest extends Base.cims.TestBase{
	Appmodule.cims.BusinessplanPage BusinessPlanPage;
	Appmodule.cims.LoginPage loginpage;
	XLS_Reader xls_reader;

	public BusinessPlanTest() throws InterruptedException {
		super();
	}  
	@BeforeMethod
	public void setup() throws InterruptedException {
		intialization(); // Launch Browser
		loginpage = new Appmodule.cims.LoginPage(); // To use loginpage methods
		BusinessPlanPage = new Appmodule.cims.BusinessplanPage(); // To use UserSearchPage Methods
}
	@Test(priority=1)
	public void Business() throws InterruptedException, AWTException, IOException {
		BusinessPlanPage.CreateandApproveBusinessPlan();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
