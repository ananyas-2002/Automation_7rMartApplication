package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {
	HomePage homepage;
	AdminUsersPage adminusers;

	@Test(description = "Validating Admin Users Page", retryAnalyzer = retry.Retry.class)
	public void verifiesAdminUsers() throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");

		LoginPage login = new LoginPage(driver);
		login.enterUsername(username).enterPassword(password);
		// login.enterPassword(password);
		homepage = login.signIn();

		// String newadminusername=ExcelUtility.readStringData(2, 0, "adminuserpage");
		String newadminpassword = ExcelUtility.readStringData(2, 1, "adminuserpage");
		String newadminusertype = ExcelUtility.readStringData(2, 2, "adminuserpage");
		FakerUtility fake = new FakerUtility();
		String newadminusername = fake.creatARandomFirstName(); // for generating fake data such as here generating fake
																// username

		// AdminUsersPage adminusers=new AdminUsersPage(driver);
		// adminusers.clickAdminUsers();
		adminusers = homepage.clickAdminUsersMoreInfo();
		adminusers.clickNewButton().enterUsernameForAdmin(newadminusername).enterPasswordForAdmin(newadminpassword)
				.selectUserType(newadminusertype).saveNewAdminData();
		// adminusers.enterUsernameForAdmin(newadminusername);
		// adminusers.enterPasswordForAdmin(newadminpassword);
		// adminusers.selectUserType(newadminusertype);
		// adminusers.saveNewAdminData();

		// validataion section
		boolean newuseralert = adminusers.newUserCreatedAlertMessage();
		Assert.assertTrue(newuseralert);

	}

}
