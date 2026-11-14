public class Board {
	
	private int empty = 0;
	private int ship = 1;
	private int hit = 2;
	private int miss = 3;
	
	private int[][] newBoard;

	public Board(int r, int c) {
		newBoard = new int[r][c];
	}
	
	/*places a ship
	 * but first checks whether space is available
	 * AKA if the placement is valid
	 */
	public boolean addShip(int r, int c, int length, boolean horizontal) {
		//check if ship goes outside board
		if (horizontal == true) {
			if (c + length > newBoard[0].length) {
				return false;
			}
		else {
			if (r + length > newBoard.length) {
				return false;
			}
		}
		}
		//check if ship overlaps w/other ships
		for (int a = 0; a < length; a++) {
			if (horizontal == true) {
				if (newBoard[r][c + a] != 0) {
					return false;
				}
			}
			else {
				if (newBoard[r + a][c] != 0) {
					return false;
					}
				}
		}

		// if no space conflicts, place ship
		for (int b = 0; b < length; b++) {

			if (horizontal) {
				newBoard[r][c + b] = 1;
			}
			else {
				newBoard[r + b][c] = 1;
			}
		}

		return true;

	}
	
	/*finds ships based on length
	 * used to check if all 5 ships are placed correctly before starting game
	 */
	public boolean foundShip(int length) {
		//horizontal check
		for (int d = 0; d < newBoard.length; d++) {
			int num = 0;
			for (int e = 0; e < newBoard[d].length; e++) {
				if (newBoard[d][e] == 1) {
					num ++;
				}
				else {
					if (num == length) {
						return true;
				}
				num = 0;
			}
		}
		if (num == length) {
			return true;
			}
		}
		
		//vertical check
		for (int f = 0; f < newBoard[0].length; f++) {

        int num = 0;

			for (int g = 0; g < newBoard.length; g++) {

            if (newBoard[g][f] == 1) {
                num++;
            }
            else {
                if (num == length) {
                    return true;
                }
                num = 0;
            }
        }

        if (num == length) {
            return true;
        }
    }

		return false;
	}
	
	/*if you  guess invalid coordinates, board doesn't change (invalid)
	 * if you miss, changes 0->3
	 * if you hit, changes 1->2
	 * if you already shot, board doesn't change
	 */
	public int shoot(int r, int c) {

    // checks if coordinates are outside  board
    if (r < 0 || r >= newBoard.length || c < 0 || c >= newBoard[0].length) {
        return -1;
    }

    // checks if the square is empty
    if (newBoard[r][c] == 0) {
        newBoard[r][c] = 3;
        return 0;
    }

    // checks if the square contains a ship
    else if (newBoard[r][c] == 1) {
        newBoard[r][c] = 2;
        return 1;
    }

    // if square has already been shot
    else {
        return 2;
    }
}
	
	
	public int getValue(int r, int c) {
		return newBoard[r][c];
	}
	
	public void setValue(int r, int c, int v) {
		newBoard[r][c] = v;
	}
	
	/*indicates that game is over
	 * by checking if there are any "1"s left 
	 * if there are none left then all ships must have been sunk
	 */
	public boolean gameOver() {

    for (int h = 0; h < newBoard.length; h++) {
        for (int i = 0; i < newBoard[h].length; i++) {

            if (newBoard[h][i] == 1) {
                return false;
            }
        }
    }

    return true;
	}
	
	
	public String toString() {
		String board = "";
		for (int i = 0; i < newBoard.length; i++) {
			for (int j = 0; j < newBoard[i].length; j++) {
                if (newBoard[i][j] == empty)
                    board += "- ";
                else if (newBoard[i][j] == ship)
                    board += "b ";
                else if (newBoard[i][j] == hit)
                    board += "x ";
                else if (newBoard[i][j] == miss)
                    board += "m ";
            }

            board += "\n";
        }

        return board;
	}
}
