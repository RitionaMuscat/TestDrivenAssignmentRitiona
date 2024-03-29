package home;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

public class MovieLogicLayer {
	private MovieDataLayer dataLayer;

	public MovieLogicLayer(MovieDataLayer dataLayer) {
		this.dataLayer = dataLayer;
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
					 if ( Double.toString(rating) != "")
					 {
						if (rating < 4.0) {
							MovieName = "Movie: " + MovieName + "Rating: Bad (" + rating + ")" + " Plot: "
									+ jsonResponse.getString("plot");
						} else if (rating > 4.0 && rating < 7.0) {
							MovieName = "Movie: " + MovieName + "Rating: Decent (" + rating + ")" + " Plot: "
									+ jsonResponse.getString("plot");
						} else if (rating > 7.0 && rating < 10.0) {
							MovieName = "Movie: " + MovieName + "Rating: Good (" + rating + ")" + " Plot: "
									+ jsonResponse.getString("plot");
						} else if (rating == 10.0) {
							MovieName = "Movie: " + MovieName + "Rating: Awesome (" + rating + ")" + " Plot: "
									+ jsonResponse.getString("plot");
						}
					 }

					}
				} else {
					return "Movie Name is Empty";
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (JSONException ex)
			{
				System.out.println(ex.getMessage());
			}
		} else {
			return "Movie Name Cannot Be Null!! No details returned";
		}

			return MovieName;
	
	}
}
