package home;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class LogicLayer {
	private DataLayer dataLayer;

	public LogicLayer(DataLayer dataLayer) {
		this.dataLayer = dataLayer;
	}

	public String getCurrencyConversion(String baseCurrency, String CurrencyToGetRate, double amountToConvert) {
		double rate = 0;
		double ConversionAmountTotal = 0;
		String returnedValues = "";
		if (baseCurrency != "" && CurrencyToGetRate == "" && amountToConvert != 0) {
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
			} catch (IOException e) {
				System.err.println(e.getMessage());
				return "-1";
			}
		} else {
			return "Values cannot be null";
		}
	}

	public List<String> getDefinition(String term) {
		List<String> _Termlist = new ArrayList<String>();
		if (term != null) {
			try {
				String json = dataLayer.getJsonDictionary(term);
				if (json != "") {
					JSONObject jsonResponse = new JSONObject(json);
					JSONArray hits = jsonResponse.getJSONArray("list");

					for (int i = 0; i < hits.length(); i++) {
						JSONObject hit = hits.getJSONObject(i);
						_Termlist.add(hit.getString("word"));
						_Termlist.add(hit.getString("definition"));
						_Termlist.add("\n");
					}

					return _Termlist;
				} else {
					System.out.println("Term was not found");
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		} else {
			System.out.println("Word Is not defined");
		}
		return _Termlist;
	}

	public String getMovie(String movieName) {
		if (movieName != null) {
			String MovieName = "";
			double rating = 0;
			try {
				String json = dataLayer.getJsonMovie(movieName);
				JSONObject jsonResponse = new JSONObject(json);

				for (int i = 0; i < jsonResponse.length(); i++) {
					MovieName = jsonResponse.getString("title");
					rating = jsonResponse.getDouble("rating");
					if (rating <= 4.0) {
						MovieName = "Movie: " + MovieName + "\n" + "Rating: Bad (" + rating + ")\n" + "Plot: "
								+ jsonResponse.getString("plot");
					} else if (rating >= 4.0 && rating <= 7.0) {
						MovieName = "Movie: " + MovieName + "\n" + "Rating: Decent (" + rating + ")\n" + "Plot: "
								+ jsonResponse.getString("plot");
					} else if (rating >= 7.0 && rating <= 10.0) {
						MovieName = "Movie: " + MovieName + "\n" + "Rating: Good (" + rating + ")\n" + "Plot: "
								+ jsonResponse.getString("plot");
					} else if (rating == 10.0) {
						MovieName = "Movie: " + MovieName + "\n" + "Rating: Awesome (" + rating + ")\n" + "Plot: "
								+ jsonResponse.getString("plot");
					}
				}

			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
			return MovieName;
		} else
			return "Missing Parameter Movie Name";
	}
}
