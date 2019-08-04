# NOTE: 
#		
#		Add newly added tags in enum located at "src\main\java\enums\FeatureTags.java" file
#
#
Feature: Automated End2End and API Tests
Description: The purpose of this feature is to test End 2 End integration.

@E2Etest
Scenario: Verificaion of important information across OpenWeatherMap	
	Given user navigates to "https://openweathermap.org"
	When page load completes
	Then verify navigation options avaiable in top menu as "Weather Maps Guide API Price Partners Stations Widgets Blog "
	And verify search Option available
	And verify current weather updates displayed
	Then verify all links working under current weather
	
@E2Etest
Scenario: Verificaion for search of INVALID city 	
	Given user navigates to "https://openweathermap.org"
	When page load completes
	And user enters "aaaabb" as search text
	And user click on search button
	Then alert as not found displayed
	
@E2Etest	
Scenario: Verificaion for search of VALID city 	
	Given user navigates to "https://openweathermap.org"
	When page load completes
	And user enters "Mumbai" as search text
	And user click on search button
	Then verify current weather updates displayed for "Mumbai"
	
@E2Etest
# fail scenario
Scenario: Verificaion for search of VALID city (INVALID SCENARIO)
	Given user navigates to "https://openweathermap.org"
	When page load completes
	And user enters "Mumbai" as search text
	And user click on search button
	Then verify current weather updates displayed for "delhi"

@APItest
#https://samples.openweathermap.org/data/2.5/forecast/daily?id=524901&appid=b1b15e88fa797225412429c1c50c122a1
Scenario: Verificaion for 16 day forecast data for using cityID	 
	Given url is "https://samples.openweathermap.org/data/2.5/forecast" 
	When user submit get "/daily" request with id as "524901" and appid as "b1b15e88fa797225412429c1c50c122a1"
	Then verify status is success
	And verify city name is response is "Moscow"
	And verify list contains 7 entries
	
@APItest 
# fail scenario https://samples.openweathermap.org/data/2.5/forecast/daily?id=524901&appid=b1b15e88fa797225412429c1c50c122a1
Scenario: Verificaion for 16 day forecast data for using cityID (INVALID SCENARIO)
	Given url is "https://samples.openweathermap.org/data/2.5/forecast" 
	When user submit get "/daily" request with id as "524901" and appid as "b1b15e88fa797225412429c1c50c122a1"
	Then verify status is success
	And verify city name is response is "Mubai"
	And verify list contains 7 entries