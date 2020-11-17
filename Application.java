import javax.swing.SwingUtilities;
/*11/17/20
 * Code Killers
 * Implements the Tic tac Toe Board
 */
public class Application{
	

public static void main(String[] args) {	
	SwingUtilities.invokeLater(new Runnable() {

		@Override
		public void run() {
			
			new TFrame();
			
		}
		
	});
	
	

	
}
}	