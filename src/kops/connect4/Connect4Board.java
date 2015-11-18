package kops.connect4;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Connect4Board extends JFrame implements ActionListener{

	private int[][] board;
	private JFrame frame;
	private JPanel mainPanel, buttons, grid;
	private ImageIcon img = new ImageIcon(getClass().getResource("blue box down"));
	private JButton column1, column2, column3, column4, column5, column6, column7; 
	
	char player; 	//keeps track of which player's turn it is
	
	
	
	public Connect4Board(){
		this.board = new int[7][6];		//the board will have 7 columns and 6 rows
	}	
	
	
	
	public void setUp() {
		frame.setTitle("Connect 4");
		frame.setSize(700, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		//add buttons to the button panel
		buttons.setLayout(mgr);
		buttons.add(column1 = new JButton (img)); 
		buttons.add(column2 = new JButton (img));
		buttons.add(column3 = new JButton (img));
		buttons.add(column4 = new JButton (img));
		buttons.add(column5 = new JButton (img));
		buttons.add(column6 = new JButton (img));
		buttons.add(column7 = new JButton (img));
		
		//create grid
		grid.setBackground(Color.cyan);
		
		
		//add subpanels
		mainPanel.add(buttons);
		mainPanel.add(grid);
		
		
		
		frame.getContentPane().add(mainPanel);
		//or = frame.setContentPane(mainPanel);
		
		
	}

	
	
	public void startGame() {
		
		
	}
	
	
	
	public boolean checkIfWon(){
		return false;
		
	}

	
	
	public boolean playAgain() {
		
		//if want to play again
		if()
		return true;
		
		//if don't want to play again
		frame.dispose();
		
	}

	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()) == column1){
			addToRow(1);
		}
		
	}

	
	
	public void addToRow(int i) {
		
		
	}

	

}
