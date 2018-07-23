import java.util.NoSuchElementException;
/**
 * PilaIntArray: Implementació basada en arrays de l'estructura de dades 
 * lineal Pila d'enters.
 * 
 * @author PRG
 * @version Curs 2015/16
 */
public class PilaIntArray {
    private static final int MAX = 10;   // dimensió màxima de l'array
    private int[] lArray; // array utilitzat per emmagatzemar 
                          //les dades de la pila
    private int cim;      // índex que marca el punt d'acces a la pila

    /**
     * Crea una pila buida.
     */
    public PilaIntArray() {
        lArray = new int[MAX];
        cim = -1;
    }

    /**
     * Empila un nou element en la pila.
     * @param x, int a empilar en la pila actual.
     */
    public void empilar(int x) {
        if (cim + 1 == lArray.length) { duplicaArray(); }
        cim++;
        lArray[cim] = x;
    }
    
    private void duplicaArray() {
        int[] aux = new int[2 * lArray.length];
        for (int i = 0; i < lArray.length; i++) {
            aux[i] = lArray[i];
        }
        lArray = aux;
    }

    /**
     * Torna i desempila el cim de la pila.
     * @throws NoSuchElementException si la pila está buida.
     * @return int, dada de l'element cim desempilat de la pila actual.
     */
    public int desempilar() {
        if (cim < 0) {
            throw new NoSuchElementException("Pila buida");
        }
        int x = lArray[cim];
        cim--;
        return x;
    }

    /**
     * Torna l'element cim de la pila actual.
     * @throws NoSuchElementException si la pila está buida.
     * @return int, dada de l'element cim de la pila actual.
     */
    public int cim() { 
        if (cim < 0) {
            throw new NoSuchElementException("Pila buida");
        }
        return lArray[cim]; 
    }

    /**
     * Comprova si la pila actual està o no buida. 
     * @return boolean, true si la pila està buida i false en cas contrari.
     */
    public boolean esBuida() { return cim == -1; }

    /**
     * Torna el número d'elements de la pila actual.
     * @return int, número d'elements de la pila actual.
     */
    public int talla() { return cim + 1; }
    
    /**
     * Comprova si la pila actual és igual o no a una pila donada.
     * @param o Object que representa la pila a comparar.
     * @return boolean, true si són iguals i false en cas contrari.
     */
    public boolean equals(Object o) {
		boolean igual = false;
        if (o instanceof PilaIntArray) {
            PilaIntArray p = (PilaIntArray) o;
            if (this.talla() != p.talla()) { return false; }
            else {
                int i = 0;
                while (i <= cim && lArray[i] == p.lArray[i]) { i++; } 
                igual = i > cim;
            }			
        }
        return igual;
    }
}
