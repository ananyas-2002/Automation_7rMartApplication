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

		ManageFooterTextPage managefootertext = new ManageFooterTextPage(driver);
		managefootertext.clickManageFooterText();
		managefootertext.clickManageFooterTextMoreInfo();
		managefootertext.clickEditDetailsButton();
		managefootertext.EnterAddressInAddressField("romanth first block");
		managefootertext.EnterEmail("romanathan@gmail.com");
		managefootertext.EnterPhoneNumber("6543267966");
		managefootertext.updateButton();
		boolean alertupdatemeaage=managefootertext.alertUpdateMessageisDisplayed();
		Assert.assertTrue(alertupdatemeaage);
	}

}
