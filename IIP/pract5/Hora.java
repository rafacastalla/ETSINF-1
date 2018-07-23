/**
 * Classe Hora. 
 * 
 *  @author (IIP. Grau en Informatica. ETSINF, UPV) 
 *  @version (Curs 2015-16)
 */
public class Hora {

    // ATRIBUTS:
    private int h;
    private int m;

    // CONSTRUCTORS:
    /**
     *  Hora corresponent a les hh hores i mm minuts.
     *  Precondicio: 0<=hh<24, 0<=mm<60.
     */
     public Hora(int hh, int mm) {
      this.h = hh;
      this.m = mm;
     }
    
    /** Hora (hores i minuts) actual UTC (temps coordinat universal).
     */ 
     public Hora(){
      long t = System.currentTimeMillis() / 60000;
      int hA = (int) ((t % (60 * 24) + 120) / 60);
      int mA = (int) (t %60);
      this.h = hA;
      this.m = mA;
        
     }
  
    // CONSULTORS I MODIFICADORS:
    /** Retorna les hores de l'Hora. */ 
    public int getHores() {return this.h;}

    /** Retorna els minuts de l'Hora. */ 
    public int getMinuts() {return this.m;}
   
    /** Modifica les hores de l'Hora. */ 
    public void setHores(int hh) {this.h = hh;}
   
    /** Modifica els minuts de l'Hora. */ 
    public void setMinuts(int mm) {this.m = mm;}
   
    // ALTRES METODES:
    /** Retorna l'Hora en format "hh:mm".
     */
    public String toString(){
        //convertir les hores en format hh
        String hA2d = "0" + h;
        hA2d = hA2d.substring(hA2d.length() - 2);
        //convertir els minuts en mm
        String mA2d = "0" + m;
        mA2d = mA2d.substring(mA2d.length() - 2);
        //els unim
        return hA2d + ":" + mA2d;
    }
  
    /** Retorna true sii o es una Hora que coincideix
     *  en hores i minuts amb l'Hora. 
     */
    
    public boolean equals(Object o){
      return o instanceof Hora && //comprova que son del mateix tipus
            this.h == ((Hora) o).h &&
            this.m == ((Hora) o).m;
            /*this.h.equals(((Hora) o).getHores()) && els int no porten equals
            this.m.equals(((Minuts) o).getMinuts()); els int no porten equals*/
    }
    
    /** Retorna el nombre de minuts transcorreguts 
     *  des de les 00:00 fins l'Hora. 
     */
    public int aMinuts(int h00, int m00){
        h00 = h * 60;
        m00 = h00 + m;
        return m00;
    }
    
    /** Compara cronologicament l'Hora i altraHora. El resultat es un valor:
     *     - negatiu si l'Hora es anterior a altraHora,
     *     - zero si son iguals,
     *     - positiu si l'Hora es posterior a altraHora.
     */
    public int compareTo(Hora altraHora) {
     int hora = this.h -((Hora) altraHora).h;
     int min = this.m -((Hora) altraHora).m;
     min = min / 60;
     return hora + min;
    }


    // ACTIVITAT EXTRA:      
    /** Retorna una Hora a partir de la descripcio textual en format "hh:mm".
     */
    /*public static Hora valueOf(String hhmm) {
    
    }*/
  
}
