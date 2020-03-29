package stepdefs.api;

import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.TestBase;

public class PostRequestStepDefs extends TestBase {


	String email = GetRandomString(10) + "@gmail.com";
	
	//RequestSpecification req_spec=null;
	//Response resp=null;


	@Given("I set header and body to create new user")
	public void i_set_header_and_body_to_create_new_user() {

		
		
		HashMap<String,String> hm_header = new HashMap<String,String>();
		hm_header.put("Content-Type", "application/json");

		String body_string = "{\n" + 
				"	\"gender\":\"female\",\n" + 
				"	\"last_name\":\"lastnamevisionit\",\n" + 
				"	\"first_name\":\"firstnamevisionit\",\n" + 
				"	\"email\":\""+ email +"\"\n" + 
				"}";
		
		req_spec.headers(hm_header).body(body_string);
		
	}

	@When("I hit the api with post request and end point as {string}")
	public void i_hit_the_api_with_post_request_and_end_point_as(String endPoint) {
		resp = req_spec.when().post(endPoint);
		System.out.println(resp.asString());
	}

	@Then("API created a new User in the system")
	public void api_created_a_new_User_in_the_system() {
		resp.then()
		.statusCode(302)
		.assertThat()
		.body("_meta.success", equalTo(true))
		.body("_meta.code", equalTo(201))
		.body("_meta.message", equalTo("A resource was successfully created in response to a POST request. The Location header contains the URL pointing to the newly created resource."))
		.body("result.first_name", equalTo("firstnamevisionit"))
		.body("result.last_name", equalTo("lastnamevisionit"))
		.body("result.gender", equalTo("female"))
		.body("result.email", equalTo(email))
		.body("result.dob", equalTo(null));

	}

	@Then("I can find the new user in the system when i get the user")
	public void i_can_find_the_new_user_in_the_system_when_i_get_the_user() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
}
