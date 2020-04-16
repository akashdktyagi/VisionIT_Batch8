package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import cucumber.api.Scenario;
import utils.ui.Interact;

public class CmnPageObjects extends Interact {
	
	Scenario scn;
	
	private By search_text_box = By.id("twotabsearchtextbox");
	private By search_button = By.xpath("//input[@value='Go']");
	
	public CmnPageObjects(WebDriver driver, Scenario s) {
		setDriver(driver);
		this.scn = s;
	}
	
	public void SetSearchTextBox(String text) {
		setElement(search_text_box, text);
	}
	
	public void ClickOnSearchButton() {
		clickElement(search_button);
	}
	
}
