package stepDefiniton;

import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.google.gson.Gson;

import apiPOJO.Example;
import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APITestSteps {

	String URI = null;
	Response response = null;

	@Given("url is {string}")
	public void url_is(String uri) {
		URI = uri;
	}

	@When("user submit get {string} request with id as {string} and appid as {string}")
	public void user_submit_get_request_with_id_as_and_appid_as(String getResource, String cityid, String appid) {
		RestAssured.baseURI = URI;

		response = RestAssured.given().param("id", cityid).param("appid", appid).when().get(getResource);

		System.out.println(response.asString());

	}

	@Then("verify status is success")
	public void verify_status_is_success() {
		assertTrue((response.getStatusCode() == 200));
	}

	@Then("verify city name is response is {string}")
	public void verify_city_name_is_response_is(String cityName) {
		Example jsonObject = new Gson().fromJson(response.asString(), Example.class);

		assertEquals(jsonObject.getCity().getName(), cityName);
	}
	
	@Then("verify list contains {int} entries")
	public void verify_list_contains_entries(Integer listCount) {
		Example jsonObject = new Gson().fromJson(response.asString(), Example.class);
		assertTrue(jsonObject.getList().size()==listCount);
	}

}
