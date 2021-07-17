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

public class StepsCurrency {
	OkHttpClient client = new OkHttpClient();

	Request request = new Request.Builder()
		.url("https://exchangerate-api.p.rapidapi.com/rapid/latest/EUR")
		.get()
		.addHeader("x-rapidapi-key", "ff143ff2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
		.addHeader("x-rapidapi-host", "exchangerate-api.p.rapidapi.com")
		.build();
//	Response response = client.newCall(request).execute();
	
@When("I dont have any parameters passed")
public void i_dont_have_any_parameters_passed() {
    // Write code here that turns the phrase above into concrete actions
    MainClass.main(null);
}

@Then("I check that the warning is shown")
public void i_check_that_the_warning_is_shown() {
    // Write code here that turns the phrase above into concrete actions
	equals("Args is null: Cannot read the array length because \"args\" is null");
}

@Given("That The Conversion is available")
public void that_The_Conversion_is_available(List<String> params) {
	MainClass.main(params.toArray(new String[params.size()]));
}

@When("I search with the parameters")
public void i_search_with_the_parameters(List<String> params) {
	MainClass.main(params.toArray(new String[params.size()]));
}

@Then("Conversion is Returned")
public void conversion_is_Returned() {
   System.out.println("Conversion Is Correct");
}

@Given("I input small case currencies")
public void i_input_small_case_currencies(List<String> params) {
	MainClass.main(params.toArray(new String[params.size()]));
}

@When("I search with these fields")
public void i_search_with_these_fields(List<String> params) {
	MainClass.main(params.toArray(new String[params.size()]));
}

@Then("Currency Conversion is returned")
public void currency_Conversion_is_returned() {
	  System.out.println("Conversion Is Correct");
}

@When("I search for multiple currencies")
public void i_search_for_multiple_currencies(List<String> params) {
	System.out.println(params);
	MainClass.main(params.toArray(new String[params.size()]));
}

@Then("No rates are returned")
public void no_rates_are_returned() {
   System.out.println("Np rates found");
}

@Given("I have Invalid Keys")
public void i_have_Invalid_Keys() {
	Request request = new Request.Builder()
			.url("https://exchangerate-api.p.rapidapi.com/rapid/latest/EUR")
			.get()
			.addHeader("x-rapidapi-key", "ff143ed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
			.addHeader("x-rapidapi-host", "exchangerate-api.p.rapidapi.com")
			.build();
}

@Then("{int} error is displayed")
public void error_is_displayed(Integer int1) throws IOException {
	Response response = client.newCall(request).execute();
	int responseCode =response.code();
	assertEquals(403, responseCode);
}

@Given("I input invalid amounts and non existant currencies")
public void i_input_invalid_amounts_and_non_existant_currencies(List<String> params) {
	MainClass.main(params.toArray(new String[params.size()]));
}

@Then("Error Should Return")
public void error_Should_Return() {
    System.out.println("Invalid Currencies");
}

@Given("I enter an invalid character")
public void i_enter_an_invalid_character(List<String> params) {
	MainClass.main(params.toArray(new String[params.size()]));
}

@Then("Conversion is Invalid")
public void conversion_is_Invalid() {
    System.out.println("Invalid Conversion");
}

@When("I Input A space in Currency")
public void i_Input_A_space_in_Currency(List<String> params) {
	MainClass.main(params.toArray(new String[params.size()]));
}

@Then("Currency Will Return as Invalid")
public void currency_Will_Return_as_Invalid() {
    System.out.println("Currency will return as invalid");
}



}
