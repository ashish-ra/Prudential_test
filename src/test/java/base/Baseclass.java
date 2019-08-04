package base;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import managers.WebDriverfactory;

public class Baseclass {
	
	/*
	 * This class will create driver instance using WebDriver Factory and will be extended by StepDefinition classes
	 */

	public static WebDriver driver;
	
	public static WebDriver initialzation()
	{
		System.out.println("---------Baseclass---------initialization---------");
		WebDriverfactory webdrivrfactory=new WebDriverfactory();
		driver=webdrivrfactory.createDriver();
		return driver;
	}
}
