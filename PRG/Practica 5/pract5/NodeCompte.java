import java.io.Serializable;
/**
 * Write a description of class NodeCompte here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NodeCompte implements Serializable{
    CompteAp dada;
    NodeCompte seguent;

    NodeCompte(CompteAp d, NodeCompte seg) {
        this.dada = d;
        this.seguent = seg;
    }

    /** Constructor que permet crear un node amb un int i
     *  el seu node seguent es null.
     *  @param d int que conte el node.
     */
    NodeCompte(CompteAp d) {
        this(d, null);
    }
}
