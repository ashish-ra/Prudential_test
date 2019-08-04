package managers;

import org.openqa.selenium.WebDriver;

import pomPages.OpenWeatherPage;

public class PageObjectManager {
	private WebDriver driver;
	OpenWeatherPage openWeatherPage;

	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	/* This class will create singleton objects for all Page object classes with received driver 
	 * ------------------ Singleton for all POM pages--------------------------
	 */
	
	public OpenWeatherPage getOpenWeatherPage(){
		return (openWeatherPage == null) ? openWeatherPage = new OpenWeatherPage(driver) : openWeatherPage;
	}

}

