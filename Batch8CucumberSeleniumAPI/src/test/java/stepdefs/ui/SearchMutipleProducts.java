package stepdefs.ui;

import java.util.ArrayList;
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
	public void i_search_Products(ArrayList<String> arraylist1) {
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
		arraylist1.add("Mobile");
		arraylist1.add("Computer");
		arraylist1.add("LED TV");
		arraylist1.add("Pantry");
		arraylist1.add("Kitchen");
		arraylist1.add("toy train");
		arraylist1.add("toy cars");
		arraylist1.add("sport shoes for mens");
		arraylist1.add("gogless for boys");
		arraylist1.add("books in hindi best seller");
		
	}

	@When("Click on Search")
	public void click_on_Search() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@When("Select product from the {string} list and Click on Product")
	public void select_product_from_the_list_and_Click_on_Product(String string, io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    throw new cucumber.api.PendingException();
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
