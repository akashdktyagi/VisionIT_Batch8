package stepdefs.ui;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import context.TestBase;
import context.TestContextUI;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.CmnPageObjects;
import pageobjects.SearchPageObjects;
import utils.manager.driver.factory.DriverFactory;
import utils.manager.driver.factory.DriverManager;
import utils.manager.driver.singleton.WebDriverManagerSingleton;
import utils.manager.driver.staticmethod.WebDriverManagerSimple;

public class ProductDescriptionStepDefs extends TestBase{

	TestContextUI testContextUI;
	Scenario scn;
	
	public ProductDescriptionStepDefs(TestContextUI testContextUI) {
		this.testContextUI = testContextUI;
	}
	
	
	
}
