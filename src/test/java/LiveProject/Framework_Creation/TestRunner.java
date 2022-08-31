package LiveProject.Framework_Creation;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
			features = {"Feature/"},
			glue = {"stepdefinitions"},
			plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					 "json:target/cucumber-reports/Cucumber.json",
						"junit:target/cucumber-reports/Cucumber.xml",
						"html:target/cucumber-reports/Cucumber-reports.html"},
			monochrome = true
			// "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		)

		

public class TestRunner {
	
}
