package pageobjects;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import cucumber.api.Scenario;
import utils.ui.Interact;
public class ProductDescriptionObjects extends Interact {
	Scenario scn;

	private By product_header_element = By.xpath("//span[@id='productTitle']']");
	private By Add_To_cart_Button=By.id("add-to-cart-button");


	public ProductDescriptionObjects(WebDriver driver,Scenario s) 
	{
		setDriver(driver);
		this.scn = s;
	}


	public void ValidateProductDescriptionHeader(String expected) 
	{
		String actual = getText(product_header_element);
		scn.write("actual: " + actual + " , Expected: " + expected);
		Assert.assertEquals("Product Header", expected.trim(), actual.trim());
	}

	public void ClickOnAddToCartButton()
	{
		clickElement(Add_To_cart_Button);
	}

}
