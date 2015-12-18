package kops.contacts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class JsonReader {

	private String name;
	private Contact contact;
	private String urlString;
	private Contact[] contacts;
	
	public JsonReader(){
		urlString = "http://jsonplaceholder.typicode.com/users";
		try{
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			//get array of Contacts from Json
			Gson gson = new Gson();
			this.contacts = gson.fromJson(reader, Contact[].class);
					
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public Contact[] getContacts(){
		return this.contacts;
	}
}
