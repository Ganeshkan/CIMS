package Appmodule.cims;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.cims.XLS_Reader;

public class BusinessplanPage extends LoginPage{
	public BusinessplanPage() {
		PageFactory.initElements(driver, this);
	}
	XLS_Reader xls_reader;
	@SuppressWarnings("deprecation")
	WebDriverWait wait = new WebDriverWait(driver,30);
	//Login-xpath
	@FindBy(id = "userName")
	WebElement username;
	@FindBy(id = "userPassword")
	WebElement password;
	@FindBy(xpath = "//span[text()='LOGIN']")
	WebElement loginButton;
	//Logout xpath 
	@FindBy(xpath="//button[@id='cimslogoutbtn']")
	WebElement Logoutbtn;
	@FindBy(xpath="//div[@dir='ltr']//button[2]")
	WebElement confrmlogout;
	//Businessmenu-xpath
	@FindBy(xpath="//div[@class='ml-2 screenName']")
	WebElement ScreenName;
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[1]")
	WebElement Cimsmenu;
	@FindBy(xpath="//a[normalize-space()='Office Administration']")
	WebElement officeadministration;
	@FindBy(xpath="//app-menu-item[@appmenuaccess='BusinessNewDiv']//li[contains(text(),'New')]")
	WebElement Newbusinessplan;
	@FindBy(xpath="//app-menu-item[@routerlink='/home/business-plan']//li[contains(text(),'Search')]")
	WebElement businesssearch;
	//Business plan-search
	@FindBy(xpath="//span[normalize-space()='Search']")
	WebElement businessplansearch;
	@FindBy(xpath="(//input[@id='istrBusinessPlanRefNo'])[1]")
	WebElement BusinessPlanRefNo;
	@FindBy(xpath="//button[@id='bpsearchbtn']//span//div//div[contains(text(),'Search')]")
	WebElement searchbtn;
	@FindBy(xpath="//table[@class='mat-table w100']//tbody//tr//td[1]")
	WebElement select_businessplan;

	//Business info-xpath
	@FindBy(xpath="(//small[contains(text(),'mandatory')])")
	WebElement mandatory;
	@FindBy(xpath="//input[@id='businessName']")
	WebElement  Businessname;
	@FindBy(xpath="//input[@id='ownerFirstName']")
	WebElement  ownerfirstname;
	@FindBy(xpath="//input[@id='ownerLastName']")
	WebElement  ownerlastname;
	@FindBy(xpath="//input[@id='dateOfBirth']")
	WebElement dateofbirth;
	@FindBy(xpath="//mat-select[@id='genderValue']//div//div//div")
	WebElement gender;
	@FindBy(xpath="//span[normalize-space()='Male']")
	WebElement male;
	@FindBy(xpath="//span[normalize-space()='Female']")
	WebElement female;
	@FindBy(xpath="//input[@id='ownerContactNo']")
	WebElement  ownercontactno;
	@FindBy(xpath="//input[@id='ownerEmail']")
	WebElement  owneremailid;
	@FindBy(xpath="//span[normalize-space()='Edit']")
	WebElement editaddress ;
	@FindBy(xpath="//mat-select[@id='addressTypeValue']//div//div//div")
	WebElement addresstype;
	@FindBy(xpath="//div[@id='addressTypeValue-panel']")
	WebElement addresstypelist;
	@FindBy(xpath="//form[@autocomplete='off']//div//div//div//div//app-select-control[@label='Province']//div//mat-select[@id='provinceValue']//div//div//div")
	WebElement province;
	@FindBy(xpath="//div[@id='provinceValue-panel']")
	WebElement provincelist;
	@FindBy(xpath="//form[@autocomplete='off']//div//div//div//div//app-select-control[@label='Island']//div//mat-select[@id='islandValue']//div//div//div")
	WebElement island;
	@FindBy(xpath="//div[@id='islandValue-panel']")
	WebElement islandlist;
	@FindBy(xpath="//input[@id='line1']")
	WebElement addressline1;
	@FindBy(xpath="(//span[contains(text(),'Save')])[2]")
	WebElement adresssavebtn;
	@FindBy(xpath="//mat-select[@id='provinceValue']//div//div//div")
	WebElement otherprovince;
	@FindBy(xpath="//div[@id='provinceValue-panel']")
	WebElement otherprovincelist;
	@FindBy(xpath="//mat-select[@id='islandValue']//div//div//div")
	WebElement otherisland;
	@FindBy(xpath="//div[@id='islandValue-panel']")
	WebElement otherislandlist;
	@FindBy(xpath="//input[@id='birthRegNo']")
	WebElement birthregno;
	@FindBy(xpath="//input[@id='drivingLicenseNo']")
	WebElement drivinglisence;
	@FindBy(xpath="//a[@id='bpsavebtn']")
	WebElement businessinfosavebtn;

