package home;

import org.mockito.Mockito;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

class Stubs {

	MovieDataLayer data = new MovieDataLayer();
	MovieLogicLayer logic = new MovieLogicLayer(data);
	
	CurrencyDataLayer data1 = new CurrencyDataLayer();
	CurrencyLogicLayer logic2 = new CurrencyLogicLayer(data1);
	
	DictionaryDataLayer data2 = new DictionaryDataLayer();
	DictionaryLogicLayer logic3 = new DictionaryLogicLayer(data2);



	void testMovies() {
		System.out.println("**--- Test Movies executed ---**");
		data = Mockito.mock(MovieDataLayer.class);
		logic = Mockito.mock(MovieLogicLayer.class);
		
		

		when(logic.getMovie("friends")).thenReturn("Movie Details returned");
	}
	

	void testJSONCurrency() {
		System.out.println("**--- Test Currency executed ---**");
		data1 = Mockito.mock(CurrencyDataLayer.class);
		logic2 = Mockito.mock(CurrencyLogicLayer.class);
		
        when(logic2.getCurrencyConversion("GBP", "EUR",50)).thenReturn("Currency Conversion Returned");

	}

	void testGetDefinition() {
		System.out.println("**--- Test Defnitions executed ---**");
		data2 = Mockito.mock(DictionaryDataLayer.class);
		logic3 = Mockito.mock(DictionaryLogicLayer.class);
		
		ArrayList<String> definition = new ArrayList<String>();
	    definition.addAll(logic3.getDefinition("trees"));
		when( logic3.getDefinition("trees")).thenReturn(definition);
	}

}
