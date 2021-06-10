package home;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;

class JsonCurrency {

	DataLayer dataLayer = new DataLayer();
	LogicLayer logic = new LogicLayer(dataLayer);
	Double amountToConvert = 11.20;
	String baseCurrency = "EUR";
	String CurrencyToGetRate = "GBP";

	@BeforeAll
	static void setup() {
		RestAssured.baseURI = SetupConstants.CURR_URL;

	}

	@Test
	void missingParameters() throws JSONException, IOException {
		io.restassured.response.Response res = given()
				.header("x-rapidapi-key", "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
				.header("x-rapidapi-host", "exchangerate-api.p.rapidapi.com").when().get(RestAssured.baseURI).then()
				.assertThat().extract().response();

		if (res.getStatusCode() != 200) {
			System.out.println("missingParameters: BaseCurrency Not Provided not provided \n");
		} else {
			System.out.println(res.body().asString() + "\n");
		}
	}

	@Test
	void missingAuthenticationHeaders() throws JSONException, IOException {
		io.restassured.response.Response res = given()
				// .header("x-rapidapi-key",
				// "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
				.header("x-rapidapi-host", "exchangerate-api.p.rapidapi.com").when()
				.get(RestAssured.baseURI + baseCurrency).then().assertThat().extract().response();

		if (res.getStatusCode() != 200) {
			System.out.println("missingAuthenticationHeaders: Missing Headders \n");
		} else {
			System.out.println("missingAuthenticationHeaders: " + res.body().asString() + "\n");
		}
	}

	@Test
	void invalidKey() throws JSONException, IOException {
		io.restassured.response.Response res = given()
				.header("x-rapidapi-key", "ff143ffed2msh2f1f7c558b7c62dp130jsnd361f3ac8348")
				.header("x-rapidapi-host", "exchangerate-api.p.rapidapi.com").when()
				.get(RestAssured.baseURI + baseCurrency).then().assertThat().extract().response();

		if (res.getStatusCode() != 200) {
			System.out.println("invalidKey: Key Is Wrong \n");
		} else {
			System.out.println("missingAuthenticationHeaders: " + res.body().asString() + "\n");
		}
	}

	@Test
	void invalidParameters() throws JSONException, IOException {
		io.restassured.response.Response res = given()
				.header("x-rapidapi-key", "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
				.header("x-rapidapi-host", "exchangerate-api.p.rapidapi.com").when().get(RestAssured.baseURI + null)
				.then().assertThat().extract().response();

		if (res.getStatusCode() != 200) {
			System.out.println("invalidParameters: Parameter Cannot Be Empty \n");
		} else {
			System.out.println("invalidParameters: " + res.body().asString() + "\n");
		}
	}

	@Test
	void getConvertedAmount() throws JSONException, IOException {
		io.restassured.response.Response res = given()
				.header("x-rapidapi-key", "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
				.header("x-rapidapi-host", "exchangerate-api.p.rapidapi.com").when().get(RestAssured.baseURI + null)
				.then().assertThat().extract().response();

		if (res.getStatusCode() != 200) {
			System.out.println("getConvertedAmount: error \n");
		} else {
			System.out.println("getConvertedAmount: " + res.body().asString() + "\n");
		}
	}

}
