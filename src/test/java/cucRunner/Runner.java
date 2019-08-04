package cucRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


	@CucumberOptions(
			features = "featureFiles",
			glue = { "stepDefiniton/" }, 
			tags = "@APItest,@E2Etest", 
			dryRun = false, 
			plugin = { "pretty", "html:target/cucumber-reports"
			/*,"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html*/
					}, 
			monochrome = true,
			strict=true
			)

	public class Runner {

		private TestNGCucumberRunner testRunner;

		@BeforeClass
		public void setUP() {
			testRunner = new TestNGCucumberRunner(this.getClass());
		}

		@Test(dataProvider = "features")
		public void login(PickleEventWrapper pickleWrapper, CucumberFeatureWrapper cFeature) throws Throwable {
			testRunner.runScenario(pickleWrapper.getPickleEvent());
		}

		@DataProvider(name = "features")
		public Object[][] getFeatures() {
			return testRunner.provideScenarios();
		}

		@AfterClass
		public void tearDown() {
			// Reporter.loadXMLConfig("extent-config.xml");
			testRunner.finish();
		}

	}

