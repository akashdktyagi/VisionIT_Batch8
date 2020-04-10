package pageobjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPageObjects {

	WebDriver driver;
	
	private By product_list = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
	
	public SearchPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public void ValidateProductList(String productName) {
	
		List<WebElement> list_products = driver.findElements(product_list);
		
		for (int i=0;i<list_products.size();i++) {
			if (list_products.get(i).getText().toLowerCase().contains(productName.toLowerCase())) {
				Assert.assertTrue(true);
			}else {
				Assert.fail("Product not correctly displayed in the search result. Product at index: " + (i+1));
			}
		}
		
	}
}
