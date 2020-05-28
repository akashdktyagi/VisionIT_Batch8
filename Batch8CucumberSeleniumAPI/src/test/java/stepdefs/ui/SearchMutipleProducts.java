package stepdefs.ui;


import java.util.HashMap;
import java.util.List;

import context.TestContextUI;
import cucumber.api.Scenario;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchMutipleProducts {
	TestContextUI testContextUI;
	Scenario scn;
	
	@When("I search Products")
	public void i_search_Products(List<HashMap<String,String>> list1) {
		/* |Products|
	     |Mobile|
	     |Computer|
	     |LED TV|
	     |Pantry|
	     |Kitchen|
	     |toy train|
	     |toy cars|
	     |sport shoes for mens|
	     |gogless for boys|
	     |books in hindi best seller|
		//dataTable.as
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    throw new cucumber.api.PendingException();
	    */
		String products = list1.get(0).get("Products");
		testContextUI.getCmnPageObjects().SetSearchTextBox(products);
		
	}

	@When("Click on Search")
	public void click_on_Search() {
		testContextUI.getCmnPageObjects().ClickOnSearchButton();
		scn.write("Search was sucessfull");
	}

		@Then("product list should appear pertaining to the product search as {string}")
		public void product_list_should_appear_pertaining_to_the_product_search_as(List<HashMap<String,String>> list2) {
			String productName = list2.get(0).get("Products");
			testContextUI.getSearchPageObjects().ValidateProductList(productName);
			testContextUI.getSearchPageObjects().ClickOnProductLink();
		}
	

	@Then("Click on Add to Cart")
	public void click_on_Add_to_Cart() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("Click on Proceed to Buy the products")
	public void click_on_Proceed_to_Buy_the_products() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("Page Nevigate to Login page")
	public void page_Nevigate_to_Login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("Enter User Email Id or Phone")
	public void enter_User_Email_Id_or_Phone() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("Click on Continue")
	public void click_on_Continue() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("Enter Valid Password")
	public void enter_Valid_Password() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("Click on Login Button")
	public void click_on_Login_Button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}


}
