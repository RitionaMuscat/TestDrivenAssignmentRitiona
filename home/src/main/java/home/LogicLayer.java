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

		if (baseCurrency != null && CurrencyToGetRate != null && amountToConvert != 0) {
			try {
				String json = dataLayer.getCurrencyConversion(baseCurrency);
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
			} catch (Exception e) {
				System.err.println(e.getMessage());
				return "-1";
			}
		} else {
			return "Values cannot be null";
		}
	}

	public List<String> getDefinition(String term) {
		List<String> _Termlist = new ArrayList<String>();
		System.out.println(term.contains("--"));

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

						if (rating <= 4.0) {
							MovieName = "Movie: " + MovieName + "\n" + "Rating: Bad (" + rating + ")\n" + "Plot: "
									+ jsonResponse.getString("plot");
						} else if (rating > 4.0 && rating <= 7.0) {
							MovieName = "Movie: " + MovieName + "\n" + "Rating: Decent (" + rating + ")\n" + "Plot: "
									+ jsonResponse.getString("plot");
						} else if (rating > 7.0 && rating <= 10.0) {
							MovieName = "Movie: " + MovieName + "\n" + "Rating: Good (" + rating + ")\n" + "Plot: "
									+ jsonResponse.getString("plot");
						} else if (rating == 10.0) {
							MovieName = "Movie: " + MovieName + "\n" + "Rating: Awesome (" + rating + ")\n" + "Plot: "
									+ jsonResponse.getString("plot");
						}
					}
				} else {
					return "Movie Name is Empty";
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		} else {
			return "Movie Name Cannot Be Null!!";
		}
		return MovieName;
	}
}
