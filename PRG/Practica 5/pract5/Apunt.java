import java.io.Serializable;
import java.util.Locale;
/**
 * Classe Apunt per a representar un apunt d'un compte. 
 * @author PRG 
 * @version Curs 2015/16
 */
public class Apunt implements Serializable {
    public static final String INGRES = "Ingres";
    public static final String REINTEGRAMENT = "Reintegrament";
    private String descripcio;
    private double quantitat;

    /**
     * Constructor que, donades una descripció i una quantitat, 
     * crea un Apunt.
     * @param des String que representa la descripció.
     * @param can double que representa la quantitat.
     */
    public Apunt(String des, double quan) {
        descripcio = des;
        quantitat = quan;
    }

    /**
     * Torna la descripció de l'apunt.
     * @return String, la descripció. 
     */
    public String getDescripcio() { return descripcio; }
    
    /**
     * Torna la quantitat de l'apunt.
     * @return double, la quantitat. 
     */
    public double getQuantitat() { return quantitat; }
    
    /**
     * Torna un String amb la descripció i la quantitat
     * de l'apunt separats per ": ".
     * @return String.
     */
    public String toString() {        
        return String.format(Locale.US, "%13s: %10.2f", descripcio, quantitat);
    }
    
}
