package StepDefinition;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        },
        features = {"src/test/resources/features"},
        glue = {"com.example.StepDefinitions"},
        tags = "@BookFlight" // test that has to be run
        //dryRun = true
        //monochrome = true  //print output in console
)
public class TestRunner extends AbstractTestNGCucumberTests {


}