package stepdefs.ui;

import java.util.ArrayList;
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

	public AddToCartStepDefs(TestContextUI testContextUI) {
		this.testContextUI = testContextUI;
	}

	@Given("I have {int} products added in the cart")
	public void i_have_products_added_in_the_cart(Integer proCount) throws Exception {
		for(int i=0; i<proCount; i++) {
			testContextUI.getCmnPageObjects().SetSearchTextBox(ProductList().get(i));
			testContextUI.getCmnPageObjects().ClickOnSearchButton();

			i_click_on_first_product_in_the_Search_Result();
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
		Thread.sleep(10000);
	}

	@When("I delete one product from the cart")
	public void i_delete_one_product_from_the_cart() {
		testContextUI.getAddToCartPageObjects().ClickOnCartBtn();
		testContextUI.getAddToCartPageObjects().DeleteProductLink(0);
	}

	@Then("cart should be updated accordingly")
	public void cart_should_be_updated_accordingly() {
		testContextUI.getAddToCartPageObjects().ValidateSubTotalAfterDeletion();
	}

	public static ArrayList<String> ProductList() {
		ArrayList<String> productList = new ArrayList<String>();
		productList.add("Laptop");
		productList.add("Earphones");
		return productList;
	}

	//***********************for TC0041***********************

	@Given("I search for product as Laptop and add it to cart")
	public void i_search_for_product_as_Laptop_and_add_it_to_cart() throws Exception {
		testContextUI.getCmnPageObjects().SetSearchTextBox("Laptop");
		testContextUI.getCmnPageObjects().ClickOnSearchButton();

		i_click_on_first_product_in_the_Search_Result();
		i_click_on_Add_To_Cart_button();

		testContextUI.getDriver().close();
		testContextUI.getDriver().switchTo().window((String)testContextUI.getDriver().getWindowHandles().toArray()[0]).navigate().refresh();
	}

	@Given("I search for product as Earphones and add it to cart")
	public void i_search_for_product_as_Mobile_and_add_it_to_cart() throws Exception {
		testContextUI.getCmnPageObjects().SetSearchTextBox("Earphones");
		testContextUI.getCmnPageObjects().ClickOnSearchButton();

		i_click_on_first_product_in_the_Search_Result();
		i_click_on_Add_To_Cart_button();

		testContextUI.getDriver().close();
		testContextUI.getDriver().switchTo().window((String)testContextUI.getDriver().getWindowHandles().toArray()[0]).navigate().refresh();
	}

	@When("I click on Delete button")
	public void i_click_on_Delete_button() {
		testContextUI.getAddToCartPageObjects().ClickOnCartBtn();
		testContextUI.getAddToCartPageObjects().ClickOnDeleteBtn();
	}

	@Then("I get message as {string}")
	public void i_get_message_as(String msg) {
		testContextUI.getAddToCartPageObjects().ValidateCartIsEmpty(msg);
	}

}
