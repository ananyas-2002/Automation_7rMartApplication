package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	
	@Test(description="Validating Manage News Page")
	public void verifiesManageNewsFeature() throws IOException {
		
		String username=ExcelUtility.readStringData(1, 0, "loginpage");
		String password=ExcelUtility.readStringData(1, 1, "loginpage");
		
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.signIn();
		
		String newnews=ExcelUtility.readStringData(2, 0, "managenewsaddnewspage");
		
		ManageNewsPage managenews=new ManageNewsPage(driver);
		managenews.clickingManageNews();
		managenews.clickMoreInfo();
		managenews.clickNewButtonForAddNews();
		managenews.clickEnterNewsField(newnews);
		managenews.clickSaveButton();
		boolean alertmessage=managenews.isAlertMessageDisplayed();
		Assert.assertTrue(alertmessage);
	}
	
   
}