	@FindBy(xpath="(//div[@class='f14 ml-2'])[1]")
	WebElement Business_plan_ref_no;

	//Business-plan tab xpath
	@FindBy(xpath="//div[contains(text(),'Business Plan Description')]")
	WebElement BusinessplanDes_tab;
	@FindBy(xpath="//textarea[@id='companyDescription']")
	WebElement Businessdescription;
	@FindBy(xpath="//a[@id='bpsavebtn']//span[1]")
	WebElement BusinessDescsavebtn;
	//Notes-tab
	@FindBy(xpath="//div[text()='Notes']")
	WebElement Notestab;
	@FindBy(xpath="//mat-tab-body//div//span[1]")
	WebElement Newnotesbtn;
	@FindBy(xpath="//mat-select[@id='statusValue']")
	WebElement Status;
	@FindBy(xpath="//span[text()=' In Progress ']")
	WebElement Inprogress;
	@FindBy(xpath="//span[text()=' Completed ']")
	WebElement completed;
	@FindBy(xpath="//textarea[@id='notes']")
	WebElement comments;
	@FindBy(xpath="//a[contains(@color,'primary')]")
	WebElement savenotes;
	//History-tab
	@FindBy(xpath="//div[contains(text(),'History')]")
	WebElement historytab;
	@FindBy(xpath="//tbody/tr[1]/td[1]")
	WebElement assignedofficer;


