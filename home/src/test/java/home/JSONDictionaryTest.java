package home;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.junit.jupiter.api.Test;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

class JSONDictionaryTest {

	DataLayer dataLayer = new DataLayer();
	LogicLayer logic = new LogicLayer(dataLayer);
	String word = "Who";
	
	@Test
	void missingParameters() throws JSONException {
		System.out.println(logic.getDefinition(""));
		}
	
	@Test
	void missingAuthenticationHeaders() throws JSONException, IOException
	{
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
				.url("https://mashape-community-urban-dictionary.p.rapidapi.com/define?term=Who")	
				.get()
				//.addHeader("x-rapidapi-key", "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
				.addHeader("x-rapidapi-host", "mashape-community-urban-dictionary.p.rapidapi.com")
				.build();

		Response response = client.newCall(request).execute();
		String missingAPIKey = "Missing API Key";
		
		if(response.code() == 401)
			System.out.println("\n"+"missingAuthenticationHeaders " + missingAPIKey);
		else
			System.out.println("\n"+"missingAuthenticationHeaders " + response.body().string());
	}
	
	@Test
	void invalidKey() throws JSONException, IOException
	{
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
				.url("https://mashape-community-urban-dictionary.p.rapidapi.com/define?term=Who")	
				.get()
				.addHeader("x-rapidapi-key", "1234"/* "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348"*/)
				.addHeader("x-rapidapi-host", "mashape-community-urban-dictionary.p.rapidapi.com")
				.build();

		Response response = client.newCall(request).execute();
	
		if(response.code() == 401)
			System.out.println("Invalid Key");
		else
			System.out.println("Invalid Key " + response.body().string());
	}
	
	@Test
	void invalidParameters() throws Exception {
		ArrayList<String> arrayDictionary = new ArrayList<String>();
		Integer wordInNumeric = 123 ;
		arrayDictionary.addAll(logic.getDefinition(wordInNumeric.toString()));
		if (arrayDictionary.size() == 0 )
			System.out.println("\n"+"Invalid Parameters, word should be in string" );
		else
			System.out.println("\n"+"invalidParameters "+arrayDictionary.toString());
	}
	
	@Test
	void getDefinition() throws Exception {
		ArrayList<String> arrayDictionary = new ArrayList<String>();
		arrayDictionary.addAll(logic.getDefinition(word.toString()));
		if (arrayDictionary.size() == 0 )
			System.out.println("\n"+"No word" );
		else
			System.out.println("\n"+"getDefinition "+arrayDictionary.toString());
	}

}
