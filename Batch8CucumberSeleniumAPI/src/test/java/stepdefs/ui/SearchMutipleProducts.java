package stepdefs.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import context.TestContextUI;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import utils.ui.Interact;

public class SearchMutipleProducts extends Interact {
	TestContextUI testContextUI;
	Scenario scn;

	@When("I search Product and click on Search Button")
	public void i_search_Product_and_click_on_Search_Button(List<String> list) {
		try {
			for (int i = 0; i < list.size(); i++) {
				testContextUI.getCmnPageObjects().SetSearchTextBox(list.get(i));
				testContextUI.getCmnPageObjects().ClickOnSearchButton();

			}
		} catch (NullPointerException e) {
			System.out.println("NullPointerException thrown!");
		}

	}

	@And("I Select product from the list and click on it")
	public void i_Select_product_from_the_list_and_click_on_it(List<String> list1) {

		testContextUI.getSearchPageObjects().ClickOnProductLink();
	}

	@Then("Page is nevigating to new window")
	public void page_is_nevigating_to_new_window() {
		testContextUI.getDriver().switchTo().window((String) testContextUI.getDriver().getWindowHandles().toArray()[1]);
	}

	@Then("I Validate product description and detail")
	public void i_Validate_product_description_and_detail() {

	}

	@Then("I Click on Add to Cart")
	public void i_Click_on_Add_to_Cart() {
		testContextUI.getCmnPageObjects().ClickOnAddToCart();
		testContextUI.getDriver().close();
		testContextUI.getDriver().switchTo().window((String) testContextUI.getDriver().getWindowHandles().toArray()[0])
				.navigate().refresh();
		testContextUI.getCmnPageObjects().CleartextBox();
	}

	@Then("I Click on cart and Processed to Buy Products")
	public void i_Click_on_cart_and_Processed_to_Buy_Products() {
		testContextUI.getCmnPageObjects().ClickOnCart();
		testContextUI.getCmnPageObjects().proceedToBuyProduts();
	}

}
