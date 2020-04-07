package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

		features="classpath:features/ui",
		glue="stepdefs.ui",
		tags="",
		plugin = {"pretty",
				"html:target/html/",
				"json:target/json/file.json",
		},
		strict=false,
		dryRun=false

		)
public class RunTestUI {

	//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
}
