package kops.connect4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Connect4Board extends JFrame {

	private PieceComponent boardGUI[][] = new PieceComponent[7][6];	// for GUI purposes
	private int board[][] = new int[7][6];		// for calculating next spot in column and calculating winner
												// 0 = empty, 1 = red, 2 = yellow
	//pointers for each column
	int p1=5, p2=5, p3=5, p4=5, p5=5, p6=5, p7=5;
	
	
	private JPanel mainPanel, buttons, grid;
	private ImageIcon img = new ImageIcon("button images/blue down arrow.PNG");
	private JButton column1, column2, column3, column4, column5, column6, column7; 

	boolean haveWinner = false;
	char player = 'R'; 	//keeps track of which player's turn it is
						//Red starts
	
	public Connect4Board(){
		
		startGame();
	}	
	
	

	public void startGame() {
		
			setUp();	//sets up window and panels and begins game play			
		
		
	}
	
	
	
	public void setUp() {
		setTitle("Connect 4");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(745,730);
		
		
	    
		//add buttons to the button panel and connect buttons to actionListeners
	    buttons = new JPanel();
	    
		buttons.add(column1 = new JButton (img)); 
		column1.setPreferredSize(new Dimension(100,100));
		column1.addActionListener(new C1Listener());
		buttons.add(column2 = new JButton (img));
		column2.setPreferredSize(new Dimension(100,100));
		column2.addActionListener(new C2Listener());
		buttons.add(column3 = new JButton (img));
		column3.setPreferredSize(new Dimension(100,100));
		column3.addActionListener(new C3Listener());
		buttons.add(column4 = new JButton (img));
		column4.setPreferredSize(new Dimension(100,100));
		column4.addActionListener(new C4Listener());
		buttons.add(column5 = new JButton (img));
		column5.setPreferredSize(new Dimension(100,100));
		column5.addActionListener(new C5Listener());
		buttons.add(column6 = new JButton (img));
		column6.setPreferredSize(new Dimension(100,100));
		column6.addActionListener(new C6Listener());
		buttons.add(column7 = new JButton (img));
		column7.setPreferredSize(new Dimension(100,100));
		column7.addActionListener(new C7Listener());
		
		
		//fill grid panel
		grid = new JPanel();
		grid.setLayout(new GridLayout(6, 7));
		grid.setPreferredSize(new Dimension(740,582));
		grid.setBackground(Color.BLUE);
		
		for(int i = 0; i < 7; i++){
			for(int j = 0; j <6; j++){
			boardGUI[i][j] = new PieceComponent(Color.WHITE);
			board[i][j] = 0;
            grid.add(boardGUI[i][j]);
			
			}
		}
		
		
		//add subpanels
		mainPanel = new JPanel();	    
		mainPanel.add(buttons, BorderLayout.PAGE_START);
		mainPanel.add(grid, BorderLayout.CENTER);
		
		//add mainpanel to content pane
		add(mainPanel);
			
		//display window
		//pack();
		setVisible(true);
	}


	
	// for 
	public boolean checkIfWon(){
		boolean won = false;
		for(int i=0; i< 7; i++){
			for(int j=0; j<6; j++){
				if(board[i][j] == 0){
					break;
				}
				else{
					// if the element is within the last three columns AND the last three rows, it cannot be the start point of a four consecutive numbers
					if (j >= 3 && i >= 4){
						break;
					}
					
					// Test if this element is the start of a row
					// Test for four across
					if (j < 3 && (board[j][i] == board[j][i+1] && (board[j][i] == board[j][i+2] && board[j][i] == board[j][i+3])) ){
						won = true;
					}
					// test for four down
					else if (j<3 && (board[j][i] == board[j+1][i] && (board[j][i] == board[j+2][i] && board[j][i] == board[j+3][i])) ){
						won = true;
					}
					// test for four diagonal - slanting right or slanting left
					else if (j<3 && i<4 && (board[j][i] == board[j+1][i+1] && (board[j][i] == board[j+2][i+2] && board[j][i] == board[j+3][i+3])) ){
						won = true;
					}
					else if ((i<4 && j<3) && (board[j][i] == board[j+1][i-1] && (board[j][i] == board[j+2][i-2] && board[j][i] == board[j+3][i-3])) ){	
						won = true;
					}
					else;	// won is false
				}
			}
		}
		
		return won;
	}

	
	
	/*
	 * implement later?
	 * 
	 * public boolean playAgain() {
		
		if(){	//if want to play again
		return true;
		}
		else{	//if don't want to play again
			frame.dispose();
		}
			
	}*/

	
	
	//actionListener classes
	private class C1Listener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(p1>=0){
				addToRow(1);
				
				haveWinner = checkIfWon();
				
				//display winner
				if(haveWinner){
					JOptionPane.showMessageDialog(null, "Winner is "+player);
				}
				
				else{
					//toggle player
					if(player == 'R'){		//if red just moved, switch turn to yellow
						player = 'Y';
					}
					else{					// from yellow, switch back to red
						player = 'R';
					}
				}
			}
		}
	}
	private class C2Listener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(p2>=0){
			addToRow(2);
			haveWinner = checkIfWon();
			//display winner
			if(haveWinner){
				JOptionPane.showMessageDialog(null, "Winner is "+player);
			}
			
			else{
				//toggle player
				if(player == 'R'){		//if red just moved, switch turn to yellow
					player = 'Y';
				}
				else{					// from yellow, switch back to red
					player = 'R';
				}
			}}
			
		}
	}
	private class C3Listener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(p3>=0){
			addToRow(3);
			haveWinner = checkIfWon();
			//display winner
			if(haveWinner){
				JOptionPane.showMessageDialog(null, "Winner is "+player);
			}
			
			else{
				//toggle player
				if(player == 'R'){		//if red just moved, switch turn to yellow
					player = 'Y';
				}
				else{					// from yellow, switch back to red
					player = 'R';
				}
			}
			}
		}
	}
	private class C4Listener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(p4>=0){
			addToRow(4);
			haveWinner = checkIfWon();
			//display winner
			if(haveWinner){
				JOptionPane.showMessageDialog(null, "Winner is "+player);
			}
			
			else{
				//toggle player
				if(player == 'R'){		//if red just moved, switch turn to yellow
					player = 'Y';
				}
				else{					// from yellow, switch back to red
					player = 'R';
				}
			}}
			
		}
	}
	private class C5Listener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(p5>=0){
			addToRow(5);
			haveWinner = checkIfWon();
			//display winner
			if(haveWinner){
				JOptionPane.showMessageDialog(null, "Winner is "+player);
			}
			
			else{
				//toggle player
				if(player == 'R'){		//if red just moved, switch turn to yellow
					player = 'Y';
				}
				else{					// from yellow, switch back to red
					player = 'R';
				}
			}
			}
		}
	}
	private class C6Listener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(p6>=0){
				addToRow(6);
				haveWinner = checkIfWon();
				//display winner
				if(haveWinner){
					JOptionPane.showMessageDialog(null, "Winner is "+player);
				}
				
				else{
					//toggle player
					if(player == 'R'){		//if red just moved, switch turn to yellow
						player = 'Y';
					}
					else{					// from yellow, switch back to red
						player = 'R';
					}
				}
			}
		}
	}
	private class C7Listener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(p7>=0){
				addToRow(7);
				haveWinner = checkIfWon();
				//display winner
				if(haveWinner){
					JOptionPane.showMessageDialog(null, "Winner is "+player);
				}
				
				else{
					//toggle player
					if(player == 'R'){		//if red just moved, switch turn to yellow
						player = 'Y';
					}
					else{					// from yellow, switch back to red
						player = 'R';
					}
				}
			}
		}
	}
	
	
	
	//adds a piece to board[][] and updates gui
	
	public void addToRow(int column) {
		column--;
		//depending on which player, change int to insert
		int num;
		if(player == 'R'){
			num = 1;
		}
		else{
			num = 2;
		}
		
		//access this column's pointer and insert
		int nextSpot = 0;
		switch(column){
		case 1:
			nextSpot = p1;
			board[column][nextSpot] = num;
			p1--;
			break;
		case 2:
			nextSpot = p2;
			board[column][nextSpot] = num;
			p2--;
			break;
		case 3:
			nextSpot = p3;
			board[column][nextSpot] = num;
			p3--;
			break;
		case 4:
			nextSpot = p4;
			board[column][nextSpot] = num;
			p4--;
			break;
		case 5:
			nextSpot = p5;
			board[column][nextSpot] = num;
			p5--;
			break;
		case 6:
			nextSpot = p6;
			board[column][nextSpot] = num;
			p6--;
			break;
		case 7:
			nextSpot = p7;
			board[column][nextSpot] = num;
			p7--;
			break;
		
		}
			

		//using the values in the board[][], refill grid layout with updated pieces
		for(int i = 0; i<7; i++){
			for(int j =0; j<6;j++){
				if(board[i][j] == 0){
					PieceComponent p = new PieceComponent(Color.WHITE);
					boardGUI[i][j] = p;
					grid.add(boardGUI[i][j]);
					//grid.repaint();
					
					
					
				}
				else if(board[i][j] == 1){
					PieceComponent p = new PieceComponent(Color.RED);
					boardGUI[i][j] = p;
					grid.add(boardGUI[i][j]);
					//grid.repaint();
				}
				else{
					PieceComponent p = new PieceComponent(Color.YELLOW);
					boardGUI[i][j] = p;
					grid.add(boardGUI[i][j]);
					//grid.repaint();
				
				}
			}
		}
		
	}
}
