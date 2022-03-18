import java.awt.Font;

public class functions_format {
	notepad mynotepad;
	Font font;
	int fontsize;
	
	public functions_format(notepad n) {
		this.mynotepad = n;
	}
	
	public void wordwrap() {
		if(mynotepad.word_wrap_bool == false) {
			mynotepad.textfield.setLineWrap(true);
			mynotepad.textfield.setWrapStyleWord(true);
			mynotepad.word_wrap_bool = true;
			mynotepad.menu_format_wrap.setText("Word wrap: on");
		}
		else if(mynotepad.word_wrap_bool == true) {
			mynotepad.textfield.setLineWrap(false);
			mynotepad.word_wrap_bool = false;
			mynotepad.menu_format_wrap.setText("Word wrap: off");
		}
	}
	
	public void setfontsize(int fontsize) {
		
		Font font = new Font("Arial", Font.PLAIN, fontsize);
		mynotepad.textfield.setFont(font);
	}
}
