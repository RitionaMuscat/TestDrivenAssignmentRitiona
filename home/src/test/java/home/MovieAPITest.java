package home;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.junit.jupiter.api.Test;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

class MovieAPITest {

	DataLayer dataLayer = new DataLayer();
	LogicLayer logic = new LogicLayer(dataLayer);
	String movieName = "friends";
	@Test
	void missingParameters() throws NullPointerException {
		ArrayList<String> arrayMovie = new ArrayList<String>();
		logic.getMovie(movieName);
	}
	
	@Test
	void missingAuthenticationHeaders() throws JSONException, IOException
	{
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
				.url("https://imdb-internet-movie-database-unofficial.p.rapidapi.com/film/friends")
				.get()
				//.addHeader("x-rapidapi-key", "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
				.addHeader("x-rapidapi-host", "imdb-internet-movie-database-unofficial.p.rapidapi.com")
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
				.url("https://imdb-internet-movie-database-unofficial.p.rapidapi.com/film/friends")
				.get()
				.addHeader("x-rapidapi-key","ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac83" /* "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348"*/)
				.addHeader("x-rapidapi-host", "imdb-internet-movie-database-unofficial.p.rapidapi.com")
				.build();

		
		Response response = client.newCall(request).execute();
	
		if(response.code() == 401)
			System.out.println("Invalid Key");
		else
			System.out.println("Invalid Key " + response.body().string());
	}
	
	@Test
	void invalidParameters() throws Exception {
		logic.getMovie(null);
	}
	
	@Test
	void getMovie() throws Exception {
	   logic.getMovie(movieName.toString());
	}
	
	

}
