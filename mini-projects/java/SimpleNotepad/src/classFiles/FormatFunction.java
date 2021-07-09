package classFiles;
import java.awt.Font;

public class FormatFunction {
	GUI gui;
	Font Arial, CSMS, TNR;
	String selectedF;
	
	public FormatFunction(GUI gui) {
		this.gui = gui;
	}
	
	public void wordWrap() {
		if(gui.wordWrapOn == false) {
			gui.wordWrapOn = true;
			gui.textArea.setLineWrap(true);
			gui.textArea.setWrapStyleWord(true);
			gui.fWrap.setText("Word Wrap: On");
		}
		else if(gui.wordWrapOn == true) {
			gui.wordWrapOn = false;
			gui.textArea.setLineWrap(false);
			gui.textArea.setWrapStyleWord(false);
			gui.fWrap.setText("Word Wrap: Off");
		}
	}
	
	public void createFont(int size) {
		Arial = new Font("Arial", Font.PLAIN, size);
		CSMS = new Font("Comic Sans MS", Font.PLAIN, size);
		TNR = new Font("Times New Roman", Font.PLAIN, size);
		
		setFont(selectedF);
	}
	
	public void setFont(String font) {
		selectedF = font;
		
		switch(selectedF) {
		case "Arial": gui.textArea.setFont(Arial); break;
		case "CSMS": gui.textArea.setFont(CSMS); break;
		case "TNR": gui.textArea.setFont(TNR); break;
		}
	}
	
	
}
