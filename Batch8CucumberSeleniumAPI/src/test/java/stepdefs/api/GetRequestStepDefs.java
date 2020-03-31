package stepdefs.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.not;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.TestBase;

public class GetRequestStepDefs extends TestBase {

	Scenario scn;
	
	@Before
	public void SetUp(Scenario s) {
		this.scn = s;
	}
	
	@After
	public void CleanUp() {
		req_spec=null;
		resp=null;
	}
	
	@Given("Go rest API is up and running")
	public void go_rest_API_is_up_and_running() {
		req_spec = given().baseUri(server).auth().oauth2(accessToken);
	}

	@When("I hit the api with get request and end point as {string}")
	public void i_hit_the_api_with_get_request_and_end_point_as(String endPoint) {
		resp = req_spec.when().get(endPoint);
		scn.write("Response of the request is: " + resp.asString() +"<br>" );

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

	@Then("API should return user details of user id {string}")
	public void api_should_return_single_user_details(String user_id) {
		resp.then()
		.assertThat()
		.statusCode(200)
		.body("_meta.success", equalTo(true))
		.body("_meta.code", equalTo(200))
		.body("_meta.message",equalTo("OK. Everything worked as expected."))
		.body("result", not(emptyArray()))
		.body("result.id", equalTo(user_id));
	}

	@Then("API should return all the users on page {int} only")
	public void api_should_return_all_the_user_with_specific_page_only(int pageNumber) {
		resp.then()
		.assertThat()
		.statusCode(200)
		.body("_meta.success", equalTo(true))
		.body("_meta.code", equalTo(200))
		.body("_meta.message",equalTo("OK. Everything worked as expected."))
		.body("_meta.currentPage", equalTo(pageNumber))
		.body("result", not(emptyArray()));	
	}

	@Then("API should return user not found response for id {string}")
	public void api_should_return_user_not_found_response(String user_id) {
		resp.then()
		.assertThat()
		.statusCode(200)
		.body("_meta.success", equalTo(false))
		.body("_meta.code", equalTo(404))
		.body("_meta.message",equalTo("The requested resource does not exist."))
		.body("result.name", equalTo("Not Found"))
		.body("result.message", equalTo("Object not found: " + user_id))
		.body("result.code", equalTo(0))
		.body("result.status", equalTo(404));
	}

	@Then("API should return all the female users")
	public void api_should_return_all_the_female_users() {
		resp.then()
		.assertThat()
		.statusCode(200)
		.body("_meta.success", equalTo(true))
		.body("_meta.code", equalTo(200))
		.body("_meta.message",equalTo("OK. Everything worked as expected."))
		.body("result.gender", everyItem(equalTo("female")));
	}

	@Then("API should return all the female users with status as active")
	public void api_should_return_all_the_female_users_with_status_as_active() {
		resp.then()
		.assertThat()
		.statusCode(200)
		.body("_meta.success", equalTo(true))
		.body("_meta.code", equalTo(200))
		.body("_meta.message",equalTo("OK. Everything worked as expected."))
		.body("result.gender", everyItem(equalTo("female")))
		.body("result.status", everyItem(equalTo("active")));
	}

}
