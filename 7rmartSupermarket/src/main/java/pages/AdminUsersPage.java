package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUsersPage {
	
	@FindBy(xpath="(//p[contains(text(),'Admin Users')])[2]")WebElement adminusers;
	//@FindBy(xpath="(//a[@class='small-box-footer'])[1]")WebElement adminmoreinfo;
	@FindBy(xpath="//a[contains(@class,'btn btn-rounded btn-danger')]")WebElement newbutton;
	@FindBy(css="input#username")WebElement usernamefield;
	@FindBy(css="input#password")WebElement passwordfield;
	@FindBy(xpath="//select[@id='user_type']")WebElement usertype;
	@FindBy(xpath="(//button[@type='submit'])[2]")WebElement savebutton;
	@FindBy(xpath="//div[contains(@class,'alert alert-success alert-dismissible')]")WebElement newuseralertmessage;
	
	WebDriver driver;
	PageUtility page=new PageUtility();
	
	
	public AdminUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/*
	public void clickAdminUsers() {
		adminusers.click();
	}
	public AdminUsersPage clickAdminUsersMoreInfo() {
		adminmoreinfo.click();
		return this;
	}*/
	public AdminUsersPage clickNewButton() {
		newbutton.click();
		return this;
	}
	public AdminUsersPage enterUsernameForAdmin(String usernameinput) {
		usernamefield.sendKeys(usernameinput);
		return this;
	}
	public AdminUsersPage enterPasswordForAdmin(String passwordinput) {
		passwordfield.sendKeys(passwordinput);
		return this;
	}
	public AdminUsersPage selectUserType(String value) {
		page.dropdownValue(usertype, value);
		return this;
	}
	public AdminUsersPage saveNewAdminData() {
		savebutton.click();
		return this;
	}
	public boolean newUserCreatedAlertMessage() {
		return newuseralertmessage.isDisplayed();
		
		
	}
	

}
