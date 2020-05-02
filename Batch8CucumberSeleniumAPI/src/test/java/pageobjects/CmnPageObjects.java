package pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import cucumber.api.Scenario;

import utils.ui.Interact;

public class CmnPageObjects extends Interact {
	private static final Logger logger = LogManager.getLogger(CmnPageObjects.class);
	Scenario scn;

	private By search_text_box = By.id("twotabsearchtextbox");
	private By search_button = By.xpath("//input[@value='Go']");
	private By hamburger_menu_link =  By.id("nav-hamburger-menu");
	private By nav_link_logo =  By.xpath("//a[@class='nav-logo-link']");
	private By nav_link_cart =  By.id("nav-cart");
	private By nav_link_prime =  By.id("nav-link-prime");
	private By nav_link_orders =  By.id("nav-orders");
	private By nav_link_acount =  By.id("nav-link-accountList");


	public CmnPageObjects(WebDriver driver, Scenario s) {
		setDriver(driver);
		this.scn = s;
	}

	public void SetSearchTextBox(String text) {
		setElement(search_text_box, text);
		logger.info("Value enetered in search box: " + text);
		takeScreenShotAndAttachInReport(scn);
	}

	public void ClickOnSearchButton() {
		try {
			clickElement(search_button);	
			logger.info("Clicked on Search Button");
		}catch(Exception e) {
			logger.error("Exception occured while tring to click on search button. Exception: " + e.getMessage());
		}

	}

	public void validateHamBurgerMenuIsDisplayed() {
		boolean b = validateElementIsDisplayed(hamburger_menu_link);
		Assert.assertEquals(true, b);
	}

	public void validateAmazonLogo() {
		boolean b = validateElementIsDisplayed(nav_link_logo);
		Assert.assertEquals(true, b);
	}

	public void validateElementPresentInHeaderSection(String text) throws Exception {
		boolean b=false;
		
		switch(text.toLowerCase().trim()) {
	
			case "hamburger menu":
				b = validateElementIsDisplayed(hamburger_menu_link);
				break;
			case "amazon prime logo":
				b = validateElementIsDisplayed(nav_link_logo);
				break;
			case "accounts and list link":
				b = validateElementIsDisplayed(nav_link_acount);
				break;
			case "return and orders":
				b = validateElementIsDisplayed(nav_link_orders);
				break;
			case "your prime link":
				b = validateElementIsDisplayed(nav_link_prime);
				break;
			case "cart link":
				b = validateElementIsDisplayed(nav_link_cart);
				break;
			case "search text box":
				b = validateElementIsDisplayed(search_text_box);
				break;
			default:
				logger.fatal("Header Link Description is not present in the case. Please add link description first.");
				scn.write("Header Link Description is not present in the case. Please add link description first.");
				throw new Exception("Header Link Description is not present in the case. Please add link description first.");
			}

		if (b) {
			scn.write("Header Link is displayed: " + text);
			Assert.assertEquals(true, b);
		}else {
			scn.write("Header Link is not displayed: " + text);
			Assert.fail("Header Link is not displayed: " + text);
		}

	}

}
