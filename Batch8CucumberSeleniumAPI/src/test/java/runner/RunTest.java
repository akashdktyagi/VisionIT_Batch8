package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

		features="classpath:features/api",
		glue="stepdefs.api",
		tags="@get,@post,@put,@delete,@patch,@options",
		plugin = {"pretty",
				"html:target/html/",
				"json:target/json/file.json",
		},
		strict=true,
		dryRun=false

		)
public class RunTest {

	//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
}
