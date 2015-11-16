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

public class QuadraticGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel a, b, c, x, result;
	private JTextField aInput, bInput, cInput;
	private JButton calculate;

	public QuadraticGUI() {
		setTitle("Quadratic Equation");
		setSize(200, 230);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container cont = getContentPane();

		setLayout(new BoxLayout(cont, BoxLayout.Y_AXIS));

		a = new JLabel();
		a.setText("A:");
		add(a);
		
		aInput = new JTextField();
		add(aInput);
		

		b = new JLabel();
		b.setText("B:");
		add(b);
		
		bInput = new JTextField();
		add(bInput);
		

		c = new JLabel();
		c.setText("C:");
		add(c);
		
		cInput = new JTextField();
		add(cInput);
		
		
		x = new JLabel();
		x.setText("X=");
		add(x);

		calculate = new JButton("Calculate");
		add(calculate);
		
		result = new JLabel();
		add(result);
		
		calculate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Double ainput = Double.parseDouble(aInput.getText());
				double binput = Double.parseDouble(bInput.getText());
				double cinput = Double.parseDouble(cInput.getText());
				
				
				QuadraticEquation q = new QuadraticEquation(ainput, binput, cinput);
				String sresult = (q.getPositiveX().toString()+", "+q.getNegativeX().toString());
				result.setText(sresult);
					
				
			}
		});

	}
}
