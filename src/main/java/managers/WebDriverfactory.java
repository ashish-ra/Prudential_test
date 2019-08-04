package managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import enums.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverfactory {

	private static WebDriver driver;
	private static DriverType driverType;

	public WebDriverfactory() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
	}

	public WebDriver createDriver() {
		switch (driverType) {
		case firefox:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case chrome:
			WebDriverManager.chromedriver().version("2.40").setup();
			driver = new ChromeDriver();
			break;
		case ie:
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(),
				TimeUnit.SECONDS);
		return driver;
	}

	public static void quitDriver() {
		driver.close();
		driver.quit();
	}

	/*public static void main(String[] args) {
		WebDriverfactory wd=new WebDriverfactory();
		driver=wd.getDriver();
		driver.get("https://openweathermap.org/");
	}*/
}
