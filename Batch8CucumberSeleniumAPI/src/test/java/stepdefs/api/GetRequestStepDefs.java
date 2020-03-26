package stepdefs.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import trial.junit.api.gorest.TestBase;

public class GetRequestStepDefs extends TestBase {

	String server = LoadProperties().getProperty("url");
	String accessToken = LoadProperties().getProperty("token");
	
	RequestSpecification req_spec=null;
	Response resp=null;
	
	Scenario scn;
	
	@Before
	public void SetUp(Scenario s) {
		this.scn = s;
	}


	@Given("Go rest API is up and running")
	public void go_rest_API_is_up_and_running() {
		req_spec = given().baseUri(server).auth().oauth2(accessToken);
	}

	@When("I hit the api with get request and end point as {string}")
	public void i_hit_the_api_with_get_request_and_end_point_as(String endPoint) {
		resp = req_spec.when().get(endPoint);
		scn.write("Response of the request is: " + resp.asString() );
		
	}

	@Then("API should return all the users")
	public void api_should_return_all_the_users() {
		resp.then().assertThat()
		.statusCode(200)
		.body("_meta.success", equalTo(true))
		.body("_meta.code", equalTo(200))
		.body("_meta.message",equalTo("OK. Everything worked as expected."))
		.body("result", not(emptyArray()));

	}

	@Then("API should return single user details")
	public void api_should_return_single_user_details() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@Then("API should return all the users with specific pagination value")
	public void api_should_return_all_the_user_with_specific_pagination_value_user() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}


	@After
	public void PostMethod(Scenario s) {

		String filePath = null;
		if (s.isFailed()) {
			//take screen shot
			//filePath = value;
		}
		//s.embed(filepath, mimeType);
	}


}
