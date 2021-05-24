package home;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

class JsonCurrency {

	DataLayer dataLayer = new DataLayer();
	LogicLayer logic = new LogicLayer(dataLayer);
	Double amountToConvert = 11.20;
	String baseCurrency = "EUR";
	String CurrencyToGetRate = "GBP";
	
	@Test
	void missingParameters() throws JSONException, IOException {
		logic.getCurrencyConversion(baseCurrency, "", 0);
	}
	
	@Test
	void missingAuthenticationHeaders() throws JSONException, IOException
	{
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
				.url("https://exchangerate-api.p.rapidapi.com/rapid/latest/"+baseCurrency)
				.get()
				//.addHeader("x-rapidapi-key", "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
				.addHeader("x-rapidapi-host", "exchangerate-api.p.rapidapi.com")
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
				.url("https://exchangerate-api.p.rapidapi.com/rapid/latest/"+baseCurrency)
				.get()
				.addHeader("x-rapidapi-key","EUR" /*"ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348"*/)
				.addHeader("x-rapidapi-host", "exchangerate-api.p.rapidapi.com")
				.build();
		Response response = client.newCall(request).execute();
	
		if(response.code() == 401)
			System.out.println("Invalid Key");
		else
			System.out.println("Invalid Key " + response.body().string());
	}
	
	@Test
	void invalidParameters() throws Exception {
		logic.getCurrencyConversion("!", CurrencyToGetRate, amountToConvert);
		if (amountToConvert == 0.00 || baseCurrency == "" || baseCurrency == "" )
			System.out.println("\n"+"Invalid Parameters, amount should not be 0" );
		else
			System.out.println("\n"+"invalidParameters "+amountToConvert);
	}
	
	@Test
	void getConvertedAmount() throws Exception {
		logic.getCurrencyConversion(baseCurrency, CurrencyToGetRate, amountToConvert);
	}

}
