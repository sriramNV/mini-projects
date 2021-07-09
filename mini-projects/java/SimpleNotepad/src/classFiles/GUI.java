package classFiles;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
//import javax.swing.undo.UndoManager;
import javax.swing.undo.*;


public class GUI implements ActionListener {
	
	 JFrame window;
//	 Text Area
	 JTextArea textArea;
	 JScrollPane scrollPane;
	 Boolean wordWrapOn = false;
//	 Main menu bar
	 JMenuBar menuBar;
	 JMenu fileM, editM, formatM, colorM;
//	 file menu
	 JMenuItem fNew,fOpen,fSave,fSaveAs,fExit;
//	 edit menu
	 JMenuItem eRedo, eUndo;
//	 format menu
	 JMenuItem fWrap , fontArial, fontCSMS, fontTNR, fontSize8, fontSize12, fontSize16, fontSize18, fontSize20, fontSize24, fontSize28;
	 JMenu mFont, mFontSize;
//	 color menu
	 JMenuItem color1, color2, color3;
	 
	 fileFunction file = new fileFunction(this);
	 FormatFunction format = new FormatFunction(this);
	 ColorFunction colorF = new ColorFunction(this);
	 EditFunction edit = new EditFunction(this);
	 KeyHandler kHandle = new KeyHandler(this);
	 
	 UndoManager um = new UndoManager();
	
	
	public GUI() {
		createWindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
		createEditMenu();
		createFormatMenu();
		createColorMenu();
		
		
		format.selectedF = "Arial";
		format.createFont(16);
		format.wordWrap();
		colorF.changeColor("white");
		
		window.setVisible(true); 
	}
	
	public void createWindow() {
		window = new JFrame("Notepad");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void createTextArea() {
		textArea = new JTextArea();
		textArea.setFont(format.Arial);
		
		textArea.addKeyListener(kHandle);
		
		textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
			
			@Override
			public void undoableEditHappened(UndoableEditEvent e) {
				um.addEdit(e.getEdit());
				
			}
		});
		
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollPane);
	}
	
	public void createMenuBar() {
		
		menuBar = new JMenuBar();
		fileM = new JMenu("File");
		editM = new JMenu("Edit");
		formatM = new JMenu("Format");
		colorM = new JMenu("Background Color");
		
		window.setJMenuBar(menuBar);		
		
		menuBar.add(fileM);
		menuBar.add(editM);		
		menuBar.add(formatM);		
		menuBar.add(colorM);
	}
	
	public void createFileMenu() {
		fNew = new JMenuItem("New");
		fOpen = new JMenuItem("Open");
		fSave = new JMenuItem("Save");
		fSaveAs = new JMenuItem("Save As");
		fExit = new JMenuItem("Exit");
		
		fNew.addActionListener(this);
		fNew.setActionCommand("New");
		fileM.add(fNew);
		
		fOpen.addActionListener(this);
		fOpen.setActionCommand("Open");
		fileM.add(fOpen);
		
		fSave.addActionListener(this);
		fSave.setActionCommand("Save");
		fileM.add(fSave);
		
		fSaveAs.addActionListener(this);
		fSaveAs.setActionCommand("SaveAs");
		fileM.add(fSaveAs);
		
		fExit.addActionListener(this);
		fExit.setActionCommand("Exit");
		fileM.add(fExit);
	}
	
	public void createEditMenu() {
		eUndo = new JMenuItem("Undo");
		eUndo.addActionListener(this);
		eUndo.setActionCommand("undo");
		editM.add(eUndo);
		
		eRedo = new JMenuItem("Redo");
		eRedo.addActionListener(this);
		eRedo.setActionCommand("redo");
		editM.add(eRedo);
	}
	
	
	
	public void createFormatMenu() {
		
		fWrap = new JMenuItem("Word Wrap: Off");
		fWrap.addActionListener(this);
		fWrap.setActionCommand("WordWrap");
		formatM.add(fWrap);
		
		mFont = new JMenu("Font");
		formatM.add(mFont);
		
		fontArial = new JMenuItem("Arial");
		fontArial.addActionListener(this);
		fontArial.setActionCommand("Arial");
		mFont.add(fontArial);
		
		fontCSMS = new JMenuItem("ComicSans MS");
		fontCSMS.addActionListener(this);
		fontCSMS.setActionCommand("CSMS");
		mFont.add(fontCSMS);
		
		fontTNR = new JMenuItem("Times New Roman");
		fontTNR.addActionListener(this);
		fontTNR.setActionCommand("TNR");
		mFont.add(fontTNR);
		
		mFontSize = new JMenu("Font Size");
		formatM.add(mFontSize);
		
		fontSize8 = new JMenuItem("8px");
		fontSize8.addActionListener(this);
		fontSize8.setActionCommand("f8");
		mFontSize.add(fontSize8);
		
		fontSize12 = new JMenuItem("12px");
		fontSize12.addActionListener(this);
		fontSize12.setActionCommand("f12");
		mFontSize.add(fontSize12);
		
		fontSize16 = new JMenuItem("16px");
		fontSize16.addActionListener(this);
		fontSize16.setActionCommand("f16");
		mFontSize.add(fontSize16);
		
		fontSize18 = new JMenuItem("18px");
		fontSize18.addActionListener(this);
		fontSize18.setActionCommand("f18");
		mFontSize.add(fontSize18);
		
		fontSize20 = new JMenuItem("20px");
		fontSize20.addActionListener(this);
		fontSize20.setActionCommand("f20");
		mFontSize.add(fontSize20);
		
		fontSize24 = new JMenuItem("24px");
		fontSize24.addActionListener(this);
		fontSize24.setActionCommand("f24");
		mFontSize.add(fontSize24);
		
		fontSize28 = new JMenuItem("28px");
		fontSize28.addActionListener(this);
		fontSize28.setActionCommand("f28");
		mFontSize.add(fontSize28);
	}
	
	public void createColorMenu() {
		color1 = new JMenuItem("White");
		color1.addActionListener(this);
		color1.setActionCommand("white");
		colorM.add(color1);
		
		color2 = new JMenuItem("Black");
		color2.addActionListener(this);
		color2.setActionCommand("black");
		colorM.add(color2);
		
		color3 = new JMenuItem("Blue");
		color3.addActionListener(this);
		color3.setActionCommand("blue");
		colorM.add(color3);
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		switch (command) {
		case "New": file.newFile(); break;
		case "Open": file.fOpen(); break;
		case "Save": file.fSave(); break;
		case "SaveAs": file.fSaveAs(); break;
		case "Exit": file.fExit(); break;
		
		case "undo": edit.undo(); break;
		case "redo": edit.redo(); break;
		
		case "WordWrap": format.wordWrap(); break;
		
		case "Arial": format.setFont("Arial"); break;
		case "CSMS": format.setFont("CSMS"); break;
		case "TNR": format.setFont("TNR"); break;
		
		case "f8": format.createFont(8); break;
		case "f12": format.createFont(12); break;
		case "f16": format.createFont(16); break;
		case "f18": format.createFont(18); break;
		case "f20": format.createFont(20); break;
		case "f24": format.createFont(24); break;
		case "f28": format.createFont(28); break;
		
		case "white": colorF.changeColor("white"); break;
		case "black": colorF.changeColor("black"); break;
		case "blue": colorF.changeColor("blue"); break;
		
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		new GUI();
	}

}
