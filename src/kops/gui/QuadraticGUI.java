package kops.gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class QuadraticGUI extends JFrame {

	private JLabel a, b, c, x, result;
	private JTextField aInput, bInput, cInput;
	private JButton calculate;

	public QuadraticGUI() {
		setTitle("Quadratic Equation");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container cont = getContentPane();

		setLayout(new BoxLayout(cont, BoxLayout.Y_AXIS));

		a = new JLabel();
		a.setText("A:");
		add(a);
		aInput = new JTextField();
		add(aInput);
		aInput = aInput.getText();

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
		

		calculate = new JButton("Calculate");
		add(calculate);
		calculate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				QuadraticEquation q = new QuadraticEquation(aInput, bInput, cInput);
				
			}

		});

	}
}
