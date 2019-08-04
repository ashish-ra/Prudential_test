package stepDefiniton;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.GherkinKeyword;

import base.Baseclass;
import cucumber.api.java.en.*;
import managers.PageObjectManager;
import managers.WebDriverfactory;
import pomPages.OpenWeatherPage;

public class OpenWetherHomeSteps extends Baseclass{
	
	OpenWeatherPage openWeather;
	PageObjectManager pageobjectmanager;
	
	public OpenWetherHomeSteps() {
		pageobjectmanager = new PageObjectManager(driver);
		openWeather = pageobjectmanager.getOpenWeatherPage();
	}
	
	
	@Given("user navigates to {string}")
	public void user_navigates_to(String url) {
	    driver.get(url);
	}

	@When("page load completes")
	public void page_load_completes() {
	   support.SupportMethods.waitForPageLoad(driver);
	}

	@Then("verify navigation options avaiable in top menu as {string}")
	public void verify_navigation_options_avaiable_in_top_menu_as(String expectedOptions) {
	   System.out.println(openWeather.topMenuList());
	   assertEquals(openWeather.topMenuList(), expectedOptions);
	}

	@Then("verify search Option available")
	public void verify_search_Option_available() {
	  assertTrue((openWeather.input_Search).isDisplayed());
	}

	@Then("verify current weather updates displayed")
	public void verify_current_weather_updates_displayed() {
		assertTrue((openWeather.cityName).isDisplayed());
		System.out.println("data of \""+openWeather.defaultCityname() +"\" is displayed");
	}

	@Then("verify all links working under current weather")
	public void verify_all_links_working_under_current_weather() {
		assertTrue(openWeather.currentweatherLinks());
	}

	@When("user enters {string} as search text")
	public void user_enters_as_search_text(String cityname) {
		openWeather.input_Search.sendKeys(cityname);
	}

	@When("user click on search button")
	public void user_click_on_search_button() {
	    openWeather.button_Search.click();
	}

	@Then("alert as not found displayed")
	public void alert_as_not_found_displayed() {
		System.out.println(openWeather.alertSearch.getText());
	    assertTrue(openWeather.alertSearch.getText().contains("Not found"));
	}
	
	@Then("verify current weather updates displayed for {string}")
	public void verify_current_weather_updates_displayed_for(String city) {
	   assertTrue(openWeather.validSearchMenuName.getText().contains(city));
	}
}
