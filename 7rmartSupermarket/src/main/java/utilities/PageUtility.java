package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void dropdownVisibleText(WebElement element, String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void dropdownValue(WebElement element, String attributevalue) {
		Select select=new Select(element);
		select.selectByValue(attributevalue);
	}
	
	public void dropdownIndex(WebElement element, int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
		
	}
	
	public void actionrightClick(WebDriver driver, WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
		
	}
	public void actionsDragandDrop(WebDriver driver,WebElement source, WebElement target) {
		Actions action=new Actions(driver);
		action.dragAndDrop(source, target).perform();
		
	}
	public void actionsDoubleClick(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
		
	}
	public void actionsMouseHover(WebDriver driver,WebElement element){
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
		
	}
	public void actionsClickandDrag(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.click(element);
	}
	public void alertSimplealert(WebDriver driver,String text) {
		Alert alert=driver.switchTo().alert();
		text=alert.getText();
		System.out.println(text);
		alert.accept();
	}
	public void alertconfirmationalert(WebDriver driver) {
		Alert alert=driver.switchTo().alert();
		alert.accept();
		//alert.dismiss();
	}
	public void alertPromptalert(WebDriver driver,String text) {
		Alert alert=driver.switchTo().alert();
		alert.sendKeys(text);
		alert.accept();
	}
	public void javaScriptExecutorscrolldown(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,150)","");
		
	}
	public void javaScriptExecutorClick(WebDriver driver,WebElement showmessage) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", showmessage);
	}
	public void javaScriptSendkeys(WebDriver driver,String value,WebElement message) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=value;", message);

	}
	public void javaScriptExecutorscrollup(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeAsyncScript("window.scrollBy(0,-100)", "");
	}
	public void javaScriptExecutorscrollEntirepage(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeAsyncScript("window.scrollBy(0,document.body.scrollHeight)", "");
	}


}
