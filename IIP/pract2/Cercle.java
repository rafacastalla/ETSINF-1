/** 
 * Classe Cercle: defineix un cercle d'un determinat radi, color i
 * posició del seu centre, amb la funcionalitat que apareix a continuació.
 * @author IIP 
 * @version Pràctica 2 - Curs 2015/16
 */  
public class Cercle  {
    private double radi; 
    private String color;
    private int centreX, centreY;   
    
    /** Crea un Cercle de radi 50, negre i centre en (100,100). */
    public Cercle() {
        radi = 50; 
        color = "negre"; 
        centreX = 100;  
        centreY = 100; 
    }
    
    /** Crea un Cercle de radi r, color c i centre en (cx,cy). 
     *  @param r double que representa el radi. 
     *  @param col String que representa el color.
     *  @param cx int que representa l'abscissa del centre.
     *  @param cy int que representa l'ordenada del centre.
     */
    public Cercle(double r, String col, int cx, int cy) {
        radi = r;  
        color = col; 
        centreX = cx; 
        centreY = cy; 
    }

    /** Torna el radi del Cercle. 
     *  @return double, el radi. 
     */
    public double getRadi() { return radi; }    

    /** Torna el color del Cercle.
     *  @return String, el color.  
     */
    public String getColor() { return color; }  

    /** Torna l'abscissa del centre del Cercle. 
     *  @return int, l'abscissa.   
     */
    public int getCentreX() { return centreX; }  

    /** Torna l'ordenada del centre del Cercle. 
     *  @return int, l'ordenada.   
     */
    public int getCentreY() { return centreY; }
 
    /** Actualitza el radi del Cercle a nouRadi. 
     *  @param nouRadi double que representa el nou radi.
     */
    public void setRadi(double nouRadi) { radi = nouRadi; }   

    /** Actualitza el color del Cercle a nouColor. 
     *  @param nouColor String que representa el nou color.
     */
    public void setColor(String nouColor) { color = nouColor; }   
 
    /** Actualitza el centre del Cercle a la posició (cx,cy). 
     *  @param cx int que representa la nova abscissa del centre.
     *  @param cx int que representa la nova ordenada del centre.
     */
    public void setCentre(int cx, int cy) { centreX = cx; centreY = cy; }
    
    /** Torna l'àrea del Cercle.
     *  @return double, l'àrea.  
     */
    public double area() { return Math.PI * radi * radi; }
    
    /** Torna el perímetre del Cercle.
     *  @return double, el perímetre.  
     */
    public double perimetre() { return 2 * Math.PI * radi; }
    
    /** Torna un String amb les dades del Cercle. 
     *  @return String, les dades. 
     */
    public String toString() { 
        String res = "Cercle de radi " + radi;
        res += ", color " + color;
        res += " i centre (" + centreX + "," + centreY + ")";
        return res; 
    }

} // de Cercle
