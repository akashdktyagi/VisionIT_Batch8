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
	public void i_search_Product_and_click_on_Search_Button(DataTable products) {
	 List<String> data = new ArrayList<String>();
	 for(int i=0;i<data.size();i++) {
		 testContextUI.getCmnPageObjects().SetSearchTextBox(null); 
	 }
	   
	}

	@And("I Select product from the list and click on it")
	public void i_Select_product_from_the_list_and_click_on_it(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    throw new cucumber.api.PendingException();
	}

	@Then("Page is nevigating to new window")
	public void page_is_nevigating_to_new_window() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("I Validate product description and detail")
	public void i_Validate_product_description_and_detail() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("I Click on Add to Cart")
	public void i_Click_on_Add_to_Cart() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	
/*	@When("I search Products and click Search")
	public void i_search_Products_and_click_search(List<HashMap<String,String>> list1) {
		String products = list1.get(0).get("Products");
		testContextUI.getCmnPageObjects().SetSearchTextBox(products);
		testContextUI.getCmnPageObjects().ClickOnSearchButton();
		scn.write("Search was sucessfull");
		
	}

		@Then("product list should appear pertaining to the product search")
		public void product_list_should_appear_pertaining_to_the_product_search_as(List<HashMap<String,String>> list2) {
			String productName = list2.get(0).get("ProductsName");
			testContextUI.getSearchPageObjects().ValidateProductList(productName);
			testContextUI.getSearchPageObjects().ClickOnProductLink();
			switchToSecondWindowTab();
			
		}
			
	@And("And I am able to see product description and detail in new tab")
	public void i_am_able_to_see_product_description_and_detail_in_new_tab() {
		
	}

	@And("Click on Add to Cart and Process to Buy the Products")
	public void click_on_add_to_Cart_and_Process_to_Buy_the_Products() {
		testContextUI.getCmnPageObjects().ClickOnAddToCart();
		testContextUI.getCmnPageObjects().proceedToBuyProduts();
	   
	}

	@And("Page is Nevigated to Login Enter Valid Credentails and login")
	public void page_Nevigate_to_Login_Enter_Valid_Credentails_and_login() {
	
	}

*/

}
