package home;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import home.CurrencyDataLayer;
import home.CurrencyLogicLayer;
import home.DictionaryDataLayer;
import home.DictionaryLogicLayer;
import home.MovieDataLayer;
import home.MovieLogicLayer;

class UnitTest {

	MovieDataLayer data = new MovieDataLayer();
	MovieLogicLayer logic = new MovieLogicLayer(data);
	
	CurrencyDataLayer data1 = new CurrencyDataLayer();
	CurrencyLogicLayer logic2 = new CurrencyLogicLayer(data1);
	
	DictionaryDataLayer data2 = new DictionaryDataLayer();
	DictionaryLogicLayer logic3 = new DictionaryLogicLayer(data2);
	

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
			System.out.println(logic3.getDefinition(words.get(j)));
		}
		System.out.println(logic3.getDefinition("apple"));
		System.out.println(logic3.getDefinition("--"));
		System.out.println(logic3.getDefinition(""));
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
			System.out.println(logic2.getCurrencyConversion(baseCurrency.get(k),currencyToConvertTo.get(k),amount));
			
		}

	}

}
