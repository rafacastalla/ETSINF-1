import java.util.NoSuchElementException;
/**
 * CuaIntEnla: Implementació enllaçada de l'estructura de dades 
 * lineal Cua d'enters.
 * 
 * @author PRG
 * @version Curs 2015/16
 */
public class CuaIntEnla {
    private NodeInt primer, ultim; // referència al primer i últim elements 
                                   // de la cua (punts d'acces a la cua)
    private int talla;             // número d'elements de la cua

    /**
     * Crea una cua buida.
     */
    public CuaIntEnla() {
        primer = null;
        ultim = null;
        talla = 0;
    }

    /**
     * Encua un nou element en la cua.
     * @param x, int a encuar en la cua actual.
     */
    public void encuar(int x) {
        NodeInt nou = new NodeInt(x);
        if (ultim != null) { ultim.seguent = nou; }
        else { primer = nou; }
        ultim = nou;
        talla++;
    }

    /**
     * Torna i desencua el primer de la cua.
     * @throws NoSuchElementException si la cua està buida.
     * @return int, dada de l'element primer desencuat de la cua actual.
     */
    public int desencuar() {
        if (talla == 0) { 
            throw new NoSuchElementException("Cua buida");
        }
        int x = primer.dada;
        primer = primer.seguent;
        if (primer == null) { ultim = null; }
        talla--;
        return x;
    }
    
    /**
     * Torna la dada de l'element primer de la cua actual.
     * @throws NoSuchElementException si la cua está buida.
     * @return int, dada de l'elemento primer de la cua actual.
     */
    public int primer() { 
        if (talla == 0) { 
            throw new NoSuchElementException("Cua buida");
        }
        return primer.dada; 
    }

    /**
     * Comprova si la cua actual està o no buida.
     * @return boolean, true si la cua està buida i false en cas contrari.
     */
    public boolean esBuida() { return (primer == null); }
    
    /**
     * Torna el número d'elements de la cua actual.
     * @return int, número d'elements de la cua actual.
     */
    public int talla() { return talla; }
    
    /**
     * Torna una String formada pels valors de la CuaIntEnla.
     * @return String amb les dades de la cua.
     */
    public String toString() {
        String s = "";
        return "CuaIntEnla [primer=" + primer + ", ultim=" + ultim + ", talla=" + talla + "]";
    }    

    /**
     * Comprova si la cua actual és igual o no a una cua donada.
     * @param o Object que representa la cua a comparar.
     * @return boolean, true si són iguals i false en cas contrari.
     */
    public boolean equals(Object o) {
        boolean igual = false;
        if (o instanceof CuaIntEnla) {
            if (talla == ((CuaIntEnla) o).talla) { 
                NodeInt p = primer, aux = ((CuaIntEnla) o).primer;
                while (p != null && p.dada == aux.dada) {
                    p = p.seguent;
                    aux = aux.seguent;
                }
                if (p == null) { igual = true; }
            }
        }
        return igual;
    }
    
    public void concatenar(CuaIntEnla q){
        talla+=q.talla;
        if(primer==null){primer=q.primer;}
        else{ultim.seguent=q.primer;}
        ultim=q.primer;
    }
    //NO HI HA REPETICIÓ
    public boolean esSubconjunt(CuaIntEnla q){
        NodeInt aux, auxq = q.primer;
        boolean resposta= true;
        if(q.talla>talla){
            return resposta = false;
        }else{
            while(auxq != null && resposta){
                aux = primer;
                while(aux != null && auxq.dada != aux.dada){
                    aux = aux.seguent;
                }
                resposta=(aux != null);
                auxq = auxq.seguent;
            }
        }
        return resposta;
    } 
    
    public void colar(int x){
    	NodeInt aux = primer;
    	NodeInt ant = null;
    	while(aux != null && aux.dada != x){
    		ant = aux;
    		aux = aux.seguent;    		
    	}
    	if(aux != null && aux != primer){
    		ant = aux.seguent;
    		aux = primer;  
    		primer = aux;
    		if (aux == ultim) ultim = ant;
    	}
    }
}
