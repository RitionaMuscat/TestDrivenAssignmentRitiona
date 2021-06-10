package home;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

class JSONDictionaryTest {

	DataLayer dataLayer = new DataLayer();
	LogicLayer logic = new LogicLayer(dataLayer);
	String word = "Who";

	@BeforeAll
	static void setup() {
		RestAssured.baseURI = SetupConstants.DICT_URL;

	}

	@Test
	void missingParameters() throws IOException {

		io.restassured.response.Response res = given()
				.header("x-rapidapi-key", "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
				.header("x-rapidapi-host", "mashape-community-urban-dictionary.p.rapidapi.com").when()
				.get(RestAssured.baseURI + word).then().assertThat().extract().response();

		if (res.getStatusCode() != 200) {
			System.out.println("missingParameters: Term to search not provided \n");
		} else {
			System.out.println(res.body().asString() + "\n");
		}

	}

	@Test
	void missingAuthenticationHeaders() throws IOException {

		io.restassured.response.Response res = given()
				// .header("x-rapidapi-key",
				// "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
				.header("x-rapidapi-host", "mashape-community-urban-dictionary.p.rapidapi.com").when()
				.get(RestAssured.baseURI + word).then().assertThat().extract().response();

		if (res.getStatusCode() != 200) {
			System.out.println("missingAuthenticationHeaders: Authentication Header Missing \n");
		} else {
			System.out.println(res.body().asString() + "\n");
		}

	}

	@Test
	void invalidKey() throws IOException {

		io.restassured.response.Response res = given()
				.header("x-rapidapi-key", "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8")
				.header("x-rapidapi-host", "mashape-community-urban-dictionary.p.rapidapi.com").when()
				.get(RestAssured.baseURI + word).then().assertThat().extract().response();

		if (res.getStatusCode() != 200) {
			System.out.println("invalidKey: Key Is not Correct \n");
		} else {
			System.out.println(res.body().asString() + "\n");
		}

	}

	@Test
	void invalidParameters() throws IOException {

		io.restassured.response.Response res = given()
				.header("x-rapidapi-key", "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
				.header("x-rapidapi-host", "mashape-community-urban-dictionary.p.rapidapi.com").when()
				.get(RestAssured.baseURI + null).then().assertThat().extract().response();

		if (res.getStatusCode() != 200) {
			System.out.println("Invalid Parameter \n");
		} else {
			System.out.println(res.body().asString() + "\n");
		}

	}

	@Test
	void getDefinition() throws IOException {

		io.restassured.response.Response res = given()
				.header("x-rapidapi-key", "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
				.header("x-rapidapi-host", "mashape-community-urban-dictionary.p.rapidapi.com").when()
				.get(RestAssured.baseURI + word).then().assertThat().extract().response();

		if (res.getStatusCode() != 200) {
			System.out.println("getDefinition failed \n");
		} else {
			System.out.println(res.body().asString() + "\n");
		}

	}

}
