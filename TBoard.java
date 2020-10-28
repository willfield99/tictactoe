
public class TBoard {
	public String[][] now; //2d array representing the board and containing x's and o's
	private int turns;//how many turns have been taken
	
	public TBoard() {
		
		now = new String[3][3];//3x3 tic tac toe board
		
		
	}
	
	public int rows() {
		return now.length;
	}
	
	public int columns() {
		return now[0].length;
	}
	
	public void takeTurn(int x, int y) {//performs each turn player 1 is x player 2 is o. player 1 always goes first
		if(turns % 2 == 0) {
			now[x][y] = "X";
		}else {
			now[x][y] = "O";
		}
	}
	
	public boolean checkwin() {//checks if a game winning move has been made
		
		

		//Check each row
		for(int i = 0; i < 3; i++) {
			if(now[i][0] == now[i][1] && now[i][1] == now[i][2] && now[i][0] != null) {
				return true;
			}
		}

		//Check each column
		for(int j = 0; j < 3; j++) {
			if(now[0][j] == now[1][j] && now[1][j] == now[2][j] && now[0][j] != null) {
				return true;
			}
		}

		//Check the diagonals
		if(now[0][0] == now[1][1] && now[1][1] == now[2][2] && now[0][0] != null) {
			return true;
		}
		if(now[2][0] == now[1][1] && now[1][1] ==  now[0][2] && now[2][0] != null) {
			return true;
		}

		//Otherwise nobody has not won yet
		return false;
	}
	
	public boolean checkCat() {//check for a cats game
		
		return false;
	}
	
		
		
		
	
}
