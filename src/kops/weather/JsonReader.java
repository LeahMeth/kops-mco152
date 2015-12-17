package kops.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import com.google.gson.Gson;

public class JsonReader {

	private String description, icon, name;
	private double temp;
	private String urlString;
	private CurrentWeather cw;
	
	public JsonReader(String zip){
		urlString = "http://api.openweathermap.org/data/2.5/weather?zip="
			+ zip + ",us&appid=2de143494c0b295cca9337e1e96b00e0&units=imperial";
		try {
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			Gson gson = new Gson();
			
			this.cw = gson.fromJson(reader, CurrentWeather.class);
			this.name = cw.getName();
			this.description = cw.getWeather().getDescription();
			this.temp = cw.getMain().getTemp();
			this.icon = "http://openweathermap.org/img/w/" + cw.getWeather().getIcon() + ".png";
					
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public String getDescription() {
		return this.description;
	}

	public double getTemp() {
		return this.temp;
	}

	public String getIcon() {
		return this.icon;
	}
	
	public String getName(){
		return this.name;
	}
}
