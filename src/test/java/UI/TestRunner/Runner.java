package UI.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;
@CucumberOptions(
        features = "src/main/resources/features",
        glue = {"UI.stepDefinitions", "UI.Base"},
        plugin = {"pretty"},
        monochrome = true,
        dryRun = false
)
public class Runner extends AbstractTestNGCucumberTests {
        @Parameters({"BrowserName","URL"})
        @BeforeClass(alwaysRun = true)
        public void setUp(@Optional("Chrome") String BrowserName,@Optional("http://localhost:3000/") String URL ) {
                System.setProperty("BrowserName", BrowserName);
                System.setProperty("URL",URL);
        }








        @AfterClass(alwaysRun = true)
        public void tareDown(){
                System.clearProperty("BrowserName");
        }
        @Override
        @DataProvider(parallel = false)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}