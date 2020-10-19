
/*4/16/19
 * 
 * The GameofLifePanel displays the GameofLifeBoard on a grid. 
 * Contains a paintComponent method displaying the board 
 * and a toggleCellAt method that switches a cell when it is clicked
 * 
 * William Field
 */

import java.awt.Color;
import java.io.FileNotFoundException;

@SuppressWarnings("serial")
public class TPanel extends javax.swing.JPanel {

	private TBoard board;// board displayed by the panel

	public TPanel(TBoard board) throws FileNotFoundException {// constructor-initializes board and
																				// sets up ClickCell

		this.board = board;

		ClickCell click;// Used by toggle cell to invert a cells occupancy
		click = new ClickCell(this);
		addMouseListener(click);// adding a mouselistener to the panel with ClickCell functionality

	}

	@Override
	public void paintComponent(java.awt.Graphics g) {// paintComponent method, designs the graphics of the board
		super.paintComponent(g);// always comes in paintComponent
		setBackground(Color.white);
		int width = getWidth() / board.rows();// width of each cell
		int height = getHeight() / board.columns();// height of each cell

		for (int row = 0; row < board.rows(); row++) {
			for (int column = 0; column < board.columns(); column++) {

				if (board.isAlive(row, column)) {// if the cell is alive it is green
					g.setColor(Color.green);
					g.fillRect(row * width, column * height, width, height);

				} 

				g.setColor(Color.black);//all cells receive a black border
				g.drawRect(row * width, column * height, width, height);

			}

		}

	}

	public void toggleCellAt(int x, int y) {// inverts a cells occupancy
		int width = getWidth() / board.rows();// width of each cell
		int height = getHeight() / board.columns();// height of each cell
		int row = x / width;// finds which cell was clicked
		int column = y / height;
		board.toggle(row, column);// toggles that cell on the board
		repaint();// repainting the panel

	}

}