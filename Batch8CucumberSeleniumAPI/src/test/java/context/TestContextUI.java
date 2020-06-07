package context;
import org.openqa.selenium.WebDriver;
import cucumber.api.Scenario;
import pageobjects.*;
public class TestContextUI {
	private WebDriver driver;
	private CmnPageObjects cmnPageObjects;
	private SearchPageObjects searchPageObjects;
	private ProductDescriptionObjects productDescriptionObjects;
	private AddToCartObjects addToCartObjects;

	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public CmnPageObjects getCmnPageObjects() {
		return cmnPageObjects;
	}

	public SearchPageObjects getSearchPageObjects() {
		return searchPageObjects;
	}
	

	public ProductDescriptionObjects getProductDescriptionObjects() {
		return productDescriptionObjects;
	}

	public AddToCartObjects geAddToCartObjects(){
		return addToCartObjects;
	}

	public void initializePageObjectClasses(WebDriver driver,Scenario scn) {
		cmnPageObjects = new CmnPageObjects(driver,scn);
		searchPageObjects = new SearchPageObjects(driver,scn);
		productDescriptionObjects = new ProductDescriptionObjects(driver,scn);
		addToCartObjects = new AddToCartObjects(driver, scn);
	}

}