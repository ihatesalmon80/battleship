public class Board {
	
	private int[][] newBoard;

	public Board(int r, int c) {
		newBoard = new int[r][c];
	}
	
	public int getValue(int r, int c) {
		return newBoard[r][c];
	}
	
	public void setValue(int r, int c, int v) {
		newBoard[r][c] = v;
	}
	
	public String toString() {
		String board = "";
		for (int i = 0; i<10; i++) {
			for (int j = 0; j<10; j++) {
				String element = newBoard[i][j] + " ";
				board = board + element;
			}
			board = board + "\n";
		}
		return board;
	}
}
