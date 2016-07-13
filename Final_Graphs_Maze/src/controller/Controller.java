package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import config.HandlerLanguage;
import constant.ConstantsListener;
import view.PrinicipalFrame;
import view.WindowSelectionImage;
import view.CreateWindowMaze;
import view.DialogHelpAbout;
import view.DialogHowToUse;

/**
 * UNIVERSIDAD PEDAGOGICA Y TECNOLOGICA DE COLOMBIA FACULTAD DE INGENIERIA.
 * ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION.
 * PRESENTADO A: Ing Helver Valero. 
 * PROGRAMACION III 
 * Clase donde se encuenta el manejador de eventos
 * @author Jenny Quesada , Ruth Rojas
 */
public class Controller implements ActionListener, Serializable {

	// ------Atributtes-----

	private HandlerLanguage handlerLanguage;
	private PrinicipalFrame frame;
	private CreateWindowMaze createWindow;
	private WindowSelectionImage windowSelection;

	// ------Builder------

	public Controller() {
		 try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		 loadConfiguration();
	}

	// -----Methods-----

	public void show() {
		frame = new PrinicipalFrame(this);
		frame.setVisible(true);

	}

	public void showWindowCreate() {

		this.createWindow = new CreateWindowMaze(this);
		this.createWindow.setVisible(true);
	}

	public void loadConfiguration() {
		if (handlerLanguage == null) {
			handlerLanguage = new HandlerLanguage("language/config.ini");
			try {
				handlerLanguage.loadLanguage();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(HandlerLanguage.language);
		}
	}
	
	public void showWindowSelection(){
		
		this.windowSelection = new WindowSelectionImage();
		this.windowSelection.setVisible(true);
	}
	public void changeToEnglish() {
		HandlerLanguage handlerLanguage = new HandlerLanguage("language/config.ini");
		try {
			handlerLanguage.language = "language/languageUs.properties";
			handlerLanguage.setLanguage();
			frame.getMenu().changeLenguage();
			frame.getToolBar().changeLenguage();
			frame.changeLenguage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void changeToSpanish() {
		HandlerLanguage handlerLanguage = new HandlerLanguage("language/config.ini");
		try {
			handlerLanguage.language = "language/languageEs.properties";
			handlerLanguage.setLanguage();
			frame.getMenu().changeLenguage();
			frame.getToolBar().changeLenguage();
			frame.changeLenguage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case ConstantsListener.ITEM_FILE_OPEN_IMAGE:
			showWindowSelection();
			break;
		case ConstantsListener.ITEM_FILE_CREATE_IMAGE:
			showWindowCreate();
			break;
		case ConstantsListener.ITEM_FILE_EDIT_IMAGE:
			break;
		case ConstantsListener.ITEM_FILE_CLOSE_APP:
			System.exit(0);
			break;
		case ConstantsListener.ITEM_FILE_LANGUAGE_SPANISH:
			changeToSpanish();
			break;
		case ConstantsListener.ITEM_FILE_LANGUAGE_ENGLISH:
			changeToEnglish();
			break;
		case ConstantsListener.CREATE_MAZE :
			createWindow.generateMaze();
			break;
		case ConstantsListener.ITEM_ABOUT:
			DialogHelpAbout dialogHelpAbout  = new DialogHelpAbout(frame);
			dialogHelpAbout.setVisible(true);
			break;
		case ConstantsListener.ITEM_HELP_HOW_TO_USE:
			 new DialogHowToUse(frame);
		}
	}
}