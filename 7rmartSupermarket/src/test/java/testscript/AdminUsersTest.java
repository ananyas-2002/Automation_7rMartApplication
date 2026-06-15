package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base {
	
	@Test
	public void verifiesAdminUsers() throws IOException {
		
		String username=ExcelUtility.readStringData(1, 0, "loginpage");
		String password=ExcelUtility.readStringData(1, 1, "loginpage");
		
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.signIn();
		
		String newadminusername=ExcelUtility.readStringData(2, 0, "adminuserpage");
		String newadminpassword=ExcelUtility.readStringData(2, 1, "adminuserpage");
		String newadminusertype=ExcelUtility.readStringData(2, 2, "adminuserpage");

		
		AdminUsersPage adminusers=new AdminUsersPage(driver);
		adminusers.clickAdminUsers();
		adminusers.clickAdminUsersMoreInfo();
		adminusers.clickNewButton();
		adminusers.enterUsernameForAdmin(newadminusername);
		adminusers.enterPasswordForAdmin(newadminpassword);
		adminusers.selectUserType(newadminusertype);
		//adminusers.enterUsernameForAdmin("ramya234");
		//adminusers.enterPasswordForAdmin("ramya22");
		//adminusers.selectUserType("admin");
		adminusers.saveNewAdminData();
		//validataion section
		boolean newuseralert=adminusers.newUserCreatedAlertMessage();
		Assert.assertTrue(newuseralert);
		
}

}
