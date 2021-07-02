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

	MovieDataLayer data = new MovieDataLayer();
	MovieLogicLayer logic = new MovieLogicLayer(data);
	
	CurrencyDataLayer data1 = new CurrencyDataLayer();
	CurrencyLogicLayer logic2 = new CurrencyLogicLayer(data1);
	
	DictionaryDataLayer data2 = new DictionaryDataLayer();
	DictionaryLogicLayer logic3 = new DictionaryLogicLayer(data2);
	
	@BeforeAll
	static void setup() {
		RestAssured.baseURI = SetupConstants.MOVIE_URL;

	}

	@Test
	void testMovies() {
		System.out.println("**--- Test Movies executed ---**");
		data = Mockito.mock(MovieDataLayer.class);
		logic = Mockito.mock(MovieLogicLayer.class);
		
		String movieDetails = logic.getMovie("friends");

		when(logic.getMovie("friends")).thenReturn(movieDetails);
	    assertEquals(movieDetails, logic.getMovie("friends"));
	}
	
	@Test
	void testJSONCurrency() {
		System.out.println("**--- Test Currency executed ---**");
		data1 = Mockito.mock(CurrencyDataLayer.class);
		logic2 = Mockito.mock(CurrencyLogicLayer.class);
		
		String Amounts = logic2.getCurrencyConversion("GBP", "EUR",50);

		when(logic2.getCurrencyConversion("GBP", "EUR",50)).thenReturn(Amounts);
	    assertEquals(Amounts, logic2.getCurrencyConversion("GBP", "EUR",50));
	}
	
	@Test
	void testGetDefinition() {
		System.out.println("**--- Test Defnitions executed ---**");
		data2 = Mockito.mock(DictionaryDataLayer.class);
		logic3 = Mockito.mock(DictionaryLogicLayer.class);
		
		ArrayList<String> definition = new ArrayList<String>();
	    definition.addAll(logic3.getDefinition("trees"));
		when( logic3.getDefinition("trees")).thenReturn(definition);
	    assertEquals(definition,  logic3.getDefinition("trees"));
	}

}
