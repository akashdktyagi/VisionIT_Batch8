package pageobjects;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import utils.ui.Interact;


public class LoginPage extends Interact{

Scenario scn;
	
	//public WebDriver driver; 
	
private	By USERNAME=By.id("ap_email");
private By PASSWORD=By.id("ap_password");
private	By sbmit =By.id("signInSubmit");

public LoginPage(WebDriver driver,Scenario s)
{
	setDriver(driver);
	this.scn = s;
	

}

public void enterusername(String username)
{
	setElement(USERNAME, username);
	WebDriverWait wait = new WebDriverWait(driver, 60);
	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(USERNAME));
	element.sendKeys(username);
}

public void enterpassword(String password)
{
	setElement(PASSWORD, password);
	
	WebDriverWait wait = new WebDriverWait(driver, 60);
	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(PASSWORD));
	element.sendKeys(password);

}
public void ClickOnSubmitButton()
{
	clickElement(sbmit);
}



}