	public void CreateandApproveBusinessPlan() throws InterruptedException, AWTException, IOException {
		try {
			System.out.println(
					"check whether the Business Plan Creation Officer can able to login to default landing page:");
			//Business creation officer login
			username.sendKeys("bco");
			password.sendKeys("password");
			loginButton.click();
			Thread.sleep(1000);
			String Actualscreenname=ScreenName.getText();
			if(Actualscreenname.contains(" Business plan Detail ")) {
				System.out.println("Pass");
			}else {
				System.out.println("Fail");
			}
		} catch (Exception e) {
		}
		//Redirect to the New-Business plan page
		String Actualscreenname=ScreenName.getText();
		if(Actualscreenname.contains(" Business plan Detail ")) {
			System.out.println("Landing page :"+Actualscreenname );

		}else {
			Thread.sleep(2000);
			Cimsmenu.click();Thread.sleep(1000);
			officeadministration.click();Thread.sleep(1000);
			Newbusinessplan.click();Thread.sleep(1000);
		}

		try {
			System.out.println("check whether the mandatory msg shows without entering any mandatory fields and click save:");
			wait.until(ExpectedConditions.visibilityOfElementLocated((By) businessinfosavebtn)).click();
			if(mandatory.isDisplayed()) {
				System.out.println("Pass");
			}
			else {
				System.out.println("Fail");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}



		Businessname.sendKeys(BusinessName());
		ownerfirstname.sendKeys(Firstname());
		ownerlastname.sendKeys(Lastname());
		try {
			System.out.println("check whether the d.o.b field allows to select present and future dates");
			dateofbirth.click();
			driver.findElement(By.xpath(
					"//button[@class='mat-focus-indicator mat-calendar-period-button mat-button mat-button-base']"))
			.click();
			String Year = "1994";
			while (true) {
				String Text = driver.findElement(By.xpath("//td[@aria-label='2016']")).getText();
				if (Text.equals(Year)) {
					break;

				} else {
					WebElement previousmonth = driver
							.findElement(By.xpath("//button[@aria-label='Previous 24 years']"));
					previousmonth.click();
					break;
				}
			}
			driver.findElement(By.xpath("//td[@aria-label='1994']")).click();
			driver.findElement(By.xpath("//td[@aria-label='November 1994']")).click();
			driver.findElement(By.xpath("//td[@aria-label='10 Nov 1994']")).click();
			System.out.println("Pass");
		} catch (Exception e) {
			System.out.println("Fail");
			e.printStackTrace();
		}
		Thread.sleep(1000);
		gender.click();Thread.sleep(1000);
		male.click();Thread.sleep(1000);
		ownercontactno.sendKeys(Numeric_values());
		owneremailid.sendKeys(prop.getProperty("owneremailid"));
		Thread.sleep(1000);
		editaddress.click();Thread.sleep(1000);
		addresstype.click();Thread.sleep(1000);
		addresstypelist.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		province.click();Thread.sleep(1000);
		provincelist.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		island.click();Thread.sleep(1000);
		islandlist.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		addressline1.sendKeys("1-90, MGO colony");Thread.sleep(1000);
		adresssavebtn.click();Thread.sleep(2000);
		otherprovince.click();Thread.sleep(1000);
		otherprovincelist.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		otherisland.click();Thread.sleep(1000);
		otherislandlist.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		Thread.sleep(1000);
		birthregno.sendKeys(AlphaNumeric_values());
		drivinglisence.sendKeys(AlphaNumeric_values());
		businessinfosavebtn.click();TimeUnit.SECONDS.sleep(25);
		String BP_ref_no=Business_plan_ref_no.getText();
		//Business-plan description
		BusinessplanDes_tab.click();Thread.sleep(1000);
		Businessdescription.sendKeys(Description_values());
		BusinessDescsavebtn.click();Thread.sleep(4000);
		//Notes-tab
		Notestab.click();Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(Newnotesbtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Status)).click();
		Thread.sleep(1000);
		Inprogress.click();Thread.sleep(2000);
		comments.sendKeys("Verified and status changed-001");
		savenotes.click();TimeUnit.SECONDS.sleep(15);
		//History-tab
		historytab.click();Thread.sleep(1000);
		String Loginid;
		String AssgnOfficername = assignedofficer.getText();
		System.out.println(AssgnOfficername);
		String Verificationofficerlogin = "";
		if (AssgnOfficername.contains("Eddie Woksen")) {
			Verificationofficerlogin = "ewoksen";
		} else if (AssgnOfficername.contains("clentine Ronson")) {
			Verificationofficerlogin = "cronson";
		}else if (AssgnOfficername.contains("Paul Claude")) {
			Verificationofficerlogin = "pclaude";
		}else if (AssgnOfficername.contains("Jimmy Alick")) {
			Verificationofficerlogin = "jalick";
		}else if (AssgnOfficername.contains("Ben Asmus")) {
			Verificationofficerlogin = "basmus";
		}else if (AssgnOfficername.contains("Binson Henry")) {
			Verificationofficerlogin = "bhenry";
		}else if (AssgnOfficername.contains("Junior Kalsakau")) {
			Verificationofficerlogin = "jjkalsakau";
		}else if (AssgnOfficername.contains("Nick Oli")) {
			Verificationofficerlogin = "onick";
		}else if (AssgnOfficername.contains("Leintz Vusilai")) {
			Verificationofficerlogin = "lvusilai";
		}else if (AssgnOfficername.contains("Iven Joshua")) {
			Verificationofficerlogin = "ijoshua";
		}else if (AssgnOfficername.contains("Business Plan Processing Officer")) {
			Verificationofficerlogin = "bpo";
		}else if (AssgnOfficername.contains("Super Admin")) {
			Verificationofficerlogin = "Superadmin";
		}
		Loginid = Verificationofficerlogin;
		Thread.sleep(1000);
		//Logout
		Logoutbtn.click();Thread.sleep(1000);
		confrmlogout.click();
		Thread.sleep(3000);

		//********************Business plan processing officer***************/////////

		username.sendKeys(Loginid);
		password.sendKeys("password");
		loginButton.click();
		TimeUnit.SECONDS.sleep(5);
		//Redirect to the Business-search page
		try {
			String Actualscreenname1=ScreenName.getText();
			if(Actualscreenname1.contains(" Business plan Search ")) {
				businessplansearch.click();Thread.sleep(1000);
				BusinessPlanRefNo.sendKeys(BP_ref_no);Thread.sleep(1000);
				searchbtn.click();Thread.sleep(1000);
				select_businessplan.click();
			}else {
				Thread.sleep(2000);
				Cimsmenu.click();Thread.sleep(1000);
				officeadministration.click();Thread.sleep(1000);
				businesssearch.click();TimeUnit.SECONDS.sleep(1);
				businessplansearch.click();Thread.sleep(1000);
				BusinessPlanRefNo.sendKeys(BP_ref_no);Thread.sleep(1000);
				searchbtn.click();Thread.sleep(1000);
				select_businessplan.click();	
			}
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			System.out.println("Unable to redirect to the business plan search screen.");
			e.printStackTrace();
		}
		Notestab.click();Thread.sleep(1000);
		Newnotesbtn.click();Thread.sleep(1000);
		Status.click();Thread.sleep(1000);
		completed.click();
		comments.sendKeys(Alphabetic_Values());
		savenotes.click();		

	}
}
