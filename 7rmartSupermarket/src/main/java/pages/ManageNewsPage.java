package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	    @FindBy(xpath="(//p[contains(text(),'Manage News')])[2]")WebElement managenews;
	    @FindBy(xpath="(//a[contains(@class,'small-box')])[7]")WebElement moreinfobutton;
	    @FindBy(xpath="//a[contains(@class,'btn btn-rounded btn-danger')]")WebElement newbutton;
	    @FindBy(css="textarea#news")WebElement enternewsinputfield;
	    @FindBy(css="button[type='submit']")WebElement savebutton;
	    @FindBy(xpath="//div[contains(@class,'alert alert-success alert')]")WebElement alertmessage;
	    
	    WebDriver driver;
	    public ManageNewsPage(WebDriver driver) {
	    	this.driver=driver;
	    	PageFactory.initElements(driver, this);
	    	
	    }
	    
	    public void clickingManageNews() {
	    	managenews.click();
	    }
	    public void clickMoreInfo() {
	    	moreinfobutton.click();
	    }
	    public void clickNewButtonForAddNews() {
	    	newbutton.click();
	    }
	    public void clickEnterNewsField(String newnews) {
	    	enternewsinputfield.sendKeys(newnews);
	    }
	    public void clickSaveButton() {
	    	savebutton.click();
	    }
	    public boolean isAlertMessageDisplayed() {
			return alertmessage.isDisplayed();
	    	
	    }

}
