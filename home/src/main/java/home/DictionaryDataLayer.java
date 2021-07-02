package home;
import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class DictionaryDataLayer {
	public String getJsonDictionary(String term) throws IOException{

		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
				.url("https://mashape-community-urban-dictionary.p.rapidapi.com/define?term="+term)	
				.get()
				.addHeader("x-rapidapi-key", "ff143ffed2msh2f1f7c558b7c62dp13f2b0jsnd361f3ac8348")
				.addHeader("x-rapidapi-host", "mashape-community-urban-dictionary.p.rapidapi.com")
				.build();

		Response response = client.newCall(request).execute();

		return response.body().string();
	}

}
