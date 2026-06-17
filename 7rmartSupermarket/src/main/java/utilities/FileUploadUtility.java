package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

//import constant.Constant;

public class FileUploadUtility {
	public void fileUploadUsingSendKeys(WebElement element, String filepath) {
		element.sendKeys(filepath);
	}
	
	public void fileUploadUsingRobotClass(String filepath) throws AWTException {
		StringSelection s=new StringSelection(filepath);   //StringSelection class used to store file path ,StringSelection stores file path as text 
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);  // copies the file path into system clipboard, same as ctrl+c action performed
		Robot r=new Robot();  //used to perform keyboard actions
		r.delay(2500);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);   //VK_CONTROL and VK_V are the constants in keyevent, VK is virtual control  KeyEvent is class ,KeyEvent class used to perform keyboard action 
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER); //to enter , to upload file
		r.keyRelease(KeyEvent.VK_ENTER);
	}

}
