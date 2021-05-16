package Runners;
import org.junit.runner.RunWith;

import org.testng.annotations.Test;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@Test
@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/bookATicketFeatureFiles",
		glue="tecketBookingDefinition",
		monochrome=true,
		tags= "@test",
		plugin= {"pretty","html:target/cucumber.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				})
public class TestRunner {
//	
	
}
