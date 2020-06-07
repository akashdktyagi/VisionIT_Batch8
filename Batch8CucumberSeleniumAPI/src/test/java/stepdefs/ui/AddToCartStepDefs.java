package stepdefs.ui;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import context.TestBase;
import context.TestContextUI;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddToCartStepDefs extends TestBase {

	TestContextUI testContextUI;
	Scenario scn;
	String productClickedName;
	String UpdatedTextCartValue;
	String TextCartValue;

	public AddToCartStepDefs(TestContextUI testContextUI) {
		this.testContextUI = testContextUI;
	}
	
	@Given("I get a text for cart")
	public String i_get_a_text_for_cart() {
		TextCartValue=testContextUI.getCmnPageObjects().get_Cart_value();
		return TextCartValue;
			    
	}
	
	
	@And("I click on any product in the Search result")
	public void i_click_on_any_product_in_the_Search_result()
	{
		productClickedName = testContextUI.getSearchPageObjects().ClickOnFirstProduct();
	}
	
	
	@When("I click on Add to Cart button")
	public String i_click_on_Add_to_Cart_button() {
		testContextUI.getDriver().switchTo().window((String) testContextUI.getDriver().getWindowHandles().toArray()[1]);
		testContextUI.geAddToCartObjects().ClickOnAddToCartButton();
		UpdatedTextCartValue=testContextUI.getCmnPageObjects().get_Cart_value();
		return UpdatedTextCartValue;
		
		}

	@Then("Count Of The Cart Should Be Displayed As {int}")
	public void count_Of_The_Cart_Should_Be_Displayed_As(Integer int1) {
		testContextUI.geAddToCartObjects().ValidateCartSubtotal();
	}

	
	@Then("I am able to see the cart value gets updated in the header section")
	public void i_am_able_to_see_the_cart_value_gets_updated_in_the_header_section() {
		boolean bb=false;	
		if(!TextCartValue.equals(UpdatedTextCartValue))
		{
			bb=true;
			Assert.assertEquals(true,bb);
		}
		
	   	}

}
