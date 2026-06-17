package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base{
	
	@Test
	public void verifyManageContact() throws IOException {
		
		String username=ExcelUtility.readStringData(1, 0, "loginpage");
		String password=ExcelUtility.readStringData(1, 1, "loginpage");
		
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.signIn();
		
		String phonenumber=ExcelUtility.readIntegerData(2, 0, "managecontactpage");
		String email=ExcelUtility.readStringData(2, 1, "managecontactpage");
		String address=ExcelUtility.readStringData(2, 2, "managecontactpage");
		String deliverytime=ExcelUtility.readIntegerData(2, 3, "managecontactpage");
		String deliverchargelimit=ExcelUtility.readIntegerData(2, 4, "managecontactpage");
		
		ManageContactPage managecontact=new ManageContactPage(driver);
		managecontact.clickManageContact();
		managecontact.clickManageContactMoreInfo();
		managecontact.clickActionbutton();
		managecontact.enterPhonenumber(phonenumber);
		managecontact.enterEmail(email);
		managecontact.enterAddressField(address);
		managecontact.enterDeliveryTime(deliverytime);
		managecontact.enterDeliveryChargeLimit(deliverchargelimit);
		managecontact.clickUpdatebutton();
		boolean alertmessage=managecontact.updatedAlertMessageIsDisplayed();
		Assert.assertTrue(alertmessage);
	}

}
