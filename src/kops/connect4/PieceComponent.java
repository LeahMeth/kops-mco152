package kops.connect4;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class PieceComponent extends JComponent {
    
	private Color color;
	public PieceComponent(Color color){
    	this.color = color;
    }
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillOval(10, 10, 80, 80);
        super.repaint();
    }

	/*private Color getColor() {
		
		return color;
	}*/
	
	public void setColor(Color color){
		this.color = color;
	}
}
