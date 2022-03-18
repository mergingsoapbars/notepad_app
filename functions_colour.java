import java.awt.Color;

public class functions_colour {
	notepad mynotepad;
	String colour;
	
	public functions_colour(notepad n) {
		this.mynotepad = n;
	}
	
	public void setcolour(String colour) {
		switch(colour) {
		case "Red": 
			mynotepad.window.getContentPane().setBackground(Color.BLACK);
			mynotepad.textfield.setBackground(Color.WHITE); 
			mynotepad.textfield.setForeground(Color.RED);
			break;
		case "Blue": 
			mynotepad.window.getContentPane().setBackground(Color.BLACK);
			mynotepad.textfield.setBackground(Color.BLUE); 
			mynotepad.textfield.setForeground(Color.BLUE);
			break;
		case "Green": 
			mynotepad.window.getContentPane().setBackground(Color.BLACK);
			mynotepad.textfield.setBackground(Color.WHITE); 
			mynotepad.textfield.setForeground(Color.GREEN); 
			break;
		case "Black": 
			mynotepad.window.getContentPane().setBackground(Color.BLACK);
			mynotepad.textfield.setBackground(Color.WHITE); 
			mynotepad.textfield.setForeground(Color.BLACK); 
			break;
		}
	}

}
