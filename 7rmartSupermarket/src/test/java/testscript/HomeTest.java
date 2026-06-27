package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.HomePage;
import utilities.ExcelUtility;

public class HomeTest extends Base {

	@Test(description="Validate logout functionality",groups= {"regression"})
	public void verifiesLogout() throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");

		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.signIn();

		HomePage logout = new HomePage(driver);
		logout.clickAdminIcon();
		logout.clickLogoutButton();
		boolean signdisplay = logout.isSignDisplayed();
		Assert.assertTrue(signdisplay);
	}

}
