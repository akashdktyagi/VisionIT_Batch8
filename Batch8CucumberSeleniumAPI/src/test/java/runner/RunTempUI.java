package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

		features="classpath:features/ui/Search.feature",
		glue="stepdefs.ui",
		tags="@TC0006",
		plugin = {"pretty",
				"html:target/html/",
				"json:target/json/file.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		},
		strict=false,
		dryRun=false

		)
public class RunTempUI {

	//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
}
