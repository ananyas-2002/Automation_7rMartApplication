package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.ScreenShotUtility;
import utilities.WaitUtility;

public class Base {

	public WebDriver driver;
	public Properties properties;
	public FileInputStream fileinput;

	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void browserInitialization(String browser) throws Exception {

		if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else {
			throw new Exception("Invalid");
		}
		try {
			properties = new Properties();
			fileinput = new FileInputStream(Constant.CONFIGFILE);
			properties.load(fileinput);
		} catch (Exception e) {
			System.out.println(e);
		}
		driver.get(properties.getProperty("url"));
		// driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICITWAIT));
		driver.manage().window().maximize();
	}

	@AfterMethod(alwaysRun=true)
	public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			ScreenShotUtility scrShot = new ScreenShotUtility(); // creating obj
			scrShot.getScreenShot(driver, iTestResult.getName());
		}
		driver.quit();
	}
}

	/*
	@AfterMethod
	public void browserQuitandClose() {
		driver.close();
		// driver.quit();
	}
	*/


