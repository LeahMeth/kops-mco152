package kops.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
import java.net.URL;

public class HttpURLConnectionDemo {

	public static void main(String[] args) throws IOException {
		
		//connect - in HW will concatenate zip into below link
		
		URL url = new URL("http://api.openweathermap.org/data/2.5/weather?zip=11367,us&appid=2de143494c0b295cca9337e1e96b00e0&units_imperial");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		//read stream
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String s;
		while((s = reader.readLine()) != null){
			System.out.println(s);
		}
		
	}

}
