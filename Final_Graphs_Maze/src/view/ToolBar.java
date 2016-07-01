package view;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import config.HandlerLanguage;
import config.HandlerProperties;
import constant.ConstantsListener;
import constant.ConstantsView;
import controller.Controller;
/**
 * UNIVERSIDAD PEDAGOGICA Y TECNOLOGICA DE COLOMBIA
 * FACULTAD DE INGENIERIA.
 * ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION.
 * PRESENTADO A: Ing Helver Valero.
 * PROGRAMACION III
 * Clase 
 * @author Jenny Quesada , Ruth Rojas
 */
public class ToolBar extends JToolBar {

	//-----Attributte-------

	private static final long serialVersionUID = 1L;
	private JButton buttonOpenImage;
	private JButton buttonCreateImage;
	private JButton buttonEditImage;
	private Controller controller;

	//------Builder------

	public ToolBar(Controller controller) {
		super();
		this.controller = controller;
		init();
		try {
			changeLenguage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//------Methods-------
	
	private void init() {
		addButtonOpenImage();
		addButtonCreateImage();
		addButtonEditImage();
	}

	private void addButtonOpenImage() {
		buttonOpenImage = new JButton(createImageIcon(ConstantsView.IMAGE_OPEN));
		buttonOpenImage.addActionListener(controller);
		buttonOpenImage.setActionCommand(ConstantsListener.ITEM_FILE_OPEN_IMAGE);
		this.add(buttonOpenImage);
	}

	private void addButtonCreateImage() {
		buttonCreateImage = new JButton(createImageIcon(ConstantsView.IMAGE_CREATE));
		this.add(buttonCreateImage);
	}

	private void addButtonEditImage() {
		buttonEditImage = new JButton(createImageIcon(ConstantsView.IMAGE_EDIT));
		this.add(buttonEditImage);
	}

	protected ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			return null;
		}
	}

	public void changeLenguage() throws IOException {

		HandlerProperties handlerProperties = new HandlerProperties(HandlerLanguage.language);
		handlerProperties.load();
		buttonOpenImage
		.setToolTipText(handlerProperties.getProperty(ConstantsView.TOOL_BAR_TOOL_TIP_BUTTON_OPEN_IMAGE));
		buttonCreateImage
		.setToolTipText(handlerProperties.getProperty(ConstantsView.TOOL_BAR_TOOL_TIP_BUTTON_CREATE_IMAGE));
		buttonEditImage
		.setToolTipText(handlerProperties.getProperty(ConstantsView.TOOL_BAR_TOOL_TIP_BUTTON_EDIT_IMAGE));

	}
}
