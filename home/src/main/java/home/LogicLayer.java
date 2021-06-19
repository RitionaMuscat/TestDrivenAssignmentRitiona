package home;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LogicLayer {
	private DataLayer dataLayer;

	public LogicLayer(DataLayer dataLayer) {
		this.dataLayer = dataLayer;
	}

	public String getCurrencyConversion(String baseCurrency, String CurrencyToGetRate, double amountToConvert) {
		double rate = 0, ConversionAmountTotal = 0;
		String returnedValues = "";

		try {

			String json = dataLayer.getCurrencyConversion(baseCurrency);
			if (json.contains("does not exist")) {
				System.out.println("Currency Cannot Be Null");
			} else {
				JSONObject jsonResponse = new JSONObject(json);
				JSONObject hits = jsonResponse.getJSONObject("rates");

				for (int i = 0; i < hits.length(); i++) {
					Double coversionRate = hits.getDouble(CurrencyToGetRate);
					rate = coversionRate;
				}
				ConversionAmountTotal = amountToConvert * rate;
				returnedValues = baseCurrency + amountToConvert + " converts to " + CurrencyToGetRate + " "
						+ ConversionAmountTotal + " today";
				return returnedValues;
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			return "-1";
		}
		return returnedValues;
	}

	public List<String> getDefinition(String term) {
		List<String> _Termlist = new ArrayList<String>();

		try {
			if (term.length() != 0 && term.contains("--") == false) {
				String json = dataLayer.getJsonDictionary(term);
				JSONObject jsonResponse = new JSONObject(json);

				JSONArray hits = jsonResponse.getJSONArray("list");

				for (int i = 0; i < hits.length(); i++) {
					JSONObject hit = hits.getJSONObject(i);
					_Termlist.add(hit.getString("word"));
					_Termlist.add(hit.getString("definition"));
					_Termlist.add("\n");
				}
			} else {
				System.out.println("Word Is not defined or incorrect");
			}

		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

		return _Termlist;
	}

	public String getMovie(String movieName) {
		String MovieName = "";
		double rating = 0;

		if (movieName != null) {
			try {
				if (movieName != "") {
					String json = dataLayer.getJsonMovie(movieName);
					JSONObject jsonResponse = new JSONObject(json);

					for (int i = 0; i < jsonResponse.length(); i++) {
						MovieName = jsonResponse.getString("title");
						rating = jsonResponse.getDouble("rating");
					 if (rating != 0.0 || Double.toString(rating) != "")
					 {
						if (rating < 4.0) {
							MovieName = "Movie: " + MovieName + "\n" + "Rating: Bad (" + rating + ")\n" + "Plot: "
									+ jsonResponse.getString("plot");
						} else if (rating > 4.0 && rating < 7.0) {
							MovieName = "Movie: " + MovieName + "\n" + "Rating: Decent (" + rating + ")\n" + "Plot: "
									+ jsonResponse.getString("plot");
						} else if (rating > 7.0 && rating < 10.0) {
							MovieName = "Movie: " + MovieName + "\n" + "Rating: Good (" + rating + ")\n" + "Plot: "
									+ jsonResponse.getString("plot");
						} else if (rating == 10.0) {
							MovieName = "Movie: " + MovieName + "\n" + "Rating: Awesome (" + rating + ")\n" + "Plot: "
									+ jsonResponse.getString("plot");
						}
					 }
					 else {
						 System.out.println("Rating is null");
					 }
					}
				} else {
					return "Movie Name is Empty";
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
			} catch (JSONException ex)
			{
				System.err.println(ex.getMessage());
			}
		} else {
			return "Movie Name Cannot Be Null!! No details returned";
		}
		if (MovieName != "")
			return MovieName;
		else
			return "No details returned";
	}
}
