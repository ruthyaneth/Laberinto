package config;
import java.io.IOException;
/**
 * UNIVERSIDAD PEDAGOGICA Y TECNOLOGICA DE COLOMBIA
 * FACULTAD DE INGENIERIA.
 * ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION.
 * PRESENTADO A: Ing Helver Valero.
 * PROGRAMACION III
 * Clase  
 * @author Jenny Quesada , Ruth Rojas
 */
public class HandlerLanguage {
	
	//-------Atributtes-------
	
	private String fileName;
	public static String language = "undified";
	
	//-------Builder--------
	
	public HandlerLanguage(String fileName) {
		this.fileName = fileName;
	}
	
	//-------Methods--------
	
	public void loadLanguage() throws IOException{
		
		HandlerProperties handlerProperties = new HandlerProperties(fileName);
		handlerProperties.load();
		language = handlerProperties.getProperty("language");
	}

	public void setLanguage() throws IOException{
		HandlerProperties handlerProperties = new HandlerProperties(fileName);
		handlerProperties.load();
		handlerProperties.setProperty("language", language);
		handlerProperties.save();
	}

	//-------Gets&&Setss-------
	
}
