package home;

import org.json.JSONObject;

public class CurrencyLogicLayer {
	private CurrencyDataLayer dataLayer;
	public CurrencyLogicLayer(CurrencyDataLayer dataLayer) {
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

}
