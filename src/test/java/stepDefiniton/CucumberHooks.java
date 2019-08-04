package stepDefiniton;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.Baseclass;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.WebDriverfactory;

public class CucumberHooks extends Baseclass{

	
	@Before("~@APItest")
	public void driverinitialize(Scenario scenario) {
		Baseclass.initialzation();
	}
	
	@After("~@APItest")
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			try 
			{
				final byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			}
			catch (Exception e) {
				System.out.println("____________error occurred __________"+ e);
			}
		}
		
		Baseclass.driver.quit();
	}
}
