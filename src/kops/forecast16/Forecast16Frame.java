package kops.forecast16;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Forecast16Frame extends JFrame{
	private JLabel enterCityName, description, temp, icon;
	private JTextField cityEntry;
	private JButton get16Forecast;
	//to display 16 days at a time, will use a JPanel 
	//the JPanel will display forecasts 
	private JPanel forecasts;
	
	public Forecast16Frame(){
		setTitle("16-Day Forecast");
		setSize(700,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
		
		setBackground(Color.CYAN);
		
		enterCityName = new JLabel();
		enterCityName.setText("Enter Name of City:");		
		add(enterCityName);
		
		cityEntry = new JTextField();
		Dimension d = new Dimension(200, 25);
		cityEntry.setMaximumSize(d);
		add(cityEntry);
		
		get16Forecast = new JButton();
		get16Forecast.setText("Get the forecast for the next 16 days");
		add(get16Forecast);
		
		forecasts = new JPanel();
		add(forecasts);
		
		get16Forecast.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				Forecast16Thread thread = new Forecast16Thread(cityEntry, description, temp, icon, forecasts);
				thread.start();
			}
		});
		
	}
}
