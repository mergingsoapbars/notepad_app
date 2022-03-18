import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class notepad implements ActionListener {
	
	JFrame window;
	JTextArea textfield;
	JScrollPane scroller;
	JMenuBar menubar;
	JMenu menu_file, menu_edit, menu_format, menu_colour;
	JMenuItem menu_file_new, menu_file_open, menu_file_save, menu_file_saveas, menu_file_exit;
	JMenuItem menu_format_size_8,menu_format_size_10, menu_format_size_12, menu_format_size_14; 
	JMenuItem menu_format_size_16,menu_format_size_20, menu_format_size_24, menu_format_size_48, menu_format_wrap; 
	JMenuItem menu_edit_undo, menu_edit_redo;
	JMenu menu_format_size;
	boolean word_wrap_bool = false;
	
	functions_file func = new functions_file(this);
	functions_format form = new functions_format(this);
	functions_edit edit = new functions_edit(this);
	
	UndoManager unma = new UndoManager();	

	public notepad() {
		
		createWindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
		createFormatMenu();
		createEditMenu();
		
		window.setVisible(true);
		form.setfontsize(12);
	}
	
	public void createWindow() {
		window = new JFrame("Jeroen's notepad");
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void createTextArea() {
		textfield = new JTextArea();
		scroller = new JScrollPane(textfield, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		window.add(scroller);
		textfield.getDocument().addUndoableEditListener(new UndoableEditListener() {
			@Override
			public void undoableEditHappened(UndoableEditEvent e) {
				unma.addEdit(e.getEdit());
			}
		});
	}
	
	public void createMenuBar() {
		menubar = new JMenuBar();
		window.setJMenuBar(menubar);
		
		menu_file = new JMenu("File");
		menubar.add(menu_file);
		
		menu_edit = new JMenu("Edit");
		menubar.add(menu_edit);
		
		menu_format = new JMenu("Format");
		menubar.add(menu_format);
	}
	
	public void createFileMenu() {
	
		menu_file_new = new JMenuItem("New");
		menu_file_new.addActionListener(this);
		menu_file_new.setActionCommand("New");
		menu_file.add(menu_file_new);
		
		menu_file_open = new JMenuItem("Open");
		menu_file_open.addActionListener(this);
		menu_file_open.setActionCommand("Open");
		menu_file.add(menu_file_open);
		
		menu_file_save = new JMenuItem("Save");
		menu_file_save.addActionListener(this);
		menu_file_save.setActionCommand("Save");
		menu_file.add(menu_file_save);
		
		menu_file_saveas = new JMenuItem("Save as...");
		menu_file_saveas.addActionListener(this);
		menu_file_saveas.setActionCommand("Save as...");
		menu_file.add(menu_file_saveas);
		
		menu_file_exit = new JMenuItem("Exit");
		menu_file_exit.addActionListener(this);
		menu_file_exit.setActionCommand("Exit");
		menu_file.add(menu_file_exit);
	}
	
	public void createFormatMenu() {
		menu_format_wrap = new JMenuItem("Word wrap: off");
		menu_format_wrap.addActionListener(this);
		menu_format_wrap.setActionCommand("Word wrap");
		menu_format.add(menu_format_wrap);
		
		menu_format_size = new JMenu("Font size");
		menu_format.add(menu_format_size);
		
		menu_format_size_8 = new JMenuItem("8");
		menu_format_size_8.addActionListener(this);
		menu_format_size_8.setActionCommand("8");
		menu_format_size.add(menu_format_size_8);
		
		menu_format_size_10 = new JMenuItem("10");
		menu_format_size_10.addActionListener(this);
		menu_format_size_10.setActionCommand("10");
		menu_format_size.add(menu_format_size_10);
		
		menu_format_size_12 = new JMenuItem("12");
		menu_format_size_12.addActionListener(this);
		menu_format_size_12.setActionCommand("12");
		menu_format_size.add(menu_format_size_12);
		
		menu_format_size_14 = new JMenuItem("14");
		menu_format_size_14.addActionListener(this);
		menu_format_size_14.setActionCommand("14");
		menu_format_size.add(menu_format_size_14);
		
		menu_format_size_16 = new JMenuItem("16");
		menu_format_size_16.addActionListener(this);
		menu_format_size_16.setActionCommand("16");
		menu_format_size.add(menu_format_size_16);
		
		menu_format_size_20 = new JMenuItem("20");
		menu_format_size_20.addActionListener(this);
		menu_format_size_20.setActionCommand("20");
		menu_format_size.add(menu_format_size_20);
		
		menu_format_size_24 = new JMenuItem("24");
		menu_format_size_24.addActionListener(this);
		menu_format_size_24.setActionCommand("24");
		menu_format_size.add(menu_format_size_24);
		
		menu_format_size_48 = new JMenuItem("48");
		menu_format_size_48.addActionListener(this);
		menu_format_size_48.setActionCommand("48");
		menu_format_size.add(menu_format_size_48);
	}
	
	public void createEditMenu() {
		menu_edit_undo = new JMenuItem("Undo");
		menu_edit_undo.addActionListener(this);
		menu_edit_undo.setActionCommand("Undo");
		menu_edit.add(menu_edit_undo);
		
		menu_edit_redo = new JMenuItem("Redo");
		menu_edit_redo.addActionListener(this);
		menu_edit_redo.setActionCommand("Redo");
		menu_edit.add(menu_edit_redo);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		switch(command) {
		case "New": func.newfile(); break;
		case "Open": func.openfile(); break;
		case "Save": func.savefile(); break;
		case "Save as...": func.savefileas(); break;
		case "Exit": func.exitfile(); break;
		
		case "Word wrap": form.wordwrap(); break;
		
		case "8": form.setfontsize(8); break;
		case "10": form.setfontsize(10); break;
		case "12": form.setfontsize(12); break;
		case "14": form.setfontsize(14); break;
		case "16": form.setfontsize(16); break;
		case "20": form.setfontsize(20); break;
		case "24": form.setfontsize(24); break;
		case "48": form.setfontsize(48); break;
		
		case "Undo": edit.undo(); break;
		case "Redo": edit.redo(); break;
		}
	}
	
	public static void main(String[] args) {
		new notepad();
	}
}
