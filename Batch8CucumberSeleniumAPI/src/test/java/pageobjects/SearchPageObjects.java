package pageobjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.Scenario;
import utils.ui.Interact;

public class SearchPageObjects extends Interact {

	Scenario scn;
	
	private By product_list = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
	private By product_list_all = By.xpath("//div[@class='s-result-list s-search-results sg-row']//span[@class='a-size-medium a-color-base a-text-normal']");
	
	public SearchPageObjects(WebDriver driver,Scenario s) {
		setDriver(driver);
		this.scn = s;
	}
	
	public String ClickOnProductLink() {
		List<WebElement> list = getListOfWebElements(product_list_all);
		clickElement(list.get(0));
		scn.write("Clicked on First Product Link");
		return list.get(0).getText();
	}
	
	public String ClickOnProductLink(int productIndex) {
		List<WebElement> list = getListOfWebElements(product_list_all);
		clickElement(list.get(productIndex));
		scn.write("Clicked on Product id: " + productIndex + " Product Link");
		return list.get(productIndex).getText();
	}
	
	public String ClickOnProductLink(String productTextContains) {
		List<WebElement> list = getListOfWebElements(product_list_all);
		boolean flag=false;
		int counter=0;
		for(int i=0;i<list.size();i++) {
			if (list.get(i).getText().contains(productTextContains)) {
				clickElement(list.get(i));
				counter=i;
				flag=true;
				break;
			}
		}
		
		if (flag) {
			scn.write("Clicked on Product containing text as: " + productTextContains + "");
		}else {
			scn.write("Unable to click on Product containing text as: " + productTextContains + " No product found with mentioned text");
			Assert.fail("Unable to click on Product containing text as: " + productTextContains + " No product found with mentioned text");
		}
		
		return list.get(counter).getText();

	}
	
	
	public String ClickOnProductLinsdsfsffdk(String productTextContains) {


		int counter=0;
		for(int i=0;i<list.size();i++) {
			if (list.get(i).getText().contains(productTextContains)) {
				clickElement(list.get(i));
				counter=i;
				flag=true;
				break;
			}
		}
		
		if (flag) {
			scn.write("Clicked on Product containing text as: " + productTextContains + "");
		}else {
			scn.write("Unable to click on Product containing text as: " + productTextContains + " No product found with mentioned text");
			Assert.fail("Unable to click on Product containing text as: " + productTextContains + " No product found with mentioned text");
		}
		
		return list.get(counter).getText();

	}
	
	
	public void ValidateProductList(String productName) {
	
		List<WebElement> list_products = getListOfWebElements(product_list);
		for (int i=0;i<list_products.size();i++) {
			if (list_products.get(i).getText().toLowerCase().contains(productName.toLowerCase())) {
				Assert.assertTrue(true);
			}else {
				Assert.fail("Product not correctly displayed in the search result. Product at index: " + (i+1));
			}
		}
		
	}
}
