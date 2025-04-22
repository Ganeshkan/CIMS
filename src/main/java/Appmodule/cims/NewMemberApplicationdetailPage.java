package Appmodule.cims;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewMemberApplicationdetailPage extends Base.cims.TestBase{

	public NewMemberApplicationdetailPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userName")
	WebElement username;
	@FindBy(id = "userPassword")
	WebElement password;
	@FindBy(xpath = "//span[text()='LOGIN']")
	WebElement loginButton;
	@FindBy(xpath="//div[@class='ml-2 screenName']")
	WebElement ScreenName;
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[1]")
	WebElement Cimsmenu;
	@FindBy(xpath="//li[@appmenuaccess='MemberMainDiv']")
	WebElement MemberMenu;
	@FindBy(xpath="//li[text()='New']")
	WebElement newmember;
	@FindBy(xpath ="//li[text()=' Search']")
	WebElement membersearch;
	@FindBy(xpath="//app-menu-item[@routerlink='/home/member']//li[@class='menu-item']")
	WebElement approvedmembersearch;


	@FindBy(xpath="//span[text()='Search']")
	WebElement searchbox;
	@FindBy(xpath="//input[@id='cooperativeRefNo']")
	WebElement searchbycoopregno;
	@FindBy(xpath="//mat-select[@id='statusValue']")
	WebElement searchstatus;
	@FindBy(xpath="//span[text()=' Approved ']")
	WebElement searchstatusvalues;
	@FindBy(xpath="//div[text()='Search']")
	WebElement searchbtn;
	@FindBy(xpath="//tbody/tr[1]/td[6]")
	WebElement CoopAppNo;
	@FindBy(xpath="(//table[@class='mat-table w100']//tbody//tr//td[1])[1]")
	WebElement selectAppno;
	@FindBy(xpath="//a[@color='primary']//span[1]")
	WebElement meminfosavebtn;

	@FindBy(xpath="//div[text()= 'Documents']")
	WebElement Documenttab;

	@FindBy(xpath="//div[text()='Other Details']")
	WebElement otherdetailtab;

	@FindBy(xpath="//div[text()='Checklist']")
	WebElement checklisttab;

	@FindBy(xpath="//div[text()='Notes']")
	WebElement Notestab;
	@FindBy(xpath="//mat-tab-body//div//span[1]")
	WebElement Newnotesbtn;
	@FindBy(xpath="//mat-select[@id='statusValue']")
	WebElement Status;
	@FindBy(xpath="//span[text()=' Pending Verification 1 ']")
	WebElement pendingverfy1;
	@FindBy(xpath="//span[text()=' Pending Verification 2 ']")
	WebElement pendingverfy2;
	@FindBy(xpath="//span[normalize-space()='Pending Approval']")
	WebElement pendingapproval;
	@FindBy(xpath="//span[normalize-space()='Approved']")
	WebElement approved;
	@FindBy(xpath="//textarea[@id='notes']")
	WebElement comments;
	@FindBy(xpath="//a[contains(@color,'primary')]")
	WebElement savenotes;

	@FindBy(xpath="//div[text()='History']")
	WebElement Historytab;
	@FindBy(xpath="//tbody/tr[1]/td[1]")
	WebElement AssignedToofficer;


	int day=4;
	@SuppressWarnings("deprecation")
	WebDriverWait wait = new WebDriverWait(driver,30);




	public void NewMemberRegistration() throws InterruptedException, AWTException {
		//member application officer
		username.sendKeys(prop.getProperty("Memname"));
		password.sendKeys(prop.getProperty("Mempsd"));
		loginButton.click();
		TimeUnit.SECONDS.sleep(3);
		String Actualscreenname =ScreenName.getText();
		String coapplicationno = "";
		try {
			if(Actualscreenname.contains(" Member Search ")) {
				TimeUnit.SECONDS.sleep(5);
				coapplicationno=CoopAppNo.getText();
			}else {
				TimeUnit.SECONDS.sleep(3);
				Cimsmenu.click();Thread.sleep(2000);
				MemberMenu.click();Thread.sleep(2000);
				approvedmembersearch.click();TimeUnit.SECONDS.sleep(10);
				coapplicationno=CoopAppNo.getText();
			}
			System.out.println("Entered cooperative Application no:"+coapplicationno);
		} catch (InterruptedException e) {
			System.out.println("Unable to get the cooperative application no");
			e.printStackTrace();
		}
		try {
			Cimsmenu.click();Thread.sleep(2000);
			MemberMenu.click();Thread.sleep(2000);
			newmember.click();TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			System.out.println("Redirect to New Member registration failed");
			e.printStackTrace();
		}
		Thread.sleep(2000);
		WebElement CoopRegNo=driver.findElement(By.id("cooperativeRegNo"));
		CoopRegNo.sendKeys(coapplicationno);
		Thread.sleep(1000);

		WebElement CoopSearchicon=driver.findElement(By.xpath("//a[contains(@class,'mat-focus-indicator mat-tooltip-trigger i-btn bg mat-button mat-button-base ng-star-inserted')]"));
		CoopSearchicon.click();Thread.sleep(1000);

		WebElement MembershipNo=driver.findElement(By.id("membershipNo"));
		MembershipNo.sendKeys(prop.getProperty("MembershipNo"));
		Thread.sleep(1000);
		WebElement Memfirstname=driver.findElement(By.id("firstName"));
		Memfirstname.sendKeys(prop.getProperty("Memfirstname"));
		Thread.sleep(1000);

		WebElement Memlastname=driver.findElement(By.id("lastName"));
		Memlastname.sendKeys(prop.getProperty("Memlastname"));
		Thread.sleep(1000);
		WebElement Gendervalue=driver.findElement(By.id("genderValue"));
		Gendervalue.click();Thread.sleep(1000);
		WebElement Selectgender=driver.findElement(By.xpath("//span[text()=' Male ']"));
		Selectgender.click();Thread.sleep(1000);
		WebElement MaritalStatus=driver.findElement(By.id("maritalStatusValue"));
		MaritalStatus.click();Thread.sleep(1000);
		WebElement SelectMaritalstatus=driver.findElement(By.xpath("//span[text()=' Single ']"));
		SelectMaritalstatus	.click();Thread.sleep(1000);

		// choose days of  datebirth
		try {
			WebElement ClickMemberDOB = driver.findElement(By.id("dateOfBirth"));
			ClickMemberDOB.click();
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
		} catch (Exception e) {
			System.out.println("unable to select the Member DOB");
			e.printStackTrace();
		}

		Thread.sleep(1000);
		WebElement Membershipdate=driver.findElement(By.id("dateOfElection"));
		Membershipdate.click();Thread.sleep(1000);
		WebElement selmembershipdate=driver.findElement(By.xpath("//table[contains(@class,'mat-calendar-table')]//tbody//tr//td//div[contains(text(),"+day+")]"));
		selmembershipdate.click();Thread.sleep(1000);
		//KYC
		WebElement BirthregNo=driver.findElement(By.id("birthRegNo"));
		BirthregNo.sendKeys(prop.getProperty("BRN"));Thread.sleep(1000);
		WebElement passportno=driver.findElement(By.id("passportNo"));
		passportno.sendKeys(prop.getProperty("passportNo"));Thread.sleep(1000);
		WebElement Nationalityddl=driver.findElement(By.id("nationalityValue"));
		Nationalityddl.click();Thread.sleep(1000);
		WebElement SelctNationalityddl=driver.findElement(By.xpath("//span[text()=' Vanuatu ']"));
		SelctNationalityddl	.click();Thread.sleep(1000);
		//scroll-down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		WebElement Memberemailid=driver.findElement(By.id("emailId"));
		Memberemailid.sendKeys(prop.getProperty("Emailid"));Thread.sleep(1000);
		WebElement MembContactNo=driver.findElement(By.id("contactNo"));
		MembContactNo.sendKeys(prop.getProperty("ContactNo"));
		Thread.sleep(2000);
		WebElement AddressEdit=driver.findElement(By.xpath("(//span[text()=' Edit '])[1]"));
		AddressEdit	.click();
		Thread.sleep(2000);
		WebElement Addrestypeddl=driver.findElement(By.id("addressTypeValue"));
		Addrestypeddl.click();Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()=' Branch Office ']")).click();Thread.sleep(1000);
		WebElement AddProvinceddl=driver.findElement(By.id("provinceValue"));
		AddProvinceddl.click();Thread.sleep(1000);
		WebElement SelectProvince=driver.findElement(By.xpath("//span[text()=' Malampa ']"));Thread.sleep(1000);
		SelectProvince.click();
		WebElement Addline=driver.findElement(By.id("line1"));
		Addline	.sendKeys(prop.getProperty("memberAddressline1"));Thread.sleep(1000);
		WebElement Islandddl=driver.findElement(By.id("islandValue"));
		Islandddl.click();Thread.sleep(1000);
		WebElement Selectisland=driver.findElement(By.xpath("//span[text()=' Akhamb ']"));Thread.sleep(1000);
		Selectisland.click();
		WebElement Addresssavebtn=driver.findElement(By.xpath("(//span[text()=' Save '])[2]"));
		Addresssavebtn.click();Thread.sleep(2000);
		//membertab Save btn
		meminfosavebtn.click();
		TimeUnit.SECONDS.sleep(10);


		//Othertab
		otherdetailtab.click();
		//Share Register
		WebElement SharecountNewbtn=driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator btn-mw btn-tertiary mat-raised-button mat-button-base ng-star-inserted')]"));
		SharecountNewbtn.click();
		Thread.sleep(2000);
		WebElement sharecount=driver.findElement(By.id("shareCount"));
		sharecount.sendKeys(prop.getProperty("Sharecount"));
		WebElement CreditAmt=driver.findElement(By.id("creditAmount"));
		CreditAmt.sendKeys(prop.getProperty("CreditValue"));
		WebElement Interestshare=driver.findElement(By.id("interestRate"));
		Interestshare.sendKeys(prop.getProperty("Interestonshare"));
		WebElement ShareRegsavebtn=driver.findElement(By.xpath("//a[contains(@class,'mat-focus-indicator ml-3 btn-mw mat-raised-button mat-button-base mat-primary ng-star-inserted')]"));
		ShareRegsavebtn.click();
		TimeUnit.SECONDS.sleep(5);
		//Nomineedetail
		WebElement Nomineetab=driver.findElement(By.id("mat-tab-label-1-1"));
		Nomineetab.click();
		Thread.sleep(2000);
		WebElement NomineeNewbtn=driver.findElement(By.xpath("//span[text()=' New ']"));
		NomineeNewbtn.click();
		WebElement Nomineefirstname=driver.findElement(By.id("nomineeFirstName"));
		Nomineefirstname.sendKeys(prop.getProperty("Nomineefirstname"));
		Thread.sleep(1000);
		WebElement Nomineelastname=driver.findElement(By.id("nomineeLastName"));
		Nomineelastname.sendKeys(prop.getProperty("Nomineelastname"));
		WebElement Nominateddate=driver.findElement(By.id("nomineeDate"));
		Nominateddate.click();
		WebElement Nominatedate=driver.findElement(By.xpath("//table[contains(@class,'mat-calendar-table')]//tbody//tr//td//div[contains(text(),"+day+")]"));
		Nominatedate.click();Thread.sleep(1000);
		//nominee date of birth
		try {
			WebElement Nomineedateofbirth=driver.findElement(By.id("dob"));
			Nomineedateofbirth.click();
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
		} catch (Exception e) {
			System.out.println("unable to select the Member DOB");
			e.printStackTrace();
		}

		WebElement Nomineerelationshipdate=driver.findElement(By.id("relationshipValue"));
		Nomineerelationshipdate.click();
		WebElement Selectnominee=driver.findElement(By.xpath("//span[text()=' Father ']"));
		Selectnominee.click();
		WebElement Nomineesavebtn=driver.findElement(By.xpath("//span[text()=' Save ']"));
		Nomineesavebtn.click();
		TimeUnit.SECONDS.sleep(20);

		try {
			//Documents tab
			TimeUnit.SECONDS.sleep(2);
			Documenttab.click();
			Thread.sleep(1000);
			for (int i = 1; i <= 3; i++) {
				WebElement CoopAppselectDoc1 = driver.findElement(By.xpath("(//span[text()='Select'])[" + i + "]"));
				CoopAppselectDoc1.click();
				Thread.sleep(1000);
				// creating object of Robot class
				Robot rb = new Robot();
				// copying File path to Clipboard
				StringSelection str = new StringSelection("C:\\Users\\IT Galax20\\Documents\\New Text Document 1.txt");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
				Thread.sleep(1000);
				// press Contol+V for pasting
				rb.keyPress(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_V);
				Thread.sleep(1000);
				// release Contol+V for pasting
				rb.keyRelease(KeyEvent.VK_CONTROL);
				rb.keyRelease(KeyEvent.VK_V);
				Thread.sleep(1000);
				// for pressing and releasing Enter
				rb.keyPress(KeyEvent.VK_ENTER);
				rb.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Upload'])"))).click();
				TimeUnit.SECONDS.sleep(3);
			} 
		} catch (Exception e) {
			System.out.println("Error:477: Failed to upload the documents");
		}
		//Notestab
				Notestab.click();
				Newnotesbtn.click();
				Status.click();Thread.sleep(1000);
				pendingverfy1.click();
				comments.sendKeys("Approved and verified");
				savenotes.click();
				TimeUnit.SECONDS.sleep(30);

		//Historytab
		Historytab.click();
		String Loginid;
		TimeUnit.SECONDS.sleep(10);
		String AssgnOfficername = AssignedToofficer.getText();
		System.out.println(AssgnOfficername);
		String Verificationofficerlogin = "";
		if (AssgnOfficername.contains("Member Officer")) {
			Verificationofficerlogin = "Memofficer";
		} else if (AssgnOfficername.contains("coop ver1")) {
			Verificationofficerlogin = "CV1";
		} else if (AssgnOfficername.contains("Super Admin")) {
			Verificationofficerlogin = "Superadmin";
		} else if (AssgnOfficername.contains("Paul Claude")) {
			Verificationofficerlogin = "pclaude";
		}else if (AssgnOfficername.contains("Jack Philip")) {
			Verificationofficerlogin = "jnphilip";
		}


		System.out.println("Member First verification officer Loginid:" + Verificationofficerlogin);
		Loginid = Verificationofficerlogin;
		//Logout 
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='cimslogoutbtn']"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Yes']"))).click();
		TimeUnit.SECONDS.sleep(2);


		///*****************Verification officer 1 login**************************///
		username.sendKeys(Loginid);
		password.sendKeys("password");
		loginButton.click();
		TimeUnit.SECONDS.sleep(3);

		try {
			String ScreenName = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ml-2 screenName']")))
					.getText();
			System.out.println("Displayed screen Name :" + ScreenName);
			if (ScreenName.contains(" Member Application Search ")) {
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[1]")))
				.click();
				TimeUnit.SECONDS.sleep(2);
			} else {
				TimeUnit.SECONDS.sleep(2);
				Cimsmenu.click();Thread.sleep(1000);
				MemberMenu.click();Thread.sleep(1000);
				membersearch.click();
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[1]")))
				.click();
				TimeUnit.SECONDS.sleep(5);
			} 
		} catch (Exception e) {
			System.out.println("Unable to select the Cooperative search from CimsMenu");
		}

		//checklist tab
		checklisttab.click();Thread.sleep(1000);
		for(int i=1; i<=5; i=i+2){ 
			WebElement Checklist=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//mat-checkbox//label[@class='mat-checkbox-layout'])["+i+"]")));
			Checklist.click();
			Thread.sleep(2000);
		}
		//Notestab
		Notestab.click();
		Newnotesbtn.click();
		Status.click();Thread.sleep(1000);
		pendingverfy2.click();
		comments.sendKeys("Approved and verified");
		savenotes.click();
		TimeUnit.SECONDS.sleep(15);
		//History tab
		Historytab.click();
		String Loginid1;
		String AssgnOfficername1 = AssignedToofficer.getText();
		System.out.println(AssgnOfficername1);
		String Verificationofficerlogin1 = "";
		if (AssgnOfficername.contains("Paul Claude")) {
			Verificationofficerlogin1 = "pclaude";
		} else if (AssgnOfficername1.contains("Rodney David")) {
			Verificationofficerlogin1 = "mkehma";
		}else if (AssgnOfficername1.contains("Member Officer")) {
			Verificationofficerlogin1 = "Memofficer";
		}else if (AssgnOfficername1.contains("clentine Ronson")) {
			Verificationofficerlogin1 = "cronson";
		}else if (AssgnOfficername1.contains("Rodney David")) {
			Verificationofficerlogin1 = "davidr";
		}

		System.out.println("Cooperative second verification officer Loginid:"+Verificationofficerlogin1);
		Loginid1 = Verificationofficerlogin1;
		System.out.println("Cooperation Application Pending verification 2");
		//Logout 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='cimslogoutbtn']"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Yes']"))).click();
		TimeUnit.SECONDS.sleep(3);



		//***********************verification officer 2 *************************//
		username.sendKeys(Loginid1);
		password.sendKeys("password");
		loginButton.click();
		TimeUnit.SECONDS.sleep(3);
		try {
			String ScreenName = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ml-2 screenName']")))
					.getText();
			System.out.println("Displayed screen Name :" + ScreenName);
			if (ScreenName.contains(" Member Application Search ")) {
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[1]")))
				.click();
				TimeUnit.SECONDS.sleep(2);
			} else {
				TimeUnit.SECONDS.sleep(2);
				Cimsmenu.click();Thread.sleep(2000);
				MemberMenu.click();Thread.sleep(1000);
				membersearch.click();
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[1]")))
				.click();
				TimeUnit.SECONDS.sleep(5);
			} 
		} catch (Exception e) {
			System.out.println("Unable to select the Cooperative search from CimsMenu");
		}
		//checklist tab
		checklisttab.click();
		Thread.sleep(1000);
		for(int i=2; i<=6; i=i+2){ 
			WebElement Checklist=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//mat-checkbox//label[@class='mat-checkbox-layout'])["+i+"]")));
			Checklist.click();
			Thread.sleep(2000);
		}
			//Notestab
			Notestab.click();Thread.sleep(1000);
			Newnotesbtn.click();Thread.sleep(1000);
			Status.click();Thread.sleep(1000);
			pendingapproval.click();Thread.sleep(1000);
			comments.sendKeys("Approved and verified");Thread.sleep(1000);
			savenotes.click();
			TimeUnit.SECONDS.sleep(15);
			//History tab
			Historytab.click();
			String Loginid2;
			TimeUnit.SECONDS.sleep(10);
			String AssgnOfficername2 = AssignedToofficer.getText();
			System.out.println(AssgnOfficername2);
			String Verificationofficerlogin2 = "";
			if (AssgnOfficername2.contains("Jimmy Alick")) {
				Verificationofficerlogin2 = "jalick";
			} else if (AssgnOfficername2.contains("Member Officer")) {
				Verificationofficerlogin2 = "Memofficer";
			}else if (AssgnOfficername2.contains("clentine Ronson")) {
				Verificationofficerlogin2 = "cronson";
			}else if (AssgnOfficername2.contains("Paul Claude")) {
				Verificationofficerlogin2 = "pclaude";
			}else if (AssgnOfficername2.contains("Joe Iauko")) {
				Verificationofficerlogin2 = "jiauko";
			}else if (AssgnOfficername2.contains("Binson Henry")) {
				Verificationofficerlogin2 = "bhenry";
			}else if (AssgnOfficername2.contains("Leintz Vusilai")) {
				Verificationofficerlogin2 = "lvusilai";
			}else if (AssgnOfficername2.contains("coop app")) {
				Verificationofficerlogin2 = "CA";
			}else if (AssgnOfficername2.contains("Jack Philip")) {
				Verificationofficerlogin2 = "jnphilip";
			}
			System.out.println("Cooperative second verification officer Loginid:"+Verificationofficerlogin2);
			Loginid2 = Verificationofficerlogin2;
			System.out.println("Cooperation Application Pending verification 2");
			//Logout
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='cimslogoutbtn']"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Yes']"))).click();
			TimeUnit.SECONDS.sleep(3);
			
			
			////****************************Approval officer*****************///////
			username.sendKeys(Loginid2);
			password.sendKeys("password");
			loginButton.click();
			TimeUnit.SECONDS.sleep(3);
			try {
				String ScreenName = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ml-2 screenName']")))
						.getText();
				System.out.println("Displayed screen Name :" + ScreenName);
				if (ScreenName.contains(" Member Application Search ")) {
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[1]")))
					.click();
					TimeUnit.SECONDS.sleep(2);
				} else {
					TimeUnit.SECONDS.sleep(2);
					Cimsmenu.click();Thread.sleep(2000);
					MemberMenu.click();Thread.sleep(1000);
					membersearch.click();
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[1]")))
					.click();
					TimeUnit.SECONDS.sleep(5);
				} 
			} catch (Exception e) {
				System.out.println("Unable to select the Cooperative search from CimsMenu");
			}

			//Notestab
			try {
				Notestab.click();
				Newnotesbtn.click();Thread.sleep(1000);
				Status.click();Thread.sleep(1000);
				approved.click();
				comments.sendKeys("Approved and verified");
				savenotes.click();
				TimeUnit.SECONDS.sleep(15);
			} catch (InterruptedException e) {
				System.out.println("Interuption in Approval notes ");
				e.printStackTrace();
			}


		}
	}

