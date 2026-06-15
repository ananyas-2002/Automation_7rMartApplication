package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	@FindBy(xpath="//a[@data-toggle='dropdown']") WebElement admin;
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")WebElement logout;
	@FindBy(xpath="//button[@type='submit']")WebElement signindisplay;
	
	public WebDriver driver;
	
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickAdminIcon() {
		admin.click();
	}
	public void clickLogoutButton() {
		logout.click();
	}
	public boolean isSignDisplayed() {
		return signindisplay.isDisplayed();
		
	}

}
