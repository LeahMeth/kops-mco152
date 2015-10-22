package kops.gui;

import java.awt.Container;
//import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JFrameDemo extends JFrame {
	
	private JLabel label, label2;
	
	public JFrameDemo(){
		setTitle("JFrameDemo");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container cont = getContentPane();
		
		setLayout(new BoxLayout(cont, BoxLayout.Y_AXIS));
		
		label = new JLabel();
		label2 = new JLabel();
		label.setText("Almost Shabbos!");
		label2.setText("label");
		
		add(label);
		add(label2);
		JTextField tf = new JTextField("field");
		add(tf);
		
		JButton button1 = new JButton("Button =)");
		add(button1);
		button1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Hello there!");
				
			}
			
			
		});
		
		
	}
	

}
