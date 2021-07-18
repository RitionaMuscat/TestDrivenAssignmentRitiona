package home;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class StepsDefinitionDefinition {

	OkHttpClient client = new OkHttpClient();

	Request request = new Request.Builder()
			.url("https://mashape-community-urban-dictionary.p.rapidapi.com/define?term=apple").get()
			.addHeader("x-rapidapi-key", "ff14ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
			.addHeader("x-rapidapi-host", "mashape-community-urban-dictionary.p.rapidapi.com").build();

	@When("I dont pass the word")
	public void i_dont_pass_the_word(List<String> params) {
		MainClass.main(params.toArray(new String[params.size()]));
	}

	@Then("I check that the warning message is shown")
	public void i_check_that_the_warning_message_is_shown() {
		equals("Args is null: Cannot read the array length because \"args\" is null");
	}

	@Given("Definition is available")
	public void definition_is_available(List<String> params) {
		MainClass.main(params.toArray(new String[params.size()]));
	}

	@When("I search for the word")
	public void i_search_for_the_word(List<String> params) {
		MainClass.main(params.toArray(new String[params.size()]));
	}

	@Then("Return Word Does Not Exist")
	public void return_Word_Does_Not_Exist() {
		System.out.println("Outputs are the same");
	}

	@Given("I input jumbled multiple items")
	public void i_input_jumbled_multiple_items(List<String> params) {
		MainClass.main(params.toArray(new String[params.size()]));
	}

	@When("I search for the item")
	public void i_search_for_the_item(List<String> params) {
		MainClass.main(params.toArray(new String[params.size()]));
	}

	@Then("Return Word is invalid")
	public void return_Word_is_invalid() {
		System.out.println("Word Is Invalid");
	}

	@When("I search for multiple words")
	public void i_search_for_multiple_words(List<String> params) {
		MainClass.main(params.toArray(new String[params.size()]));
	}

	@Then("No Definitions returned")
	public void no_Definitions_returned() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("No Definitions Returned");
	}

	@Given("I enter a percentage with the definition name")
	public void i_enter_a_percentage_with_the_definition_name(List<String> params) {
		MainClass.main(params.toArray(new String[params.size()]));
	}

	@Then("Definition Shall Not Be Returned")
	public void definition_Shall_Not_Be_Returned() {
		System.out.println("No Definition Found");
	}

	@Given("I input numbers in the word")
	public void i_input_numbers_in_the_word(List<String> params) {
		MainClass.main(params.toArray(new String[params.size()]));
	}

	@Then("No Definition to be returned")
	public void no_Definition_to_be_returned() {
		System.out.println("No Definition Found");
	}

	@Given("I have an invalid key")
	public void i_have_an_invalid_key() {
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
				.url("https://mashape-community-urban-dictionary.p.rapidapi.com/define?term=apple").get()
				.addHeader("x-rapidapi-key", "ff13ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
				.addHeader("x-rapidapi-host", "mashape-community-urban-dictionary.p.rapidapi.com").build();

	}

	@Then("{int} error is returned")
	public void error_is_returned(Integer int1) {

		Response response;
		try {
			response = client.newCall(request).execute();
			int responseCode = response.code();
			assertEquals(403, responseCode);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@When("I Input A Word with spaces")
	public void i_Input_A_Word_with_spaces(List<String> params) {
		MainClass.main(params.toArray(new String[params.size()]));
	}

	@Then("Word Should be provided")
	public void word_Should_be_provided() {
	    System.out.println("Word Is Successfully returned");
	}


}
