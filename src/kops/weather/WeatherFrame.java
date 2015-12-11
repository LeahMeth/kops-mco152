package kops.weather;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.google.gson.Gson;

public class WeatherFrame extends JFrame{

	private JLabel description, temp, zipcode;
	private JTextField z;
	private JButton getWeather;
	
	
	public WeatherFrame(){
		setTitle("Weather");
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cont = getContentPane();
		setLayout(new BoxLayout(cont, BoxLayout.Y_AXIS));
		
		
		
		zipcode = new JLabel();
		zipcode.setText("Enter zip code:");
		add(zipcode);
		
		z = new JTextField("",15);
		
		add(z);
		
		getWeather = new JButton();
		getWeather.setText("Get Weather Report");
		add(getWeather);
		
		getWeather.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Clicked Button");
				String zip =  z.getText();
				URL url; 
				InputStream in = null;
				try {
					url = new URL("http://api.openweathermap.org/data/2.5/weather?zip="+zip+",us&appid=2de143494c0b295cca9337e1e96b00e0&units=imperial");
					HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					in  = connection.getInputStream();
					System.out.println("made a url connection");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				
				//CurrentWeather object
				final Gson gson = new Gson();
				CurrentWeather cw = gson.fromJson(reader, CurrentWeather.class);
								
				description = new JLabel();
				description.setText(cw.getDescription());
				add(description);
				System.out.println(description.toString());
				
				temp = new JLabel();
				temp.setText(cw.getTemp());
				temp.setMaximumSize(temp.getPreferredSize() );
				add(temp);
				
				
				
				
				
				
			}
			
		});
		
		
		
		
		
		
	}
	
	
	
}
