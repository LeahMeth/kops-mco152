package kops.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;

public class ProjectileJFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public static void main(String[] args) {
		new ProjectileJFrame().setVisible(true);
	}
	
	
	public ProjectileJFrame(){
		setTitle("Projectile Arc");
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BorderLayout layout = new BorderLayout();
		Container c = getContentPane();
		c.setLayout(layout);
		c.add(new ProjectileComponent(), BorderLayout.CENTER);
	}

}
