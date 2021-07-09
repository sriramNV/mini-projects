package classFiles;
import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class fileFunction {
	GUI gui;
	String fileName, fileAddr;
	
	public fileFunction(GUI gui) {
		this.gui = gui;
	}
	
	public void newFile() {
		gui.textArea.setText("");
		gui.window.setTitle("New");		
		fileName = null;
		fileAddr = null;
	}
	
	public void fOpen() {
		FileDialog fd = new FileDialog(gui.window,"Open",FileDialog.LOAD);
		fd.setVisible(true);
		
		if(fd.getFile()!=null) {
			fileName = fd.getFile();
			fileAddr = fd.getDirectory();
			gui.window.setTitle(fileName);
			
		}
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(fileAddr + fileName));
			gui.textArea.setText("");
			String line = null;
			
			while((line = br.readLine())!= null) {
				gui.textArea.append(line + "\n");
			}
			br.close();
		}
		catch (Exception e) {
			System.out.print("File not Exist or cannot be opened");
		}
	}
	
	public void fSave() {
		if(fileName == null) {
			fSaveAs();
		}
		else {
			try {
				FileWriter fw = new FileWriter(fileAddr + fileName); 
				fw.write(gui.textArea.getText());
				fw.close();
			}
			catch (Exception e) {
				System.out.print("Cannot save at current path");
			}
		}
	}
	
	public void fSaveAs() {
		FileDialog fd = new FileDialog(gui.window,"Save",FileDialog.SAVE);
		fd.setVisible(true);
		
		if(fd.getFile()!=null) {
			fileName = fd.getFile();
			fileAddr = fd.getDirectory();
			gui.window.setTitle(fileName);
		}
		try {
			FileWriter fw = new FileWriter(fileAddr + fileName); 
			fw.write(gui.textArea.getText());
			fw.close();
		}
		catch (Exception e) {
			System.out.print("Cannot Save try running as administrator");
		}
	}
	
	public void fExit() {
		System.exit(0);
	}
	
}
