/**
 * Classe NodeInt: Representació d'una estructura que associa 
 * una dada (de tipus int) i l'enllaç a la dada següent.
 * 
 * @author PRG
 * @version Curs 2015/16
 */
class NodeInt {
    int dada;           // dada del node
    NodeInt seguent;    // enllaç al següent node
    
    /** Constructor A: crea un node amb una dada d i que no té següent. 
     *  @param d int que representa la dada del nou node.
     */ 
    NodeInt(int d) { 
        dada = d; 
        seguent = null; 
        // de manera equivalent: this(d, null);
    } 
    
    /** Constructor B: crea un node amb una dada d, enllaçat a un node 
     *  preexistent s. 
     *  @param d int que representa la dada del nou node.
     *  @param s NodeInt amb el qual enllaçar el nou node.
     */ 
    NodeInt(int d, NodeInt s) { 
        dada = d; 
        seguent = s; 
    }   
    
    public String toString() {
		return "NodeInt [dada=" + dada + ", seguent=" + seguent + "]";
	}  
}
