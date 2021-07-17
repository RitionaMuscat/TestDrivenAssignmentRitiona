package home;

import java.util.List;

import io.cucumber.java.en.Given;

public class StepsDefinitionDefinition {


//Failed scenarios:
//file:///C:/Users/ritio/OneDrive/Desktop/Mcast%20Degree/TestDrivenAssignmentRitiona/home/src/test/resources/dictionary.feature:13# Jumbled Definition
//file:///C:/Users/ritio/OneDrive/Desktop/Mcast%20Degree/TestDrivenAssignmentRitiona/home/src/test/resources/dictionary.feature:25# Multiple Movie Names
//file:///C:/Users/ritio/OneDrive/Desktop/Mcast%20Degree/TestDrivenAssignmentRitiona/home/src/test/resources/dictionary.feature:35# Numeric and Symbol files
//file:///C:/Users/ritio/OneDrive/Desktop/Mcast%20Degree/TestDrivenAssignmentRitiona/home/src/test/resources/dictionary.feature:40# Invalid Characters (percentages)
//
//Undefined scenarios:
//file:///C:/Users/ritio/OneDrive/Desktop/Mcast%20Degree/TestDrivenAssignmentRitiona/home/src/test/resources/dictionary.feature:2# No word is provided
//file:///C:/Users/ritio/OneDrive/Desktop/Mcast%20Degree/TestDrivenAssignmentRitiona/home/src/test/resources/dictionary.feature:6# Authorized user is able to find a definition
//
//7 Scenarios (4 failed, 2 undefined, 1 passed)
//16 Steps (4 failed, 6 skipped, 4 undefined, 2 passed)
//0m4.584s
//
//
//java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 3
//	at home.MainClass.main(MainClass.java:26)
//	at home.StepsDefinitionMovies.i_input_jumbled_words(StepsDefinitionMovies.java:90)
//	at ?.I input jumbled words(file:///C:/Users/ritio/OneDrive/Desktop/Mcast%20Degree/TestDrivenAssignmentRitiona/home/src/test/resources/dictionary.feature:14)
//
//java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 2
//	at home.MainClass.main(MainClass.java:26)
//	at home.StepsDefinitionMovies.i_search_for_movie_name(StepsDefinitionMovies.java:109)
//	at ?.I search for movie name(file:///C:/Users/ritio/OneDrive/Desktop/Mcast%20Degree/TestDrivenAssignmentRitiona/home/src/test/resources/dictionary.feature:26)
//
//java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 1
//	at home.MainClass.main(MainClass.java:26)
//	at home.StepsDefinitionMovies.i_input_characters_and_symbols(StepsDefinitionMovies.java:144)
//	at ?.I input characters and symbols(file:///C:/Users/ritio/OneDrive/Desktop/Mcast%20Degree/TestDrivenAssignmentRitiona/home/src/test/resources/dictionary.feature:36)
//
//java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 1
//	at home.MainClass.main(MainClass.java:26)
//	at home.StepsDefinitionMovies.i_enter_a_percentage_with_the_movie_name(StepsDefinitionMovies.java:156)
//	at ?.I enter a percentage with the movie name(file:///C:/Users/ritio/OneDrive/Desktop/Mcast%20Degree/TestDrivenAssignmentRitiona/home/src/test/resources/dictionary.feature:41)
//

//You can implement missing steps with the snippets below:

@Given("I dont pass the word")
public void i_dont_pass_the_word() {
    // Write code here that turns the phrase above into concrete actions
    MainClass.main(null);
}
//
@Given("Definition is available")
public void definition_is_available(List<String> params) {

	MainClass.main(params.toArray(new String[params.size()]));
}
//
@When("I search for the word")
public void i_search_for_the_word(List<String> params) {
//    // Write code here that turns the phrase above into concrete actions
//    // For automatic transformation, change DataTable to one of
//    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
//    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
//    // Double, Byte, Short, Long, BigInteger or BigDecimal.
//    //
//    // For other transformations you can register a DataTableType.
//    throw new io.cucumber.java.PendingException();
	MainClass.main(params.toArray(new String[params.size()]));
}
//
//@Then("Return Word Does Not Exist")
//public void return_Word_Does_Not_Exist() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//

}
