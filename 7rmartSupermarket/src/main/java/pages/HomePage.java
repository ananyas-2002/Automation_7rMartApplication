package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement admin;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	WebElement logout;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signindisplay;

	@FindBy(xpath = "(//a[contains(@class,'small-box')])[7]")
	WebElement managenewsmoreinfobutton;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[3]")
	WebElement managecontactmoreinfo;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[9]")
	WebElement managaecategorymoreinfo;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[8]")
	WebElement moreinfomanagefootertext;
	@FindBy(xpath="(//a[@class='small-box-footer'])[1]")
	WebElement adminmoreinfo;

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ManageNewsPage clickManagenewsMoreInfo() {
		managenewsmoreinfobutton.click();
		return new ManageNewsPage(driver);
	}

	public ManageContactPage clickManageContactMoreInfo() {
		managecontactmoreinfo.click();
		return new ManageContactPage(driver);
	}

	public ManageCategoryPage clickManageCategoryMoreInfo() {
		managaecategorymoreinfo.click();
		return new ManageCategoryPage(driver);
	}

	public ManageFooterTextPage clickManageFooterTextMoreInfo() {
		moreinfomanagefootertext.click();
		return new ManageFooterTextPage(driver);
	}
	
	public AdminUsersPage clickAdminUsersMoreInfo() {
		adminmoreinfo.click();
		return new AdminUsersPage(driver);
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
