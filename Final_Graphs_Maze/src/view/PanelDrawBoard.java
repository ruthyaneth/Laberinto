package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.naming.directory.DirContext;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;

import controller.Controller;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import logic.Box;

import logic.Circle;
import logic.Grafo;
import logic.Line;
import logic.Nodo;
import logic.Step;
import persistence.FileUtil;
import util.PairPositions;

/**
 * UNIVERSIDAD PEDAGOGICA Y TECNOLOGICA DE COLOMBIA
 * FACULTAD DE INGENIERIA.
 * ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION.
 * PRESENTADO A: Ing Helver Valero.
 * PROGRAMACION III
 * Clase donde se generara el laberinto que el usuario ingrese con su ancho y su alto 
 * @author Jenny Quesada, Ruth Rojas
 */
public class PanelDrawBoard  extends JDialog {

	//------Atributtes------ 

	private Vector<Line> line;
	private Vector<Step> step;
	private Circle circleInit;
	private Circle circleEnd;
	private int row;
	private int columns;
	private int init = -1;
	private int end = -1;
	private Box[][] box;
	private PanelCreateButton panelButton;
	private CreateWindowMaze create;
	private int ancho_casilla = 40;
	private int alto_casilla = 40; 
	private Grafo grafo;
	private Controller controller;

	//------Builders------

	public PanelDrawBoard(CreateWindowMaze create , int row , int column , Controller controller) {

		this.line = new Vector<Line>(0);
		this.step = new Vector<Step>(0);
		this.row = row;
		this.columns = column;
		initComponent(controller);
	}

	public PanelDrawBoard(CreateWindowMaze create, int row , int column , int init, int end, Grafo grafo) {

		this.line = new Vector<Line>(0);
		this.step = new Vector<Step>(0);
		this.row = row;
		this.columns = column;
		this.init = init;
		this.end = end;
		this.grafo = grafo;
		initComponent(controller);
	}
	
	public PanelDrawBoard(){
		this.line = new Vector<Line>(0);
		this.step = new Vector<Step>(0);
		this.row = 20;
		this.columns = 30;
		initComponent(controller);
	}

	//-----Methods--------

	public void initComponent(Controller controller){
		initThis();
		initPanelButton(controller);

	}

	public void initThis(){
		this.setSize(700, 700);
		this.setLocationRelativeTo(null);
		box = new Box[row][columns];
		addBox();
	}

	public void initPanelButton(Controller controller){
		this.panelButton = new PanelCreateButton(controller);
		this.panelButton.setBorder(BorderFactory.createTitledBorder("Opciones"));
		this.add(panelButton,BorderLayout.SOUTH);
	}

	public void addBox(){

		JPanel casilla = new JPanel(new GridLayout(row, columns));
		JPanel casillaPanel = null;
		JButton abajo, derecha;
		int numeroNodos = 0;
		Nodo actual = null;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < columns; j++) {

				numeroNodos = i * columns + j;
				box[i][j] = new Box(numeroNodos);
				casillaPanel = new JPanel(new BorderLayout());
				
				if(this.init==numeroNodos){
					casillaPanel.setBackground(Color.RED);
				}
				if(this.end==numeroNodos){
					casillaPanel.setBackground(Color.BLUE);
				}
				
				if(grafo!=null){
					actual=grafo.obtenerNodo(numeroNodos);
				}
				int  fila  =i;
				int columna = j;

				abajo = new JButton();
				abajo.setBackground(Color.decode("#D8D8D8"));
				if(grafo != null){
					if((i+1<row) && actual.getVecinos().contains(new Nodo( (i+1)*columns+j  ))){
						abajo.setBackground(Color.pink);
						box[i][j].setVecinoInf(true);
					}
					if((i-1>=0) && actual.getVecinos().contains(new Nodo( (i-1)*columns+j  ))){
						box[i][j].setVecinoSup(true);
					}
				}
				abajo.setPreferredSize(new Dimension(6,6));
				abajo.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						boolean vecinoInf = box[fila][columna].tieneVecinoInf();
						box[fila][columna].setVecinoInf(!vecinoInf);
						if (fila + 1 < row) {
							box[fila + 1][columna].setVecinoSup(!vecinoInf);
						}

						JButton b = (JButton) e.getSource();
						b.setBackground((!vecinoInf) ? Color.decode("#0000FF"): Color.black);
					}
				});
				casillaPanel.add(abajo, BorderLayout.SOUTH);

				derecha = new JButton();
				derecha.setBackground(Color.decode("#D8D8D8"));

				if(grafo!=null){
					if((j+1<columns) && actual.getVecinos().contains(new Nodo( (i*columns)+j+1 ))){
						derecha.setBackground(Color.decode("#0000FF"));
						box[i][j].setVecinoDer(true);
					}
					if((j-1>=0) && actual.getVecinos().contains(new Nodo( (i*columns)+j-1 ))){
						box[i][j].setVecinoIzq(true);
					}
				}

				derecha.setPreferredSize(new Dimension(6,6));

				derecha.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						boolean vecinoDer = box[fila][columna].tieneVecinoDer();
						box[fila][columna].setVecinoDer(!vecinoDer);
						if (columna + 1 < columns) {
							box[fila][columna + 1].setVecinoIzq(!vecinoDer);
						}

						JButton b = (JButton) e.getSource();
						b.setBackground((!vecinoDer) ? Color.decode("#0000FF"): Color.black);
					}
				});

				casillaPanel.add(derecha, BorderLayout.EAST);
				casilla.add(casillaPanel);
				add(casilla,BorderLayout.CENTER);

			}
		}

	}

	public void cleanAll(){
		line.removeAllElements();
		step.removeAllElements();
		setCircleEnd(null);
		setCircleEnd(null);
	}
	
	public void addLine(Line lines){

		line.add(lines);
	}

	public void addLine(int positionX1, int positionY1 , int positionX2 , int positionY2 ){

		line.add( new Line(positionX1, positionX2, positionY1, positionY2));
	}

	public void addStep(Step steps){

		step.add(steps);
	}

	public void addStep(int positionX1, int positionY1 , int positionX2 , int positionY2 ){

		step.add(new Step(positionX1, positionX2, positionY1, positionX2));
	}
	
	public void savePath(Controller controller){
		System.out.println("Metodo SAVE PATH");
		String path = "C:/Users/Jenny/git/Laberinto/Final_Graphs_Maze/Rutas.txt" ;
		FileUtil util = new FileUtil();
		File file = new File(path);
		util.save(file, box, init, end);
		create = new  CreateWindowMaze(controller);
		create.readFile(file, false);
		create.setVisible(true);
				
		
		
		
	}
	
	//------Gets&&Sets------

	public Circle getCircleInit() {
		return circleInit;
	}

	public void setCircleInit(Circle circleInit) {
		this.circleInit = circleInit;
	}

	public Circle getCircleEnd() {
		return circleEnd;
	}

	public void setCircleEnd(Circle circleEnd) {
		this.circleEnd = circleEnd;
	}

	public PanelCreateButton getPanelButton() {
		return panelButton;
	}

	public void setPanelButton(PanelCreateButton panelButton) {
		this.panelButton = panelButton;
	}









}