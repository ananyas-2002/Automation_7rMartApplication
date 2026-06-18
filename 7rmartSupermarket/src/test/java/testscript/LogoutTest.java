package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LogoutTest extends Base {

	@Test(description="Validate logout functionality")
	public void verifiesLogout() throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");

		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.signIn();

		LogoutPage logout = new LogoutPage(driver);
		logout.clickAdminIcon();
		logout.clickLogoutButton();
		boolean signdisplay = logout.isSignDisplayed();
		Assert.assertTrue(signdisplay);
	}

}
