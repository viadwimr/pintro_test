package pintro.cucumber.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/swagLabs/cucumber/features/",
        glue = "swagLabs.cucumber.stepDef",
        plugin = {"pretty", "html:target/cucumber-reports-api.html"},
        monochrome = true
)
public class TestRunner {
}
