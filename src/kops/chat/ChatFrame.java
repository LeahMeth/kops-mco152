package kops.chat;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;

public class ChatFrame extends JFrame{

	private JTextArea type;
	private JTextField display;
	private JButton button;
	private JPanel panel;
	private JPanel lowerPanel;
	private JScrollPane scroll;
	
	public ChatFrame(){
		setTitle("Chat");
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		add(panel);
		
		type = new JTextArea(400, 300);
		type.setBackground(Color.GREEN);
		scroll = new JScrollPane(type);
		
		panel.add(scroll);
		
		lowerPanel = new JPanel();
		lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.X_AXIS));
		panel.add(lowerPanel);
		
		display = new JTextField();
		lowerPanel.add(display);
		
		button = new JButton("Click Me!");
		
		
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				try{
					URL url = new URL("http://192.168.117.111:8080");
					HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					connection.setDoOutput(true);
					OutputStream out = connection.getOutputStream();
					PrintWriter writer = new PrintWriter(out);
					writer.println("Leah: "+display.getText());
					writer.flush();
					
					//tell server that ready for response
					connection.getInputStream();
				}catch(IOException e1){
					e1.printStackTrace();
				}
			}
		});
		lowerPanel.add(button);
		
		Server server = new Server(8080);
		server.setHandler(new ChatP2PHandler(type));
		
		try {
			server.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public static void main(String[] args){
		new ChatFrame().setVisible(true);
	}
	
}
