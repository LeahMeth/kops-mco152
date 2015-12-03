package kops.connect4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Connect4Board extends JFrame {

	private PieceComponent boardGUI[][] = new PieceComponent[6][7];	// for GUI purposes
	private int board[][] = new int[6][7];		// for calculating next spot in column and calculating winner
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
	}	
	
	

	public void startGame() {
			setUp();	//sets up window and panels and begins game play			
	}
	
	
	
	public void setUp() {
		setTitle("Connect 4");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(745,730);
		setIconImage(img.getImage());
		
	    
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
		
		for(int r = 0; r < 6; r++){
			for(int c = 0; c < 7; c++){
			boardGUI[r][c] = new PieceComponent(Color.WHITE);
			board[r][c] = 0;
            grid.add(boardGUI[r][c]);
			
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
		int spot;
		for(int r = 0; r < 6; r++){	//r = row num
			for(int c = 0; c < 7; c++){	//c = column num
				spot = board[r][c];
				if(spot == 0){	//empty spot
					break;
				}
				else{
					// if the element is within the last three columns AND the last three rows,
					// it cannot be the start point of a four consecutive numbers
					if(r >= 3 && c >= 4){
						break;
					}
					
					// Test if this element is the start of a winning sequence
					
					// Test for four across
					else if(spot == board[r][c+1] && spot == board[r][c+2] 
							&& spot == board[r][c+3]) {
						won = true;
					}
					// test for four down
					else if( spot == board[r+1][c] && spot == board[r+2][c] 
							&& spot == board[r+3][c]){
						won = true;
					}
					// test for four diagonal - slanting right or slanting left
					else if(c < 4 && r < 3 && spot == board[r+1][c+1] 
							&& spot == board[r+2][c+2] && spot == board[r+3][c+3]){
						won = true;
					}
					else if(c > 2 && r < 2 && spot == board[r+1][c-1] 
							&& spot == board[r+2][c-2] && spot == board[r+3][c-3]){	
						won = true;
					}
					else;	// won is false
				}
			}
		}
		
		return won;
	}

	
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
				if(player == 'R'){		// if red just moved, switch turn to yellow
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
		
		switch(column){
		case 0:			
			board[p1--][column] = num;			
			break;
		case 1:			
			board[p2--][column] = num;			
			break;
		case 2:			
			board[p3--][column] = num;			
			break;
		case 3:
			board[p4--][column] = num;
			break;
		case 4:
			board[p5--][column] = num;
			break;
		case 5:
			board[p6--][column] = num;		
			break;
		case 6:
			board[p7--][column] = num;
			break;
		
		}
			

		//using the values in the board[][], refill grid layout with updated pieces
		for(int r = 0; r < 6; r++){
			for(int c = 0; c < 7; c++){
				if(board[r][c] == 0){				
					boardGUI[r][c].changeColor(Color.WHITE);
				}
				else if(board[r][c] == 1){				
					boardGUI[r][c].changeColor(Color.RED);
				}
				else{					
					boardGUI[r][c].changeColor(Color.YELLOW);
				}
			}
		}grid.repaint();
		
	}
}
