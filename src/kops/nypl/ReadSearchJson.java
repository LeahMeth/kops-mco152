package kops.nypl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class ReadSearchJson {

	private Result[] results;
	private String urlString;
	private String searchString;
	private HoldNyplAPI holder;

	public ReadSearchJson(String searchString){
		this.searchString = searchString;
		urlString = "http://api.repo.nypl.org/api/v1/items/search?q="+searchString+"&publicDomainOnly=true";
				
		try{
		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("Authorization", "Token token=\"nl409kc0uzanx9hd\"");
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(in));
		
		Gson gson = new Gson();
		this.holder = gson.fromJson(reader, HoldNyplAPI.class);
		this.results = holder.getNyplAPI().getResponse().getResults();
		
		}catch(IOException e){
			e.printStackTrace();
		}
				
	}

	public Result[] getResults() {
		return this.results;

	}

}
