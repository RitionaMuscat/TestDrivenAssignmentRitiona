package home;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class LogicLayer {
	private DataLayer dataLayer;
	public LogicLayer(DataLayer dataLayer)
	{
		this.dataLayer = dataLayer;
	}
	
	public String getCurrencyConversion(String baseCurrency, String CurrencyToGetRate)
	{
		double rate = 0;
		try {
			String json = dataLayer.getCurrencyConversion(baseCurrency);
			JSONObject jsonResponse = new JSONObject(json);
			JSONObject hits = jsonResponse.getJSONObject("rates");

			for (int i = 0; i < hits.length(); i++) {
				Double coversionRate = hits.getDouble(CurrencyToGetRate);
				rate = coversionRate;
			}
			return  CurrencyToGetRate+" "+rate;
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return "-1";
		}
	}
	
	public List<String> getDefinition(String term) {
		List<String> _Termlist=new ArrayList<String>();  
		try {
			String json = dataLayer.getJsonDictionary(term);
			JSONObject jsonResponse = new JSONObject(json);
			JSONArray hits = jsonResponse.getJSONArray("list");

			for (int i = 0; i < hits.length(); i++) {
				JSONObject hit = hits.getJSONObject(i);
				_Termlist.add(hit.getString("word"));
				_Termlist.add(hit.getString("definition"));
				_Termlist.add("\n"); 
			}
			return  _Termlist;
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return _Termlist;
	}
	

	public String getMovie(String movieName) {
		String MovieName = "";
		try {
			String json = dataLayer.getJsonMovie(movieName);
			JSONObject jsonResponse = new JSONObject(json);

			for (int i = 0; i < jsonResponse.length(); i++) {
				MovieName = jsonResponse.getString("title");
				MovieName = "Movie: "+ MovieName + "\n" + "Rating: "+ jsonResponse.getString("rating") + "\n" + "Plot: " + jsonResponse.getString("plot");
			}
			return  MovieName;
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return MovieName;
	
	}
}
