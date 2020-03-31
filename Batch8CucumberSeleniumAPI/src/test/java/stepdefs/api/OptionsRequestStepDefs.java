package stepdefs.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import java.util.HashMap;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import utils.TestBase;
import utils.api.CmnApiMethods;

public class OptionsRequestStepDefs extends TestBase {
	
	Scenario scn;

	@Before
	public void SetUp(Scenario s) {
		this.scn = s;
	}
	
	@When("I hit the api with options request")
	public void i_hit_the_api_with_options_request() {
		resp = req_spec.when().options("/public-api/users/6199"); //hard coded user used for now
		scn.write("Response Put Request: " + resp.asString());
	}

	@Then("API should return the list of available methods")
	public void api_should_return_the_list_of_available_methods() {
		resp.then().assertThat().body("_meta.allow", equalTo("GET, PUT, PATCH, DELETE, HEAD, OPTIONS"));
	}
}
