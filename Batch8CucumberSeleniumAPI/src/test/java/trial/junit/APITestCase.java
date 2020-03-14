package trial.junit;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class APITestCase {

	String server_name ="http://dummy.restapiexample.com";
	@Test
	public void t_01_get_request() {
		
		given().baseUri("http://dummy.restapiexample.com").
		when().get("/api/v1/employees").
		then().
		assertThat().statusCode(200).
		assertThat().body("status",equalTo("success")).
		assertThat().body("data[0].id",equalTo("1")).
		assertThat().body("data[0].employee_name",equalTo("Tiger Nixon"));
		
	}
	
	@Test
	public void t_02_get_request_breaking_steps() {
		
		RequestSpecification req_spec = given().baseUri(server_name);
		Response response = req_spec.when().get("/api/v1/employees");
		ValidatableResponse valid_response = response.then();
		valid_response.assertThat().statusCode(200).
		assertThat().body("status",equalTo("success")).
		assertThat().body("data[0].id",equalTo("1")).
		assertThat().body("data[0].employee_name",equalTo("Tiger Nixon"));
		
	}
	@Test
	public void t_03_get_request_get_single_employee_detail() {
		RequestSpecification req_spec = given().baseUri(server_name);
		Response response = req_spec.when().get("/api/v1/employee/1");
		ValidatableResponse valid_response = response.then();
		valid_response.assertThat().statusCode(200).
		assertThat().body("status",equalTo("success")).
		assertThat().body("data[0].id",equalTo("1")).
		assertThat().body("data[0].employee_name",equalTo("Tiger Nixon"));
	}
	
	@Test
	public void t_04_get_request_get_incorrect_employee_detail() {
		RequestSpecification req_spec = given().baseUri(server_name);
		Response response = req_spec.when().get("/api/v1/employee/45644454646645654645646egeg");
		ValidatableResponse valid_response = response.then();
		valid_response.assertThat().statusCode(200).
		assertThat().body("status",not(equalTo("success")));

	}
	
	
	@Test
	public void t_05_post_postive_create_new_employee() {
		
		String dynamic_name = GetRandomString(8);
		
		//Body Text
		String body_text = "{\"name\":\"" + dynamic_name + "\",\"salary\":\"123\",\"age\":\"23\"}";
		
		System.out.println("Body Text sent as: " + body_text);
		
		//Header Hash Map
		HashMap<String,String> hm_header = new HashMap<String,String>();
		hm_header.put("Content-Type", "application/json");
		
		System.out.println("Header " + hm_header.toString());
		
		//Req Specification with Base URI and Header 
		RequestSpecification req_spec = given().baseUri(server_name).headers(hm_header);
		
		//Getting the response of Post, Note body is also sent in the Post request
		Response response = req_spec.when().body(body_text).post("/api/v1/create");
		System.out.println("Response received after Post Request " + response.asString());
		
		ValidatableResponse valid_response = response.then();
		
		//Assertion 1
		valid_response.assertThat().body("status",equalTo("success")).
		assertThat().body("data.name",equalTo(dynamic_name)).
		assertThat().body("data.salary",equalTo("123")).
		assertThat().body("data.age",equalTo("23"));

		
		//Assertion 2 - Get Request using the ID generated in previous Step
		int id = response.jsonPath().getInt("data.id");
		//String salary = response.jsonPath().getString("data.salary");
		//Map<String, String> hm_data = response.jsonPath().getMap("data");
		
		Response response_get = given().baseUri(server_name).when().get("/api/v1/employee/" + id);
		//Response response_get = given().when().get("http://dummy.restapiexample.com/api/v1/employee/93");
		System.out.println("Response received after Get Request: " + response_get.asString());
		
		response_get.then().
		assertThat().statusCode(200).
		assertThat().body("status",equalTo("success")).
		assertThat().body("data.id",equalTo(id)).
		assertThat().body("data.employee_name",equalTo(dynamic_name)).
		assertThat().body("data.employee_salary",equalTo("123")).
		assertThat().body("data.employee_age",equalTo("23"));

	}
	
	
	public void t_06_post_negative_send_incorrect_name() {
		
		String dynamic_name = "-343535435";
		
		//Body Text
		String body_text = "{\"name\":\"" + dynamic_name + "\",\"salary\":\"123\",\"age\":\"23\"}";
		
		System.out.println("Body Text sent as: " + body_text);
		
		//Header Hash Map
		HashMap<String,String> hm_header = new HashMap<String,String>();
		hm_header.put("Content-Type", "application/json");
		
		System.out.println("Header " + hm_header.toString());
		
		//Req Specification with Base URI and Header 
		RequestSpecification req_spec = given().baseUri(server_name).headers(hm_header);
		
		//Getting the response of Post, Note body is also sent in the Post request
		Response response = req_spec.when().body(body_text).post("/api/v1/create");
		System.out.println("Response received after Post Request " + response.asString());
		
		ValidatableResponse valid_response = response.then();
		
		//Assertion 1
		valid_response.assertThat().body("status",not(equalTo("success")));
		valid_response.assertThat().body("status",(equalTo("failed")));
	}
	
	public void t_07_post_negative_send_incorrect_negative_salary() {
		
	}
	
	public void t_08_post_negative_send_incorrect_negative_age() {
		
	}
	public void t_09_post_negative_send_special_characters() {
		
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
