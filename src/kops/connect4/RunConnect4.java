package kops.connect4;

public class RunConnect4 {

	public static void main(String[] args) {
		Connect4Board board = new Connect4Board();
		char playAgain = 0;
		
		while(playAgain != 'n'){
			board.setUp();
			board.startGame();
			playAgain = board.playAgain();
		}
	
	}

}
