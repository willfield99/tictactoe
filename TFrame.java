import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sun.xml.internal.ws.api.server.Container;

public class TFrame extends JFrame {
	
	/**
	 * 
	 
	private static final long serialVersionUID = 1L;
	private TPanel boardpanel;// the panel on which the board is displayed
	private ButtonPanel buttonpanel;
	**/
	private java.awt.Container pane;
	private String currentPlayer;
	private JButton [][] board;
	private boolean hasWinner;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem quit;
	private JMenuItem newGame;
	 /*
	public TFrame(int x, int y, int width, int height) throws FileNotFoundException {// Creates the frame
		super();
		TBoard board;// board used by the panel
		
		board = new TBoard();
		boardpanel = new TPanel(board);
		buttonpanel = new ButtonPanel();
		

		JPanel undo = new JPanel();

		add(boardpanel, BorderLayout.CENTER);// adding boardpanel to the center of the window
		add(buttonpanel, BorderLayout.NORTH);// adding the buttons to the south of the window
		
		add(undo, BorderLayout.EAST);
		
		undo.add(new JButton("undo"));
		setSize(width, height);// Size mutator
		setLocation(x, y);// Location mutator

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
	*/
	public TFrame() {
		super();
		pane = getContentPane();
		pane.setLayout(new GridLayout(3,3));
		setTitle("Tic Tac Toe");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		currentPlayer = "x";
		board = new JButton[3][3];
		hasWinner = false;
		initializeBoard();
		inMenuBar();
		
	}
	
	private void inMenuBar() {
		menuBar = new JMenuBar();
		menu = new JMenu("File");
		newGame = new JMenuItem("New Game");
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
		menu.add(newGame);
		menu.add(quit);
		menuBar.add(menu);
		setJMenuBar(menuBar);
	}
	private void resetBoard() {
		currentPlayer = "x";
		hasWinner = false;
		for(int i = 0; i < 3; i++) {
			for(int j = 0;j < 3; j++) {
				board[i][j].setText("");
				
			}
		}
	}
	private void initializeBoard() {
		for(int i = 0; i <3; i++) {
			for(int j = 0; j <3; j++) {
				JButton btn = new JButton();
				//btn.setFont(new Font(Font.SANS_SERIF, FONT.BOLD, 100));
				board[i][j] = btn;
				btn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(((JButton)e.getSource()).getText().contentEquals("") &&
						hasWinner == false) {
							btn.setText(currentPlayer);
							hasWinner(); 
							togglePlayer();
						}
					}
				});
				pane.add(btn);
			}
		}
	}
	private void togglePlayer() {
		if(currentPlayer.contentEquals("x"))
			currentPlayer = "o";
		else
			currentPlayer = "x";
	}
	private void hasWinner() {
	        if(board[0][0].getText().equals(currentPlayer) && board[1][0].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer)) {
	            JOptionPane.showMessageDialog(null, "Player" + currentPlayer + "has won");
	            hasWinner = true;
	        }
	        else if(board[0][1].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer)) {
	            JOptionPane.showMessageDialog(null, "Player" + currentPlayer + "has won");
	            hasWinner = true;
	        }
	        else if(board[0][2].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
	            JOptionPane.showMessageDialog(null, "Player" + currentPlayer + "has won");
	            hasWinner = true;
	        }
	        else if(board[0][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
	            JOptionPane.showMessageDialog(null, "Player" + currentPlayer + "has won");
	            hasWinner = true;
	        }
	        else if(board[0][2].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer)) {
	            JOptionPane.showMessageDialog(null, "Player" + currentPlayer + "has won");
	            hasWinner = true;
	        }
	        else if(board[0][0].getText().equals(currentPlayer) && board[0][1].getText().equals(currentPlayer) && board[0][2].getText().equals(currentPlayer)) {
	            JOptionPane.showMessageDialog(null, "Player" + currentPlayer + "has won");
	            hasWinner = true;
	        }
	        else if(board[1][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer)) {
	            JOptionPane.showMessageDialog(null, "Player" + currentPlayer + "has won");
	            hasWinner = true;
	        }
	        else if(board[2][0].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
	            JOptionPane.showMessageDialog(null, "Player" + currentPlayer + "has won");
	            hasWinner = true;
	        }
	}
	
}