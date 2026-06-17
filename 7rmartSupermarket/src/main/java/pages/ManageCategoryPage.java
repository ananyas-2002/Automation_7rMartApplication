package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;
//import utilities.WaitUtility;

public class ManageCategoryPage {
	@FindBy(xpath = "(//div[@class='inner'])[9]")
	WebElement managecategory;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[9]")
	WebElement managaecategorymoreinfo;
	@FindBy(xpath = "(//a[contains(@class,'danger')])[1]")
	WebElement newbutton;
	@FindBy(xpath = "//input[@id='category']")
	WebElement categoryinput;
	@FindBy(xpath = "//li[@class='ms-elem-selectable']")
	WebElement discount;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement choosefile;
	@FindBy(xpath = "//button[@name='create']")
	WebElement save;
	@FindBy(xpath = "//div[contains(@class,'alert')]")
	WebElement alertcategorycreated;

	public WebDriver driver;
	FileUploadUtility fileupload = new FileUploadUtility();
	//WaitUtility wait = new WaitUtility();
	PageUtility page=new PageUtility();

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickManageCategory() {
		managecategory.click();
	}

	public void clickManageCategoryMoreInfo() {
		managaecategorymoreinfo.click();
	}

	public void clickNewButton() {
		newbutton.click();
	}

	public void enterCategory(String category) {
		categoryinput.sendKeys(category);
	}

	public void selectDiscount() {
		discount.click();
	}

	public void choosefilecategory() {
		//fileupload.fileUploadUsingSendKeys(choosefile);
		fileupload.fileUploadUsingSendKeys(choosefile, Constant.BERRYIMG);
	}

	public void savecategory() {
		//wait.waitForElementToBeClickable(driver, save);
		page.javaScriptExecutorClick(driver, save);
	//	save.click();
	}

	public boolean categoryCreatedIsDisplayed() {
		return alertcategorycreated.isDisplayed();

	}

}
