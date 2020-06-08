package stepdefs.ui;

import org.openqa.selenium.WebDriver;

import context.AmazonBase;
import context.TestBase;
import context.TestContextUI;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.LandingAmazon;
import pageobjects.LoginAmazonPage;
import utils.manager.driver.factory.DriverFactory;
import utils.manager.driver.factory.DriverManager;

public class AmazonStefDef extends AmazonBase{
	
	


	 @Given("^Enter url and page is navigated to Login page$")
	    public void enter_url_and_page_is_navigated_to_login_page() throws Throwable {
		 DriverManager driverManager = DriverFactory.getDriverManager("chrome");
			WebDriver driver = driverManager.getDriver();
			driverManager.maximizeBrowser();
			driverManager.navigateToDriver(browser);

	    }

	    @When("^ user Click on Login link in home page to land on sign in page$")
	    public void iser_click_on_login_link_in_home_page_to_land_on_sign_in_page() throws Throwable {
	    	LandingAmazon l1=new LandingAmazon();
			l1.getlogin();
			l1.a1.build().perform();
			
	    }

	    @Then("^ User enter valid Email_Id and Password$")
	    public void user_enter_valid_emailid_and_password(String usernmae, String wrergr) throws Throwable {
	    	
	    	
	    	LoginAmazonPage l2=new LoginAmazonPage();
			l2.getemail().sendKeys("username");
			l2.continues().click();
			l2.password().sendKeys("12345");
	    }

	    @And("^User  is succesfully  login  to page$")
	    public void user_is_succesfully_login_to_page() throws Throwable {
	    	
	    	
			LoginAmazonPage l2=new LoginAmazonPage();
			
			l2.login().click();
	    	    }

	}
	

