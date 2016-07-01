package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import config.HandlerLanguage;
import config.HandlerProperties;
import constant.ConstantsView;

public class DialogHelpAbout extends JDialog {

	private static final long serialVersionUID = 7866298941041835837L;
	private JPanel panelImages;
	private JLabel labelImagen1;
	private JLabel labelImagen2;
	private JPanel panelInfo;
	private JTextArea textAreaInfo;
	private JScrollPane scrollPane;

	public DialogHelpAbout(JFrame j) {
		super(j);
		this.setSize(ConstantsView.WIDTH_DIALOJ_ABOUT, ConstantsView.HEIGHT_DIALOG_ABOUT);
		this.setLocationRelativeTo(j);
		addPanelIamges();
		addLabelImagen1();
		addLabelImagen2();
		addPanelInfo();
		addFieldInfo();
		try {
			changeLenguage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void addPanelIamges(){
		
		panelImages = new JPanel();
		panelImages.setBorder(new LineBorder(Color.decode("#6A0888")));
		panelImages.setBackground(Color.decode("#6E6E6E"));
		this.add(panelImages, BorderLayout.WEST);
		
	}
	private void addPanelInfo(){
		panelInfo = new JPanel();
		panelInfo.setBackground(Color.decode("#424242"));
		this.add(panelInfo, BorderLayout.CENTER);
	}
	private void addLabelImagen1(){
		
		labelImagen1 = new JLabel(" ");
		labelImagen1.setBorder(new LineBorder(Color.decode("#A901DB")));
		labelImagen1.setIcon(new ImageIcon(getClass().getResource(ConstantsView.IMAGE_LABEL_IMAGEN1)));
		panelImages.add(labelImagen1);
	}
	
	private void addFieldInfo(){
		textAreaInfo = new JTextArea(10,10);
		scrollPane = new JScrollPane(textAreaInfo);
		this.add(scrollPane);
		scrollPane.setBounds(50, 20, 10, 100);
		textAreaInfo.setEditable(false);
		textAreaInfo.setLineWrap(true);
		textAreaInfo.setWrapStyleWord(true);
		textAreaInfo.setBackground(Color.decode("#151515"));
		textAreaInfo.setForeground( Color.decode("#FAFAFA"));
	}
	private void addLabelImagen2(){
		
		labelImagen2 = new JLabel();
		labelImagen1.setBorder(new LineBorder(Color.decode("#A901DB")));
		panelImages.add(labelImagen2);
	}

	public void changeLenguage() throws IOException {

		HandlerProperties handlerProperties = new HandlerProperties(HandlerLanguage.language);
		handlerProperties.load();
		this.setTitle(handlerProperties.getProperty(ConstantsView.TITLE_DIALOG_HELP_ABOUT));
		textAreaInfo.setText(handlerProperties.getProperty(ConstantsView.INFO_ABOUT));
	}
}
