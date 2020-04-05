package trial.junit.ui.tc;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import trial.junit.ui.po.PO_Login;

public class TC_TestParaBank {
	

	public void t_01_login() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://parabank.parasoft.com/parabank/index.htm");
		
		PO_Login poLogin = new PO_Login(driver);
		poLogin.setUserName("john");
		poLogin.setPassword("demo");
		poLogin.ClickOnLoginButton();
	}

}
