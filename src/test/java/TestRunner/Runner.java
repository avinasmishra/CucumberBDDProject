package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
       features = {"src/test/resources/Features/Login.feature", "src/test/resources/Features/Customers.feature"},

        /* To run all feature file- use (features = "src/test/resources//Features/")*/
        /*To run specific feature file- use ( features = {"src/test/resources/Features/Login.feature", "src/test/resources/Features/Customers.feature"},) */

        glue = "StepDefination",
        dryRun = false,
        monochrome = true,
        tags = "@sanity and @regression or @sanity",
        //plugin = {"pretty", "html:target/cucumber-reports/report1.html"}

        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class Runner {
    /* this class should be empty  */
}

