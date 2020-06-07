package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import cucumber.api.Scenario;
import junit.framework.Assert;
import utils.ui.Interact;

public class AddToCartObjects extends Interact {
	Scenario scn;
	
	public AddToCartObjects(WebDriver driver,Scenario s) {
		setDriver(driver);
		this.scn = s;
	}
	
	
	private By add_to_cart_button = By.id("add-to-cart-button");
	private By cart_subtotal = By.id("attach-accessory-cart-total-string");
	private By cart_button = By.xpath("//form[@id='attach-view-cart-button-form']//input[@class='a-button-input']");
	private By validate_cart_window = By.xpath("//div[@id='sc-active-cart']//div[@class='a-row']//h2");
	private By product_added_inCartWindow = By.id("sc-subtotal-label-activecart");
	public void ClickOnAddToCartButton() {
		clickElement(add_to_cart_button);
		scn.write("Clicked on Add_TO_Cart Button");
	}
	public void ValidateCartSubtotal() {
		if (getText(cart_subtotal).toLowerCase().contains("1 item")) {
			Assert.assertTrue(true);
			scn.write("Count Of The Cart Displayed As 1");
		}else {
			Assert.fail("Count Of The Cart not Displayed As 1");
		}
	}
	public void ClickOnCart() {
		clickElement(cart_button);
		scn.write("Clicked on Cart Button");
	}
	@SuppressWarnings("deprecation")
	public void ValidateNavigatedToCartWindowWithproductAdded() {
		String expected="Shopping Cart";
		String actual=getText(validate_cart_window);
		Assert.assertEquals(expected, actual);
		scn.write("User Navigated to Cart Window");
		
		if (getText(product_added_inCartWindow).toLowerCase().contains("1 item")) {
			Assert.assertTrue(true);
			scn.write("Product added in cart window");
		}else {
			Assert.fail("Product not added in cart window");
		}
			
	}
	
	
	
	
}
