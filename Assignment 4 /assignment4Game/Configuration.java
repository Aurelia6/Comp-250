package assignment4Game;

public class Configuration {
	
	public int[][] board;
	public int[] available;
	boolean spaceLeft;
	
	public Configuration(){
		board = new int[7][6];
		available = new int[7];
		spaceLeft = true;
	}
	
	public void print(){
		System.out.println("| 0 | 1 | 2 | 3 | 4 | 5 | 6 |");
		System.out.println("+---+---+---+---+---+---+---+");
		for (int i = 0; i < 6; i++){
			System.out.print("|");
			for (int j = 0; j < 7; j++){
				if (board[j][5-i] == 0){
					System.out.print("   |");
				}
				else{
					System.out.print(" "+ board[j][5-i]+" |");
				}
			}
			System.out.println();
		}
	}
	
	public void addDisk (int index, int player){
		// ADD YOUR CODE HERE
	}
	
	public boolean isWinning (int lastColumnPlayed, int player){
		// ADD YOUR CODE HERE
		return false; // DON'T FORGET TO CHANGE THE RETURN
	}
	
	public int canWinNextRound (int player){
		// ADD YOUR CODE HERE
		return 0; // DON'T FORGET TO CHANGE THE RETURN
	}
	
	public int canWinTwoTurns (int player){
		// ADD YOUR CODE HERE
		return 0; // DON'T FORGET TO CHANGE THE RETURN
	}
	
}
