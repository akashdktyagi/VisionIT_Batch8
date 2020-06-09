package stepdefs.ui;

import java.util.List;

import context.TestContextUI;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStepDefs {

	TestContextUI testContextUI;
	Scenario scn;
	String expectedProductName;

	public HomePageStepDefs(TestContextUI testContextUI) {
		this.testContextUI = testContextUI;
	}

	@Then("Below header Links are displayed")
	public void below_header_Links_are_displayed(List<String> list) throws Exception {

		for (int i=0;i<list.size();i++) {
			testContextUI.getCmnPageObjects().validateElementPresentInHeaderSection(list.get(i));	
		}

	}
	
	@When("I move mouse on the {string}")
	public void i_move_mouse_on_the(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@When("I click on {string} Link in the Accounts and Links Fly Out Pop up")
	public void i_click_on_Link_in_the_Accounts_and_Links_Fly_Out_Pop_up(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("I navigate to {string} Page")
	public void i_navigate_to_Page(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
	
	@Given("I click on {string}")
	public void i_click_on(String category) {
		testContextUI.getHomePageObjects().ClickOnProductCategory(category);
	}

	@When("I click on any product in the list")
	public void i_click_on_any_product_in_the_list() {
		expectedProductName = testContextUI.getHomePageObjects().ClickOnFirstProductInTheList();
	}

	@Then("I am able to see product description and details")
	public void i_am_able_to_see_product_description_and_details() {
		testContextUI.getProductDescriptionObjects().ValidateProductDescriptionHeader(expectedProductName);
	}
}
