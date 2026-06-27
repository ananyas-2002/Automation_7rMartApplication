package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
//import utilities.WaitUtility;

public class ManageContactPage {
	
	@FindBy(xpath="(//div[@class='inner'])[3]")WebElement manangecontact;
	//@FindBy(xpath="(//a[@class='small-box-footer'])[3]")WebElement managecontactmoreinfo;
	@FindBy(xpath="//a[@role='button']")WebElement actionbutton;
	@FindBy(xpath="//input[@id='phone']")WebElement phonenumberinputfield;
	@FindBy(xpath="//input[@id='email']")WebElement emailinputfield;
	@FindBy(xpath="//textarea[@name='address']")WebElement addressfield;
	@FindBy(xpath="//textarea[@name='del_time']")WebElement deliverytime;
	@FindBy(xpath="//input[@name='del_limit']")WebElement deliverychargelimit;
	@FindBy(xpath="//button[contains(@class,'info')]")WebElement updatemanagecontactbutton;
	@FindBy(xpath="//div[contains(@class,'dismissible')]")WebElement contactupdatedalert;
	
	
	public WebDriver driver;
	//WaitUtility wait=new WaitUtility();
	PageUtility page=new PageUtility();
	
	public ManageContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public ManageContactPage clickManageContact() {
		manangecontact.click();
		return this;
	}/*
	public void clickManageContactMoreInfo() {
		managecontactmoreinfo.click();
	}*/
	public ManageContactPage clickActionbutton() {
		actionbutton.click();
		return this;
	}
	public ManageContactPage enterPhonenumber(String phonenumber) {
		phonenumberinputfield.sendKeys(phonenumber);
		return this;
	}
	public ManageContactPage enterEmail(String email) {
		emailinputfield.sendKeys(email);
		return this;
	}
	public ManageContactPage enterAddressField(String address) {
		addressfield.sendKeys(address);
		return this;
	}
	public ManageContactPage enterDeliveryTime(String deliverytimeinput) {
		deliverytime.sendKeys(deliverytimeinput);
		return this;
	}
	public ManageContactPage enterDeliveryChargeLimit(String chargelimit) {
		deliverychargelimit.sendKeys(chargelimit);
		return this;
	}
	public ManageContactPage clickUpdatebutton() {
		//wait.waitForElementToBeClickable(driver, updatemanagecontactbutton);
		page.javaScriptExecutorClick(driver, updatemanagecontactbutton);
		//updatemanagecontactbutton.click();
		return this;
	}
	public boolean updatedAlertMessageIsDisplayed() {
		return contactupdatedalert.isDisplayed();
		
	}

}
