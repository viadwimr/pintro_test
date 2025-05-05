package pintro.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/pintro/cucumber/features/api.feature",
        glue = "pintro.cucumber.stepDef",
        plugin = {"pretty", "html:target/cucumber-reports-api.html"},
        monochrome = true
)
public class TestRunnerApiTest {
}
