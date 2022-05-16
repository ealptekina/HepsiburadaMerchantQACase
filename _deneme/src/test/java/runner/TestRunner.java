package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;
import utility.Variables;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\features\\HepsiburadaCases.feature", glue = {"testcases"})
public class TestRunner {
    @AfterSuite
    public void teardown() {
        Variables.driver.close();
    }
}