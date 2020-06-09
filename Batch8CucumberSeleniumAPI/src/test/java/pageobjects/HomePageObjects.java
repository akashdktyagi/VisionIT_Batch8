package pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.Scenario;
import utils.ui.Interact;

public class HomePageObjects extends Interact {
	
	private static final Logger logger = LogManager.getLogger(HomePageObjects.class);
	Scenario scn;

	private String product_category = "//a[ contains(@aria-label,'%s')]";
	private By product_list = By.xpath("//span[@class='a-truncate a-size-base']");
	
	public HomePageObjects(WebDriver driver, Scenario s) {
		setDriver(driver);
		this.scn = s;
	}
	
	public void ClickOnProductCategory(String proName) {
		By by_element = By.xpath(String.format(product_category, proName));
		clickElement(by_element);
		scn.write("Clicked on Product Category link: " + proName);
		logger.info("Clicked on Product Category link: " + proName);
	}
	
	public String ClickOnFirstProductInTheList() {
		List<WebElement> list = getListOfWebElements(product_list);
		clickElement(list.get(0));
		scn.write("Clicked on first Product in the list");
		logger.info("Clicked on first Product in the list");
		return list.get(0).getText();
	}
	
}
