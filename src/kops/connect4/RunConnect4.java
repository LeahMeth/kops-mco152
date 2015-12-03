package kops.connect4;

import java.util.Scanner;

import javax.swing.JOptionPane;



public class RunConnect4 {

	public static void main(String[] args) {
		Connect4Board board = new Connect4Board();
		Scanner in = new Scanner(System.in);
		char playAgain;
		board.startGame();
		
		
		//playAgain = JOptionPane.showInputDialog("Enter Yes to play again or No to exit").charAt(0);
		//while(playAgain == 'Y' || playAgain == 'y'){
			//board.startGame();
		//}

	}

}
