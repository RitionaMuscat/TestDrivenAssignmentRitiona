package home;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;

class JsonCurrency {

	CurrencyDataLayer dataLayer = new CurrencyDataLayer();
	CurrencyLogicLayer logic = new CurrencyLogicLayer(dataLayer);
	Double amountToConvert = 11.20;
	String baseCurrency = "EUR";
	String CurrencyToGetRate = "GBP";

	@BeforeAll
	static void setup() {
		RestAssured.baseURI = SetupConstants.CURR_URL;

	}

	@Test
	void missingParameters() throws JSONException, IOException {
		given().header("x-rapidapi-key", "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
				.header("x-rapidapi-host", "exchangerate-api.p.rapidapi.com").when().get(RestAssured.baseURI).then()
				.assertThat().statusCode(SetupConstants.HTTP_NOT_FOUND);

	}

	@Test
	void missingAuthenticationHeaders() throws JSONException, IOException {
		given()
				// .header("x-rapidapi-key",
				// "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
				.header("x-rapidapi-host", "exchangerate-api.p.rapidapi.com").when()
				.get(RestAssured.baseURI + baseCurrency).then().assertThat()
				.statusCode(SetupConstants.HTTP_UNATHORIZED);

	}

	@Test
	void invalidKey() throws JSONException, IOException {
		given().header("x-rapidapi-key", "ff143ffed2msh2f1f7c558b7c62dp130jsnd361f3ac8348")
				.header("x-rapidapi-host", "exchangerate-api.p.rapidapi.com").when()
				.get(RestAssured.baseURI + baseCurrency).then().assertThat().statusCode(SetupConstants.HTTP_FORBIDDEN);

	}

	@Test
	void invalidParameters() throws JSONException, IOException {
		given().header("x-rapidapi-key", "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
				.header("x-rapidapi-host", "exchangerate-api.p.rapidapi.com").when().get(RestAssured.baseURI + "")
				.then().assertThat().statusCode(SetupConstants.HTTP_NOT_FOUND);

	}

	@Test
	void getConvertedAmount() throws JSONException, IOException {
		given().header("x-rapidapi-key", "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
				.header("x-rapidapi-host", "exchangerate-api.p.rapidapi.com").when().get(RestAssured.baseURI + null)
				.then().assertThat().statusCode(SetupConstants.HTTP_OK);

	}

}
