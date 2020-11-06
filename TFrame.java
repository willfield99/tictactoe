import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sun.xml.internal.ws.api.server.Container;
/*
 * Sets up and operates the tic tac toe board
 */
public class TFrame extends JFrame {
	
	
	private java.awt.Container pane;
	private String currentPlayer;
	private JButton [][] board;
	private JButton [][] prevboard;
	private boolean hasWinner;
	private JMenuBar menuBar;
	
	
	
	public TFrame() {//constructs the window
		super();
		pane = getContentPane();
		pane.setLayout(new GridLayout(3,3));
		setTitle("Tic Tac Toe");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(500,500);
		setVisible(true);
		currentPlayer = "x";
		board = new JButton[3][3];
		prevboard = new JButton[3][3];
		hasWinner = false;
		initializeBoard();
		inMenuBar();
		
	}
	
	private void inMenuBar() {//this method makes the menu bar at the top of the interface
		JMenu file;
		JMenuItem quit;
		JMenuItem newGame;
		JMenu edit;
		JMenu about;
		JMenuItem undo;
		
		menuBar = new JMenuBar();
		file = new JMenu("File");
		newGame = new JMenuItem("Reset Game");
		newGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetBoard();
			}
		});
		quit = new JMenuItem("Quit");
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		file.add(newGame);
		file.add(quit);
		
		edit = new JMenu("Edit");
		undo = new JMenuItem("Undo");
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				undoTurn();
			}
		});
		edit.add(undo);
		about = new JMenu("About");
		
		
		
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(about);
		setJMenuBar(menuBar);
	}
	private void resetBoard() {//sets board spaces to empty
		currentPlayer = "x";
		hasWinner = false;
		for(int i = 0; i < 3; i++) {
			for(int j = 0;j < 3; j++) {
				board[i][j].setText("");
				
			}
		}
	}
	
	private void undoTurn() {
		for(int i = 0; i <3; i++) {
			for(int j = 0; j <3; j++) {
				JButton btn = new JButton();
				//btn.setForeground(Color.BLUE);
				btn.setText(prevboard[i][j].getText());
				pane.add(btn);//add the new button to the pane
			}
		}
	}
	private void initializeBoard() {//creates the board each turn
		
		for(int i = 0; i <3; i++) {
			for(int j = 0; j <3; j++) {
				JButton btn = new JButton();
				
				btn.setForeground(Color.BLUE);
				
				board[i][j] = btn;
				btn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {//listens for a click on one of the spaces. puts the appropriate game piece there
						if(((JButton)e.getSource()).getText().contentEquals("") &&
						hasWinner == false) {//if the space is empty and there hasnt been a winner yet
							btn.setText(currentPlayer);//put the current players game piece there
							if(currentPlayer.contentEquals("x")) {//x is red o is blue
								btn.setForeground(Color.RED);
							}else {
								btn.setForeground(Color.BLUE);
							}
							hasWinner(); //check if it was a game winning move
							togglePlayer();//its now the other players turn
							prevboard = board;
						}
					}
				});
				prevboard[i][j] = btn;
				pane.add(btn);//add the new button to the pane
			}
		}
	}
	private void togglePlayer() {//switches for each turn
		if(currentPlayer.contentEquals("x"))
			currentPlayer = "o";
		else
			currentPlayer = "x";
	}
	/*
	I created this method that will check if all the spaces are filled. If called at the end of the hasWinner method, 
	it effectively checks for a tie because if all the spaces are filled and no one has won yet, it must be a tie.
*/
	private boolean checkTie() {
		int tally = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(board[i][j].getText().isEmpty()) {
					break;
				} 
				else {
					tally = tally + 1;
				}
			}	 
	        }	
		if (tally == 9) {
			return true;	
		} else {	
			return false;
		}
	}
	        

	private void hasWinner() {//checks if the game has been won
	        if(board[0][0].getText().equals(currentPlayer) && board[1][0].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer)) {
	            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
	            hasWinner = true;
	        }
	        else if(board[0][1].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer)) {
	            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
	            hasWinner = true;
	        }
	        else if(board[0][2].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
	            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
	            hasWinner = true;
	        }
	        else if(board[0][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
	            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
	            hasWinner = true;
	        }
	        else if(board[0][2].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer)) {
	            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
	            hasWinner = true;
	        }
	        else if(board[0][0].getText().equals(currentPlayer) && board[0][1].getText().equals(currentPlayer) && board[0][2].getText().equals(currentPlayer)) {
	            JOptionPane.showMessageDialog(null, "Player" + currentPlayer + " has won");
	            hasWinner = true;
	        }
	        else if(board[1][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer)) {
	            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
	            hasWinner = true;
	        }
	        else if(board[2][0].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
	            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
	            hasWinner = true;
	        }
	        else if (checkTie() == true) {        	
	        	JOptionPane.showMessageDialog(null, "The game has ended in a tie");
	        	hasWinner = false;
	        }

	}
	
}