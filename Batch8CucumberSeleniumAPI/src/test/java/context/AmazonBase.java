package context;
import java.io.FileInputStream;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.model.Log;



public class AmazonBase {

	
	public WebDriver driver;
	 public Properties prop;
	
	 public WebDriver driverInitilization() throws IOException
	 {
		 
		prop=new Properties();
		
		FileInputStream fis=new FileInputStream("/Batch8CucumberSeleniumAPI/src/test/resources/config.properties");
	prop.load(fis);
	
	String browser=prop.getProperty("url_ui");
	return driver;

	 }
	 
	 
}

