package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CmnPageObjects {

	WebDriver driver;
	
	private By search_text_box = By.id("twotabsearchtextbox");
	private By search_button = By.xpath("//input[@value='Go']");
	
	public CmnPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public void SetSearchTextBox(String text) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(search_text_box));
		element.sendKeys(text);
	}
	
	public void ClickOnSearchButton() {
		driver.findElement(search_button).click();
	}
	
}
