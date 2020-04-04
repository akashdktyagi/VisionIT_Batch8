package stepdefs.api;

import cucumber.api.Scenario;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestContext {

    RequestSpecification req_spec=null;
    Response resp=null;
    String newUserID = null;
    Scenario scn=null;
    
}
