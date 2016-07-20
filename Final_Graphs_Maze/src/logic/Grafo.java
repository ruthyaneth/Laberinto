package logic;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

/**
 * 
 * @author Milena Garcia, Miguel Amaya, Yeisson Boada
 * Clase usada para representar el laberinto y encontrar la solucion al mismo
 * 
 */
public class Grafo {

	char[]  nodosD;  // Letras de identificacion de nodo
    int[][] grafo;  // Matriz de distancias entre nodos
    String  rutaMasCorta;                           // distancia mas corta
    int     longitudMasCorta = Integer.MAX_VALUE;   // ruta mas corta
    List<Nodo>  listos=null;                        // nodos revisados Dijkstra
    
	private Vector<Nodo> nodos;
	
	/**
	 * Crea un grafo sin nodos
	 */
	public Grafo(){
		this.nodos=new Vector<Nodo>(0);
	}
	
	/**
	 * Agregar un nodo al grado
	 */
	public void add(Nodo n){
		this.nodos.add(n);
	}
	
	/**
	 * Obtiene el nodo representado por n en el grafo
	 * @param nodoNumero El numero que representa al nodo
	 * @return El nodo especificado por n o null en caso de el nodo no exista en el grafo
	 */
	public Nodo obtenerNodo(int nodoNumero){
		for(Nodo nodo:nodos){
			if(nodo.getNumero()==nodoNumero){
				return nodo;
			}
		}
		return null;
	}
	
	/**
	 * Revisa si el nodo representado por <code>nodoNumero</code> ya existe en el grafo.
	 * 
	 * En caso de que el grafo no contenga el nodo especificado, se agrega a la lista de nodos del grafo
	 * @param nodoNumero El numero del nodo a agregar 
	 * @return El nodo que fue agregado al grafo
	 */
	public Nodo procesarAgregar(int nodoNumero){
		if(existe(nodoNumero)){
			return obtenerNodo(nodoNumero);
		}else{
			Nodo nuevo=new Nodo(nodoNumero);
			add(nuevo);
			return nuevo;
		}
	}
	
	
	/**
	 * Revisa la existencia de un nodo dentro del grafo
	 * @param numeroNodo El numero del nodo a buscar
	 * @return true si el nodo existe, false en caso contrario 
	 */
	public boolean existe(int numeroNodo){
		return obtenerNodo(numeroNodo)!=null;
	}

	/**
	 * FUERZA BRUTA
	 */
	public Vector<Nodo> DFS(int inicio,int fin){
		
		TreeSet<Nodo> visitados=new TreeSet<Nodo>();
		Stack<Nodo> porVisitar=new Stack<Nodo>();
		
		Vector<Nodo> resultado=null;
		
		Nodo nodoInicial=obtenerNodo(inicio);
		porVisitar.push(nodoInicial); //el primer nodo a visitar es inicio
		
		boolean listo=false;
		Nodo nodofin=null;
		while(porVisitar.size()!=0 && !listo){
			Nodo actual=porVisitar.pop();
			visitados.add(actual);
			TreeSet<Nodo> vecinos=actual.getVecinos(); //obtenemos los vecinos del nodo
			
			for(Nodo n:vecinos){
				if(!visitados.contains(n)){ //si el vecino no ha sido visitado lo encolamos
					n.setPadre(actual);
					if(n.getNumero()==fin){
						listo=true;
						nodofin=n;
						break;
					}
					porVisitar.add(0,n);
				}
			}
		}
		
		if(listo){
			Nodo nodoActual=nodofin;
			resultado=new Vector<Nodo>();
			while(nodoActual!=null){
				resultado.add(nodoActual);
				nodoActual=nodoActual.getPadre();
			}
		}
		return resultado;
		
	}

	// verifica si un nodo ya esta en lista de terminados
    public boolean estaTerminado(int j) {
        Nodo tmp = new Nodo(nodosD[j]);
        return listos.contains(tmp);
    }
    
    // retorna la posicion en el arreglo de un nodo especifico
    private int posicionNodo(char nodo) {
        for(int i=0; i<nodosD.length; i++) {
            if(nodosD[i]==nodo) return i;
        }
        return -1;
    }
	/**
	 * Devuelve los nodos que forman parte del grafo
	 * @return En listado de nodos del grafo
	 */
	public Vector<Nodo> getNodos() {
		return nodos;
	}

}
