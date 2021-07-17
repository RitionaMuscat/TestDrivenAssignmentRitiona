package home;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) // Framework to Run the tests
@CucumberOptions(
	strict = true, // undefined and pending steps should be treated as errors
	monochrome = true, // simple output 
	
	dryRun = false,
	features = "src/test/resources/movie.feature",
	glue= {"StepsDefinitionMovies"}
)
public class MovieTestCucumber {
	
}
