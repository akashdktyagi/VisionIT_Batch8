package stepdefs.ui;

import java.util.List;

import org.openqa.selenium.interactions.Actions;

import context.TestContextUI;
import cucumber.api.Scenario;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStepDefs {

	TestContextUI testContextUI;
	Scenario scn;

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

	}

	@When("I click on {string} Link in the  Accounts and Links Fly Out Pop up")
	public void i_click_on_Link_in_the_Accounts_and_Links_Fly_Out_Pop_up(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@Then("I navigate to {string} Page")
	public void i_navigate_to_Page(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

}
