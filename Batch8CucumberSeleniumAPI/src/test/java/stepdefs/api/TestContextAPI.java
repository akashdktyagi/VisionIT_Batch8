package stepdefs.api;

import cucumber.api.Scenario;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestContextAPI {

	protected RequestSpecification req_spec=null;
    protected Response resp=null;
    protected String newUserID = null;
    protected Scenario scn=null;
    
}
