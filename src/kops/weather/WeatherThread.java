package kops.weather;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class WeatherThread extends Thread{

	private JLabel description, temp, icon, name;
	private JTextField getZip;	
	
	public WeatherThread(JTextField getZip, JLabel description, JLabel temp,
			JLabel icon, JLabel name) {
		this.getZip = getZip;
		this.description = description;
		this.temp = temp;
		this.icon = icon;
		this.name = name;
	}
	
	public void run() {
		String zip =  getZip.getText();
		
		
		try {
			JsonReader jr = new JsonReader(zip);		
			
			String urlString = jr.getIcon();
			URL url = new URL(urlString);
			ImageIcon icon = new ImageIcon(url);
			Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
			icon = new ImageIcon(image);
			
			this.description.setText(jr.getDescription());
			this.temp.setText(jr.getTemp()+" F");
			this.icon.setIcon(icon);
			this.name.setText(jr.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	
}
