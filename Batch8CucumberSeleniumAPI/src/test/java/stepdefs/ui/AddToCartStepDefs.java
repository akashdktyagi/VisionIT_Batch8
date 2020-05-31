package stepdefs.ui;

import context.TestBase;
import context.TestContextUI;
import cucumber.api.Scenario;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddToCartStepDefs extends TestBase {

	TestContextUI testContextUI;
	Scenario scn;

	public AddToCartStepDefs(TestContextUI testContextUI) {
		this.testContextUI = testContextUI;
	}

	
	@When("I click on Add to Cart button")
	public void i_click_on_Add_to_Cart_button() {
		testContextUI.getDriver().switchTo().window((String) testContextUI.getDriver().getWindowHandles().toArray()[1]);
		testContextUI.getAddToCartObjects().ClickOnAddToCartButton();
		}

	@Then("Count Of The Cart Should Be Displayed As {int}")
	public void count_Of_The_Cart_Should_Be_Displayed_As(Integer int1) {
		testContextUI.getAddToCartObjects().ValidateCartSubtotal();
	}

	@Then("I click on Cart")
	public void i_click_on_Cart() {
		testContextUI.getAddToCartObjects().ClickOnCart();
	}

	@Then("User Should Be Able To Navigate To Cart Window With The Product Added")
	public void user_Should_Be_Able_To_Navigate_To_Cart_Window_With_The_Product_Added() {
		testContextUI.getAddToCartObjects().ValidateNavigatedToCartWindowWithproductAdded(); 
	}


}
