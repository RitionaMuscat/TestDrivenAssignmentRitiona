package home;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DataLayer {
	public String getJsonMovie(String movieId) throws IOException {
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
			//.url("https://imdb-internet-movie-database-unofficial.p.rapidapi.com/film/tt4052886")
			.url("https://imdb-internet-movie-database-unofficial.p.rapidapi.com/film/"+movieId)
			.get()
			.addHeader("x-rapidapi-key", "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
			.addHeader("x-rapidapi-host", "imdb-internet-movie-database-unofficial.p.rapidapi.com")
			.build();

		Response response = client.newCall(request).execute();
		
		return response.body().string();
}
	
	public String getJsonDictionary(String term) throws IOException{
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
//			.url("https://mashape-community-urban-dictionary.p.rapidapi.com/define?term=wat")
			.url("https://mashape-community-urban-dictionary.p.rapidapi.com/define?term="+term)	
			.get()
			.addHeader("x-rapidapi-key", "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
			.addHeader("x-rapidapi-host", "mashape-community-urban-dictionary.p.rapidapi.com")
			.build();

	 Response response = client.newCall(request).execute();

		return response.body().string();
	}
	
	public String getCurrencyConversion(String Currency) throws IOException
	{
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
			.url("https://exchangerate-api.p.rapidapi.com/rapid/latest/"+Currency)
			.get()
			.addHeader("x-rapidapi-key", "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
			.addHeader("x-rapidapi-host", "exchangerate-api.p.rapidapi.com")
			.build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}
}
