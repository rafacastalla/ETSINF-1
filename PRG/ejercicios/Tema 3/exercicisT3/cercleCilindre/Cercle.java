/**
 * Classe Cercle - Descripcio d'un cercle
 * 
 * @author PRG
 * @version Curs 2015/16
 */
public class Cercle extends Figura {
    private static final int RADI_PER_DEFECTE = 3;
    protected double radi;    
    
    /**
     * Crea un nou Cercle donats el seu color i el seu radi.
     * @param r double que representa el radi.
     * @param c String que representa el color.
     */
    public Cercle(double r, String c) {
        super("Cercle", c);
        this.radi = r;        
    }
    
    /**
     * Crea un nou Cercle amb el color per defecte, donat el seu radi.
     * @param r double que representa el radi.
     */
    public Cercle(double r) { this(r, COLOR_PER_DEFECTE); }
    
    /**
     * Torna el radi del Cercle actual.
     * @return double, el radi.
     */
    public double getRadi() { return this.radi; }
    
    /**
     * Actualitza el radi del Cercle actual.
     * @param r double que representa el nou radi.
     */
    public void setRadi(double r) { this.radi = r; }
    
    /**
     * Torna l'area del Cercle actual.
     * @return double, l'area.
     */
    public double getArea() { return Math.PI * radi * radi; }
    
    /**
     * Torna el perimetre del Cercle actual.
     * @return double, el perimetre.
     */
    public double getPerimetre() { return 2 * Math.PI * radi; }
    
    /**
     * Torna un String amb les dades del Cercle actual.
     * @return String.
     */
    public String toString() {
        return super.toString() + " i radi: " + radi;     
    }      
}