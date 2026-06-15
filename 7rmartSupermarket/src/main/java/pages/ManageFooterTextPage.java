package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage {
	
	@FindBy(xpath="(//div[@class='inner'])[8]")WebElement managefootertext;
	@FindBy(xpath="(//a[@class='small-box-footer'])[8]")WebElement moreinfomanagefootertext;
	@FindBy(xpath="(//a[@role='button'])[1]")WebElement editdatabutton;
	@FindBy(xpath="//textarea[@id='content']")WebElement addressfield;
	@FindBy(xpath="//input[@id='email']")WebElement emailfield;
	@FindBy(xpath="//input[@id='phone']")WebElement phonenumberfield;
	@FindBy(xpath="//button[@type='submit']")WebElement updatebutton;
	@FindBy(xpath="//div[contains(@class,'dismissible')]")WebElement updatealertmessage;
	
	WebDriver driver;
	
	public ManageFooterTextPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickManageFooterText() {
		managefootertext.click();
	}
	public void clickManageFooterTextMoreInfo() {
		moreinfomanagefootertext.click();
	}
	public void clickEditDetailsButton() {
		editdatabutton.click();
	}
	public void EnterAddressInAddressField(String addressdata) {
		addressfield.clear();
		addressfield.sendKeys(addressdata);
	}
	public void EnterEmail(String email) {
		emailfield.clear();
		emailfield.sendKeys(email);
	}
	public void EnterPhoneNumber(String phonenumber) {
		phonenumberfield.clear();
		phonenumberfield.sendKeys(phonenumber);
	}
	public void updateButton() {
		updatebutton.click();
	}
	public boolean alertUpdateMessageisDisplayed() {
		return updatealertmessage.isDisplayed();
		
	}
	


}
