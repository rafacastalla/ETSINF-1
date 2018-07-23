/**
 * Classe OperacionsEnlla: classe d'utilitats que conté operacions amb
 * seqüències enllaçades.
 * 
 * @author PRG 
 * @version Curs 2015/16
 */
public class OperacionsEnlla {
    
    /**
     * Satura les dades d'una seqüència donada a un valor màxim.
     * @param sec NodeInt seqüència origen.
     * @param maxim int a saturar. 
     */
    public static void saturar(NodeInt sec, int maxim) {
        NodeInt aux = sec; 
        while (aux != null) { 
            if (aux.dada > maxim) { aux.dada = maxim; }
            aux = aux.seguent; 
        }
    }
            
    /**
     * Torna el màxim d'una seqüència donada amb, al menys, un node.
     * @param sec NodeInt seqüència original.
     * @return int valor màxim de la seqüència.
     */
    public static int maxim(NodeInt sec) {
        int max = sec.dada;
        /* COMPLETAR */
        return max;
    }
    
    /** Torna el nombre d'elements de la seqüència sec.
     *  @param sec NodeInt seqüència origen.
     *  @return int nombre d'elements de sec.
     */
    public static int talla(NodeInt sec) {
        int res = 0;
        /* COMPLETAR */
        return res;
    }
    
    /** Torna en un array del tamany just els elements de la seqüència sec.
     *  @param sec NodeInt seqüència origen.
     *  @return int[] array amb els elements de sec.
     */
    public static int[] toArray(NodeInt sec) {
        int[] res = new int[talla(sec)];
        /* COMPLETAR */
        return res;
    }
    
    /** Torna en una seqüència els elements d'un array a.
     *  @param a array d'enters seqüència origen.
     *  @return NodeInt seqüència amb els elements de l'array a.
     */
    public static NodeInt toSeq(int[] a) {
        NodeInt sec = null, aux = null;
        /* COMPLETAR */
        return sec;
    }
    
    /**
     * Torna la posició de la primera ocurrència d'un valor d en 
     * una seqüència donada sec.
     * @param sec NodeInt seqüència origen.
     * @param d int a buscar. 
     * @return int posició que ocupa d en la seqüència o -1 si no està.
     */
    public static int buscar(NodeInt sec, int d) {
        /* COMPLETAR */
        return -1; 
    }
    
    /**
     * Donada una seqüència, insereix la dada d en la posició i, 
     * sempre que 0<=i<=n.
     * @param sec NodeInt seqüència origen.
     * @param d int a inserir. 
     * @param i int posició on inserir 0<=i<=n.
     * @return NodeInt seqüència resultat.
     */
    public static NodeInt inserir(NodeInt sec, int d, int i) {
        if (i == 0) { sec = new NodeInt(d, sec); }
        else { 
            NodeInt aux = sec; 
            int k = 0;
            while (aux != null && k < i - 1) {
                aux = aux.seguent; 
                k++;
            }
            if (aux != null) { // Èxit en la cerca 
                aux.seguent = new NodeInt(d, aux.seguent);
            }
        }    
		// El paràmetre sec ha canviat, 
        // cal tornar el seu valor: 
        return sec;
    }
    
    /**
     * Donada una seqüència, insereix recursivament la dada d en la 
     * posició i, sempre que 0<=i<=n.
     * Es distingeixen els dos casos següents:
     * - Seqüència amb n = 0 nodes, sec==null. S'insereix en cap de sec, 
     *   només si i==0.
     * - Seqüència amb n > 0 nodes. Si i==0, s'insereix en cap de sec, 
     *   sino el problema es redueix a inserir en la posició i-1 de la 
     *   subseqüència sec.seguent.
     * @param sec NodeInt seqüència origen.
     * @param d int a inserir. 
     * @param i int posició on inserir 0<=i<=n.
     * @return NodeInt seqüència resultat.
     */
    public static NodeInt inserirRec(NodeInt sec, int d, int i) {
        if (sec == null) {
            if (i == 0) { sec = new NodeInt(d); }
        }
        else {
            if (i == 0) { sec = new NodeInt(d, sec); }
            else { sec.seguent = inserirRec(sec.seguent, d, i - 1); }
        }
        return sec;
    }
    
