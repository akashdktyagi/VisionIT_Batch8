package utils.manager.driver.factory;



public class DriverFactory {

	public static DriverManager getDriverManager(String browserType) throws Exception {
		DriverManager driverManager;
		switch (browserType.toLowerCase()) {
		case "chrome":
			driverManager = new ChromeManager();
			break;
		case "firefox":
			driverManager = new FirefoxManager();
			break;
		default:
			throw new Exception("no such browser is present to be initialize. Browser name: " + browserType);
		}
		
		return driverManager;
	}
}
