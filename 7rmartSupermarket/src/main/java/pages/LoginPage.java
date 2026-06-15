package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import utilities.WaitUtility;

public class LoginPage {
	
	@FindBy(xpath="//input[@type='text']") WebElement usernamefield;
	@FindBy(xpath="//input[@type='password']") WebElement passwordfield;
	@FindBy(xpath="//button[@type='submit']") WebElement signin;
	@FindBy(xpath="//label[@for='remember']") WebElement rememberme;
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
	@FindBy(xpath="//div[contains(@class,'dismissible')]")WebElement alertmessage;
	
	public WebDriver driver;
	//WaitUtility wait=new WaitUtility();
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String username) {
	usernamefield.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordfield.sendKeys(password);
	}
	public void signIn() {
		//wait.waitForElementToBeClickable(driver, signin);
		signin.click();
	}
	
	public void remeberMe() {
		rememberme.click();
	}
	public boolean isDashboardDisplayed() {  //for validation created this method, Assertion done in test class bcz for validation using Assertion 
		return dashboard.isDisplayed();  
	}
	public boolean isAlertMessageDisplayed() {  //for invalide login credentials validating
		return alertmessage.isDisplayed() ;
		
	}

}
