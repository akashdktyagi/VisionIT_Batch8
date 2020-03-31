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

public class PatchRequestStepDefs extends TestBase {

	String newUserID = null;
	
	Scenario scn;
	String email = GetRandomString(10) + "@gmail.com";
	
	@Before
	public void SetUp(Scenario s) {
		this.scn = s;
	}

	@When("I hit the api with patch request to update the existing user details")
	public void i_hit_the_api_with_patch_request_to_update_the_existing_user_details() {

		HashMap<String,String> hm_header = new HashMap<String,String>();
		hm_header.put("Content-Type", "application/json");

		String body_string = "{\n" + 
				"	\"email\":\""+ email +"\"\n" + 
				"}";
		scn.write("body sent as: " +  body_string);
		
		req_spec.headers(hm_header).body(body_string);	
		
		scn.write("End Point: " + "/public-api/users/" + newUserID);
		resp = req_spec.when().put("/public-api/users/" + newUserID);
		scn.write("Response Patch Request: " + resp.asString());
	}

}
