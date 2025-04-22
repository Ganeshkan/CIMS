package Appmodule.cims;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Officevisitdetailpage extends LoginPage{

	public Officevisitdetailpage() {
		PageFactory.initElements(driver, this);
	}


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
		//officevisit-xpath
		@FindBy(xpath="//div[@class='ml-2 screenName']")
		WebElement ScreenName;
		@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[1]")
		WebElement Cimsmenu;
		@FindBy(xpath="//a[normalize-space()='Office Administration']")
		WebElement officeadministration;
		@FindBy(xpath="(//li[@class='menu-item'][normalize-space()='New'])[2]")
		WebElement Newofficevisit;
		@FindBy(xpath="(//li[@class='menu-item'][normalize-space()='Search'])[2]")
		WebElement officevisitsearch;
		//office visit -search
		@FindBy(xpath="(//span[@class='placeholder'])[1]")
		WebElement officevisitsearchpanel;
		@FindBy(xpath="(//input[@id='istrVisitRefNo'])[1]")
		WebElement visitrefno;
		@FindBy(xpath="//button[@id='bpsearchbtn']//span//div//div[contains(text(),'Search')]")
		WebElement searchbtn;
		@FindBy(xpath="//table[@class='mat-table w100']//tbody//tr//td[1]")
		WebElement select_officevisit;
		
	//office-visit info-xpath
		@FindBy(xpath="(//input[@id='cooperativeRegNo'])[1]")
		WebElement coopRegNo;
		@FindBy(xpath="(//a[@mattooltip='Search'])[1]")
		WebElement coopregnosearch;
		@FindBy(xpath="(//input[@id='memberNo'])[1]")
		WebElement membershipno;
		@FindBy(xpath="(//a[@mattooltip='Search'])[2]")
		WebElement memshipnosearch;
		@FindBy(xpath="(//textarea[@id='purposeDescription'])[1]")
		WebElement visitordescription;
		@FindBy(xpath="(//input[@id='visitorName'])[1]")
		WebElement visitorname;
		@FindBy(xpath="//mat-select[@id='visitorTypeValue']//div//div//div")
		WebElement visitortype;
		@FindBy(xpath="(//div[@id='visitorTypeValue-panel'])[1]")
		WebElement visitorTypeValue;
		@FindBy(xpath="//mat-select[@id='provinceValue']//div//div//div")
		WebElement visitorprovince;
		@FindBy(xpath="(//div[@id='provinceValue-panel'])[1]")
		WebElement provinceValue;
		@FindBy(xpath="//mat-select[@id='purposeTypeValue']//div//div//div")
		WebElement purposeType;
		@FindBy(xpath="(//div[@id='purposeTypeValue-panel'])[1]")
		WebElement purposeTypeValue;
		@FindBy(xpath="//mat-select[@id='branchValue']//div//div//div")
		WebElement branchValue;
		@FindBy(xpath="(//div[@id='branchValue-panel'])[1]")
		WebElement branchValuelist;
		@FindBy(xpath="//mat-select[@id='teamValue']//div//div//div")
		WebElement designation;
		@FindBy(xpath="(//div[@id='teamValue-panel'])[1]")
		WebElement teamValue;
		@FindBy(xpath="//mat-select[@id='officerToMeet']//div//div//div")
		WebElement officerToMeet;
		@FindBy(xpath="(//div[@id='officerToMeet-panel'])[1]")
		WebElement officerToMeetvalue;
		@FindBy(xpath="(//span[normalize-space()='Save'])[1]")
		WebElement officevisitinfosavebtn;
		
		@FindBy(xpath="(//div[contains(text(),'Notes')])[1]")
		WebElement Notestab;
		@FindBy(xpath="(//span[normalize-space()='New'])[1]")
		WebElement Newnotes;
		@FindBy(xpath="//mat-select[@id='statusValue']//div//div//div")
		WebElement status;
		@FindBy(xpath="//span[normalize-space()='Closed']")
		WebElement statusclosed;
		@FindBy(xpath="(//textarea[@id='notes'])[1]")
		WebElement comments;
		@FindBy(xpath="//span[normalize-space()='Save']")
		WebElement savenotesbtn;
		
		
		
		
		
		
	public void createofficevisit() throws InterruptedException {

		 //Business creation officer login
		username.sendKeys("superadmin");
		password.sendKeys("password");
		loginButton.click();
		Thread.sleep(1000);
		TimeUnit.SECONDS.sleep(2);
		try {
			//Redirect to the New-Business plan page
			String Actualscreenname = ScreenName.getText();
			if (Actualscreenname.contains(" Office Visit Detail ")) {
				System.out.println("Landing page :" + Actualscreenname);
			} else {
				Thread.sleep(2000);
				Cimsmenu.click();
				Thread.sleep(1000);
				officeadministration.click();
				Thread.sleep(1000);
				Newofficevisit.click();
				Thread.sleep(1000);
			} 
		} catch (Exception e) {
			System.out.println("unable to redirect to the New officeVisit screen");
		}TimeUnit.SECONDS.sleep(2);
		//Office visit-info
		coopRegNo.sendKeys(prop.getProperty("coopregno"));Thread.sleep(1000);
		coopregnosearch.click();Thread.sleep(2000);
		membershipno.sendKeys(prop.getProperty("memberno"));Thread.sleep(1000);
		memshipnosearch.click();Thread.sleep(2000);
		visitordescription.sendKeys(Description_values());Thread.sleep(1000);
		visitorname.sendKeys(Alphabetic_Values());Thread.sleep(1000);
		visitortype.click();visitorTypeValue.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);Thread.sleep(1000);
		visitorprovince.click();provinceValue.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);Thread.sleep(1000);
		purposeType.click();purposeTypeValue.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);Thread.sleep(1000);
		branchValue.click();branchValuelist.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);Thread.sleep(1000);
		designation.click();teamValue.sendKeys(Keys.ENTER);Thread.sleep(1000);
		officerToMeet.click();officerToMeetvalue.sendKeys(Keys.ENTER);
		officevisitinfosavebtn.click();TimeUnit.SECONDS.sleep(20);
		//Notes-tab
		Notestab.click();Thread.sleep(1000);
		Newnotes.click();Thread.sleep(1000);
		status.click();Thread.sleep(1000);
		statusclosed.click();
		comments.sendKeys(Description_values());Thread.sleep(1000);
		savenotesbtn.click();TimeUnit.SECONDS.sleep(2);
	}

}
