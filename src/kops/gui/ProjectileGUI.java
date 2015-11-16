package kops.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ProjectileGUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel time, velocity, angle, result;
	private JTextField tInput, vInput, aInput;
	private JButton calculate;
	
	public ProjectileGUI(){
		
		setTitle("Projectile");
		setSize(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cont = getContentPane();
		setLayout(new BoxLayout(cont, BoxLayout.Y_AXIS));
		
		time = new JLabel();
		time.setText("Time:");
		add(time);
		
		tInput = new JTextField();
		add(tInput);
		
		velocity = new JLabel();
		velocity.setText("Velocity:");
		add(velocity);
		
		vInput = new JTextField();
		add(vInput);
		
		angle = new JLabel();
		angle.setText("Angle:");
		add(angle);
		
		aInput = new JTextField();
		add(aInput);
		
		calculate = new JButton("Calculate");
		add(calculate);
		
		result = new JLabel();
		add(result);
		
		calculate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				double t = Double.parseDouble(tInput.getText());
				double a = Double.parseDouble(aInput.getText());
				double v = Double.parseDouble(vInput.getText());
				
				Projectile p = new Projectile(t, a, v);
				String sresult = "X = "+ p.getX().toString() + ", Y = " + p.getY().toString();
				result.setText(sresult);
					
				
			}
		});
	}
	
}