    /**
     * Donada una seqüència tal que les seues dades estan ordenades 
     * de menor a major, insereix la dada d mantenint l'ordenació.
     * @param sec NodeInt seqüència origen.
     * @param d int a inserir. 
     * @return NodeInt seqüència resultat.
     */
    public static NodeInt inserirOrd(NodeInt sec, int d) {
        NodeInt aux = sec, ant = null; // el primer node no té 
                                       // anterior definit 
        while (aux != null && aux.dada < d) { 
            ant = aux; 
            aux = aux.seguent; 
        } 
        
        // Acabada la cerca: 
        // Cas a) aux==sec, sec està buida o 
        //        totes les seues dades són >=d. 
        // Cas b) aux!=sec (o ant!=null), 
        //        no totes les seues dades són >=d. 
        // La inserció darrere de ant situa el nou node 
        // a continuació de totes les dades <d.
        if (aux == sec) { sec = new NodeInt(d, sec); } // Cas a) 
        else { ant.seguent = new NodeInt(d, aux); } // Cas b)
	    // El paràmetre sec ha canviat, 
        // cal tornar el seu valor: 
        return sec;
    }
    
    /**
     * Donada una seqüència tal que les seues dades estan ordenades 
     * de menor a major, insereix recursivament la dada d mantenint 
     * l'ordenació. Es distingeixen els dos casos següents:
     * - Seqüència amb n = 0 nodes, sec==null. S'insereix en cap de sec. 
     *   La dada d és el primer que s'insereix en sec.
     * - Seqüència amb n > 0 nodes. Si sec.dada>=d, s'insereix en cap 
     *   de sec, sino el problema es redueix a inserir ordenadament en 
     *   la subseqüència sec.seguent. 
     * @param sec NodeInt seqüència origen.
     * @param d int a inserir. 
     * @return NodeInt seqüència resultat.
     */
    public static NodeInt inserirOrdRec(NodeInt sec, int d) {
        /* COMPLETAR */
        return sec;
    }
    
    /**
     * Donada una seqüència enllaçada, esborra, si existeix, la primera 
     * ocurrencia d'una dada d. Si aquest element no apareix, no es fa res.
     * @param sec NodeInt seqüència origen.
     * @param d int a esborrar. 
     * @return NodeInt seqüència resultat.
     */
    public static NodeInt esborrar(NodeInt sec, int d) {
        NodeInt aux = sec, ant = null;
        while (aux != null && aux.dada != d) {
            ant = aux;
            aux = aux.seguent;
        }
        if (aux != null) { // Èxit en la cerca
            if (ant == null) { // o aux == sec -aux és el primer node-
                sec = aux.seguent;
            }
            else { ant.seguent = aux.seguent; }
        }
		// El paràmetre sec pot haver canviat, 
        // cal tornar el seu valor: 
        return sec;
    }
    
    /**
     * Donada una seqüència enllaçada, esborra recursivament, 
     * si existeix, la primera ocurrencia d'una dada d. 
     * Si aquest element no apareix, no es fa res.
     * Es distingeixen els dos casos següents:
     * - Seqüència amb n = 0 nodes, sec==null. La dada d no està  
     *   en sec, no es fa cap esborrament.
     * - Seqüència amb n > 0 nodes. Si es troba d en cap (primera 
     *   ocurrència de d en la seqüència), s'esborra el primer node
     *   de sec; sino el problema es redueix a esborrar la primera 
     *   ocurrència de d en la subseqüència sec.seguent.  
     * @param sec NodeInt seqüència origen.
     * @param d int a esborrar. 
     * @return NodeInt seqüència resultat.
     */
    public static NodeInt esborrarRec(NodeInt sec, int d) {
        if (sec != null) {
            if (sec.dada == d) { sec = sec.seguent; }
            else { sec.seguent = esborrarRec(sec.seguent, d); }
        }
        return sec;
    }    
    
