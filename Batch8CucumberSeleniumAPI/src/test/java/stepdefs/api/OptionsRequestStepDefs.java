package stepdefs.api;

import static org.hamcrest.Matchers.equalTo;

import context.TestBaseAPI;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class OptionsRequestStepDefs extends TestBaseAPI {
	
	TestContext testContext;
	
	public OptionsRequestStepDefs(TestContext testContext) {
		this.testContext = testContext;
	}
	
	@When("I hit the api with options request")
	public void i_hit_the_api_with_options_request() {
		testContext.resp = testContext.req_spec.when().options("/public-api/users/6199"); //hard coded user used for now
		testContext.scn.write("Response Put Request: " + testContext.resp.asString());
	}

	@Then("API should return the list of available methods")
	public void api_should_return_the_list_of_available_methods() {
		testContext.resp.then().assertThat().body("_meta.allow", equalTo("GET, PUT, PATCH, DELETE, HEAD, OPTIONS"));
	}
}
