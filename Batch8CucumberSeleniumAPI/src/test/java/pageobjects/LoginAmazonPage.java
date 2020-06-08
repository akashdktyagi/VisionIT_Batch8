package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginAmazonPage {

	public WebDriver driver; 
	
	By email=By.id("ap_email");
	By continue_process=By.id("continue");
	By pass=By.id("ap_password");
	By sbmit =By.id("signInSubmit");

	
	public LoginAmazonPage(WebDriver driver)
	{
		
		this.driver=driver;
	}
	
public LoginAmazonPage() {
		// TODO Auto-generated constructor stub
	}

public WebElement getemail()
{
	return driver.findElement(email); 
}

public WebElement continues()
{
	return driver.findElement(continue_process); 
}
public WebElement password()
{
	return driver.findElement(pass); 
}
public WebElement login()
{
	return driver.findElement(sbmit); 
}

}