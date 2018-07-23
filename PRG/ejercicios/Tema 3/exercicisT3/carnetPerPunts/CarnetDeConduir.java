/**
 * Classe CarnetDeConduir: representa un carnet de conduir 
 * amb un crèdit inicial de 12 punts que es va perdent 
 * a mesura que es cometeixen infraccions.
 * 
 * @author PRG 
 * @version Curs 2015-16
 */
public class CarnetDeConduir {
    /** Quantitat per defecte de punts */ 
    public static final int PUNTS_PER_DEFECTE = 12;
    private String nom;
    private int punts;

    /** Crea un CarnetDeConduir a nom de n amb un nombre
     *  de punts per defecte.
     *  @param n String amb el nom.
     */
    public CarnetDeConduir(String n) { 
        nom = n; 
        punts = PUNTS_PER_DEFECTE; 
    }   

    /** Torna el nom del carnet.
     *  @return String, el nom.  
     */
    public String getNom() { return nom; }

    /** Aplica la penalització donada al carnet.
     *  @param penalitzacio int amb el nombre de punts a descomptar.   
     */
    public void llevarPunts(int penalitzacio) throws RetiradaImmediataCarnet{ 
        if(punts>0){punts -= penalitzacio;}
        else{
            throw new RetiradaImmediataCarnet("No tens punts gitano");
        }
    }

    /** Torna un String amb la informació del carnet.
     *  @return String.  
     */
    public String toString() { 
        return nom + " (" + punts + " punts)"; 
    }
}
