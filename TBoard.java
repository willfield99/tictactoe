
public class TBoard {
	private char[][] now; //2d array representing the board and containing x's and o's
	private int turns;//how many turns have been taken
	
	public TBoard() {
		
		now = new char[3][3];//3x3 tic tac toe board
		
		
	}
	
	public int rows() {
		return now.length;
	}
	
	public int columns() {
		return now[0].length;
	}
	
	public void takeTurn(int x, int y) {//performs each turn player 1 is x player 2 is o. player 1 always goes first
		if(turns % 2 == 0) {
			now[x][y] = 'X';
		}else {
			now[x][y] = 'Y';
		}
	}
}
