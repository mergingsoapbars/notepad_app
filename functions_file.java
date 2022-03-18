import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class functions_file {
	notepad mynotepad;
	String filename;
	String filepath;
	
	public functions_file(notepad n) {
		this.mynotepad = n; 
	}
	
	public void newfile() {
		mynotepad.textfield.setText("");
		mynotepad.window.setTitle("New notepad");
		filename = null;
		filepath = null;
	}
	
	public void openfile() {
		FileDialog fd = new FileDialog(mynotepad.window, "Open", FileDialog.LOAD);
		fd.setVisible(true);
		
		if (fd.getFile() != null) {
			filename = fd.getFile();
			filepath = fd.getDirectory();
			mynotepad.window.setTitle(filename);
		}
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filepath + filename));
			mynotepad.textfield.setText(" ");
			
			String line = null;
			
			while ((line = br.readLine()) != null) {
				mynotepad.textfield.append(line + "\n");
			}

			br.close();
		}
		
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Could not open file", "Error", JOptionPane.ERROR_MESSAGE);
			
		}
	}
	
	public void savefile() {
		if (filename == null) {
			savefileas();
		}
		else {
			try {
				FileWriter fw = new FileWriter(filepath + filename);
				mynotepad.window.setTitle(filename);
				fw.write(mynotepad.textfield.getText());
				fw.close();
				
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Could not save file", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void savefileas() {
		FileDialog fd = new FileDialog(mynotepad.window, "Save as...", FileDialog.SAVE);
		fd.setVisible(true); 
		
		if (fd.getFile() != null) {
			filename = fd.getFile();
			filepath = fd.getDirectory();
			mynotepad.window.setTitle(filename);
			
		try {
			FileWriter fw = new FileWriter(filepath + filename);
			fw.write(mynotepad.textfield.getText());
			fw.close();
		}
		
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Could not save file", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void exitfile() {
		System.exit(0);
	}
}
