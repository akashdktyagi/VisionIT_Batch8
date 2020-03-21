package trial.junit.api.gorest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import java.util.HashMap;
import java.util.Random;

import org.junit.Test;

import io.restassured.response.Response;
public class TC_PostRequest {

	String server = "https://gorest.co.in/";
	String accessToken = "HTnPGhobc6TwQ9ManvI5zKZu9Hg7wGHzceNq";
	
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
		
		
	}
	
	//To get random Key
	public String GetRandomString(int n) {
		// lower limit for LowerCase Letters 
		int lowerLimit = 97; 

		// lower limit for LowerCase Letters 
		int upperLimit = 122; 

		Random random = new Random(); 

		// Create a StringBuffer to store the result 
		StringBuffer r = new StringBuffer(n); 

		for (int i = 0; i < n; i++) { 

			// take a random value between 97 and 122 
			int nextRandomChar = lowerLimit 
					+ (int)(random.nextFloat() 
							* (upperLimit - lowerLimit + 1)); 

			// append a character at the end of bs 
			r.append((char)nextRandomChar); 
		} 

		// return the resultant string 
		return r.toString(); 
	} 
	
}


