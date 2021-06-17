package home;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import io.restassured.RestAssured;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StubsMovies {

	DataLayer data = new DataLayer();
	LogicLayer logic = new LogicLayer(data);
	@BeforeAll
	static void setup() {
		RestAssured.baseURI = SetupConstants.MOVIE_URL;

	}

	@Test
	void testMovies() {
		System.out.println("**--- Test Movies executed ---**");
		data = Mockito.mock(DataLayer.class);
		logic = Mockito.mock(LogicLayer.class);
		
		String movieDetails = logic.getMovie("friends");

		when(logic.getMovie("friends")).thenReturn(movieDetails);
	    assertEquals(movieDetails, logic.getMovie("friends"));
	}
	
	@Test
	void testJSONCurrency() {
		System.out.println("**--- Test Currency executed ---**");
		data = Mockito.mock(DataLayer.class);
		logic = Mockito.mock(LogicLayer.class);
		
		String Amounts = logic.getCurrencyConversion("GBP", "EUR",50);

		when(logic.getCurrencyConversion("GBP", "EUR",50)).thenReturn(Amounts);
	    assertEquals(Amounts, logic.getCurrencyConversion("GBP", "EUR",50));
	}
	
	@Test
	void testGetDefinition() {
		System.out.println("**--- Test Defnitions executed ---**");
		data = Mockito.mock(DataLayer.class);
		logic = Mockito.mock(LogicLayer.class);
		
		ArrayList<String> definition = new ArrayList<String>();
	    definition.addAll(logic.getDefinition("trees"));
		when( logic.getDefinition("trees")).thenReturn(definition);
	    assertEquals(definition,  logic.getDefinition("trees"));
	}

}
