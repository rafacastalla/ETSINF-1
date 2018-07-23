import java.util.NoSuchElementException;
/**
 * LlistaPIIntArray: Implementació amb array de l'estructura de dades 
 * lineal Llista amb punt d'interès d'enters.
 * 
 * @author PRG
 * @version Curs 2015/16
 */
public class LlistaPIIntArray {
    private static final int MAX = 10;  // dimensió màxima de l'array
    private int[] lArray;   // array utililitzat per emmagatzemar 
                            // les dades de la llista
    private int PI;         // posició del punt d'interès 
                            // (punt d'acces als elements de la llista)
    private int talla;      // número d'elements de la llista
    
    /**
     * Crea una llista buida.
     */
    public LlistaPIIntArray() {
        lArray = new int[MAX];
        PI = 0;
        talla = 0;
    }

    /**
     * Comprova si la llista actual està o no buida.
     * @return boolean, true si la llista està buida i false en cas contrari.
     */
    public boolean esBuida() { return talla == 0; }
    
    /**
     * Comprova si el punt d'interès està al final de la llista actual.
     * @return boolean, true si el PI està al final de la llista i false 
     * en cas contrari.
     */
    public boolean esFi() { return PI == talla; }
    
    /**
     * Torna el número d'elements de la llista actual.
     * @return int, número d'elements de la llista actual.
     */
    public int talla() { return talla; }      

    /**
     * Situa el punt d'interès en la primera posició de la llista actual.
     */
    public void inici() { PI = 0; }
    
    /**
     * Desplaça el PI una posició cap a la dreta. 
     * @throws NoSuchElementException si el PI es troba al final de la llista.
     */
    public void seguent() {
        if (PI == talla) {
            throw new NoSuchElementException("Cursor al final");
        }
        PI++; 
    }
    
    /**
     * Torna l'element en el PI. 
     * @throws NoSuchElementException si el PI es troba al final de la llista.
     * @return int, element en el PI de la llista.
     */
    public int recuperar() { 
        if (PI == talla) {
            throw new NoSuchElementException("Cursor al final");
        }
        return lArray[PI]; 
    }
    
    /**
     * Insereix l'element x en el PI. 
     * Hi ha que desplaçar a la dreta totes les dades des del PI 
     * fins el final de la llista.
     * @param x, element a afegir en la llista.
     */
    public void inserir(int x) {
        if (talla == lArray.length) { duplicaArray(); }
        for (int k = talla - 1; k >= PI; k--) {
            lArray[k + 1] = lArray[k];
        }
        lArray[PI] = x; 
        PI++;
        talla++;
    }
    
    private void duplicaArray() {
        int[] aux = new int[2 * lArray.length];
        for (int i = 0; i < lArray.length; i++) {
            aux[i] = lArray[i];
        }
        lArray = aux;
    }
    
    /**
     * Torna i elimina de la llista l'element en el PI. 
     * Hi ha que desplaçar a la esquerra totes les dades des del PI 
     * fins el final de la llista. 
     * @throws NoSuchElementException si el PI es troba al final de la llista.
     * @return int, element en el PI de la llista.
     */
    public int eliminar() {
        if (PI == talla) {
            throw new NoSuchElementException("Cursor al final");
        }
        int aux = lArray[PI];
        for (int k = PI + 1; k < talla; k++) {
            lArray[k - 1] = lArray[k];
        }
        talla--;
        return aux; 
    }
    
    /*************** MÈTODES DELS EXERCICIS *********************************/ 
    
    /**
     * Mètode privat auxiliar que busca la primera ocurrència de x 
     * des de la posició pos en endavant; si el troba, mou el PI a la 
     * posició on s'ha trobat x. Si no apareix, el PI no es mou.
     * @param pos int posició a partir de la qual es fa la cerca
     * @param x int a buscar
     * @return boolean true si el troba i false en cas contrari.
     */
    private boolean buscar(int pos, int x) { 
        int i = pos;
        while (i < talla && lArray[i] != x) { i++; }
        if (i < talla) { PI = i; return true; }
        else { return false; }
    }
    
    /**
     * Busca la primera ocurrència de x des de la posició 0 de la llista; 
     * si el troba, mou el PI a la posició on s'ha trobat x. Si no apareix, 
     * el PI no es mou.
     * @param x int a buscar
     * @return boolean true si el troba i false en cas contrari.
     */
    public boolean buscarInici(int x) { return buscar(0, x); } 
    
    /**
     * Busca la primera ocurrència de x des del PI (inclusivament) de la 
     * llista; si el troba, mou el PI a la posició on s'ha trobat x. 
     * Si no apareix, el PI no es mou.
     * @param x int a buscar
     * @return boolean true si el troba i false en cas contrari.
     */
    public boolean buscarSeguent(int x) { return buscar(PI, x); }
  
}
