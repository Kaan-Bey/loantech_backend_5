package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:target/failedRerun.txt"
        },
        features = "src/test/resources/API",
        glue = {"stepdefinitions","hooks"},
<<<<<<< HEAD
        tags = "@API45",
=======

        tags = "@API02",

>>>>>>> main
        dryRun =false
)
public class API_Runner {
}
