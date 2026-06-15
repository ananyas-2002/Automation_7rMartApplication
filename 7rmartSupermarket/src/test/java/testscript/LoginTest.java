package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test(description = "Validating Login functionality")
	public void loginWithValidCredentials() throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");

		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.signIn();
		// login.remeberMe();
		boolean homepage = login.isDashboardDisplayed();
		Assert.assertTrue(homepage);

	}

	@Test
	public void loginWithInvalidusernameAndValidPassword() throws IOException {

		String username = ExcelUtility.readStringData(2, 0, "loginpage");
		String password = ExcelUtility.readStringData(2, 1, "loginpage");

		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.signIn();
		boolean alertmessage = login.isAlertMessageDisplayed();
		Assert.assertTrue(alertmessage);

	}

	@Test
	public void loginWithValidusernameAndInvalidPassword() throws IOException {

		String username = ExcelUtility.readStringData(3, 0, "loginpage");
		String password = ExcelUtility.readStringData(3, 1, "loginpage");

		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.signIn();
		boolean alertmessage = login.isAlertMessageDisplayed();
		Assert.assertTrue(alertmessage);

	}

	@Test
	public void loginWithInvalidCredentials() throws IOException {

		String username = ExcelUtility.readStringData(4, 0, "loginpage");
		String password = ExcelUtility.readStringData(4, 1, "loginpage");

		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.signIn();
		boolean alertmessage = login.isAlertMessageDisplayed();
		Assert.assertTrue(alertmessage);
	}

}
