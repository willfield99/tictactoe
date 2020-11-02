
/*this class is currently unused
 * 
 */
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.awt.event.MouseAdapter;

public class ClickCell extends MouseAdapter {

	private TPanel panel;// panel

	public ClickCell(TPanel panel) throws FileNotFoundException {// ClickCell constructor

		this.panel = panel;
	}

	public void mouseClicked(MouseEvent event) {// gets The event where the mouse is clicked and toggles the cell there
		if (MouseEvent.BUTTON1 == event.getButton()) {
			panel.toggleCellAt(event.getX(), event.getY());// toggling cell where the mouse is clicked
		}
	}
}
