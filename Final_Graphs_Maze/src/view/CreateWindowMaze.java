package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JWindow;


import constant.ConstantsView;
import controller.Controller;
import logic.Circle;
import logic.GenerateBox;
import logic.Grafo;
import persistence.FileUtil;

/**
 * UNIVERSIDAD PEDAGOGICA Y TECNOLOGICA DE COLOMBIA
 * FACULTAD DE INGENIERIA.
 * ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION.
 * PRESENTADO A: Ing Helver Valero.
 * PROGRAMACION III
 * Clase donde se generara el laberinto que el usuario ingrese con su ancho y su alto 
 * @author  Jenny Quesada , Ruth Rojas
 * MIRAR ESTA CLASE QUE NO ESTA HACIENDO NADA 
 */
public class CreateWindowMaze  extends JDialog{

	//------Atributtes------
	
	private boolean pintarLaberinto = false;
	//-------------------
	private PanelCreateButton panelCreateButton;
	private PanelDrawBoard panelDraw;
	private int ancho_celda = 20;
	private int alto_celda = 20;
	private int radio_circulo= 30;
	int inicio,fin,filas,columnas,nodos[][];
	private FileUtil util;
	private ResourceBundle rb = null;
	private GenerateBox generate;
	private Controller controller;
	private Grafo grafo;
	//Atributos de la linea 44 de la clase Proncipal del proyecto Maze
	//Atributo grafo del proyecto Maze clase  Principal linea 56
	
	//------Builder------

	public CreateWindowMaze(Controller controller) {
		load(controller);
	}

	//------Methods------
	public void load(Controller controller){
		
		initializateThis();
		initializatePanelButton(controller);
		initializatePanelDraw();
		initializateOthers();
	}

	public void initializateOthers(){
		generate = new GenerateBox(this, 0, 0);
	}

	public void initializateThis(){
		this.setTitle(ConstantsView.DEFAUTL_NAME_WINDOW);
		this.setSize(ConstantsView.DEFAULT_SIZE, ConstantsView.DEFAULT_SIZE);
		this.setLocationRelativeTo(null);
	}

	public void initializatePanelButton(Controller controller){
		
		this.panelCreateButton = new PanelCreateButton(controller);
		this.panelCreateButton.setBorder(BorderFactory.createTitledBorder("Opciones"));
		this.add(panelCreateButton,BorderLayout.SOUTH);

	}

	public void initializatePanelDraw(){
		this.panelDraw = new PanelDrawBoard(this,3,2 );
//		this.panelDraw.setBorder(BorderFactory.createTitledBorder("Laberinto"));
//		this.add(panelDraw,BorderLayout.CENTER);
	
	}

	private int[][] preguntarFilasColumnas(){
		String cString,fString=JOptionPane.showInputDialog ("Ingrese el numero de filas");
		int filas=2;
		int columnas=2;
		int[][] resultados=new int[1][2];
		boolean error=false;
		try{
			filas=Integer.parseInt(fString);
			resultados[0][0]=filas;
			try{
				cString=JOptionPane.showInputDialog("Ingrese el numero de columnas");
				columnas=Integer.parseInt(cString);
				resultados[0][1]=columnas;
			}catch(NumberFormatException nfe){
				error=true;
				JOptionPane.showMessageDialog(this,"Error leyendo el numero de columnas","Error",JOptionPane.ERROR_MESSAGE);
			}
		}catch(NumberFormatException nfe){
			error=true;
			JOptionPane.showMessageDialog(this, "Error leyendo el numero de filas","Error",JOptionPane.ERROR_MESSAGE);
		}
		if(error){
			resultados=null;
		}
		return resultados;
	}

	/**
	 * Metodo que me toca mirar algunas cosas que no pienso que vaya ahi 
	 */

