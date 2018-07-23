import java.io.Serializable;
/**
 * Classe NodeApunt. Representa cadascun dels nodes 
 * d'una sequencia enllaçada de valors de tipus Apunt.
 * @author PRG
 * @version Curs 2015/16
 */
class NodeApunt implements Serializable {
    Apunt dada;
    NodeApunt seguent;

    /** Constructor que permet crear un node amb un Apunt i un node seguent.
     *  @param d Apunt que conte el node.
     *  @param seguent Referencia al seguent node de la llista.
     */
    NodeApunt(Apunt a, NodeApunt seg) {
        this.dada = a;
        this.seguent = seg;
    }

    /** Constructor que permet crear un node amb un Apunt i
     *  el seu node seguent es null.
     *  @param d Apunt que conte el node.
     */
    NodeApunt(Apunt a) {
        this(a, null);
    }
}
