package assignment4Game;

import java.io.*;

public class Game {
	
	public static int play(InputStreamReader input){
		BufferedReader keyboard = new BufferedReader(input);
		Configuration c = new Configuration();
		int columnPlayed = 3; int player;
		
		// first move for player 1 (played by computer) : in the middle of the grid
		c.addDisk(firstMovePlayer1(), 1);
		int nbTurn = 1;
		
		while (nbTurn < 42){ // maximum of turns allowed by the size of the grid
			player = nbTurn %2 + 1;
			if (player == 2){
				columnPlayed = getNextMove(keyboard, c, 2);
			}
			if (player == 1){
				columnPlayed = movePlayer1(columnPlayed, c);
			}
			System.out.println(columnPlayed);
			c.addDisk(columnPlayed, player);
			if (c.isWinning(columnPlayed, player)){
				c.print();
				System.out.println("Congrats to player " + player + " !");
				return(player);
			}
			nbTurn++;
		}
		return -1;
	}
	
	public static int getNextMove(BufferedReader keyboard, Configuration c, int player) {
		// ADD YOUR CODE HERE

		c.print();
		String value = ""; // will get the number entered by the user
		System.out.println(
				"It is your turn player number " + player + "!\nPlease select a column number to put your next disk: ");

		try {
			value = keyboard.readLine();// get the text entered
		} catch (IOException e) {
			System.out.println("error");
		}

		int column = Integer.parseInt(value); // We change the number entered
												// into an integer
		if (c.available[column] == 6) {
			System.out.println("\nThere is no space left in the column: " + column);
			Game.getNextMove(keyboard, c, player);
		} else {
			return column;
		}

		return 0; // DON'T FORGET TO CHANGE THE RETURN
	}
	
	public static int firstMovePlayer1 (){
		return 3;
	}
	
	public static int movePlayer1(int columnPlayed2, Configuration c) {
		// ADD YOUR CODE HERE
		// If the computer can win in the next round
		if (c.canWinNextRound(1) != -1)
			return c.canWinNextRound(1);

		// If the computer cannot win in the next round
		else {
			// If the computer can win in 2 rounds
			if (c.canWinTwoTurns(1) != -1)
				return c.canWinTwoTurns(1);

			// else just place a disk
			else {
				int i = 0;
				if (c.available[columnPlayed2] < 6)
					return columnPlayed2;
				else {
					while (columnPlayed2 - (i + 1) >= 0 || columnPlayed2 + (i + 1) <= 6) {
						if (columnPlayed2 - (i + 1) >= 0)
							if (c.available[columnPlayed2 - (i + 1)] < 6)
								return columnPlayed2 - (i + 1);
						if (columnPlayed2 + (i + 1) <= 6)
							if (c.available[columnPlayed2 + (i + 1)] < 6)
								return columnPlayed2 + (i + 1);
						i++;
					}
				}
			}
		}
		 return 0;// DON'T FORGET TO CHANGE THE RETURN
	}

}
