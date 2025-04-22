package Appmodule.cims;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.cims.TestUtil;

public class CooperativeAppDetailPage extends Base.cims.TestBase{



	public CooperativeAppDetailPage() {
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
	@FindBy(xpath="//li[@appmenuaccess='CooperativeMainDiv']")
	WebElement coopmenu;
	@FindBy(xpath = "//li[text()='Search']")
	WebElement coopsearch;
	
	@FindBy(xpath="//input[@id='cooperativeName']")
	WebElement CoopName;
	@FindBy(id="provinceValue")
	WebElement coopProvince;
	@FindBy(xpath="//span[contains(text(),' Sanma ')]")
	WebElement SelectProvinceDDL;
	@FindBy(xpath="//input[@id='startDate']")
	WebElement coopstartDate;
	@FindBy(id ="coopClassificationValue")
	WebElement classifDDL;
	@FindBy(xpath="//span[contains(text(),' Primary ')]")
	WebElement selectclassifDDLvalue;
	@FindBy(id="coopTypeValue")
	WebElement cooperativeType;
	@FindBy(xpath="//span[contains(text(),' Housing ')]")
	WebElement SelectcooperativeType;
	@FindBy(id="coopSubTypeValue")
	WebElement cooperativeSubType;
	@FindBy(xpath="(//span[contains(text(),'Housing')])[2]")
	WebElement selectcooperativeSubType;
	@FindBy(id="emailId")
	WebElement CooperativeemailID;
	@FindBy(id="phoneNo")
	WebElement Contactno;
	@FindBy(xpath="//span[contains(text(),'Edit')]")
	WebElement Editaddress;
	//Editaddresspopup
	@FindBy(id="addressTypeValue")
	WebElement Addresstype;  
	@FindBy(xpath="//span[contains(text(),' Permanent ')]")
	WebElement SelectAddressType;
	@FindBy(xpath="(//mat-select[@id=\"provinceValue\"])[2]")
	WebElement province;    
	@FindBy(xpath="//span[contains(text(),' Shefa ')]")
	WebElement selectprovince;
	@FindBy(id="line1")
	WebElement AddrLine1;
	@FindBy(id="islandValue")
	WebElement island;    
	@FindBy(xpath="//span[contains(text(),' Ifira ')]")
	WebElement selectisland;
	@FindBy(xpath ="(//span[contains(text(),'Ifira')])")
	WebElement Areacouncil; 
	@FindBy(xpath="(//span[contains(text(),'Ifira')])[2]")
	WebElement selectAreacouncil;
	@FindBy(id="villageValue")
	WebElement village;    
	@FindBy(xpath="//span[contains(text(),' Ifira')]")
	WebElement selectvillage;
	@FindBy(xpath="(//span[contains(text(),' Save ')])[2]")
	WebElement SaveAddress;
	@FindBy(xpath="(//span[contains(text(),' Save ')])")
	WebElement CooperativeinfoSaveBtn;
	WebElement waittoLoad;
	// Other detail tab 
	@FindBy(xpath="//div[text() = 'Other Details']")
	WebElement OtherdetailTab;
	@FindBy(xpath="//span[text()=' New ']")
	WebElement BusinessActivityNewBtn;
	@FindBy(xpath= "(//table[@class='mat-table w100']//tr//td)[6]")
	WebElement BusinessTypechk1;
	
	@FindBy(xpath="//span[text()= ' Save ']")
	WebElement BusinessActivitySavebtn;
	@FindBy(xpath="//div[text() = 'Members']")
	WebElement Memberstab;
	@FindBy(xpath="//span[text()=' New ']")
	WebElement MemberNewBtn;
	@FindBy(id="membershipNo")
	WebElement MembershipNumber;
	@FindBy(id="firstName")
	WebElement MemberFirstName;
	@FindBy(id="lastName")
	WebElement MemberLastName;
	@FindBy(id="dateOfBirth")
	WebElement MemberDOB;
	@FindBy(xpath = "//div[text()= 'Other Details']")
	WebElement Clickotherdetailtab;
	@FindBy(xpath = "//div[contains(@class, 'f14 f-link ml-2')]")
	WebElement CoopAppNumber;
	@FindBy(xpath = "//div[text()= 'Notes']")
	WebElement CoopAppNotestab;
	@FindBy(xpath = "//span[text()= ' New ']")
	WebElement CoopNotesNewBtn;
	@FindBy(xpath = "//span[text() = 'Pending Registration']")
	WebElement SelectNoteStatus;
	@FindBy(xpath = "//span[text()= ' Pending Verification 1 ']")
	WebElement SelectstatusPV1;
	@FindBy(xpath = "//span[text()= ' Pending Verification 2 ']")
	WebElement SelectstatusPV2;

	@FindBy(xpath = "//textarea[contains(@id, 'notes')]")
	WebElement NotesComment;
	@FindBy(xpath = "//span[text()= ' Save ']")
	WebElement CoopNotesSaveBtn;
	@FindBy(xpath = "//div[text()= 'History']")
	WebElement CoopHistorytab;
	@FindBy(xpath = "//tbody/tr[1]/td[1]")
	WebElement AssignedToofficer;

	@SuppressWarnings("deprecation")
	WebDriverWait wait = new WebDriverWait(driver,30);

	
	
	@SuppressWarnings("unused")
	public void Cooperativeinfo() throws InterruptedException, AWTException {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.ImplicitWait));
			CoopName.sendKeys(Alphabetic_Values());
			Thread.sleep(1000);
			coopProvince.click();
			SelectProvinceDDL.click();
			Thread.sleep(1000);
			coopstartDate.click();
			driver.findElement(By.xpath(
					"//div[@class = 'mat-calendar-body-cell-content mat-focus-indicator mat-calendar-body-today']"))
					.click();
			classifDDL.click();
			selectclassifDDLvalue.click();
			cooperativeType.click();
			SelectcooperativeType.click();
			cooperativeSubType.click();
			Thread.sleep(1000);
			selectcooperativeSubType.click();
			CooperativeemailID.sendKeys(prop.getProperty("ContactEmailID"));
			Contactno.sendKeys(Numeric_values());
			Editaddress.click();
			Thread.sleep(2000);
			Addresstype.click();
			SelectAddressType.click();
			province.click();
			selectprovince.click();
			AddrLine1.sendKeys(prop.getProperty("AddressLine1"));
			Thread.sleep(1000);
			island.click();
			selectisland.click();
			Thread.sleep(1000);
			SaveAddress.click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(CooperativeinfoSaveBtn)).click();
		} catch (Exception e) {
			System.out.println("Error: Something went wrong.194");
		}
		try {
			/**********************************************************other details tab*************************************/
			//Other details tab
			TimeUnit.SECONDS.sleep(20);
			wait.until(ExpectedConditions.elementToBeClickable(OtherdetailTab)).click();
			BusinessActivityNewBtn.click();
		
			try {
				for (int i = 3; i < 21; i = i + 3) {
					wait.until(ExpectedConditions
							.elementToBeClickable(By.xpath("(//table[@class='mat-table w100']//tr//td)[" + i + "]")))
							.click();
				}
				BusinessActivitySavebtn.click();
				TimeUnit.SECONDS.sleep(2);
			} catch (Exception e) {
				System.out.println("Error: Unable to select Businesstype checkbox ");
			}
			Thread.sleep(1000);
			//Members tab
			TimeUnit.SECONDS.sleep(20);
			wait.until(ExpectedConditions.elementToBeClickable(Memberstab)).click();
			MemberNewBtn.click();
			Thread.sleep(1000);
			MembershipNumber.sendKeys(prop.getProperty("MembershipNum"));
			Thread.sleep(1000);
			MemberFirstName.sendKeys(Alphabetic_Values());
			Thread.sleep(1000);
			MemberLastName.sendKeys(Alphabetic_Values());
		} catch (Exception e) {
			System.out.println("Error: Something went wrong.227");
		}
		
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
			System.out.println("");
		}
		
		try {
			
			WebElement MemberGendervalue = driver.findElement(By.id("genderValue"));
			MemberGendervalue.click();
			WebElement SelectMemberGender = driver.findElement(By.xpath("//span[text()=' Male ']"));
			SelectMemberGender.click();
			WebElement MemberMaritalStatus = driver.findElement(By.id("maritalStatusValue"));
			MemberMaritalStatus.click();
			WebElement SelectMemberMaritalstatus = driver.findElement(By.xpath("//span[text()=' Single ']"));
			SelectMemberMaritalstatus.click();
			WebElement MemberDateofElection = driver.findElement(By.id("dateOfElection"));
			MemberDateofElection.click();
			driver.findElement(By.xpath(
					"//div[@class = 'mat-calendar-body-cell-content mat-focus-indicator mat-calendar-body-today']"))
					.click();
			WebElement MemberBirthRegNo = driver.findElement(By.id("birthRegNo"));
			MemberBirthRegNo.sendKeys(AlphaNumeric_values());
			WebElement MemberPassportno = driver.findElement(By.id("passportNo"));
			MemberPassportno.sendKeys(AlphaNumeric_values());
			WebElement MemberNationality = driver.findElement(By.id("nationalityValue"));
			MemberNationality.click();
			WebElement SelctMemberNationality = driver.findElement(By.xpath("//span[text()=' Vanuatu ']"));
			SelctMemberNationality.click();
			WebElement MemberEmailID = driver.findElement(By.id("emailId"));
			MemberEmailID.sendKeys(prop.getProperty("MemberMailID"));
			WebElement MemberContactNo = driver.findElement(By.id("contactNo"));
			MemberContactNo.sendKeys(Numeric_values());
			Thread.sleep(1000);
			WebElement MemberAddressEdit = driver.findElement(By.xpath("(//span[text()=' Edit '])[1]"));
			MemberAddressEdit.click();
			Thread.sleep(3000);
			WebElement MemberAddresstype = driver.findElement(By.id("addressTypeValue"));
			MemberAddresstype.click();
			driver.findElement(By.xpath("//span[text()=' Branch Office ']")).click();
			Thread.sleep(1000);
			WebElement MemberProvince = driver.findElement(By.id("provinceValue"));
			MemberProvince.click();
			WebElement SelectMemberProvince = driver.findElement(By.xpath("//span[text()=' Malampa ']"));
			SelectMemberProvince.click();
			WebElement MAddrssline1 = driver.findElement(By.id("line1"));
			MAddrssline1.sendKeys(prop.getProperty("MemberAddrssline1"));
			WebElement MemberIsland = driver.findElement(By.id("islandValue"));
			MemberIsland.click();
			WebElement SelectMemberIsland = driver.findElement(By.xpath("//span[text()=' Akhamb ']"));
			SelectMemberIsland.click();
			WebElement MemberAddresssavebtn = driver.findElement(By.xpath("(//span[text()=' Save '])[2]"));
			MemberAddresssavebtn.click();
			Thread.sleep(2000);
			WebElement MemberSavebtn = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()=' Save '])[1]")));
			MemberSavebtn.click();
		} catch (Exception e) {
			System.out.println("Error: Something went wrong.308");
		}
		
		
		try {
			//Otherdetailtab
			TimeUnit.SECONDS.sleep(20);
			wait.until(ExpectedConditions.elementToBeClickable(Clickotherdetailtab)).click();
		} catch (Exception e) {
			System.out.println("Error: Something went wrong.315");
		}
		try {
			//Share Register
			WebElement SharecountNewbtn = driver.findElement(By.xpath(
					"//button[contains(@class,'mat-focus-indicator btn-mw btn-tertiary mat-raised-button mat-button-base ng-star-inserted')]"));
			SharecountNewbtn.click();
			Thread.sleep(1000);
			WebElement Membersharecount = driver.findElement(By.id("shareCount"));
			Membersharecount.sendKeys(prop.getProperty("MShareCount"));
			WebElement MemberCreditAmt = driver.findElement(By.id("creditAmount"));
			MemberCreditAmt.sendKeys(prop.getProperty("MCreditValue"));
			WebElement MemberInterestshare = driver.findElement(By.id("interestRate"));
			MemberInterestshare.sendKeys(prop.getProperty("MInterestonshare"));
			WebElement MemberShareRegsavebtn = driver.findElement(By.xpath(
					"//a[contains(@class,'mat-focus-indicator ml-3 btn-mw mat-raised-button mat-button-base mat-primary ng-star-inserted')]"));
			MemberShareRegsavebtn.click();
		} catch (Exception e) {
			System.out.println("Error: Something went wrong.Code line: 333");
		}
		try {
			//Nomineedetail
			TimeUnit.SECONDS.sleep(20);
			WebElement MembNomineetab = driver.findElement(By.xpath("//div[text()= 'Nominee Details']"));
			MembNomineetab.click();
			WebElement MembNomineeNewbtn = driver.findElement(By.xpath("//span[text()= ' New ']"));
			MembNomineeNewbtn.click();
			Thread.sleep(1000);
			WebElement MembNomineefirstname = driver.findElement(By.id("nomineeFirstName"));
			MembNomineefirstname.sendKeys(prop.getProperty("MNomineeFirstName"));
			WebElement MembNomineelastname = driver.findElement(By.id("nomineeLastName"));
			MembNomineelastname.sendKeys(prop.getProperty("MNomineeLastName"));
			WebElement MembNomineeDOB = driver.findElement(By.id("dob"));
			MembNomineeDOB.click();
			WebElement SelectMembNomineeDOB = driver.findElement(By.xpath(
					"//div[@class = 'mat-calendar-body-cell-content mat-focus-indicator mat-calendar-body-today']"));
			SelectMembNomineeDOB.click();
			WebElement MembNomineeDate = driver.findElement(By.id("nomineeDate"));
			MembNomineeDate.click();
			WebElement SelectMembNomineeDate = driver.findElement(By.xpath(
					"//div[@class = 'mat-calendar-body-cell-content mat-focus-indicator mat-calendar-body-today']"));
			SelectMembNomineeDate.click();
			WebElement MembNomineeRelationship = driver.findElement(By.id("relationshipValue"));
			MembNomineeRelationship.click();
			Thread.sleep(1000);
			WebElement MembNomineeRelationshipDDL = driver.findElement(By.xpath("//span[text()= ' Son ']"));
			MembNomineeRelationshipDDL.click();
			WebElement MembNomineesavebtn = driver.findElement(By.xpath(
					"//a[contains(@class,'mat-focus-indicator ml-3 btn-mw mat-raised-button mat-button-base mat-primary ng-star-inserted')]"));
			MembNomineesavebtn.click();
			TimeUnit.SECONDS.sleep(20);
			//Redirection to coop application
			CoopAppNumber.click();
			TimeUnit.SECONDS.sleep(20);
			Clickotherdetailtab.click();
		} catch (Exception e) {
			System.out.println("Error: Something went wrong.Code line: 371");
		}
		try {
			//Commitee tab
			WebElement MembCommitteetab = driver.findElement(By.xpath("//div[text()= 'Committee']"));
			MembCommitteetab.click();
			WebElement MembCommitteeNewBtn = driver.findElement(By.xpath("//span[text()= ' New ']"));
			MembCommitteeNewBtn.click();
			Thread.sleep(1000);
			WebElement MembCommiteeCode = driver.findElement(By.id("committeeCode"));
			MembCommiteeCode.sendKeys(prop.getProperty("MCommitteeCode"));
			WebElement MembCommiteeName = driver.findElement(By.id("committeeName"));
			MembCommiteeName.sendKeys(prop.getProperty("MCommitteeName"));
			WebElement MembCommiteeStartDate = driver.findElement(By.id("startDate"));
			MembCommiteeStartDate.click();
			WebElement SelectCommitteeStartDate = driver.findElement(By.xpath(
					"//div[@class = 'mat-calendar-body-cell-content mat-focus-indicator mat-calendar-body-today']"));
			SelectCommitteeStartDate.click();
			WebElement MembCommiteeSaveBtn = driver.findElement(By.xpath("//span[text()= ' Save ']"));
			MembCommiteeSaveBtn.click();
		} catch (Exception e) {
			System.out.println("Error: Something went wrong. Code line:392");
		}
		try {
			//Committee Member tab
			TimeUnit.SECONDS.sleep(10);
			WebElement CommitteeMembertab = driver.findElement(By.xpath("//div[text()= 'Member']"));
			CommitteeMembertab.click();
			Thread.sleep(1000);
			WebElement CommitteeMembrNewBtn = driver.findElement(By.xpath("//span[text()= ' New ']"));
			CommitteeMembrNewBtn.click();
			Thread.sleep(1000);
			WebElement CommiteeMembershipNo = driver.findElement(By.id("membershipNo"));
			CommiteeMembershipNo.sendKeys(prop.getProperty("MembershipNum"));
			WebElement CommiteeMembershipNoSearch = driver.findElement(By.name("search-outline"));
			CommiteeMembershipNoSearch.click();
			WebElement CommiteeMemberPosition = driver.findElement(By.id("postValue"));
			CommiteeMemberPosition.click();
			WebElement SelectCommiteeMemberPosition = driver.findElement(By.xpath("//span[text()= ' Chairman ']"));
			SelectCommiteeMemberPosition.click();
			Thread.sleep(1000);
			WebElement CommiteeMemberSave = driver.findElement(By.xpath("//span[text()= ' Save ']"));
			CommiteeMemberSave.click();
		} catch (Exception e) {
			System.out.println("Error: Something went wrong.code line: 415");
		}
		try {
			//Committee BusinessActivity tab
			TimeUnit.SECONDS.sleep(5);
			WebElement CommitteeBusinessActivitytab = driver
					.findElement(By.xpath("//div[text()= 'Business Activity']"));
			CommitteeBusinessActivitytab.click();
			WebElement CommitteeBusinessActivityNew = driver.findElement(By.id("CooperativeAppCommBusNewBtn"));
			CommitteeBusinessActivityNew.click();
			Thread.sleep(2000);
			
				for (int i = 1; i < 5; i++) {
					wait.until(ExpectedConditions
							.elementToBeClickable(By.xpath("((//table[@class='mat-table w100'])[2]//tbody//td[@class='mat-cell text-center'])["+i+"]")))
							.click();
				}
			Thread.sleep(1000);
			WebElement CommitteeBusinessActivitySave = driver.findElement(By.id("committeesaveBus"));
			CommitteeBusinessActivitySave.click();
			TimeUnit.SECONDS.sleep(5);
			CoopAppNumber.click();
		} catch (Exception e) {
			System.out.println("Error:435: Exception in Committee Business Activity Tab ");
		}
		


		/**********************************Document tab************************************/		



		try {
			//Documents tab
			TimeUnit.SECONDS.sleep(5);
			WebElement CoopAppDocumentstab = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()= 'Documents']")));
			CoopAppDocumentstab.click();
			Thread.sleep(1000);
			for (int i = 1; i <= 12; i++) {
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
		



		/************************************Notes tab***************************************/

		try {
			TimeUnit.SECONDS.sleep(10);
			CoopAppNotestab.click();
			CoopNotesNewBtn.click();
			Thread.sleep(1000);
			SelectNoteStatus.click();
			SelectstatusPV1.click();
			Thread.sleep(1000);
			NotesComment.sendKeys(Description_values());
			Thread.sleep(1000);
			CoopNotesSaveBtn.click();
			Thread.sleep(1000);
			WebElement NotesStatus = driver.findElement(By.xpath("//div[contains(@class,'panel-body f14')]"));
			String statusvalue = NotesStatus.getText();
			System.out.println(statusvalue);
		} catch (Exception e) {
			System.out.println("Error:501: Something went wrong.");
		}
		


		/****************************History tab*******************************/		
		    
			TimeUnit.SECONDS.sleep(10);
			CoopHistorytab.click();
			String AssgnOfficername = AssignedToofficer.getText();
			System.out.println(AssgnOfficername);
			String Verificationofficerlogin = "";
			if (AssgnOfficername.contains("Jimmy Alick")) {
				Verificationofficerlogin = "jalick";
			} else if (AssgnOfficername.contains("Margret Kehma")) {
				Verificationofficerlogin = "mkehma";
			} else if (AssgnOfficername.contains("Super Admin")) {
				Verificationofficerlogin = "Superadmin";
			} else if (AssgnOfficername.contains("Paul Claude")) {
				Verificationofficerlogin = "pclaude";
			}else if (AssgnOfficername.contains("Jack Philip")) {
				Verificationofficerlogin = "jnphilip";
			}
			String Loginid = Verificationofficerlogin;
			System.out.println("Cooperative First verification officer Loginid:" + Verificationofficerlogin);
			//Logout 
			TimeUnit.SECONDS.sleep(2);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='cimslogoutbtn']"))).click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Yes']"))).click();
			TimeUnit.SECONDS.sleep(5);
	


		//***************Verification officer login 1*********************//

		username.sendKeys(Loginid);
		password.sendKeys("password");
		loginButton.click();
		
		
		TimeUnit.SECONDS.sleep(4);
		
		try {
			String ScreenName = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ml-2 screenName']")))
					.getText();
			System.out.println("Displayed screen Name :" + ScreenName);
			if (ScreenName.contains(" Cooperative Application Search ")) {
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//table[@class='mat-table w100']//tbody//tr//td[1]")))
						.click();
				TimeUnit.SECONDS.sleep(2);
			} else {
				TimeUnit.SECONDS.sleep(2);
				Cimsmenu.click();
				coopmenu.click();
				coopsearch.click();
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//table[@class='mat-table w100']//tbody//tr//td[1]")))
						.click();
			} 
		} catch (Exception e) {
			System.out.println("Unable to select the Cooperative search from CimsMenu");
		}
		
		//Verification officer 1 Checklist
		TimeUnit.SECONDS.sleep(10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Checklist']"))).click();
		TimeUnit.SECONDS.sleep(2);
		for(int i=1; i<=23; i=i+2){ 
			WebElement Checklist=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//mat-checkbox//label[@class='mat-checkbox-layout'])["+i+"]")));
			Checklist.click();
			Thread.sleep(2000);
		}
		//Notes tab
		CoopAppNotestab.click();
		CoopNotesNewBtn.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("statusValue"))).click();
		SelectstatusPV2.click();
		Thread.sleep(1000);
		NotesComment.sendKeys("Assigned to pending verification officer 2");
		Thread.sleep(1000);
		CoopNotesSaveBtn.click();
		Thread.sleep(1000);
		WebElement NotesStatus1 = driver.findElement(By.xpath("//div[contains(@class,'panel-body f14')]"));
		String statusvalue1 = NotesStatus1.getText();
		
		//History tab
		TimeUnit.SECONDS.sleep(10);
		CoopHistorytab.click();
		String AssgnOfficername1 = AssignedToofficer.getText();
		System.out.println(AssgnOfficername1);
		String Verificationofficerlogin2="";
		if(AssgnOfficername1.contains("Rodney David")){
			Verificationofficerlogin2= "davidr";
		}
		else if(AssgnOfficername1.contains("coop ver2")){
			Verificationofficerlogin2= "CV2";
		}else if(AssgnOfficername1.contains("Super Admin")) {
			Verificationofficerlogin2= "Superadmin";
		}else if(AssgnOfficername1.contains("Joe Iauko")) {
			Verificationofficerlogin2= "jiauko";
		}else if(AssgnOfficername1.contains("clentine Ronson")) {
			Verificationofficerlogin2="cronson";
		}
		
		System.out.println("Cooperative second verification officer Loginid:"+Verificationofficerlogin2);
		String Loginid1 = Verificationofficerlogin2;
		System.out.println("Cooperation Application Pending verification 2");
		//Logout 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='cimslogoutbtn']"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Yes']"))).click();
		TimeUnit.SECONDS.sleep(5);



		//****************************Verification officer login 2***************//

	
			username.sendKeys(Loginid1);
			password.sendKeys("password");
			loginButton.click();
			TimeUnit.SECONDS.sleep(3);
			
			try {
				String ScreenName = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ml-2 screenName']")))
						.getText();
				System.out.println("Displayed screen Name :" + ScreenName);
				if (ScreenName.contains(" Cooperative Application Search ")) {
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//table[@class='mat-table w100']//tbody//tr//td[1]")))
							.click();
					TimeUnit.SECONDS.sleep(2);
				} else {
					TimeUnit.SECONDS.sleep(2);
					Cimsmenu.click();
					coopmenu.click();
					coopsearch.click();
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//table[@class='mat-table w100']//tbody//tr//td[1]")))
							.click();
				} 
			} catch (Exception e) {
				System.out.println("Unable to select the Cooperative search from CimsMenu");
			}
			TimeUnit.SECONDS.sleep(5);
			
			try {
				//Payment tab
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Payments ']"))).click();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='receiptNo']")))
						.sendKeys("09892767");
				Thread.sleep(500);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='paidAmount']")))
						.sendKeys("500");
				Thread.sleep(500);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-select[@id='paidForValue']")))
						.click();
				Thread.sleep(500);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=' New Registration ']")))
						.click();
				Thread.sleep(500);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-select[@id='paidBranchValue']")))
						.click();
				Thread.sleep(500);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=' Head Quarter ']")))
						.click();
				Thread.sleep(500);
				WebElement paymentdate = driver.findElement(By.id("paymentDate"));
				paymentdate.click();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()=' 17 ']"))).click();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=' Save ']"))).click();
				TimeUnit.SECONDS.sleep(5);
				//Verification officer 2 Checklist
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Checklist']"))).click();
				TimeUnit.SECONDS.sleep(2);
				for (int i = 2; i <= 24; i = i + 2) {
					WebElement Checklist = wait.until(ExpectedConditions.elementToBeClickable(
							By.xpath("(//mat-checkbox//label[@class='mat-checkbox-layout'])[" + i + "]")));
					Checklist.click();
					Thread.sleep(2000);
				} 
			} catch (Exception e) {
				System.out.println("Error occured in payment tab, Second verification officer. ");
			}
			
			//Notes tab
			
			try {
				CoopAppNotestab.click();
				CoopNotesNewBtn.click();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(By.id("statusValue"))).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=' Pending Approval ']")))
						.click();
				Thread.sleep(1000);
				NotesComment.sendKeys("Assigned to pending Approval");
				Thread.sleep(1000);
				CoopNotesSaveBtn.click();
				Thread.sleep(1000);
				WebElement NotesStatus2 = driver.findElement(By.xpath("//div[contains(@class,'panel-body f14')]"));
				String statusvalue2 = NotesStatus2.getText();
			} catch (Exception e) {
				System.out.println("Error occured in Notes tab, Second verification officer.");
			}
			
		//History tab
		TimeUnit.SECONDS.sleep(10);
		CoopHistorytab.click();
		String AssgnOfficername2 = AssignedToofficer.getText();
		System.out.println(AssgnOfficername2);
		String Verificationofficerlogin3="";
		if(AssgnOfficername2.contains("coop app")){
			Verificationofficerlogin3= "CA";
		}else if(AssgnOfficername2.contains("Super Admin")) {
			Verificationofficerlogin3= "Superadmin";
		}else if(AssgnOfficername2.contains("Jack Philip")) {
			Verificationofficerlogin3= "jnphilip";
		}else if(AssgnOfficername2.contains("Leintz Vusilai")) {
			Verificationofficerlogin3= "lvusilai";
		}else if(AssgnOfficername2.contains("Binson Henry")) {
			Verificationofficerlogin3= "bhenry";
		}else if(AssgnOfficername2.contains("Joe Iauko")) {
			Verificationofficerlogin3= "jiauko";
		}else if(AssgnOfficername2.contains("Jimmy Alick")) {
			Verificationofficerlogin3= "jalick";
		}else if(AssgnOfficername2.contains("Eddie Woksen")) {
			Verificationofficerlogin3= "ewoksen";
		}else if(AssgnOfficername2.contains("clentine Ronson")) {
			Verificationofficerlogin3= "cronson";
		}else if(AssgnOfficername2.contains("Paul Claude")) {
			Verificationofficerlogin3= "pclaude";
		}
		System.out.println("Cooperative Approving Officer Login id:"+Verificationofficerlogin3);
		String Loginid2 = Verificationofficerlogin3;
		System.out.println("Cooperative Application Pending Approval");
		
		
		try {
			//Logout 
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='cimslogoutbtn']"))).click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Yes']"))).click();
			TimeUnit.SECONDS.sleep(5);
		} catch (Exception e) {
			System.out.println("Error: Something went wrong.code : 726");
		}
		

		//****************************PENDING APPROVAL OFFICER***************//

		try {
			username.sendKeys(Loginid2);
			password.sendKeys("password");
			loginButton.click();
			TimeUnit.SECONDS.sleep(2);
			try {
				String ScreenName = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ml-2 screenName']")))
						.getText();
				System.out.println("Displayed screen Name :" + ScreenName);
				if (ScreenName.contains(" Cooperative Application Search ")) {
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//table[@class='mat-table w100']//tbody//tr//td[1]")))
							.click();
					TimeUnit.SECONDS.sleep(2);
				} else {
					TimeUnit.SECONDS.sleep(2);
					Cimsmenu.click();
					coopmenu.click();
					coopsearch.click();
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//table[@class='mat-table w100']//tbody//tr//td[1]")))
							.click();
				} 
			} catch (Exception e) {
				System.out.println("Unable to select the Cooperative search from CimsMenu");
			}
			
			TimeUnit.SECONDS.sleep(5);
			//NOTES TAB
			CoopAppNotestab.click();
			CoopNotesNewBtn.click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("statusValue"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=' Approved ']"))).click();
			Thread.sleep(1000);
			NotesComment.sendKeys(" APPLICATION APPROVED");
			Thread.sleep(1000);
			CoopNotesSaveBtn.click();
			Thread.sleep(30);
			System.out.println("Cooperation Application Approved Successfully ");
		} catch (Exception e) {
			System.out.println("Error: Something went wrong.code : 767");
		}

	}


}
