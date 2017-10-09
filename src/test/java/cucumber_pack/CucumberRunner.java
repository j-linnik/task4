package cucumber_pack;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"src/test/java/cucumber_pack/features"}, glue = {"cucumber_pack/steps"})
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
