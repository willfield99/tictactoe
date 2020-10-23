import java.io.FileNotFoundException;

public class Application{
	

public static void main(String[] args) {	
	TFrame frame;
	
	
	try {
		frame = new TFrame(500, 100, 1019, 894);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	
}
}	