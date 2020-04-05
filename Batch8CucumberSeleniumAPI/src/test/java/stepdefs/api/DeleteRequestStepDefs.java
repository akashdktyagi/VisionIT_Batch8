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

public class DeleteRequestStepDefs extends TestBase {
	
	String email = GetRandomString(10) + "@gmail.com";
	
	TestContext testContext;
	
	public DeleteRequestStepDefs(TestContext testContext) {
		this.testContext = testContext;
	}
	
	@When("I hit the api with delete request")
	public void i_hit_the_api_with_delete_request() {

		testContext.resp= testContext.req_spec.when().delete("/public-api/users/" + testContext.newUserID + "4553555");
		testContext.scn.write("Response of Delete Request: " + testContext.resp.asString());
	}

	@Then("API should delete the user")
	public void api_should_delete_the_user() {
		testContext.resp.then()
		.assertThat()
		.body("_meta.success", equalTo(false))
		.body("_meta.code", equalTo(204))
		.body("_meta.message", equalTo("The request was handled successfully and the response contains no body content."))
		.body("result", equalTo(null));
		
	}

	@Then("get request to the user should not return the user")
	public void get_request_to_the_user_should_not_return_the_user() {
		Response resp_get = given()
				.baseUri(server)
				.auth().oauth2(accessToken)
				.when()
				.get("/public-api/users/" + testContext.newUserID);
		testContext.scn.write("get reponse after delete: " + resp_get.asString());
		
		resp_get.then()
				.assertThat()
				.body("_meta.success", equalTo(false))
				.body("_meta.code", equalTo(404))
				.body("_meta.message",equalTo("The requested resource does not exist."))
				.body("result.name", equalTo("Not Found"))
				.body("result.message", equalTo("Object not found: " + testContext.newUserID));
	}

}
