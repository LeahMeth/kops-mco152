package kops.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import com.google.gson.Gson;

public class TestWeatherGUI {
	public TestWeatherGUI()throws IOException{}
	
	URL url = new URL("http://api.openweathermap.org/data/2.5/weather?zip=11367,us&appid=2de143494c0b295cca9337e1e96b00e0&units=imperial");
	HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	InputStream in  = connection.getInputStream();
	BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	
	//CurrentWeather object
	final Gson gson = new Gson();
	CurrentWeather cw = gson.fromJson(reader, CurrentWeather.class);
	
	//has Weather[]
	Weather weather[] = cw.getWeather();
	
	
	
	//has Main object
	
}
