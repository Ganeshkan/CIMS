package Appmodule.cims;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends Base.cims.TestBase{

	@FindBy(id = "userName")
	WebElement username;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(xpath = "//span[text()='LOGIN']")
	WebElement loginButton;
	
	@FindBy(xpath = "//p[contains(text(),'User not found or registered in the system.')]")
	WebElement wrongUsernameMessage;
	
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void loginAsSuperAdmin() throws InterruptedException {
		username.sendKeys(prop.getProperty("admin_username"));
		password.sendKeys(prop.getProperty("admin_password"));
		//loginButton.click();Thread.sleep(5000);
	}

	public void withoutUserNamePassword() {
		loginButton.click();
	}
	
	public boolean WrongUsername() {  //True ot False
		username.sendKeys(prop.getProperty("admin_wrongusername"));
		password.sendKeys(prop.getProperty("admin_password"));
		loginButton.click();
		return wrongUsernameMessage.isDisplayed();  //True ==> IDisplayed and False --> Element is not displayed
	}
	
	public void WrongPassword() {
		username.sendKeys(prop.getProperty("admin_username"));
		password.sendKeys(prop.getProperty("admin_wrongpassword"));
		loginButton.click();
		//return new UserSearchPage();	
	}


	public void Landingpage() {
		username.sendKeys(prop.getProperty("admin_name"));
		password.sendKeys(prop.getProperty("admin_password"));
		loginButton.click();
		
	}
	public void withoutLandingpage() {
		username.sendKeys(prop.getProperty("admin_name1"));
		password.sendKeys(prop.getProperty("admin_password"));
		loginButton.click();
		
	}
	public void ActiveRole() {
		username.sendKeys(prop.getProperty("username1"));
		password.sendKeys(prop.getProperty("admin_password"));
		loginButton.click();

		
	}
	public void InActiveRole() {
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("admin_password"));
		loginButton.click();
		
	}
	public void WithoutgivingGroupandRole() {
		username.sendKeys(prop.getProperty("GroupandRole"));
		password.sendKeys(prop.getProperty("admin_password"));
		loginButton.click();
		
	}

	public void InActiveGroup() {

		username.sendKeys(prop.getProperty("InActiveGroup"));
		password.sendKeys(prop.getProperty("admin_password"));
		loginButton.click();
		
	}

	public void Userenddate() {

		username.sendKeys(prop.getProperty("UserEnddate"));
		password.sendKeys(prop.getProperty("admin_password"));
		loginButton.click();
		
	}
	public void Userinactive() {

		username.sendKeys(prop.getProperty("UserInActive"));
		password.sendKeys(prop.getProperty("admin_password"));
		loginButton.click();
		
	}
	public void Logout() throws InterruptedException {
		username.sendKeys(prop.getProperty("admin_username"));
		password.sendKeys(prop.getProperty("admin_password"));
		loginButton.click();
		
	}
	
	public void NewCooperativeAppLogin() {
		username.sendKeys(prop.getProperty("cao_username"));
		password.sendKeys(prop.getProperty("CID_password"));
		loginButton.click();
	}
	
	public void CooperativeApplicationOfficerLogin() {
		username.sendKeys(prop.getProperty("CID_username"));
		password.sendKeys(prop.getProperty("CID_password"));
		loginButton.click();
	}
	
	public void Officevistdetaillogin() {
		username.sendKeys(prop.getProperty("offvisitUsername"));
		password.sendKeys(prop.getProperty("offvisistpswd"));
		loginButton.click();
	}
	
	public void loginAsCRO() {
		username.sendKeys(prop.getProperty("CROuserid"));
		password.sendKeys(prop.getProperty("CID_password"));
		loginButton.click();
	}
	public void NewmemberApplication() {
		username.sendKeys(prop.getProperty("Memname"));
		password.sendKeys(prop.getProperty("Mempsd"));
		loginButton.click();
	}
	
	public void Autogenerate_String() {
		 
	    int length = 10;
	    boolean useLetters = true;
	    boolean useNumbers = false;
	    String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
	    System.out.println(generatedString);
	}
	
	
	
}
	
	