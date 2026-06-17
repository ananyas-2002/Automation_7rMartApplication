package testscript;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.WaitUtility;

public class Base {
	
	public WebDriver driver;
	
	@BeforeMethod
	//@Parameters("browser")
	public void browserInitialization() {
		driver=new EdgeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICITWAIT));
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void browserQuitandClose() {
		driver.close();
		//driver.quit();
	}

}
