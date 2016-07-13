package logic;
/**
 * UNIVERSIDAD PEDAGOGICA Y TECNOLOGICA DE COLOMBIA
 * FACULTAD DE INGENIERIA.
 * ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION.
 * PRESENTADO A: Ing Helver Valero.
 * PROGRAMACION III
 * Clase  donde se crearan las casillas. 
 * @author Jenny Quesada, Ruth Rojas
 */
public class Box implements Comparable<Box>{

	//-------Atributes-------
	
	private int number;
	private boolean upperNeighbor; // Vecino superior
	private boolean lowerNeighbor; //Vecino Inferior
	private boolean leftNeighbor;//Vecino izquierdo
	private boolean rihtNeighbor;//Vecino derecho;
	
	//-------Builder--------
	
	public Box(int n){
		this.number=n;
		this.upperNeighbor=false;
		this.lowerNeighbor=false;
		this.leftNeighbor=false;
		this.rihtNeighbor=false;
	}
	
	//-------Methods-------
	
	public boolean equals(Box c){
		return this.number==c.getNumber();
	}

	//-------Gets&&Sets--------
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int numero) {
		this.number = numero;
	}

	public boolean tieneVecinoSup() {
		return upperNeighbor;
	}

	public void setVecinoSup(boolean vecinoSup) {
		this.upperNeighbor = vecinoSup;
	}

	public boolean tieneVecinoInf() {
		return lowerNeighbor;
	}

	public void setVecinoInf(boolean vecinoInf) {
		this.lowerNeighbor = vecinoInf;
	}

	public boolean tieneVecinoIzq() {
		return leftNeighbor;
	}

	public void setVecinoIzq(boolean vecinoIzq) {
		this.leftNeighbor = vecinoIzq;
	}

	public boolean tieneVecinoDer() {
		return rihtNeighbor;
	}

	public void setVecinoDer(boolean vecinoDer) {
		this.rihtNeighbor = vecinoDer;
	}

	public int compareTo(Box c) {
		return this.number-c.getNumber();
	}
	
	public String toString(){
		return this.number+"";
	}
	
	
}
