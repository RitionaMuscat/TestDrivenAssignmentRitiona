package home;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.matcher.RestAssuredMatchers.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.*;

class MovieAPITest {

	DataLayer dataLayer = new DataLayer();
	LogicLayer logic = new LogicLayer(dataLayer);
	String movieName = "friends";

	@BeforeAll
	static void setup() {
		RestAssured.baseURI = SetupConstants.MOVIE_URL;

	}

	@Test
	void missingParameters() throws IOException {

		io.restassured.response.Response res = given()
				.header("x-rapidapi-key", "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
				.header("x-rapidapi-host", "imdb-internet-movie-database-unofficial.p.rapidapi.com").when()
				.get(RestAssured.baseURI).then().assertThat()
				.extract().response();

		if (res.getStatusCode() != 200) {
			System.out.println("missingParameters: Film not provided \n");
		} else {
			System.out.println(res.body().asString() + "\n");
		}

	}

	@Test
	void missingAuthenticationHeaders() throws IOException {
		io.restassured.response.Response res = given()
				// .header("x-rapidapi-key",
				// "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
				.header("x-rapidapi-host", "imdb-internet-movie-database-unofficial.p.rapidapi.com").when()
				.get(RestAssured.baseURI + movieName).then()
				.assertThat().extract().response();
		if (res.getStatusCode() == 401) {
			System.out.println("missingAuthenticationHeaders: Missing Authentication Headers \n");
		} else {
			System.out.println("missingAuthenticationHeaders: " + res.body().asString());
		}

	}

	@Test
	void invalidKey() throws JSONException, IOException {
		io.restassured.response.Response res = given()
				.header("x-rapidapi-key", "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8")
				.header("x-rapidapi-host", "imdb-internet-movie-database-unofficial.p.rapidapi.com").when()
				.get(RestAssured.baseURI + movieName).then()
				.assertThat().extract().response();
		if (res.getStatusCode() != 200) {
			System.out.println("invalidKey: Invalid Key - " + res.getStatusCode() + "\n");
		} else {
			System.out.println("invalidKey: " + res.body().asString());
		}
	}

	@Test
	void invalidParameters() throws IOException {

		io.restassured.response.Response res = given()
				.header("x-rapidapi-key", "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
				.header("x-rapidapi-host", "imdb-internet-movie-database-unofficial.p.rapidapi.com").when()
				.get(RestAssured.baseURI + null).then().assertThat()
				.extract().response();

		if (res.getStatusCode() != 200) {
			System.out.println("invalidParameters: Film not provided \n");
		} else {
			System.out.println("invalidParameters: " + res.body().asString() + "\n");
		}

	}

	@Test
	void getMovie() throws IOException {
		io.restassured.response.Response res = given()
				.header("x-rapidapi-key", "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
				.header("x-rapidapi-host", "imdb-internet-movie-database-unofficial.p.rapidapi.com").when()
				.get(RestAssured.baseURI + null).then().assertThat()
				.extract().response();

		if (res.getStatusCode() != 200) {
			System.out.println("getMovie: Invalid Request \n");
		} else {
			System.out.println("getMovie: " + res.body().asString() + "\n");
		}
	}

}
