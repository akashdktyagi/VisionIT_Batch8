package utils.manager.driver.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxManager extends DriverManager{

	@Override
	protected void initDriver() {
		driver = new FirefoxDriver();
	}
}
