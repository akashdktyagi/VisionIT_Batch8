package stepdefs.ui;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.CmnPageObjects;
import pageobjects.SearchPageObjects;

public class SearchStepDefs {

	String url = "https://www.amazon.in/";
	WebDriver driver=null;
	CmnPageObjects cmnPageObjects = null;
	SearchPageObjects searchPageObjects = null;
	
	@Given("I have browser opened and url is navigated")
	public void i_have_browser_opened_and_url_is_navigated() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}

	@When("I search for product as {string}")
	public void i_search_for_product_as(String product) {
		cmnPageObjects = new CmnPageObjects(driver);
		cmnPageObjects.SetSearchTextBox(product);
		cmnPageObjects.ClickOnSearchButton();
		
	}

	@Then("product list should appear pertaining to the product search as {string}")
	public void product_list_should_appear_pertaining_to_the_product_search_as(String productName) {
		searchPageObjects = new SearchPageObjects(driver);
		searchPageObjects.ValidateProductList(productName);
	}
	
	
	@After
	public void CleanUp() {
		driver.quit();
	}
	
}
