package home;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class UnitTest {

	DataLayer dataLayer = new DataLayer();
	LogicLayer logic = new LogicLayer(dataLayer);
	

	Double amount = 50.00;
	ArrayList<String> movieNames = new ArrayList<String>();
	ArrayList<String> words = new ArrayList<String>();
	ArrayList<String> baseCurrency = new ArrayList<String>();
	ArrayList<String> currencyToConvertTo = new ArrayList<String>();
	@Test
	void movieTest() {
		movieNames.add("friends");
		movieNames.add("");
		movieNames.add("Fear the Walking Dead");
		movieNames.add("Black Money Love");
		movieNames.add("Breaking Bad");
		movieNames.add("The Flash");
		movieNames.add(null);
		movieNames.add("Disaster Movie");
		
		for (int i = 0; i < movieNames.size(); i++)
		{
			System.out.println(logic.getMovie(movieNames.get(i)));
		}

	}

	@Test 
	void jsonDictionaryTest(){
		words.add("pencil");
		words.add("biro");
		words.add("chicken leg");
		for(int j = 0; j < words.size(); j ++)
		{
			System.out.println(logic.getDefinition(words.get(j)));
		}
		System.out.println(logic.getDefinition("apple"));
		System.out.println(logic.getDefinition("--"));
		System.out.println(logic.getDefinition(""));
	}
	
	@Test 
	void jsonCurrencyConversion(){
		baseCurrency.add("GBP");
		baseCurrency.add("USD");
		baseCurrency.add("EUR");
		baseCurrency.add("CAD");
		baseCurrency.add("");
		baseCurrency.add(null);
		currencyToConvertTo.add("NZD");
		currencyToConvertTo.add("BRL");
		currencyToConvertTo.add("AUD");
		currencyToConvertTo.add("INR");
		currencyToConvertTo.add("");
		currencyToConvertTo.add(null);
		for (int k = 0; k < baseCurrency.size(); k++)
		{
			System.out.println(logic.getCurrencyConversion(baseCurrency.get(k),currencyToConvertTo.get(k),amount));
			
		}

	}

}
