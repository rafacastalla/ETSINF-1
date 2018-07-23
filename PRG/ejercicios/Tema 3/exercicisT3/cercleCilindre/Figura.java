/**
 * Class Figura - Descripcio d'una figura geometrica
 * 
 * @author PRG
 * @version Curs 2015/16
 */
public class Figura {
    protected static final String COLOR_PER_DEFECTE = "blau";      
    protected String color;  
    protected String tipus;
  
    /**
     * Crea una nova Figura d'un tipus i un color donats.
     * @param t String que representa el tipus.
     * @param c String que representa el color.
     */
    public Figura(String t, String c) {
        this.color = c;
        this.tipus = t;
    }
    
    /**
     * Crea una nova Figura amb el color per defecte, d'un tipus donat.
     * @param t String que representa el tipus.
     */
    public Figura(String t) {
        this(t, COLOR_PER_DEFECTE);
    }
  
    /**
     * Estableix un nou color per a la Figura actual.
     * @param c String que representa el nou color.
     */ 
    public void setColor(String c) { this.color = c; }
  
    /**
     * Torna el tipus de la Figura actual.
     * @return String, el tipus.
     */
    public String getTipus() { return this.tipus; }
    
    /**
     * Torna el color de la Figura actual.
     * @return String, el color.
     */ 
    public String getColor() { return this.color; }
 
    /**
     * Torna un String amb les dades de la Figura actual.
     * @return String.
     */
    public String toString() {
        return this.tipus + " de color " + this.color;
    }     
    
}