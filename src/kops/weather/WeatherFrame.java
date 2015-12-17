package kops.weather;


import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WeatherFrame extends JFrame{

	private JLabel description, temp, zipcode, icon, name;
	private JTextField getZip;
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
		
		getZip = new JTextField();
		Dimension d = new Dimension(300, 20);
		getZip.setMaximumSize(d);
		add(getZip);
		
		getWeather = new JButton();
		getWeather.setText("Get Weather Report");
		add(getWeather);
		
		name = new JLabel();
		add(name);
		
		description = new JLabel();
		add(description);
		
		
		temp = new JLabel();
		add(temp);
		
		icon = new JLabel();
		add(icon);
		
		
		getWeather.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				WeatherThread thread = new WeatherThread(getZip, description, temp, icon, name);
				thread.start();
				
			}
			
		});
		
		
		
		
		
		
	}
	
	
	
}
