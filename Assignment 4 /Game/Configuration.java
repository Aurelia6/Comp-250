package assignment4Game;

public class Configuration {

	public int[][] board;
	public int[] available;
	boolean spaceLeft;

	public Configuration() {
		board = new int[7][6];
		available = new int[7];
		spaceLeft = true;
	}

	public void print() {
		System.out.println("| 0 | 1 | 2 | 3 | 4 | 5 | 6 |");
		System.out.println("+---+---+---+---+---+---+---+");
		for (int i = 0; i < 6; i++) {
			System.out.print("|");
			for (int j = 0; j < 7; j++) {
				if (board[j][5 - i] == 0) {
					System.out.print("   |");
				} else {
					System.out.print(" " + board[j][5 - i] + " |");
				}
			}
			System.out.println();
		}
	}

	public void addDisk(int index, int player) {
		// ADD YOUR CODE HERE
		for (int i = 0; i < 6; i++) {
			if (board[index][i] == 0) {
				board[index][i] = player;
				available[index] = available[index] + 1;
				break;
			}	
		}

		//Case there is no more space on the board
		int nospace = 0;
		for(int j = 0 ; j < 7 ; j++)
			if(available[j]==6)
				nospace++;
		
		if(nospace == 7)
			spaceLeft = false;
	}

	public boolean isWinning(int lastColumnPlayed, int player) {
		// ADD YOUR CODE HERE
		// Vertical line
		if (available[lastColumnPlayed] >= 4) { // should have at least 4 disks
												// in this vertical line
			for (int vertical = available[lastColumnPlayed] - 2; vertical >= available[lastColumnPlayed]
					- 4; vertical--) { // we go through the vertical line
				if (!(board[lastColumnPlayed][vertical] == player))
					break;
				else if (board[lastColumnPlayed][vertical] == player && vertical == available[lastColumnPlayed] - 4)
					return true;
			}
		}

		// Horizontal line
		// we put in a list and in order each disk in the same horizontal line
		int[] Hor_line = new int[7];
		for (int i = 0; i < 7; i++)
			Hor_line[i] = board[i][available[lastColumnPlayed] - 1];

		int result = 0;
		for (int j = 0; j < 7; j++) {
			if (Hor_line[j] == player)
				result++;
			else
				result = 0;
			if (result == 4)
				return true;
		}

		/** diagonal **/
		// we create 2 lists which will contain all the numbers in the 2
		// diagonals of the last disk played
		int[] LD_to_RU = new int[7];
		int[] RU_to_LD = new int[7];

		LD_to_RU[lastColumnPlayed] = RU_to_LD[lastColumnPlayed] = player;

		/** diag left down to right up **/
		// On the left of the last column played
		int row = lastColumnPlayed - 1;
		while (row >= 0) {
			if ((available[lastColumnPlayed] - 1) - (lastColumnPlayed - row) < 0)
				break;
			else {
				if (available[row] >= (available[lastColumnPlayed] - 1) - (lastColumnPlayed - row))
					LD_to_RU[row] = board[row][(available[lastColumnPlayed] - 1) - (lastColumnPlayed - row)];
				row--;
			}
		}

		// On the right of the last column played
		row = lastColumnPlayed + 1;
		int index = 0;
		while (row <= 6) {
			if ((available[lastColumnPlayed] - 1) + (row - lastColumnPlayed) > 6)
				break;
			else {
				LD_to_RU[row] = available[lastColumnPlayed]+index;
				index++;
				row++;
			}
		}
		
		result = 0;
		for (int j = 0; j < 7; j++) {
			if (LD_to_RU[j] == player)
				result++;
			else
				result = 0;
			if (result == 4)
				return true;
		}

		/** diag right down to left up **/
		// On the right of the last column played
		row = lastColumnPlayed + 1;
		while (row <= 6) {
			if ((available[lastColumnPlayed] - 1) - (row - lastColumnPlayed) < 0)
				break;
			else {
				if (available[row] >= (available[lastColumnPlayed] - 1) - (row - lastColumnPlayed))
					RU_to_LD[row] = board[row][(available[lastColumnPlayed] -1) - (row - lastColumnPlayed)];
				row++;
			}
		}

		// On the left of the last column played
		row = lastColumnPlayed - 1;
		index = 0;
		while (row >= 0) {
			if ((available[lastColumnPlayed] - 1) + (lastColumnPlayed - row) < 0)
				break;
			else {
				RU_to_LD[row] = available[lastColumnPlayed]+index;
				index++;
				row--;
			}
		}

		result = 0;
		for (int j = 0; j < 7; j++) {
			if (RU_to_LD[j] == player)
				result++;
			else
				result = 0;
			if (result == 4)
				return true;
		}

		return false; // DON'T FORGET TO CHANGE THE RETURN
	}

	public int canWinNextRound(int player) {
		// ADD YOUR CODE HERE
		// we create a new board which is going to be the same as this, and on
		// which we will going to try each position
		Configuration new_board = new Configuration();
		// we create the same board
		for (int i = 0; i < 7; i++) {
			new_board.available[i] = available[i];
			for (int j = 0; j < available[i]; j++)
				new_board.board[i][j] = board[i][j];
		}
		
		// we pretend to add the disk at each place to find the good place if it exists
		for (int i = 0; i < 7; i++) {
			new_board.addDisk(i, player);
			if(new_board.available[i]<5)
				if (new_board.isWinning(i, player))
					return i;
			new_board.board[i][new_board.available[i] - 1] = 0;
			new_board.available[i] = new_board.available[i] - 1;
		}

		return -1; // DON'T FORGET TO CHANGE THE RETURN
	}

	public int canWinTwoTurns(int player) {
		// ADD YOUR CODE HERE
		// we create a new board which is going to be the same as this, and on
		// which we will going to try each position
		Configuration new_board = new Configuration();
		// we create the same board
		for (int i = 0; i < 7; i++) {
			new_board.available[i] = available[i];
			for (int j = 0; j < available[i]; j++)
				new_board.board[i][j] = board[i][j];
		}

		// we create the other player because we can't forget his turn
		int player2;
		if (player == 1)
			player2 = 2;
		else
			player2 = 1;

		// we pretend to add the next disk of first the player
		for (int i = 0; i < 7; i++) {
			new_board.addDisk(i, player);

			// Then if after playing at this place the player can win and the
			// other one can't
			// we pretend to add the next disk of the second player
			if (new_board.canWinNextRound(player2) == -1 && new_board.canWinNextRound(player) != -1) {
				int result = 0; // will contain 0 if whatever the second player
								// plays, the first one could win after
				for (int j = 0; j < 7; j++) {
					if (new_board.available[j] != 6) {
						new_board.addDisk(j, player2);
						if (new_board.canWinNextRound(player) == -1)
							result++;
						new_board.board[j][new_board.available[j] - 1] = 0;
						new_board.available[j] = new_board.available[j] - 1;
					}
				}
				if (result == 0)
					return i;
			}
			new_board.board[i][new_board.available[i] - 1] = 0;
			new_board.available[i] = new_board.available[i] - 1;
		}

		return -1; // DON'T FORGET TO CHANGE THE RETURN
	}

}