    /**
     * Donada una seqüència enllaçada, esborra els elements menors 
     * que un umbral donat. 
     * @param sec NodeInt seqüència origen.
     * @param umbral int a comparar. 
     * @return NodeInt seqüència resultat.
     */
    public static NodeInt esborrarMenors(NodeInt sec, int umbral) { 
        NodeInt aux = sec, ant = null; 
        while (aux != null) { 
            if (aux.dada < umbral) { // node a esborrar 
                if (aux == sec) { sec = sec.seguent; }
                else { ant.seguent = aux.seguent; }
                // ant no s’actualitza 
            } 
            else { ant = aux; }
            aux = aux.seguent; 
        } 
        // El paràmetre sec pot haver canviat, 
        // cal tornar el seu valor: 
        return sec;
    }
    
    /**
     * Donada una seqüència enllaçada, esborra recursivament 
     * els elements menors que un umbral donat. 
     * Es distingeixen els dos casos següents:
     * - Seqüència amb n = 0 nodes, sec==null. No hi ha dades 
     *   en sec, no es fa cap esborrament.
     * - Seqüència amb n > 0 nodes. S'esborren recursivament 
     *   els elements menors que umbral en la subseqüència 
     *   sec.seguent. Si l'element en el cap es menor que umbral, 
     *   s'esborra; sino dit element s'enllaça amb la subseqüència 
     *   resultat de l'esborrament. 
     * @param sec NodeInt seqüència origen.
     * @param umbral int a comparar. 
     * @return NodeInt seqüència resultat.
     */
    public static NodeInt esborrarMenorsRec(NodeInt sec, int umbral) { 
        if (sec != null) {
            NodeInt result = esborrarMenorsRec(sec.seguent, umbral);
            if (sec.dada < umbral) { sec = result; }
            else { sec.seguent = result; }
        }
        return sec;
    }
    
    /**
     * Desplaça tots els elements d'una seqüència donada, 
     * una posició cap a la dreta. 
     * L'últim element passarà a ser el primer.
     * @param sec NodeInt seqüència a desplaçar.
     * @return NodeInt seqüència desplaçada.
     */
    public static NodeInt moureADreta(NodeInt sec) {
        /* COMPLETAR */
        return sec;
    }
    
    /**
     * Desplaça tots els elements d'una seqüència donada, 
     * una posició cap a l'esquerra. 
     * El primer element passarà a ser l'últim.
     * @param sec NodeInt seqüència a desplaçar.
     * @return NodeInt seqüència desplaçada.
     */
    public static NodeInt moureAEsq(NodeInt sec) {
        /* COMPLETAR */
        return sec;
    }
    
    /**
     * Inverteix l'ordre dels elements d'una seqüència donada 
     * (amb cost lineal).
     * @param sec NodeInt seqüència a invertir.
     * @return NodeInt seqüència invertida.
     */
    public static NodeInt invertir(NodeInt sec) {
        /* COMPLETAR */
        return sec;
    }
    
    /** 
     * Torna una seqüència enllaçada amb els elements menors que e,
     * i en el mateix ordre que apareixen en una seqüència donada sec.
     * El cost serà lineal amb la longitud de sec.
     * @param sec NodeInt seqüència origen.
     * @param e int a comparar.
     * @return NodeInt seqüència enllaçada amb els elements menors que e, 
     *         en el mateix ordre que apareixen en la seqüència original.
     */ 
    public static NodeInt menorsQue(NodeInt sec, int e) {
        /* COMPLETAR */
        return nova;
    }
}
