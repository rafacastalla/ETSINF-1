import java.util.NoSuchElementException;
/**
 * PilaIntEnla2: Implementació enllaçada de l'estructura de dades 
 * lineal Pila d'enters, fent ús de la classe LlistaPIIntEnla
 * 
 * @author PRG
 * @version Curs 2015/16
 */
public class PilaIntEnla2 {
    private LlistaPIIntEnla cim; 

    /**
     * Crea una pila buida.
     */
    public PilaIntEnla2() {
        /* COMPLETAR */
    }

    /**
     * Empila un nou element en la pila.
     * @param x, int a empilar en la pila actual.
     */
    public void empilar(int x) {
        /* COMPLETAR */
    }

    /**
     * Torna i desempila el cim de la pila.
     * @throws NoSuchElementException si la pila está buida. 
     * @return int, dada de l'element cim desempilat de la pila actual.
     */
    public int desempilar() {
        /* COMPLETAR */
        return -1;  // per tal que compile
    }

    /**
     * Torna la dada de l'element cim de la pila actual.
     * @throws NoSuchElementException si la pila está buida. 
     * @return int, dada de l'element cim de la pila actual.
     */
    public int cim() { 
        /* COMPLETAR */
        return -1; // per tal que compile
    }

    /**
     * Comprova si la pila actual està o no buida.
     * @return boolean, true si la pila està buida i false en cas contrari.
     */
    public boolean esBuida() { 
	    /* COMPLETAR */
	    return true; // per tal que compile 
	}   
    
    /**
     * Torna el número d'elements de la pila actual.
     * @return int, número d'elements de la pila actual.
     */
    public int talla() { 
	    /* COMPLETAR */
	    return -1; // per tal que compile 
	}    
}
