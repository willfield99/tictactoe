import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import javax.swing.JFrame;

public class TFrame extends JFrame {

	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TPanel boardpanel;// the panel on which the board is displayed
	private ButtonPanel buttonpanel;
	
	public TFrame(int x, int y, int width, int height) throws FileNotFoundException {// Creates the frame
		super();
		TBoard board;// board used by the panel
		
		board = new TBoard();
		boardpanel = new TPanel(board);
		buttonpanel = new ButtonPanel();
		

		
		//thread.start();// starting the thread

		add(boardpanel, BorderLayout.CENTER);// adding boardpanel to the center of the window
		add(buttonpanel, BorderLayout.NORTH);// adding the buttons to the south of the window

		setSize(width, height);// Size mutator
		setLocation(x, y);// Location mutator

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
}