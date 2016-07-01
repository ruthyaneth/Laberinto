package view;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import config.HandlerLanguage;
import config.HandlerProperties;
import constant.ConstantsView;

public class DialogHowToUse extends JDialog {

	private static final long serialVersionUID = -8494982714203988239L;
	private JTextArea areaInstructions;

	public DialogHowToUse(JFrame j) {
		super(j );
		this.setSize(ConstantsView.WIDTH_DIALOJ_ABOUT, 280);
		this.setLocationRelativeTo(null);
		addAreaInstructions();
		readDoc();
		try {
			changeLenguage();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setVisible(true);
	}
	private void readDoc(){
		String infoFile = new String(), path = "src/resources/instructions.txt";
		File archivo = new File(path);

		FileReader fr = null;
		BufferedReader entrada = null;
		try {
			fr = new FileReader(path);
			entrada = new BufferedReader(fr);

			while(entrada.ready()){
				infoFile += entrada.readLine();
			}

		}catch(IOException e) {
			e.printStackTrace();
		}finally{
			try{                    
				if(null != fr){   
					fr.close();     
				}                  
			}catch (Exception e2){ 
				e2.printStackTrace();
			}
		}
		areaInstructions.setText(infoFile);
	}

	private void addAreaInstructions() {
		areaInstructions = new JTextArea();
		this.add(areaInstructions);
		areaInstructions.setEditable(false);
		areaInstructions.setLineWrap(true);
		areaInstructions.setWrapStyleWord(true);
		areaInstructions.setBackground(Color.decode("#151515"));
		areaInstructions.setForeground( Color.decode("#FAFAFA"));
	}

	public void changeLenguage() throws IOException {

		HandlerProperties handlerProperties = new HandlerProperties(HandlerLanguage.language);
		handlerProperties.load();
		this.setTitle(handlerProperties.getProperty(ConstantsView.TITLE_DIALOG_HOW_TO_USE));
		
	}
}
