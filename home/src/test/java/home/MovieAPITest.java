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

	MovieDataLayer dataLayer = new MovieDataLayer();
	MovieLogicLayer logic = new MovieLogicLayer(dataLayer);
	String movieName = "friends";

	@BeforeAll
	static void setup() {
		RestAssured.baseURI = SetupConstants.MOVIE_URL;

	}

	@Test
	void missingParameters() throws IOException {

		given().header("x-rapidapi-key", "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
				.header("x-rapidapi-host", "imdb-internet-movie-database-unofficial.p.rapidapi.com").when()
				.get(RestAssured.baseURI).then().assertThat().statusCode(SetupConstants.HTTP_NOT_FOUND);
	}

	@Test
	void missingAuthenticationHeaders() throws IOException {
		given()
				// .header("x-rapidapi-key",
				// "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
				.header("x-rapidapi-host", "imdb-internet-movie-database-unofficial.p.rapidapi.com").when()
				.get(RestAssured.baseURI + movieName).then().assertThat().statusCode(SetupConstants.HTTP_UNATHORIZED);
	}

	@Test
	void invalidKey() throws JSONException, IOException {
		given().header("x-rapidapi-key", "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8")
				.header("x-rapidapi-host", "imdb-internet-movie-database-unofficial.p.rapidapi.com").when()
				.get(RestAssured.baseURI + movieName).then().assertThat().statusCode(SetupConstants.HTTP_FORBIDDEN);
	}

	@Test
	void invalidParameters() throws IOException {

		given().header("x-rapidapi-key", "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
				.header("x-rapidapi-host", "imdb-internet-movie-database-unofficial.p.rapidapi.com").when()
				.get(RestAssured.baseURI + "//u00a0").then().assertThat().statusCode(SetupConstants.HTTP_NOT_FOUND);
	}

	@Test
	void getMovie() throws IOException {
		given().header("x-rapidapi-key", "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
				.header("x-rapidapi-host", "imdb-internet-movie-database-unofficial.p.rapidapi.com").when()
				.get(RestAssured.baseURI + movieName).then().assertThat().statusCode(SetupConstants.HTTP_OK);
	}

}
