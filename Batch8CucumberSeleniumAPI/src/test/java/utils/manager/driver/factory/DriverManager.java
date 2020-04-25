package utils.manager.driver.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	protected WebDriver driver;
	protected abstract void initDriver();

	public WebDriver getDriver() {
		initDriver();
		return driver;
	}

	public void quitDriver() {
		driver.quit();
	}
	
	public void closeDriver() {
		driver.close();
	}
	
	public void navigateToDriver(String url) {
		driver.get(url);
	}
	
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	
	public void setImplicitWaitTimeOut(int timeInMiliSeconds) {
		driver.manage().timeouts().implicitlyWait(timeInMiliSeconds, TimeUnit.MILLISECONDS);
	}
}
