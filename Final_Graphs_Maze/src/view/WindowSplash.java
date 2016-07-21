package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JProgressBar;
import javax.swing.JWindow;
import constant.ConstantsView;
import controller.Controller;


/**
 * UNIVERSIDAD PEDAGOGICA Y TECNOLOGICA DE COLOMBIA
 * FACULTAD DE INGENIERIA
 * ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION 
 * PRESENTADO A : ING HELVER VALERO
 * PROGRAMACION III-
 * @author Jenny Paola Quesada Hernandez
  *Cod:201221227
 */
public class WindowSplash extends JWindow implements Runnable {
	
	//-----Atributtes-----
	
	private Thread threadSplash;
	private JProgressBar progressBar;
	private PanelSplash panelSplash;

	
	
	//-----Builder------
	
	

	public WindowSplash() {
	loadMethod();
	this.setVisible(true);
	}

	//-----Methods-----
	/**
	 * Metodo que carga los metodos de inicializacion al constructor
	 */
	public void loadMethod(){
		initializateThis();
		initializateImage();
		initializateProgress();
		initalizateThread();
	}
	/**
	 * Metodo  que inicializa los componentes del panel
	 */
	public void initializateThis(){
		this.setSize(ConstantsView.DEFAULT_SIZE_WIDTH,ConstantsView.DEFAULT_SIZE_HIGTH);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.add(initializateImage(),BorderLayout.CENTER);
		this.add(initializateProgress(),BorderLayout.SOUTH);
	}
	
	/**
	 * Metodo para  inicializar los componentes de la imagen
	 * @return 
	 */
	public Component initializateImage(){
		return this.panelSplash = new PanelSplash();
	}
	/**
	 * Metodo donde incializa los metodo de la barra de progreso
	 * @return 
	 */
	public Component initializateProgress(){
		this.progressBar = new JProgressBar();
		this.progressBar.setIndeterminate(true);
		this.progressBar.setBackground(Color.decode("#6A0888"));
		return progressBar;
	}
	/**
	 * Metodo donde inicaliza los componentes del hilo
	 */
	public void initalizateThread(){
		this.threadSplash = new Thread(this);
		this.threadSplash.start();
	}
	/**
	 * Metodo del hilo en el cual hace que despues de que inicie  muestre la ventana principal
	 */
	@Override
	public void run() {
		this.setVisible(true);
		try {
			this.threadSplash.sleep(ConstantsView.DEFAULT_THREAD);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.dispose();
		Controller controller = new Controller();
		controller.show();
	}
	
}
