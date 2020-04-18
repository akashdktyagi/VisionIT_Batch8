package stepdefs.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.not;
import context.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GetRequestStepDefs extends TestBase {
	
	TestContextAPI testContext;
	
	public GetRequestStepDefs(TestContextAPI testContext) {
		this.testContext = testContext;
	}
	
	@Given("Go rest API is up and running")
	public void go_rest_API_is_up_and_running() {
		testContext.req_spec= given().baseUri(server).auth().oauth2(accessToken);
	}

	@When("I hit the api with get request and end point as {string}")
	public void i_hit_the_api_with_get_request_and_end_point_as(String endPoint) {
		testContext.resp= testContext.req_spec.when().get(endPoint);
		testContext.scn.write("Response of the request is: " + testContext.resp.asString() +"<br>" );

	}

	@Then("API should return all the users")
	public void api_should_return_all_the_users() {
		testContext.resp.then().assertThat()
		.statusCode(200)
		.body("_meta.success", equalTo(true))
		.body("_meta.code", equalTo(200))
		.body("_meta.message",equalTo("OK. Everything worked as expected."))
		.body("result", not(emptyArray()));

	}

	@Then("API should return user details of user id {string}")
	public void api_should_return_single_user_details(String user_id) {
		testContext.resp.then()
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
		testContext.resp.then()
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
		testContext.resp.then()
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
		testContext.resp.then()
		.assertThat()
		.statusCode(200)
		.body("_meta.success", equalTo(true))
		.body("_meta.code", equalTo(200))
		.body("_meta.message",equalTo("OK. Everything worked as expected."))
		.body("result.gender", everyItem(equalTo("female")));
	}

	@Then("API should return all the female users with status as active")
	public void api_should_return_all_the_female_users_with_status_as_active() {
		testContext.resp.then()
		.assertThat()
		.statusCode(200)
		.body("_meta.success", equalTo(true))
		.body("_meta.code", equalTo(200))
		.body("_meta.message",equalTo("OK. Everything worked as expected."))
		.body("result.gender", everyItem(equalTo("female")))
		.body("result.status", everyItem(equalTo("active")));
	}

}
