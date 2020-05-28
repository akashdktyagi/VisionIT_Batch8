package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import context.AmazonBase;

public class LandingAmazon extends AmazonBase{

	
public WebDriver driver;
	
	
	public Actions a1=new Actions(driver);                                                      
	
	WebElement move=driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));

	  
	
	By sign_in=By.xpath("//span[@class='nav-action-inner']");
	

	
	public LandingAmazon()
	{
		this.driver=driver;
	}
	
	
	public WebElement getlogin()
	
	{
		return driver.findElement(sign_in); 
	}
}
