package Appmodule.cims;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MemberchangeinDetailPage1 extends Base.cims.TestBase {

	public MemberchangeinDetailPage1() {
		PageFactory.initElements(driver, this);
	}
	@SuppressWarnings("deprecation")
	WebDriverWait wait = new WebDriverWait(driver,30);
	@FindBy(id = "userName")
	WebElement username;
	@FindBy(id = "userPassword")
	WebElement password;
	@FindBy(xpath = "//span[text()='LOGIN']")
	WebElement loginButton;
	Actions action= new Actions(driver);

	@FindBy(xpath="//div[@class='ml-2 screenName']")
	WebElement ScreenName;
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[1]")
	WebElement Cimsmenu;
	@FindBy(xpath="//li[@appmenuaccess='MemberMainDiv']//a")
	WebElement Membermenu;
	@FindBy(xpath="//app-menu-item[@routerlink='/home/member']//li")
	WebElement approvedmembersearch;
	@FindBy(xpath="//app-menu-item[@routerlink='/home/member-Application']//li")
	WebElement membersearch;
	@FindBy(xpath="//app-menu-item[@appmenuaccess='MemberChangeinDiv']//li")
	WebElement memberchangeindetail;


	@FindBy(xpath="//tbody/tr[1]/td[1]")
	WebElement Membershipnumber;
	@FindBy(xpath="//tbody/tr[1]/td[6]")
	WebElement cooperativenumber;
	@FindBy(xpath="(//small[contains(text(),'mandatory')])[1]")
	WebElement mandatory;
	//Member info tab 
	@FindBy(xpath="//input[@id='cooperativeRegNo']")
	WebElement Coopregno;
	@FindBy(xpath="//app-input-control[@label='Cooperative Reg No']//div//div//div//a[@mattooltip='Search']")
	WebElement coopregnosearch;
	//Member info -tab xpath
	@FindBy(xpath="//input[@id='membershipNo']")
	WebElement memno;
	@FindBy(xpath="//app-input-control[@label='Membership No']//div//div//div//a[@mattooltip='Search']")
	WebElement memnosearch;
	@FindBy(xpath="//input[@id='firstName']")
	WebElement memberfirstname;
	@FindBy(xpath="//input[@id='contactNo']")
	WebElement Membercontactno;
	@FindBy(xpath="//a[@color='primary']")
	WebElement meminfosavebtn;
	//Checklist-tab xpath
	@FindBy(xpath="//div[contains(text(),'Checklist')]")
	WebElement checklisttab;

	//Notes tab xpath
	@FindBy(xpath="//div[contains(text(),'Notes')]")
	WebElement Notestab;
	@FindBy(xpath="//span[normalize-space()='New']")
	WebElement NewNotes;
	@FindBy(xpath="//mat-select[@id='statusValue']")
	WebElement Status;
	@FindBy(xpath="//span[normalize-space()='Pending Verification 1']")
	WebElement Pendingverification1;
	@FindBy(xpath="//span[normalize-space()='Pending Approval']")
	WebElement pendingapproval;
	@FindBy(xpath="//span[normalize-space()='Approved']")
	WebElement approved;
	@FindBy(xpath="//textarea[@id='notes']")
	WebElement comments;
	@FindBy(xpath="//span[normalize-space()='Save']")
	WebElement savenotes;
	//History tab xpaths
	@FindBy(xpath="//div[contains(text(),'History')]")
	WebElement Historytab;
	@FindBy(xpath="//tbody//tr//td[1]")
	WebElement AssignedToOfficer;




	//Logout xpaths 
	@FindBy(xpath="//button[@id='cimslogoutbtn']")
	WebElement Logoutbtn;
	@FindBy(xpath="//div[@dir='ltr']//button[2]")
	WebElement confrmlogout;



	public void Memberchangeindetail() throws InterruptedException {
		username.sendKeys("superadmin");
		password.sendKeys("password");
		loginButton.click();Thread.sleep(2000);
		try {
			String	Actualscreenname=ScreenName.getText();
			if (Actualscreenname.contains(" Member Search ")) {
				System.out.println("default landing page: "+Actualscreenname);
				TimeUnit.SECONDS.sleep(2);
			} else {
				TimeUnit.SECONDS.sleep(2);
				Cimsmenu.click();
				Membermenu.click();
				approvedmembersearch.click();TimeUnit.SECONDS.sleep(10);
			} Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		String membershipno=Membershipnumber.getText();
		String cooperativeno=cooperativenumber.getText();
		//Redirect to the change in detail page
		try {
			Cimsmenu.click();Thread.sleep(1000);
			Membermenu.click();
			memberchangeindetail.click();Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Redirection to the member change in detail page failed");
			e.printStackTrace();
		}TimeUnit.SECONDS.sleep(2);
		//changes in Member info-tab 
		meminfosavebtn.click();Thread.sleep(1000);
		if(mandatory.isDisplayed()) {
	try {
		System.out.println("Mandatory error message displayed");
			Coopregno.sendKeys(cooperativeno);coopregnosearch.click();Thread.sleep(2000);
			memno.sendKeys(membershipno);memnosearch.click();Thread.sleep(2000);
			memberfirstname.clear();Thread.sleep(1000);
			memberfirstname.sendKeys(prop.getProperty("MemberFirstname"));
			Membercontactno.clear();Thread.sleep(1000);
			Membercontactno.sendKeys(prop.getProperty("change_contact_no"));
			meminfosavebtn.click();
		} catch (InterruptedException e) {
			System.out.println("Member info-change error");
			e.printStackTrace();
		}
	}
		else {
			System.out.println("Mandatory error message not displayed");
		}
		TimeUnit.SECONDS.sleep(30);
		//Notes tab pending verification 
		try {
			Notestab.click();Thread.sleep(1000);
			NewNotes.click();Thread.sleep(2000);
			Status.click();Thread.sleep(1000);
			Pendingverification1.click();Thread.sleep(1000);
			comments.sendKeys("Verified and status changed");
			savenotes.click();TimeUnit.SECONDS.sleep(7);
		} catch (InterruptedException e) {
			System.out.println("Notes-tab error");
			e.printStackTrace();
		}
		//History tab-Assigned Officer
		Historytab.click();
		String Loginid;
		TimeUnit.SECONDS.sleep(10);
		String AssgnOfficername = AssignedToOfficer.getText();
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
		Loginid = Verificationofficerlogin;Thread.sleep(1000);
		//Logout 
		Logoutbtn.click();Thread.sleep(1000);
		confrmlogout.click();
		Thread.sleep(2000);
		//*******************Verification officer login 1******************//
		username.sendKeys(Loginid);
		password.sendKeys("password");
		loginButton.click();
		TimeUnit.SECONDS.sleep(5);
		try {
			
			Thread.sleep(2000);
			String	Actualscreenname=ScreenName.getText();
			if (Actualscreenname.contains(" Member Application Search ")) {
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[1]")))
				.click();
				TimeUnit.SECONDS.sleep(2);
			} else {
				TimeUnit.SECONDS.sleep(2);
				Cimsmenu.click();Thread.sleep(1000);
				Membermenu.click();Thread.sleep(2000);
				membersearch.click();Thread.sleep(1000);
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
		for(int i=1; i<=3; i++){ 
			WebElement Checklist=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//mat-checkbox//label[@class='mat-checkbox-layout'])["+i+"]")));
			Checklist.click();
			Thread.sleep(2000);		
		}
		//Notes tab pending verification 
				try {
					Notestab.click();Thread.sleep(1000);
					NewNotes.click();Thread.sleep(1000);
					Status.click();Thread.sleep(1000);
					pendingapproval.click();Thread.sleep(1000);
					comments.sendKeys("Verified and status changed");
					savenotes.click();TimeUnit.SECONDS.sleep(7);
				} catch (InterruptedException e) {
					System.out.println("Notes-tab error");
					e.printStackTrace();
				}
				//History tab
				Historytab.click();
				String Loginid1;
				String AssgnOfficername1 = AssignedToOfficer.getText();
				System.out.println(AssgnOfficername1);
				String Verificationofficerlogin1 = "";
				if (AssgnOfficername1.contains("Jimmy Alick")) {
					Verificationofficerlogin1 = "jalick";
				} else if (AssgnOfficername1.contains("Member Officer")) {
					Verificationofficerlogin1 = "Memofficer";
				}else if (AssgnOfficername1.contains("clentine Ronson")) {
					Verificationofficerlogin1 = "cronson";
				}else if (AssgnOfficername1.contains("Paul Claude")) {
					Verificationofficerlogin1 = "pclaude";
				}else if (AssgnOfficername1.contains("Joe Iauko")) {
					Verificationofficerlogin1 = "jiauko";
				}else if (AssgnOfficername1.contains("Binson Henry")) {
					Verificationofficerlogin1 = "bhenry";
				}else if (AssgnOfficername1.contains("Leintz Vusilai")) {
					Verificationofficerlogin1 = "lvusilai";
				}else if (AssgnOfficername1.contains("coop app")) {
					Verificationofficerlogin1 = "CA";
				}else if (AssgnOfficername1.contains("Jack Philip")) {
					Verificationofficerlogin1 = "jnphilip";
				}
				System.out.println("Cooperative second verification officer Loginid:"+Verificationofficerlogin1);
				Loginid1 = Verificationofficerlogin1;Thread.sleep(1000);
				//Logout 
				Logoutbtn.click();Thread.sleep(1000);
				confrmlogout.click();
				Thread.sleep(2000);
			//******************Approval officer login**************///	
				username.sendKeys(Loginid1);
				password.sendKeys("password");
				loginButton.click();
				TimeUnit.SECONDS.sleep(3);
				try {
					String	Actualscreenname=ScreenName.getText();
					if (Actualscreenname.contains(" Member Application Search ")) {
						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[1]")))
						.click();
						TimeUnit.SECONDS.sleep(2);
					} else {
						TimeUnit.SECONDS.sleep(2);
						Cimsmenu.click();Thread.sleep(1000);
						Membermenu.click();Thread.sleep(2000);
						membersearch.click();
						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[1]")))
						.click();
						TimeUnit.SECONDS.sleep(5);
					} 
				} catch (Exception e) {
					System.out.println("Unable to select the Cooperative search from CimsMenu");
				}
				//Notes-tab
				try {
					Notestab.click();Thread.sleep(1000);
					NewNotes.click();Thread.sleep(1000);
					Status.click();Thread.sleep(1000);
					approved.click();Thread.sleep(1000);
					comments.sendKeys("Verified and status changed");
					savenotes.click();TimeUnit.SECONDS.sleep(7);
				} catch (InterruptedException e) {
					System.out.println("Notes-tab error");
					e.printStackTrace();
				}
				

	}












}