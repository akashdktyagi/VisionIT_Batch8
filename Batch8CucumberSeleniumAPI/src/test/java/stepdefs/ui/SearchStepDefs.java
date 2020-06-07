package stepdefs.ui;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import context.TestBase;
import context.TestContextUI;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.manager.driver.factory.DriverFactory;
import utils.manager.driver.factory.DriverManager;

public class SearchStepDefs extends TestBase{
	TestContextUI testContextUI;
	Scenario scn;
	String productClickedTextExpected;

	public SearchStepDefs(TestContextUI testContextUI) {
		this.testContextUI = testContextUI;
	}

	@Given("^I have browser opened and url is navigated$")
	public void i_have_browser_opened_and_url_is_navigated() throws Exception {	

		/* Various ways of invoking Web Driver*/
		/* Method - 1*/
		DriverManager driverManager = DriverFactory.getDriverManager("chrome");
		WebDriver driver = driverManager.getDriver();
		driverManager.maximizeBrowser();
		driverManager.navigateToDriver(serverUI);

		/* OR Mehtod - 2*/
		/*
		 *WebDriver driver = new ChromeDriver();
		 *driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		 *driver.manage().window().maximize();
		 *driver.get(serverUI);
		 */

		/* OR Mehtod - 3*/
		/*
		 WebDriver driver = WebDriverManagerSingleton.getInstanceOfWebDriverManager().getDriver();
		 */

		/* OR Mehtod - 4*/
		/*
		WebDriver driver = WebDriverManagerSimple.getDriver("chrome");
		 */
		scn.write("Chrome Driver invoked and URL navigated as: " + serverUI);
		//Assign driver and set page Objects to Test Context 
		testContextUI.setDriver(driver);
		testContextUI.initializePageObjectClasses(driver, scn);
	}

	@When("I search for product as {string}")
	public void i_search_for_product_as(String product) {
		testContextUI.getCmnPageObjects().SetSearchTextBox(product);
		testContextUI.getCmnPageObjects().ClickOnSearchButton();
		scn.write("Search was sucessfull");	
	}

	@Then("product list should appear pertaining to the product search as {string}")
	public void product_list_should_appear_pertaining_to_the_product_search_as(String productName) {
		testContextUI.getSearchPageObjects().ValidateProductList(productName);
	}
	
	@Then("Search result should displayed {string}")
	public void search_result_should_displayed_Try_Checking_Your_Spelling_Or_Use_More_General_Term(String productName) {
		testContextUI.getSearchPageObjects().ValidateInvalidateProductMessage(productName);
	}

	@When("I click on hamburger menu")
	public void i_click_on_hamburger_menu() {
		testContextUI.getCmnPageObjects().ClickOnHamburgerMenuButton();
	}

	@When("I click on hamburger menu with category as {string}")
	public void i_click_on_hamburger_menu_with_category_as(String category) {
		testContextUI.getCmnPageObjects().ClickOnHamburgerMenuProductCategoryLink(category);
	}

	@When("I click on hamburger menu with sub category as {string}")
	public void i_click_on_hamburger_menu_with_sub_category_as(String subCategory) {
		testContextUI.getCmnPageObjects().ClickOnHamburgerMenuProductSubCategoryLink(subCategory);
	}

	@Then("Search results are displayed for products related to {string}")
	public void search_results_are_displayed_for_products_related_to(String expectedTitle) throws Exception {
		testContextUI.getCmnPageObjects().validatePageTitleMatch(expectedTitle);
	}

	@When("I click on any product in the Search Result")
	public void i_click_on_any_product_in_the_Search_Result() {
		productClickedTextExpected = testContextUI.getSearchPageObjects().ClickOnProductLink();
	}

	@Then("I am able to see product description and detail in new tab")
	public void i_am_able_to_see_product_description_and_detail_in_new_tab() {
		testContextUI.getProductDescriptionObjects().switchToSecondWindowTab();
		testContextUI.getProductDescriptionObjects().ValidateProductDescriptionHeader(productClickedTextExpected);
		testContextUI.getProductDescriptionObjects().switchToDefaultWindowTab();	
	}

	@Before
	public void SetUp(Scenario s) {
		this.scn = s;
	}

	@After
	public void CleanUp(Scenario s) {	
		if (s.isFailed()) {
			TakesScreenshot scrnShot = (TakesScreenshot)testContextUI.getDriver();
			byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
			scn.embed(data, "image/png");
		}
		testContextUI.getDriver().quit();
		scn.write("Browser is Closed");
	}

}
