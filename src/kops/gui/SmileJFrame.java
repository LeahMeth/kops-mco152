package kops.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class SmileJFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public static void main(String[] args){
		
		 new SmileJFrame().setVisible(true);
		
		
	}
	
	
	public SmileJFrame(){
		
		setTitle("Smiley");
		setSize(600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		BorderLayout layout  = new BorderLayout();
		Container c = getContentPane();
		c.setLayout(layout);
		c.add(new SmileComponent(), BorderLayout.CENTER);
		
		
	}
	
	
}
