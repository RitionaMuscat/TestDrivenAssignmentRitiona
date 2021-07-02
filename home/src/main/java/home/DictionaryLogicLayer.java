package home;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class DictionaryLogicLayer {
	private DictionaryDataLayer dataLayer;

	public DictionaryLogicLayer(DictionaryDataLayer dataLayer) {
		this.dataLayer = dataLayer;
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
}
