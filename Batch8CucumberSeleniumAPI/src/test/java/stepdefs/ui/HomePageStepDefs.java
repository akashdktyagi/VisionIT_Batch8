package stepdefs.ui;

import java.util.List;

import context.TestContextUI;
import cucumber.api.Scenario;
import cucumber.api.java.en.Then;

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
}
