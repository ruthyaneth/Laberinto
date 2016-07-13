package logic;

/**
 * UNIVERSIDAD PEDAGOGICA Y TECNOLOGICA DE COLOMBIA
 * FACULTAD DE INGENIERIA.
 * ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION.
 * PRESENTADO A: Ing Helver Valero.
 * PROGRAMACION III
 * Clase   donde se crea los obstaculos que ahi en una cuadricula.
 * @author Jenny Quesada, Ruth Rojas
 */
public class Direction {

    public int x, y, f, h, g;
    public Direction padre;
    
    public Direction(Direction padre, int x, int y, int f, int g, int h){
        this.padre = padre;
        this.x = x;
        this.y = y;
        this.f = f;
        this.g = g;
        this.h = h;
    }
    
}
