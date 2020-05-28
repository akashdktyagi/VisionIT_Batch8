package utils.ui;

import static org.testng.Assert.fail;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;

/**
 * 
 * @author akashtyagi
 * Library created to interact with the elements
 */
public abstract class Interact {

	private static final Logger logger = LogManager.getLogger(Interact.class);
	private WebDriver driver;
	
	public WebDriver getDriver() {
		 return driver;
	}
	
	public void setDriver(WebDriver d) {
		this.driver=d;
	}
		
	public WebElement clickElement(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.click();
		logger.info("Element is clicked. Element Description: " + by.toString());
		return element;
	}
	
	public void clickElement(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
		webElement.click();
		logger.info("Element is clicked. Element Description: " + webElement.toString());
	}
	
	public WebElement setElement(By by, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.sendKeys(text);
		logger.info("Element is Set with text as: " + text + ". Element Description: " + by.toString());
		return element;
	}
	
	public WebElement setElement(By by, Keys down) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.sendKeys(down);
		logger.info("Element is Set with text as: " + down + ". Element Description: " + by.toString());
		return element;
	}
	
	public String getAttribute(By by, String attName) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		String value = element.getAttribute(attName);
		logger.info("Get Attribute for element: " + by.toString() + " Attribute name: " + attName);
		return value;
	}
	
	public void JavascriptExecutor(By by) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String str = "return document.getElementById('twotabsearchtextbox').value;";
		String item = (String) js.executeScript(str);
		System.out.println(item);
		int i=0;
		while(!item.contains("dell it")){
			i++;
			setElement(by, Keys.DOWN);
			Thread.sleep(1000);
			item = (String) js.executeScript(str);
			System.out.println(item);
			if(i>11){
				break;
			}
		}
		if(i>11){
			System.out.println("Item not found.");
			fail("Desired item not found.");
		}else{
			System.out.println("Desire item found.");
		}
//		return value;
	}
	
	public String getText(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		String value = element.getText();
		logger.info("Get Text for element: " + by.toString() + " Text : " + value);
		return value;
	}
	
	public List<WebElement> getListOfWebElements(By by){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		logger.info("List of Elements returned for description: " + by.toString());
		return element.findElements(by);
	}
	
	public boolean validateElementIsDisplayed(By by) {
		boolean b = driver.findElement(by).isDisplayed();
		logger.info("Element is Displayed status: " + by.toString());
		return b;
	}
	
	public void switchToSecondWindowTab() {
		String [] handles = (String[]) driver.getWindowHandles().toArray();
		driver.switchTo().window(handles[1]);
		logger.info("Browser Switched to second window tab.");
	}
	
	public void switchToDefaultWindowTab() {
		String [] handles = (String[]) driver.getWindowHandles().toArray();
		driver.switchTo().window(handles[0]);
		logger.info("Browser Switched to parent window tab.");
	}
	
	public byte[] takeScreenShot() {
		TakesScreenshot shot = (TakesScreenshot)driver;
		logger.info("Screen Shot taken for full driver. ");
		return shot.getScreenshotAs(OutputType.BYTES);
	}
	
	public byte[] takeScreenShot(By by) {
		TakesScreenshot shot = (TakesScreenshot)driver.findElement(by);
		logger.info("Screen Shot taken for element: " + by.toString() );
		return shot.getScreenshotAs(OutputType.BYTES);
	}
	
	public File takeScreenShotAsFile() {
		TakesScreenshot shot = (TakesScreenshot)driver;
		logger.info("Screen Shot taken for full driver and returned as a file.");
		return shot.getScreenshotAs(OutputType.FILE);
	}
	
	public File takeScreenShotAsFile(By by) {
		TakesScreenshot shot = (TakesScreenshot)driver.findElement(by);
		logger.info("Screen Shot taken for element and returned as a file. By descp: " + by.toString());
		return shot.getScreenshotAs(OutputType.FILE);
	}
	
	public void takeScreenShotAndAttachInReport(Scenario s) {
		s.embed(takeScreenShot(), "image/png");
	}
}
