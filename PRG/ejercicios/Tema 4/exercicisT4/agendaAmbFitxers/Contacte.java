import java.io.Serializable;
/**
 * Classe Contacte: representa un contacte (basic) d'una agenda mitjançant dos
 * atributs de tipus String: el que representa el nom del contacte, String nom,
 * i el que representa el telefon associat a aquest nom, String telefon.
 * 
 * @author PRG
 * @version Curs 2015/16
 */ 
public class Contacte implements Serializable {
    private String nom, telefon;

    /**
     * Crea un Contacte a partir d'un nom i un telefon. 
     * @param nom String que representa un nom.
     * @param telefon String que representa un telefon.
     */
    public Contacte(String n, String t) {
        this.nom = n; 
        this.telefon = t;
    }
  
    /**
     * Torna el nom.
     * @return String nom.
     */
    public String getNom() { return nom; }
    
    /**
     * Torna el telefon.
     * @return String telefon.
     */
    public String getTelefon() { return telefon; }
   
    /**
     * Canvia el nom.
     * @param nouNom String que representa el nou nom.
     */
    public void setNom(String nouNom) { nom = nouNom; }
    
    /**
     * Canvia el telefon.
     * @param nouTelefon String que representa el nou telefon.
     */
    public void setTelefon(String nouTelefon) { telefon = nouTelefon; }
  
    /**
     * Sobreescriptura del metode toString de Object.
     * @return String amb la informacio del Contacte actual.
     */
    public String toString() { 
        return nom + ": " + telefon;
    }  
}