	public void read(InputStream input , String file , boolean openEditor){

		String line = "";
		BufferedReader buffer;
		//me falta mete la parte del grafo 
		pintarLaberinto =! openEditor;
		try {
			buffer = new BufferedReader(new InputStreamReader(input));
			filas = Integer.parseInt(buffer.readLine());
			columnas = Integer.parseInt(buffer.readLine());
			inicio = Integer.parseInt(buffer.readLine());
			fin = Integer.parseInt(buffer.readLine());
			int total = filas* columnas ;
			nodos = new int[total][total]; 
			//Nodo linea 308 clase principal del proyecto Maze
			for (int i = 0; i < total; i++) {
				line = buffer.readLine();
				String[] numeros = line.trim().split(" ") ; // BUSCAR QUE ES UN TRIM 
				int nodoNumber = Integer.parseInt(numeros[0]);
				//Linea de atributo de Nodo linea 314 clase principal
				for (int j = 0; j < numeros.length; j++) {
					nodos[i][Integer.parseInt(numeros[j])]=1;
					//318
					int nVecinos = Integer.parseInt(numeros[j]);
					//322
					//323
				}
			}
		} catch (NumberFormatException e) {
			util.showMessagger((Component) this,"Mensaje  de error archivo sintaxis ");
		}catch (IOException e) {
			util.showMessagger((Component) this,util.mesagge("Error de archivo", new Object[]{file}));
		}

		if(!openEditor){
//			drawTablero();
			repaint();
		}else{
			//337
			//338
		}


	}

	public void readFile(File file , boolean openEditor){

		try {
			this.read(new FileInputStream(file), file.getName(), openEditor);
		} catch (FileNotFoundException e) {
			util.showMessagger((Component) this, "Archivo no existe");
		}
	}

	public void generateMaze(){// Metodo para generar el laberinto 
		
		int[][] datos = preguntarFilasColumnas();
		if(datos != null){
			panelDraw = new PanelDrawBoard(this, datos[0][0], datos[0][1]);
			this.panelDraw.setVisible(true);
			
		}
	}

	public void drawTablero(){ //Metodo que dibuja el tablero
		if(nodos!=null){
			panelDraw.cleanAll();
			panelDraw.repaint();
			
			ancho_celda=panelDraw.getWidth()/columnas;
			alto_celda=panelDraw.getHeight()/filas;
			radio_circulo=ancho_celda/8;
			
			for(int fila=0;fila<filas;fila++){
				for(int columna=0;columna<columnas;columna++){
					int numero=columna+fila*columnas;
					//lineas horizontales
					panelDraw.addLine(columna*ancho_celda, 0, (columna+1)*ancho_celda, 0);
					if((fila>0 && nodos[numero][numero-columnas]==0)){
						panelDraw.addLine(columna*ancho_celda, fila*alto_celda, (columna+1)*ancho_celda, fila*alto_celda);
					}
					panelDraw.addLine(columna*ancho_celda, (filas)*alto_celda, (columna+1)*ancho_celda, (filas)*alto_celda);

					//lineas verticales
					panelDraw.addLine(0,fila*alto_celda,0,(fila+1)*alto_celda);
					if(columna>0 && nodos[numero][numero-1]==0){
						panelDraw.addLine(columna*ancho_celda,fila*alto_celda,columna*ancho_celda,(fila+1)*alto_celda);
					}
					panelDraw.addLine(columnas*ancho_celda,fila*alto_celda,columnas*ancho_celda,(fila+1)*alto_celda);
					
					if(numero==inicio){
						panelDraw.setCircleEnd(new Circle(columna*ancho_celda+(ancho_celda/2)-radio_circulo,fila*alto_celda+(alto_celda/2)-radio_circulo,radio_circulo));
					}
					if(numero==fin){
						panelDraw.setCircleInit(new Circle(columna*ancho_celda+(ancho_celda/2)-radio_circulo,fila*alto_celda+(alto_celda/2)-radio_circulo,radio_circulo));
					}
				}
			}
		}

	}

	public PanelDrawBoard getPanelDraw() {
		return panelDraw;
	}

	public void setPanelDraw(PanelDrawBoard panelDraw) {
		this.panelDraw = panelDraw;
	}
	
	
}

