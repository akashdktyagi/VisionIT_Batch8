package stepdefs.ui;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import context.TestBase;
import context.TestContextUI;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDef extends TestBase{

	TestContextUI testContextUI;
	
	public LoginStepDef(TestContextUI   testContextUI) {                   
		this.testContextUI=testContextUI;                                      
		
		}
	
	Scenario scn; 

	

	    @Given("^enter url  and navigated to brower$")
	    public void enter_url_and_navigated_to_brower() throws Throwable {
	    	WebDriver driver=new ChromeDriver();	
	    	 driver=new ChromeDriver();
	    	 driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
	    	driver.manage().window().maximize();
	    	 driver.get(serverUI);
	    			
	    			
	    		
             scn.write("Chrome Driver invoked and URL navigated as: " + serverUI);
	    	                                                                                      	    			    
	    	testContextUI.setDriver(driver);
	   
	    }

	    @When("^I enter login id  \"([^\"]*)\"and password \"([^\"]*)\"$")
	    public void i_enter_login_id_somethingand_password_something(String username, String password) throws Throwable {
	    	testContextUI.getloginpage().enterusername(username);
	    	testContextUI.getloginpage().enterpassword(password);
	    	
	   	    }

	    @Then("^login page shoud be display and navigated to homepage$")
	    public void login_page_shoud_be_display_and_navigated_to_homepage() throws Throwable {
	    	testContextUI.getloginpage().ClickOnSubmitButton();
	    }

	}
	

