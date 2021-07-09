package classFiles;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	
	GUI gui;
	
	public KeyHandler(GUI gui) {
		this.gui = gui;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
			gui.file.fSave();
		}
		
		if(e.isControlDown() && e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_S) {
			gui.file.fSaveAs();
		}
		if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_N) {
			gui.file.newFile();
		}
		if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_O) {
			gui.file.fOpen();
		}
		if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Q) {
			gui.file.fExit();;
		}
		if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z) {
			gui.edit.undo();
		}
		if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Y) {
			gui.edit.redo();
		}
		if(e.isAltDown() && e.getKeyCode() == KeyEvent.VK_F) {
			gui.fileM.doClick();
		}
		if(e.isAltDown() && e.getKeyCode() == KeyEvent.VK_E) {
			gui.editM.doClick();
		}
		if(e.isAltDown() && e.getKeyCode() == KeyEvent.VK_O) {
			gui.formatM.doClick();
		}
		if(e.isAltDown() && e.getKeyCode() == KeyEvent.VK_C) {
			gui.colorM.doClick();
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
