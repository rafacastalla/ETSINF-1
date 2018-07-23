/**
 * Classe ParaulesOrd: seqüencia d'elements de tipus String, 
 * ordenats ascendentment.
 * 
 * @author PRG
 * @version Curs 2015/16
 */
public class ParaulesOrd {
    private NodeString sec;
    private int talla;
    
    /**
     * Crea una seqüència buida.
     */
    public ParaulesOrd() {
        /* COMPLETAR */
    }
    
    /**
     * Torna el número d’elements en la seqüència.
     * @return int número d'elements.
     */
    public int talla() { return talla; }
    
    /**
     * Insereix ordenadament un String en la seqüència.
     * @param s String a inserir.
     */
    public void inserirOrd(String s) {
        /* COMPLETAR */
    }
    
    /**
     * Elimina la primera ocurrència d'un String donat que aparega en 
     * la seqüència. 
     * Si no apareguera, s’ha de tornar false i true en cas contrari.
     * @param s String a eliminar.
     * @return boolean true si s'elimina i false en cas contrari.
     */
    public boolean eliminar(String s) {
        boolean trobat = false;
        /* COMPLETAR */
        return trobat;
    }   
    
    /** 
     * Representació amb String de la seqüència.
     * @return String amb les dades de la seqüencia. 
     */
    public String toString() {
        String res = "";
        /* COMPLETAR */
        return res;
    }
    
    /** main de prova dels mètodes anteriors */
    public static void main(String[] args) {
        ParaulesOrd mi = new ParaulesOrd();
        mi.inserirOrd("marta");
        mi.inserirOrd("pepe");
        mi.inserirOrd("anna");
        mi.inserirOrd("joan");
        System.out.println(mi);
        boolean esborrat = mi.eliminar("raul");
        esborrat = mi.eliminar("joan");
        System.out.println(mi);
    }
}
