
/*4/16/2019
 * 
 * The ButtonPanel class creates the panel that contains the play and pause buttons for the board GUI 
 * 
 * William Field
 */
import java.awt.BorderLayout;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ButtonPanel() {
	
		JPanel buttons = new JPanel();
		
		add(buttons, BorderLayout.WEST);// adding buttons to BorderLayout.SOUTH
		buttons.add(new JButton("file"));// adding both playaction and pauseaction to buttons
		buttons.add(new JButton("edit"));
		buttons.add(new JButton("about"));
		
		
	}


}
