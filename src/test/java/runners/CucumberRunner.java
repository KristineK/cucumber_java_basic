package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Sample1.feature",
        plugin = {"pretty", "html:cucumber-report/report.html",
                "junit:cucumber-report/junit-report.xml",
                "json:cucumber-report/report.json"},
        tags = "@test and not @bug",
        glue = {"stepDefinitions"}
)
public class CucumberRunner {

}
