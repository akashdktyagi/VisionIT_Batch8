package pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import cucumber.api.Scenario;
import utils.ui.Interact;

public class CmnPageObjects extends Interact {
	private static final Logger logger = LogManager.getLogger(CmnPageObjects.class);
	Scenario scn;
	
	private By search_text_box = By.id("twotabsearchtextbox");
	private By search_button = By.xpath("//input[@value='Go']");
	
	public CmnPageObjects(WebDriver driver, Scenario s) {
		setDriver(driver);
		this.scn = s;
	}
	
	public void SetSearchTextBox(String text) {
		setElement(search_text_box, text);
		logger.info("Value enetered in search box: " + text);
		takeScreenShotAndAttachInReport(scn);
	}
	
	public void ClickOnSearchButton() {
		try {
			clickElement(search_button);	
			logger.info("Clicked on Search Button");
		}catch(Exception e) {
			logger.error("Exception occured while tring to click on search button. Exception: " + e.getMessage());
		}

	}
	
}
