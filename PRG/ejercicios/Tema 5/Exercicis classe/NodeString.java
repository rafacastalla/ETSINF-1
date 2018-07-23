/**
 * Classe NodeString: Representació d'una estructura que associa 
 * una dada (de tipus String) i l'enllaç a la dada següent.
 * 
 * @author PRG
 * @version Curs 2015/16
 */
class NodeString {
    String dada;           // dada del node
    NodeString seguent;    // enllaç al següent node
    
    /** Constructor A: crea un node amb una dada d i que no té següent. 
     *  @param d String que representa la dada del nou node.
     */ 
    NodeString(String d) { 
        dada = d; 
        seguent = null; 
    } 
    
    /** Constructor B: crea un node amb una dada d, enllaçat a un node 
     *  preexistent s. 
     *  @param d String que representa la dada del nou node.
     *  @param s NodeString amb el qual enllaçar el nou node.
     */ 
    NodeString(String d, NodeString s) { 
        dada = d; 
        seguent = s; 
    }   
}
