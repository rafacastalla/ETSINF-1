import java.util.NoSuchElementException;
/**
 * PilaIntEnla: Implementació enllaçada de l'estructura de dades 
 * lineal Pila d'enters.
 * 
 * @author PRG
 * @version Curs 2015/16
 */
public class PilaIntEnla {
    private NodeInt cim;  // referència al cim de la pila (punt d'acces)
    private int talla;    // número d'elements de la pila

    /**
     * Crea una pila buida.
     */
    public PilaIntEnla() {
        cim = null;
        talla = 0;
    }

    /**
     * Empila un nou element en la pila. 
     * @param x, int a empilar en la pila actual.
     */
    public void empilar(int x) {
        cim = new NodeInt(x, cim);
        talla++;
    }

    /**
     * Torna i desempila el cim de la pila.
     * @throws NoSuchElementException si la pila està buida.
     * @return int, dada de l'element cim desempilat de la pila actual.
     */
    public int desempilar() {
        if (cim == null) {
            throw new NoSuchElementException("Pila buida");
        }
        int x = cim.dada;
        cim = cim.seguent;
        talla--;
        return x;
    }

    /**
     * Torna la dada de l'element cim de la pila actual.
     * @throws NoSuchElementException si la pila està buida. 
     * @return int, dada de l'element cim de la pila actual.
     */
    public int cim() { 
        if (cim == null) { 
            throw new NoSuchElementException("Pila buida");
        }
        return cim.dada; 
    }

    /**
     * Comprova si la pila actual està o no buida. 
     * @return boolean, true si la pila està buida i false en cas contrari.
     */
    public boolean esBuida() { 
        return (cim == null);  // o return (talla == 0);
    }
    
    /**
     * Torna el número d'elements de la pila actual.
     * @return int, número d'elements de la pila actual.
     */
    public int talla() { return talla; }
    
    /**
     * Comprova si la pila actual és igual o no a una pila donada.
     * @param o Object que representa la pila a comparar.
     * @return boolean, true si són iguals i false en cas contrari.
     */
    public boolean equals(Object o) {
        boolean res = false;
        if(o instanceof PilaIntEnla && talla == ((PilaIntEnla) o).talla){
            int i = 1;
            NodeInt aux = cim;
            NodeInt altre = ((PilaIntEnla) o).cim;
            while(aux.dada == altre.dada && i<talla){
                aux = aux.seguent;
                altre = altre.seguent; 
                i++;
            }
            if(i>=talla){res = true;}
        }
        return res;
    }
    
    public void concatenar(PilaIntEnla p){
        NodeInt aux = cim;
        NodeInt ultim = null;
        
        while(aux != null){
            ultim = aux;
            aux = aux.seguent;
        }
        
        talla+=p.talla;
        
        if(cim==null){
            cim = p.cim;
        }else{  
            ultim.seguent = p.cim;
        }
    }
    
     public boolean esSubconjunt(PilaIntEnla q){
        NodeInt aux, auxq = q.cim;
        boolean resposta= true;
        if(q.talla>talla){
            return resposta = false;
        }else{
            while(auxq != null && resposta){
                aux = cim;
                while(aux != null && auxq.dada != aux.dada){
                    aux = aux.seguent;
                }
                resposta=(aux != null);
                auxq = auxq.seguent;
            }
        }
        return resposta;
    } 
    
    
    
    public String toString() {
        return "PilaIntEnla [cim=" + cim + ", talla=" + talla + "]";
    }   
}
