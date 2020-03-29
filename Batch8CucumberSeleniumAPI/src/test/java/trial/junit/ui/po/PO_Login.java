package trial.junit.ui.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PO_Login {
	
	WebDriver driver;
	
	By userName = By.name("username");
	By password = By.name("password");
	By loginButton = By.xpath("//input[@value='Log In']");
	
	public PO_Login(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setUserName(String text) {
		driver.findElement(this.userName).sendKeys(text);
	}
	
	public void setPassword(String text) {
		driver.findElement(this.password).sendKeys(text);
	}
	
	public void ClickOnLoginButton() {
		driver.findElement(this.loginButton).click();
	}
	
	
	

}
