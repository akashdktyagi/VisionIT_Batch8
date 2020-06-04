package stepdefs.ui;

import java.util.List;

import context.TestContextUI;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddToCartStepDefs {

	TestContextUI testContextUI;
	Scenario scn;
	Integer proIndex;

	public AddToCartStepDefs(TestContextUI testContextUI) {
		this.testContextUI = testContextUI;
	}
	
	@Given("I search the products given below and add them to cart")
	public void i_search_the_products_given_below_and_add_them_to_cart(List<String> list) throws Exception {
	   
		for(int i=0;i<list.size();i++) {
	
			//search and click on search btn
			testContextUI.getCmnPageObjects().SetSearchTextBox(list.get(i));
			testContextUI.getCmnPageObjects().ClickOnSearchButton();
			
		    //select first product in the list displayed
			 i_click_on_first_product_in_the_Search_Result();
			
			//add product to the cart
			 i_click_on_Add_To_Cart_button();
			 
			 testContextUI.getDriver().close();
		   	 testContextUI.getDriver().switchTo().window((String)testContextUI.getDriver().getWindowHandles().toArray()[0]).navigate().refresh();
			 testContextUI.getCmnPageObjects().ClearSearchTextBox();

		}	
	}
		
	@And("I click on first product in the Search Result")
	public void i_click_on_first_product_in_the_Search_Result() {
		 testContextUI.getSearchPageObjects().ClickOnProductLink();
	}
	
	@And("I click on Add To Cart button")
	public void i_click_on_Add_To_Cart_button() throws Exception {
		testContextUI.getDriver().switchTo().window((String)testContextUI.getDriver().getWindowHandles().toArray()[1]);
   		testContextUI.getAddToCartPageObjects().ClickOnAddToCartBtn();
   		Thread.sleep(15000);
	}
	
	@When("I click on the Cart button present in the Header section")
	public void i_click_on_the_Cart_button_present_in_the_Header_section() {
		testContextUI.getAddToCartPageObjects().ClickOnCartBtn();
	}

	@When("I click on Delete button for {string} Product")
	public void i_click_on_Delete_button_for_Product(String proName) {
		testContextUI.getAddToCartPageObjects().ClickOnDeleteBtnForDell();
	}

	@Then("I validate the Subtotal as {int} item")
	public void i_validate_the_Subtotal_as_item(Integer int1) {
		testContextUI.getAddToCartPageObjects().ValidateSubTotalAfterDeletion();
	}

}
