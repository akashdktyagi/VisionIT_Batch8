package context;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import pageobjects.CmnPageObjects;
import pageobjects.SearchPageObjects;

public class TestContextUI {

	private WebDriver driver;
	private CmnPageObjects cmnPageObjects;
	private SearchPageObjects searchPageObjects;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public CmnPageObjects getCmnPageObjects() {
		return cmnPageObjects;
	}

	public SearchPageObjects getSearchPageObjects() {
		return searchPageObjects;
	}

	public void initializePageObjectClasses(WebDriver driver,Scenario scn) {
		cmnPageObjects = new CmnPageObjects(driver,scn);
		searchPageObjects = new SearchPageObjects(driver,scn);
	}
	
}
