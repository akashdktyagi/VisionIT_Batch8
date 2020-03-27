package trial.junit.api.gorest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import java.util.HashMap;
import java.util.Random;

import org.junit.Test;

import io.restassured.response.Response;
import utils.TestBase;
public class TC_PostRequest extends TestBase {

	String server = LoadProperties().getProperty("url");
	String accessToken = LoadProperties().getProperty("token");
	
	@Test
	public void t_01_post_create_new_user() {
		
		//Get Random String for Email
		String email = GetRandomString(10) + "@gmail.com";
		
		
		//Set Header
		HashMap<String,String> hm_header = new HashMap<String,String>();
		hm_header.put("Content-Type", "application/json");
		
		//Set Body
		String body_string = "{\n" + 
				"	\"gender\":\"female\",\n" + 
				"	\"last_name\":\"lastnamevisionit\",\n" + 
				"	\"first_name\":\"firstnamevisionit\",\n" + 
				"	\"email\":\""+ email +"\"\n" + 
				"}";
		

		//post and fetch response
		Response resp = given()
		.baseUri(server)
		.auth().oauth2(accessToken)
		.headers(hm_header)
		.body(body_string)
		.when()
		.post("/public-api/users");
		
		System.out.println("Response for this Post Request is: " + resp.asString());
		
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

		
		//fire a get and check post has successfully created the data
		String id = resp.jsonPath().getString("result.id");
		Response resp_get = given()
				.baseUri(server)
				.auth().oauth2(accessToken)
				.when()
				.get("/public-api/users/" + id)
				.then()
				.assertThat()
				.statusCode(200)
				.body("_meta.success", equalTo(true))
				.body("_meta.code", equalTo(200))
				.body("_meta.message",equalTo("OK. Everything worked as expected."))
				.body("result", not(emptyArray()))
				.body("result.first_name", equalTo("firstnamevisionit"))
				.body("result.last_name", equalTo("lastnamevisionit"))
				.body("result.gender", equalTo("female"))
				.body("result.email", equalTo(email))
				.body("result.dob", equalTo(null))
				.extract()
				.response();
		
		System.out.println("Response for the get Request: " + resp_get.asString());
		
		
		//Validate the User creation  from UI
		//Write Selenium code
		
	}
	

	
}


