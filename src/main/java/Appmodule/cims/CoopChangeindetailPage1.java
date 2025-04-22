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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoopChangeindetailPage1 extends Base.cims.TestBase{

	public CoopChangeindetailPage1() {
		PageFactory.initElements(driver, this);
	}
	Actions action =new Actions(driver);

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
	@FindBy(xpath="//li[text()=' Change in Detail']")
	WebElement coopchangeindetailmenu;
	@FindBy(xpath = "//li[text()='Search']")
	WebElement coopsearch;

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
	@FindBy(xpath="(//table[@class='mat-table w100']//tbody//tr//td[4])[1]")
	WebElement CoopAppNo;
	@FindBy(xpath="(//table[@class='mat-table w100']//tbody//tr//td[1])[1]")
	WebElement selectAppno;



	@FindBy(xpath="//input[@id='cooperativeRegNo']")
	WebElement coopapplicationno;
	@FindBy(xpath="(//div[@class='input-group-append d-flex in-1 ng-star-inserted'])[1]")
	WebElement coopapplicationnosearch;
	@FindBy(xpath="//input[@id='cooperativeName']")
	WebElement CooperativeName;
	@FindBy(xpath="//app-input-control[@name='cooperativeName']//a[@class='mat-focus-indicator mat-tooltip-trigger i-btn mat-button mat-button-base ng-star-inserted']")
	WebElement clearcoopname;
	@FindBy(id="provinceValue")
	WebElement cooperativeProvinceDDL;
	@FindBy(xpath="//span[contains(text(),' Penama ')]")
	WebElement SelectProvinceDDLvalue;

	@FindBy(xpath="//input[@id='startDate']")
	WebElement cooperativeinfostartDate;

	@FindBy(id ="coopClassificationValue")
	WebElement classificationDDL;@FindBy(xpath="//span[contains(text(),' Secondary ')]")
	WebElement selectclassificationDDLvalue;

	@FindBy(id="coopTypeValue")
	WebElement cooperativeTypeDDL;@FindBy(xpath="//span[contains(text(),' Transport ')]")
	WebElement SelectcooperativeTypeDDLvalue;

	@FindBy(id="coopSubTypeValue")
	WebElement cooperativeSubTypeDDL;

	@FindBy(id="emailId")
	WebElement CIDCooperativeemailid;

	@FindBy(id="phoneNo")
	WebElement changeindetailPhoneno;

	@FindBy(xpath="//span[contains(text(),' Edit')]")
	WebElement changeindetailEditaddress;

	//Editaddresspopup
	@FindBy(id="addressTypeValue")
	WebElement AddresstypeDDl;  @FindBy(xpath="//span[contains(text(),' Residential ')]")
	WebElement SelectAddressTypeDDLvalue;

	@FindBy(xpath="(//mat-select[@id=\"provinceValue\"])[2]")
	WebElement provinceValueDDl;    @FindBy(xpath="//span[contains(text(),' Shefa ')]")
	WebElement selectprovinceDDlvalue;

	@FindBy(id="islandValue")
	WebElement islandValueDDL;    @FindBy(xpath="//span[contains(text(),' Ifira ')]")
	WebElement selectislandValueDDLvalue;
	@FindBy(id="areaCouncilValue")
	WebElement AreacouncilDDL; @FindBy(xpath="//span[contains(text(),' Ifira ')]")
	WebElement selectAreacouncilDDLValue;

	@FindBy(id="villageValue")
	WebElement villageValueDDL;    @FindBy(xpath="//span[contains(text(),' Ifira')]")
	WebElement selectvillageValueDDLValue;
	@FindBy(xpath="(//span[contains(text(),' Save ')])[2]")
	WebElement SaveEditaddress;
	@FindBy(xpath="(//span[contains(text(),' Save ')])")
	WebElement Savebtn;
	@FindBy(xpath="//span[text()=' Update ']")
	WebElement Updatebtn;

	// Other detail tab 
	@FindBy(xpath ="//div[text()='Other Details']")
	WebElement othertab;
	@FindBy(xpath="//span[text()=' New ']")
	WebElement BusinessActivityNewButton;
	//Document tab
	@FindBy(xpath="//div[text()='Documents']")
	WebElement documenttab;
	@FindBy(xpath="//div[text()='Notes']")
	WebElement Notestab;//Notes
	@FindBy(xpath="//span[text()=' New ']")
	WebElement Newnotesbtn;
	@FindBy(xpath="//mat-select[@id='statusValue']")
	WebElement Status;
	@FindBy(xpath="//span[text()=' Pending Verification 1 ']")
	WebElement Pendingverfy1;
	@FindBy(xpath="//span[text()=' Pending Approval ']")
	WebElement Pendingapproval;
	@FindBy(xpath="//span[text()=' Approved ']")
	WebElement approved;
	@FindBy(xpath="//textarea[@id='notes']")
	WebElement comments;
	@FindBy(xpath="//span[text()=' Save ']")
	WebElement savenotes;
	@FindBy(xpath="//div[text()='Checklist']")
	WebElement Checklisttab;
	@FindBy(xpath="//div[text()='History']")
	WebElement Historytab;
	@FindBy(xpath = "//table[contains(@class, 'mat-table')]//tr[1]//td[1]")
	WebElement AssignedToofficer;

	@FindBy(xpath="//button[@id='cimslogoutbtn']")
	WebElement logout;
	@FindBy(xpath="//span[text()='Yes']")
	WebElement Confrmlogout;


	@SuppressWarnings("deprecation")
	WebDriverWait wait = new WebDriverWait(driver,30);

	public void CooperativeChangeInDetail() throws InterruptedException, AWTException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(util.cims.TestUtil.ImplicitWait));
		//login with the cooperative application officer
		username.sendKeys(prop.getProperty("cao_username"));
		password.sendKeys(prop.getProperty("CID_password"));
		loginButton.click();
		TimeUnit.SECONDS.sleep(2);
		//Navigate to cooperative application search 
		try {
			String ScreenName = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ml-2 screenName']")))
					.getText();
			System.out.println("Displayed screen Name :" + ScreenName);
			if (ScreenName.contentEquals(" Cooperative Application Search ")) {
				searchbox.click();Thread.sleep(1000);
				searchstatus.click();Thread.sleep(1000);
				searchstatusvalues.click();Thread.sleep(1000);
				searchbtn.click();Thread.sleep(1000);
				TimeUnit.SECONDS.sleep(2);
			} else {
				Cimsmenu.click();Thread.sleep(1000);
				coopmenu.click();Thread.sleep(1000);
				coopsearch.click();Thread.sleep(1000);
				TimeUnit.SECONDS.sleep(5);
				searchbox.click();Thread.sleep(1000);
				searchstatus.click();
				searchstatusvalues.click();
				searchbtn.click();Thread.sleep(1000);
			} 
		} catch (Exception e) {
			System.out.println("Unable to select menu from CimsMenu");
		}


		String CoopApplicationNo=CoopAppNo.getText();Thread.sleep(2000);
		System.out.println(CoopApplicationNo);
		//Navigate to cooperative change in detail 
		try {
			String ScreenName = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ml-2 screenName']")))
					.getText();
			System.out.println("Displayed screen Name :" + ScreenName);
			if (ScreenName.contains(" Cooperative Application Change In Detail ")) {
				coopchangeindetailmenu.click();
				TimeUnit.SECONDS.sleep(2);
			} else {
				Cimsmenu.click();
				coopmenu.click();
				coopchangeindetailmenu.click();
			} 
		} catch (Exception e) {
			System.out.println("Unable to select menu from CimsMenu");
		}



		TimeUnit.SECONDS.sleep(3);
		coopapplicationno.sendKeys(CoopApplicationNo);TimeUnit.SECONDS.sleep(1);
		coopapplicationnosearch.click();Thread.sleep(1000);

		clearcoopname.click();Thread.sleep(1000);
		CooperativeName.sendKeys(prop.getProperty("changeCooperativename"));
		changeindetailPhoneno.clear();changeindetailPhoneno.sendKeys(Numeric_values());
		Thread.sleep(1000);
		Savebtn.click();TimeUnit.MINUTES.sleep(1);
		othertab.click();Thread.sleep(1000);//others tab
		documenttab.click();Thread.sleep(1000);//Document tab
		try {
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
				TimeUnit.SECONDS.sleep(10);
			} 
		} catch (Exception e) {
			System.out.println("Unable to upload document");
		} 

		Notestab.click();//Notes Tab
		Newnotesbtn.click();Thread.sleep(1000);
		Status.click();
		Pendingverfy1.click();
		comments.sendKeys("Verified and Approved");
		savenotes.click();Thread.sleep(1000);

		String Loginid;
		TimeUnit.SECONDS.sleep(30);
		Historytab.click();
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

		System.out.println("Cooperative First verification officer Loginid:" + Verificationofficerlogin);
		Loginid = Verificationofficerlogin;
		//Logout 
		TimeUnit.SECONDS.sleep(2);
		logout.click();
		Thread.sleep(1000);
		Confrmlogout.click();
		TimeUnit.SECONDS.sleep(5);

		//First verification officer login 
		username.sendKeys(Loginid);
		password.sendKeys("password");
		loginButton.click();
		TimeUnit.SECONDS.sleep(10);
		try {
			String ScreenName = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ml-2 screenName']")))
					.getText();
			System.out.println("Displayed screen Name :" + ScreenName);
			if (ScreenName.contains(" Cooperative Application Search ")) {
				searchbox.click();Thread.sleep(1000);
				searchbycoopregno.sendKeys(CoopApplicationNo);
				searchbtn.click();Thread.sleep(1000);
				selectAppno.click();
				TimeUnit.SECONDS.sleep(10);
			} else {
				Cimsmenu.click();
				coopmenu.click();
				coopsearch.click();
				TimeUnit.SECONDS.sleep(10);
				searchbox.click();Thread.sleep(1000);
				searchbycoopregno.sendKeys(CoopApplicationNo);
				searchbtn.click();Thread.sleep(1000);
				selectAppno.click();
				TimeUnit.SECONDS.sleep(10);
			} 
		} catch (Exception e) {
			System.out.println("Unable to select menu from CimsMenu");
		}
		//Checklist 
		Checklisttab.click();Thread.sleep(1000);
		for (int i = 1; i <= 3; i ++) {
			WebElement Checklist = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("(//mat-checkbox//label[@class='mat-checkbox-layout'])[" + i + "]")));
			Checklist.click();
			Thread.sleep(2000);
		} 
		//Notes tab
		Notestab.click();
		Newnotesbtn.click();Thread.sleep(1000);
		Status.click();
		Pendingapproval.click();
		comments.sendKeys("Verified and Approved");
		savenotes.click();Thread.sleep(1000);

		TimeUnit.SECONDS.sleep(30);
		Historytab.click();
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
		//Logout 
		TimeUnit.SECONDS.sleep(2);
		logout.click();
		Thread.sleep(1000);
		Confrmlogout.click();
		TimeUnit.SECONDS.sleep(5);

	
		//Approval officer login
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
				searchbox.click();Thread.sleep(1000);
				searchbycoopregno.sendKeys(CoopApplicationNo);
				searchbtn.click();Thread.sleep(1000);
				selectAppno.click();
				TimeUnit.SECONDS.sleep(10);
			} else {
				Cimsmenu.click();
				coopmenu.click();
				coopsearch.click();
				TimeUnit.SECONDS.sleep(10);
				searchbox.click();Thread.sleep(1000);
				searchbycoopregno.sendKeys(CoopApplicationNo);
				searchbtn.click();Thread.sleep(1000);
				
			} 
		} catch (Exception e) {
			System.out.println("Unable to select menu from CimsMenu");
		}
		try {
			selectAppno.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		TimeUnit.SECONDS.sleep(10);
		//Notes tab
		Notestab.click();
		Newnotesbtn.click();Thread.sleep(1000);
		Status.click();
		approved.click();
		comments.sendKeys("Verified and Approved");
		savenotes.click();Thread.sleep(1000);

		System.out.println("Change in detail Approved successfully");




	} 

















}



















