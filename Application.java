import java.io.FileNotFoundException;

import javax.swing.SwingUtilities;
/*
 * Implements TFrame
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