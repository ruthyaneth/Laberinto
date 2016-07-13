package logic;

import java.util.HashMap;
import java.util.LinkedList;
/**
 * CCCCCC
 * @author Jenny Quesada , Ruth Rojas 
 *
 */
public class ListaBusqueda {

    private ListaAscendente lista;
    private HashMap<String, Direction> hash;

    public ListaBusqueda() {
        lista = new ListaAscendente();
        hash = new HashMap<>();
    }

    public boolean add(Direction nuevo) {
        //Verificar que no existe la celda
        String llave = nuevo.x + "," + nuevo.y;
        if(hash.containsKey(llave)){
            return false;
        }
        
        lista.addOrdenado(nuevo); // 
        hash.put(llave, nuevo);
        
        return true;
    }
    
    public Direction getMenor(){
        if(!lista.isEmpty()){
            Direction c = lista.getFirst();
            
            lista.removeFirst(); // quita el nodo al principio de la lista
            hash.remove(c.x + "," + c.y);
            
            return c;
        }
        
        return null;
    }
    
    public Direction getRemove(String llave){
        if(!lista.isEmpty()){
            Direction c = hash.get(llave);
            
            //System.out.println("Lista AN: " + lista.size());
            lista.remove(c); //elimina el elemento que se pasa por parametro.
            
            hash.remove(llave);
            //System.out.println("Lista DE: " + lista.size());
            
            return c;
        }
        
        return null;
    }
    
    public Direction get(String llave){
        if(!lista.isEmpty()){ // metodo de si esta vacio 
            return hash.get(llave);
        }
        
        return null;
    }
    
    public boolean contieneElemento(Direction c){
        return hash.containsKey(c.x + "," + c.y);
    }
    
    public boolean esVacia(){
        return lista.isEmpty();
    }

    private class ListaAscendente extends LinkedList<Direction> {

        public void addOrdenado(Direction nuevo) {
            boolean agregado = false;
            for (int i = 0; i < this.size() && agregado == false; i++) {
                Direction c = this.get(i); // devuelve un onjeto en la posion especificada.

                if (c.f >= nuevo.f) {
                    this.add(i, nuevo);
                    agregado = true;
                }
            }

            if (agregado == false) {
                this.addLast(nuevo);
            }
        }

    }
}
