package classFiles;
import java.awt.Color;

public class ColorFunction {
	GUI gui;
	public ColorFunction(GUI gui) {
		this.gui = gui;
	}
	
	public void changeColor(String color) {
		switch(color) {
		case "white": 
			gui.window.getContentPane().setBackground(Color.white);
			gui.textArea.setBackground(Color.white);
			gui.textArea.setForeground(Color.black);
		break;
		case "black": 
			gui.window.getContentPane().setBackground(Color.white);
			gui.textArea.setBackground(Color.black);
			gui.textArea.setForeground(Color.white); break;
		case "blue": 
			gui.window.getContentPane().setBackground(new Color(28,186,186));
			gui.textArea.setBackground(new Color(28,186,186));
			gui.textArea.setForeground(Color.white); break;
		}
	}
}
