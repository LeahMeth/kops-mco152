package kops.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	@Override 
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		//g.drawLine(0, 300, 600, 50);   // (0,0) = origin is at topleft corner
		g.setColor(Color.yellow);
		g.fillOval(150, 150, 300, 300);
		
		g.setColor(Color.blue);
		g.fillOval(230, 250, 30, 40);
		g.fillOval(350, 250, 30, 40);
		
		g.setColor(Color.green);
		g.fillOval(290, 320, 30, 30);
		
		g.setColor(Color.magenta);
		g.drawArc(200, 300, 200, 100, 180, 180);
		
		
	}
	
	
}
