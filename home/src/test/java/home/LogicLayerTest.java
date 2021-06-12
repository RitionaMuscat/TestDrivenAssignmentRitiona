package home;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LogicLayerTest {

	DataLayer dataLayer = new DataLayer();
	LogicLayer logic = new LogicLayer(dataLayer);
	
	String baseCurrency = "EUR", currencyToConvertTo = "GBP",word = "apple",movieName = "friends";	
	Double amount = 50.00;
	@Test
	void movieTest() {
		System.out.println(logic.getMovie(movieName));
		System.out.println(logic.getMovie(""));
		System.out.println(logic.getMovie("Fear the Walking Dead"));
		System.out.println(logic.getMovie("Black Money Love"));
		System.out.println(logic.getMovie("Breaking Bad"));
		System.out.println(logic.getMovie("The Flash"));
		System.out.println(logic.getMovie(null));
		System.out.println(logic.getMovie("Disaster Movie"));
	}

	@Test 
	void jsonDictionaryTest(){
		System.out.println(logic.getDefinition(word));
		System.out.println(logic.getDefinition("--"));
		System.out.println(logic.getDefinition(""));
	}
	
	@Test 
	void jsonCurrencyConversion(){
		System.out.println(logic.getCurrencyConversion(baseCurrency,currencyToConvertTo,amount));
		System.out.println(logic.getCurrencyConversion(baseCurrency,currencyToConvertTo,0));
		System.out.println(logic.getCurrencyConversion(baseCurrency,currencyToConvertTo,0));
		System.out.println(logic.getCurrencyConversion(baseCurrency,null,0));
		System.out.println(logic.getCurrencyConversion("",null,0));
		System.out.println(logic.getCurrencyConversion(null,null,0));
		System.out.println(logic.getCurrencyConversion("","",0));
	}

}
