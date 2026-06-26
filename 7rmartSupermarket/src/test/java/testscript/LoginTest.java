package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test(description = "Validating Login functionality with valid credentials",groups= {"regression"})  //to perform regression testing
	public void loginWithValidCredentials() throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");

		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.signIn();
		// login.remeberMe();
		boolean homepage = login.isDashboardDisplayed();
		Assert.assertTrue(homepage,Constant.VALIDCREDENTIALS);

	}

	@Test(description = "Validating Login functionality with invalid username and valid password")
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

	@Test(description = "Validating Login functionality with valid username and invalid password")
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

	@Test(description = "Validating Login functionality with invalid credentials")
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
