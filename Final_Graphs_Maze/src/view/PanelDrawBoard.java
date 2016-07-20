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
	private int init;
	private int end;
	private Box[][] box;
	//	private CreateWindowMaze create;
	private PanelCreateButton panelButton;
	private int ancho_casilla = 40;
	private int alto_casilla = 40; 
	private Grafo grafo;
	private Controller controller;

	//------Builder------

	public PanelDrawBoard(CreateWindowMaze create , int row , int column) {

		this.line = new Vector<Line>(0);
		this.step = new Vector<Step>(0);
		this.row = row;
		this.columns = column;
		//	this.create = create;
		initComponent();
	}

	public PanelDrawBoard(CreateWindowMaze create, int row , int column , int init, int end, Grafo grafo) {

		this.line = new Vector<Line>(0);
		this.step = new Vector<Step>(0);
		this.row = row;
		this.columns = column;
		this.init = init;
		this.end = end;
		this.grafo = grafo;
		this.setBackground(Color.yellow);
		initComponent();
	}

	//-----Methods--------

	public void initComponent(){
		initThis();
		initPanelButton();

	}

	public void initThis(){
		this.setSize(500, 500);
		box = new Box[row][columns];
		addBox();
	}

	public void initPanelButton(){
		this.panelButton = new PanelCreateButton(controller);
		this.panelButton.setBorder(BorderFactory.createTitledBorder("Opciones"));
		this.add(panelButton,BorderLayout.SOUTH);
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

	//----Falta algunos metodos de la clase tablero  desde la linea  42 

	public void paint(Graphics graphics){
		// sigue lo de la linea 40 hata la linea 48 que es la parte del hilo  de la clase tablero del proyecto Maze
		graphics.setColor(Color.GREEN);
		for (Line line2 : line) {
			graphics.drawLine(line2.getPositionX1(), line2.getPositionX2(), line2.getPositionY1(), line2.getPositionY2());
		}
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
				casillaPanel.setBackground(Color.yellow);
				if(this.init == numeroNodos){
					casillaPanel.setBackground(Color.decode("#FF4000"));
				}
				if(this.end == numeroNodos){
					casillaPanel.setBackground(Color.decode("#FF0080"));
				}
				if(this.grafo != null){
					actual = grafo.obtenerNodo(numeroNodos);
				}

				//agregar el acition Mouser de la linea 149 clase EditorLabel
				int  fila  =i;
				int columna = j;

				abajo = new JButton();
				abajo.setBackground(Color.decode("#0489B1"));
				if(grafo != null){
					if((i+1<row) && actual.getVecinos().contains(new Nodo( (i+1)*columns+j  ))){
						abajo.setBackground(Color.decode("#0489B1"));
						box[i][j].setVecinoInf(true);
					}
					if((i-1>=0) && actual.getVecinos().contains(new Nodo( (i-1)*columns+j  ))){
						box[i][j].setVecinoSup(true);
					}
				}
				abajo.setPreferredSize(new Dimension(10,10));
				abajo.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						boolean vecinoInf = box[fila][columna].tieneVecinoInf();
						box[fila][columna].setVecinoInf(!vecinoInf);
						if (fila + 1 < row) {
							box[fila + 1][columna].setVecinoSup(!vecinoInf);
						}

						JButton b = (JButton) e.getSource();
						b.setBackground((!vecinoInf) ? Color.white: Color.black);
					}
				});
				casillaPanel.add(abajo, BorderLayout.SOUTH);

				derecha = new JButton();
				derecha.setBackground(Color.black);

				if(grafo!=null){
					if((j+1<columns) && actual.getVecinos().contains(new Nodo( (i*columns)+j+1 ))){
						derecha.setBackground(Color.white);
						box[i][j].setVecinoDer(true);
					}
					if((j-1>=0) && actual.getVecinos().contains(new Nodo( (i*columns)+j-1 ))){
						box[i][j].setVecinoIzq(true);
					}
				}

				derecha.setPreferredSize(new Dimension(4,4));

				derecha.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						boolean vecinoDer = box[fila][columna].tieneVecinoDer();
						box[fila][columna].setVecinoDer(!vecinoDer);
						if (columna + 1 < columns) {
							box[fila][columna + 1].setVecinoIzq(!vecinoDer);
						}

						JButton b = (JButton) e.getSource();
						b.setBackground((!vecinoDer) ? Color.white: Color.black);
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
	//------Gets&&Sets-----

	//	@Override
	//	public void mouseClicked(MouseEvent e) {
	//		// TODO Auto-generated method stub
	//
	//	}
	//
	//	@Override
	//	public void mouseEntered(MouseEvent e) {
	//		// TODO Auto-generated method stub
	//
	//	}
	//
	//	@Override
	//	public void mouseExited(MouseEvent e) {
	//		// TODO Auto-generated method stub
	//
	//	}
	//
	//	@Override
	//	public void mousePressed(MouseEvent e) {
	//		// TODO Auto-generated method stub
	//
	//	}
	//
	//	@Override
	//	public void mouseReleased(MouseEvent e) {
	//		// TODO Auto-generated method stub
	//
	//	}

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









}