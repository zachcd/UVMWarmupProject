

public class GameBoard {
	private BoardType type;
	
	public GameBoard(BoardType typein) {
		type = typein;
		if (type == BoardType.ENGLISH) {
			int [][] board = new int [7][7];
			//0 is no go, 1 is filled space, 2 is empty space
			board[0][0] = 0;
			board[0][1] = 0;
			board[0][2] = 1;
			board[0][3] = 1;
			board[0][4] = 1;
			board[0][5] = 0;
			board[0][6] = 0;
			board[1][0] = 0;
			board[1][1] = 0;
			board[1][2] = 1;
			board[1][3] = 1;
			board[1][4] = 1;
			board[1][5] = 0;
			board[1][6] = 0;
			board[2][0] = 1;
			board[2][1] = 1;
			board[2][2] = 1;
			board[2][3] = 1;
			board[2][4] = 1;
			board[2][5] = 1;
			board[2][6] = 1;
			board[3][0] = 1;
			board[3][1] = 1;
			board[3][2] = 1;
			board[3][3] = 2;
			board[3][4] = 1;
			board[3][5] = 1;
			board[3][6] = 1;
			board[4][0] = 1;
			board[4][1] = 1;
			board[4][2] = 1;
			board[4][3] = 1;
			board[4][4] = 1;
			board[4][5] = 1;
			board[4][6] = 1;
			board[5][0] = 0;
			board[5][1] = 0;
			board[5][2] = 1;
			board[5][3] = 1;
			board[5][4] = 1;
			board[5][5] = 0;
			board[5][6] = 0;
			board[6][0] = 0;
			board[6][1] = 0;
			board[6][2] = 1;
			board[6][3] = 1;
			board[6][4] = 1;
			board[6][5] = 0;
			board[6][6] = 0;	
		} else {
			int [][] board = new int[5][5];
			board[0][0] = 1;
			board[0][1] = 0;
			board[0][2] = 0;
			board[0][3] = 0;
			board[0][4] = 0;
			board[1][0] = 1;
			board[1][1] = 1;
			board[1][2] = 0;
			board[1][3] = 0;
			board[1][4] = 0;
			board[2][0] = 1;
			board[2][1] = 2;
			board[2][2] = 1;
			board[2][3] = 0;
			board[2][4] = 0;
			board[3][0] = 1;
			board[3][1] = 1;
			board[3][2] = 1;
			board[3][3] = 1;
			board[3][4] = 0;
			board[4][0] = 1;
			board[4][1] = 1;
			board[4][2] = 1;
			board[4][3] = 1;
			board[4][4] = 1;
		}
		
	}
	
}