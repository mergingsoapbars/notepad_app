
public class functions_edit {
	notepad mynotepad;
	
	public functions_edit(notepad n) {
		this.mynotepad = n;
	}
	
	public void undo() {
		mynotepad.unma.undo();
	}
	
	public void redo() {
		mynotepad.unma.redo();
	}
}
