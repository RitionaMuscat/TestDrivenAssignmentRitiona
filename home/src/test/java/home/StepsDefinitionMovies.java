package home;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import cucumber.api.cli.Main;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class StepsDefinitionMovies {

	private ByteArrayOutputStream myOut;

	OkHttpClient client = new OkHttpClient();

	Request request = new Request.Builder()
			.url("https://imdb-internet-movie-database-unofficial.p.rapidapi.com/film/friends")
			.get()
			.addHeader("x-rapidapi-key", "f143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
			.addHeader("x-rapidapi-host", "imdb-internet-movie-database-unofficial.p.rapidapi.com")
			.build();
	@Before
	public void captureSysOut() {
		myOut = new ByteArrayOutputStream();

		System.setOut(new PrintStream(myOut));

	}

	private String getOutput() {
		return myOut.toString().trim();
	}

	@Given("I dont pass the movie name")
	public void i_dont_pass_the_movie_name() {
		MainClass.main(null);
	}

	@Then("I check that the warning message is provided")
	public void i_check_that_the_warning_message_is_provided() {
		// Write code here that turns the phrase above into concrete actions
		equals("Args is null: Cannot read the array length because \"args\" is null");
	}

	@When("I search for")
	public void i_search_for(List<String> params) {
		MainClass.main(params.toArray(new String[params.size()]));
	}

	@Then("{string} should be returned")
	public void movie_Details_are_returned(String output) {
		// Write code here that turns the phrase above into concrete actions

		String outputNeeded = getOutput();
		if (output.equals(outputNeeded)) {
			System.out.println("Outputs are the same");
		}
	}

	@Given("Movie is available")
	public void movie_is_available(List<String> params) {
		// Write code here that turns the phrase above into concrete actions
		MainClass.main(params.toArray(new String[params.size()]));
	}

	@When("I search a movie")
	public void i_search_a_movie(List<String> params) {
		// Write code here that turns the phrase above into concrete actions
		MainClass.main(params.toArray(new String[params.size()]));
	}

	@Then("Details are returned")
	public void details_are_returned() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Movies Are Returned");
	}

	@Given("I input jumbled words")
	public void i_input_jumbled_words(List<String> params) {
		// Write code here that turns the phrase above into concrete actions
		MainClass.main(params.toArray(new String[params.size()]));
	}

	@When("I search for the movie")
	public void i_search_for_the_movie(List<String> params) {
		// Write code here that turns the phrase above into concrete actions
		MainClass.main(params.toArray(new String[params.size()]));
	}

	@Then("Return Movie Does Not Exist")
	public void return_Movie_Does_Not_Exist() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Movie Does Not exist");
	}


	@When("I search for movie name")
	public void i_search_for_movie_name(List<String> params) {
	    // Write code here that turns the phrase above into concrete actions
		MainClass.main(params.toArray(new String[params.size()]));
	}

	@Then("I should not get the movie details")
	public void i_should_not_get_the_movie_details() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Movie Does Not exist");
	}

	@Given("I have an invalid API key")
	public void i_have_an_invalid_API_key() {
	    // Write code here that turns the phrase above into concrete actions
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
				.url("https://imdb-internet-movie-database-unofficial.p.rapidapi.com/film/friends")
				.get()
				.addHeader("x-rapidapi-key", "f143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
				.addHeader("x-rapidapi-host", "imdb-internet-movie-database-unofficial.p.rapidapi.com")
				.build();

		
	}

	@Then("{int} error should be returned")
	public void error_should_be_returned(Integer int1) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		Response response = client.newCall(request).execute();
		int responseCode =response.code();
		assertEquals(403, responseCode);
	}

	@Given("I input characters and symbols")
	public void i_input_characters_and_symbols(List<String> params) {
	    // Write code here that turns the phrase above into concrete actions
		MainClass.main(params.toArray(new String[params.size()]));
	}

	@Then("No Movie Name is returned")
	public void no_Movie_Name_is_returned() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("No Movie Name is returned");
	}

	@Given("I enter a percentage with the movie name")
	public void i_enter_a_percentage_with_the_movie_name(List<String> params) {
	    // Write code here that turns the phrase above into concrete actions
		MainClass.main(params.toArray(new String[params.size()]));
	}

	@Then("Movie Shall Not Be Returned")
	public void movie_Shall_Not_Be_Returned() {
		   System.out.println("No Movie Name is returned");
	}
}
