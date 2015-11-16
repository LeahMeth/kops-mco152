package kops.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class ProjectileComponent extends JComponent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		double firstX = 0;
		double firstY = 300;
		double secondX;
		double secondY;
		
		for(int i = 0; i < 10; i++){
			Projectile p = new Projectile(i, 31, 20);
			secondX = p.getX();		
			secondY =(getHeight() - p.getY()) ;	
			((Graphics2D) g).draw(new Line2D.Double(firstX, firstY, secondX, secondY));
			firstX = secondX;
			firstY = secondY;
			
		}
		
		
	}

}
