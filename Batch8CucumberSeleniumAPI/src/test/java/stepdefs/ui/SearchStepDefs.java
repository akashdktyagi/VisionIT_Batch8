package stepdefs.ui;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchStepDefs {

	String url = "https://www.amazon.in/";
	WebDriver driver=null;
	
	@Given("I have browser opened and url is navigated")
	public void i_have_browser_opened_and_url_is_navigated() {
		driver = new ChromeDriver();
		driver.get(url);
	}

	@When("I search for product as {string}")
	public void i_search_for_product_as(String product) {
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys(product);
		
		WebElement searchbutton = driver.findElement(By.xpath("//input[@value='Go']"));
		searchbutton.click();
		
	}

	@Then("product list should appear pertaining to the product search as {string}")
	public void product_list_should_appear_pertaining_to_the_product_search_as(String productName) {

		WebElement productDescp = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		String desp = productDescp.getText();
		
		if (desp.contains(productName)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse("Product no correctly displayed in the search result", true);
		}
		
	}
	
}
