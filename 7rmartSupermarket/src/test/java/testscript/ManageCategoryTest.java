package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base {
	HomePage homepage;
	ManageCategoryPage managecategory;
	
	@Test(description="Validating Manage Category Page")
	public void verifyManageCategory() throws IOException {
		
		String username=ExcelUtility.readStringData(1, 0, "loginpage");
		String password=ExcelUtility.readStringData(1, 1, "loginpage");
		
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username).enterPassword(password);
		//login.enterPassword(password);
		homepage=login.signIn();
		
		String categoryname=ExcelUtility.readStringData(3, 0, "managecategorypage");
		//ManageCategoryPage managecategory=new ManageCategoryPage(driver);
		//managecategory.clickManageCategory();
		managecategory=homepage.clickManageCategoryMoreInfo();
		managecategory.clickNewButton().enterCategory(categoryname).selectDiscount().choosefilecategory().savecategory();
		//managecategory.enterCategory(categoryname);
		//managecategory.selectDiscount();
		//managecategory.choosefilecategory();
		//managecategory.savecategory();
		boolean alertmessage=managecategory.categoryCreatedIsDisplayed();
		Assert.assertTrue(alertmessage);
				
	}

}
