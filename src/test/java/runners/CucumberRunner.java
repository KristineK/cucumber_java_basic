package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Task1.feature", //        features = "src/test/resources/features/Sample1.feature",  to specify a specific file if a source folder then /
        plugin = {"pretty", "html:cucumber-report/html-report",
                "junit:cucumber-report/junit-report.xml",
                "json:cucumber-report/json-report.json"},
        tags = {"~@Task1Feature"}, //remove ~ to use tags
        glue = {"stepDefinitions"}
)
public class CucumberRunner {

}
