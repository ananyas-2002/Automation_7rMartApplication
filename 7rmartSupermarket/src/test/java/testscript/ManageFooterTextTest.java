package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;

public class ManageFooterTextTest extends Base {

	@Test
	public void verfiyManagerFooterUpdateData() throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");

		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.signIn();

		String address=ExcelUtility.readStringData(3, 0, "managefootertextupdate");
		String email=ExcelUtility.readStringData(3, 1, "managefootertextupdate");
		String phonenumber=ExcelUtility.readIntegerData(3, 2, "managefootertextupdate");
		
		ManageFooterTextPage managefootertext = new ManageFooterTextPage(driver);
		managefootertext.clickManageFooterText();
		managefootertext.clickManageFooterTextMoreInfo();
		managefootertext.clickEditDetailsButton();
		managefootertext.EnterAddressInAddressField(address);
		managefootertext.EnterEmail(email);
		managefootertext.EnterPhoneNumber(phonenumber);
		managefootertext.updateButton();
		boolean alertupdatemeaage=managefootertext.alertUpdateMessageisDisplayed();
		Assert.assertTrue(alertupdatemeaage);
	}

}
