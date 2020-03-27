package trial.junit.api.gorest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import io.restassured.response.Response;
import utils.TestBase;

public class TC_GetRequest extends TestBase {

	String server = LoadProperties().getProperty("url");
	String accessToken = LoadProperties().getProperty("token");
	
	@Test
	public void t_01_get_request_fetch_all_users() {
		Response resp = 
				given()
				.baseUri(server)
				.auth().oauth2(accessToken)
				
				.when()
				.get("/public-api/users")
				
				.then()
				.assertThat()
				.statusCode(200)
				.body("_meta.success", equalTo(true))
				.body("_meta.code", equalTo(200))
				.body("_meta.message",equalTo("OK. Everything worked as expected."))
				.body("result", not(emptyArray()))
				.extract()
				.response();

		System.out.println("Response Returned as: " + resp.asString());

	}
	
	@Test
	public void t_02_get_request_validate_pagination() {
		Response resp = given()
				.baseUri(server)
				.queryParam("page", "5")
				.auth().oauth2(accessToken)
				.when()
				.get("public-api/users")
				.then()
				.assertThat()
				.statusCode(200)
				.body("_meta.success", equalTo(true))
				.body("_meta.code", equalTo(200))
				.body("_meta.message",equalTo("OK. Everything worked as expected."))
				.body("_meta.currentPage", equalTo(5))
				.body("result", not(emptyArray()))
				.extract()
				.response();
		System.out.println("Response Returned as: " + resp.asString());
	}
	
	@Test
	public void t_03_get_request_single_user() {
		String user_id = "133";
		Response resp = given()
				.baseUri(server)
				.auth().oauth2(accessToken)
				.when()
				.get("public-api/users/" + user_id)
				.then()
				.assertThat()
				.statusCode(200)
				.body("_meta.success", equalTo(true))
				.body("_meta.code", equalTo(200))
				.body("_meta.message",equalTo("OK. Everything worked as expected."))
				.body("result", not(emptyArray()))
				.body("result.id", equalTo(user_id))
				.extract()
				.response();
		System.out.println("Response Returned as: " + resp.asString());
	}
	
	@Test
	public void t_04_get_negative_incorrect_user() {
		String user_id = "345345353535353544";
		Response resp = given()
				.baseUri(server)
				.auth().oauth2(accessToken)
				.when()
				.get("public-api/users/" + user_id)
				.then()
				.assertThat()
				.statusCode(200)
				.body("_meta.success", equalTo(false))
				.body("_meta.code", equalTo(404))
				.body("_meta.message",equalTo("The requested resource does not exist."))
				.body("result.name", equalTo("Not Found"))
				.body("result.message", equalTo("Object not found: " + user_id))
				.body("result.code", equalTo(0))
				.body("result.status", equalTo(404))
				.extract()
				.response();
		System.out.println("Response Returned as: " + resp.asString());
	}
	
	@Test
	public void t_05_get_all_users_with_gender_as_female() {
		Response resp = given()
				.baseUri(server)
				.queryParam("gender", "female")
				.auth().oauth2(accessToken)
				.when()
				.get("public-api/users" )
				.then()
				.assertThat()
				.statusCode(200)
				.body("_meta.success", equalTo(true))
				.body("_meta.code", equalTo(200))
				.body("_meta.message",equalTo("OK. Everything worked as expected."))
				.body("result.gender", everyItem(equalTo("female")))
				.extract()
				.response();
		//Below is another way of doing the validation for 
		//line: .body("result.gender", everyItem(equalTo("female")))
		/*
		List<String> list_gender = resp.jsonPath().getList("result.gender");
		for (int i=0;i<list_gender.size();i++) {
			if (list_gender.get(i).equalsIgnoreCase("female")) {
				Assert.assertTrue("validated", true);
			}else {
				Assert.assertTrue("female is not present in at least one entry", false);
			}
		}
		*/
		
		System.out.println("Response Returned as: " + resp.asString());

	}
	
	@Test
	public void t_06_get_all_users_with_gender_as_female_and_status_as_active() {
		Response resp = given()
				.baseUri(server)
				//.queryParam("gender", "female")
				//.queryParam("status", "active")
				.auth().oauth2(accessToken)
				.when()
				.get("/public-api/users?gender=female&status=active" )
				.then()
				.assertThat()
				.statusCode(200)
				.body("_meta.success", equalTo(true))
				.body("_meta.code", equalTo(200))
				.body("_meta.message",equalTo("OK. Everything worked as expected."))
				.body("result.gender", everyItem(equalTo("female")))
				.body("result.status", everyItem(equalTo("active")))
				.extract()
				.response();

		
		System.out.println("Response Returned as: " + resp.asString());

	}
	
}
