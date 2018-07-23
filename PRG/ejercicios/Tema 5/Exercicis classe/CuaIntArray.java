import java.util.NoSuchElementException;
/**
 * CuaIntArray: Implementació amb array circular de l'estructura de dades 
 * lineal Cua d'enters.
 * 
 * @author PRG
 * @version Curs 2015/16
 */
public class CuaIntArray {
    private static final int MAX = 10; // dimensió màxima de la cua
    private int[] lArray;              // array utilitzat per emmagatzemar 
                                       // les dades de la cua
    private int primer, ultim, talla;  // posició del primer i últim element
                                       // i número d'elements de la cua

    /**
     * Crea una cua buida.
     */
    public CuaIntArray() {
        lArray = new int[MAX];
        talla = 0; 
        primer = 0; 
        ultim = -1;
    }

    /**
     * Encua un nou element en la cua. 
     * @param x int a encuar en la cua actual.
     */
    public void encuar(int x) {
        if (talla == lArray.length) { duplicaArray(); }
        ultim = (ultim + 1) % lArray.length;
        lArray[ultim] = x;
        talla++;
    }
    
    private void duplicaArray() {
        int[] aux = new int[2 * lArray.length];
        for (int i = 0, pos = primer; i < lArray.length; i++) { 
            aux[i] = lArray[pos];
            pos = (pos + 1) % lArray.length;
        }
        primer = 0; ultim = lArray.length - 1; lArray = aux;
    }

    /**
     * Torna i desencua el primer de la cua.
     * @throws NoSuchElementException si la cua está buida.
     * @return int, dada de l'element primer desencuat de la cola actual.
     */
    public int desencuar() {
        if (talla == 0) { 
            throw new NoSuchElementException("Cua buida");
        }
        int x = lArray[primer];
        primer = (primer + 1) % lArray.length;
        talla--;
        return x;
    }

    /**
     * Torna l'element primer de la cua actual.
     * @throws NoSuchElementException si la cua está buida.
     * @return int, dada de l'element primer de la cua actual.
     */
    public int primer() { 
        if (talla == 0) { 
            throw new NoSuchElementException("Cua buida");
        }
        return lArray[primer]; 
    }

    /**
     * Comprova si la cua actual està o no buida.
     * @return boolean, true si la cua està buida i false en cas contrari.
     */
    public boolean esBuida() { return talla == 0; }

    /**
     * Torna el número d'elements de la cua actual.
     * @return int, número d'elements de la cua actual.
     */
    public int talla() { return talla; }
    
    /**
     * Torna una String formada pels valors de la CuaIntArray.
     * @return String amb les dades de la cua.
     */
    public String toString() {
        String s = "";
        for (int i = 1, pos = primer; i <= this.talla; i++) {
            s += String.format("%4d", lArray[pos]);
            pos = (pos + 1) % lArray.length;
        }
        return s;
    }    

    /**
     * Comprova si la cua actual és igual o no a una cua donada.
     * @param o Object que representa la cua a comparar.
     * @return boolean, true si són iguals i false en cas contrari.
     */
    public boolean equals(Object o) {
        if (o instanceof CuaIntArray) {
            CuaIntArray q = (CuaIntArray) o;
            if (this.talla != q.talla) { return false; }
            else {
                int i = 1, t = primer, a = primer;
                while (i <= this.talla && this.lArray[t] == q.lArray[a]) { 
                    i++;
                    t = (t + 1) % lArray.length;
                    a = (a + 1) % q.lArray.length;
                }
                return i > talla;
            }
        }
        else { return false; }
    }
}
