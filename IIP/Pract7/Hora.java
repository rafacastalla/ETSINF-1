public class Hora {

    // ATRIBUTS:
    private int m;
    private int h;

    // CONSTRUCTORS:
    /**
     *  Hora corresponent a les h hores i m minuts.
     *  Precondicio: 0<=h<24, 0<=m<60.
     */
    public Hora(int h, int m) {
        this.h = h;
        this.m = m;
    }

    /** Hora (hores i minuts) actual UTC (temps coordinat universal).
     */
    public Hora() {
       int tRestant = (int) (System.currentTimeMillis() % (24 * 3600 * 1000));
       h = tRestant / (3600 * 1000);
       m = (tRestant % (3600 * 1000)) / (60 * 1000);
    }


    // CONSULTORS I MODIFICADORS:
    /** Retorna les hores de l'Hora. */
    public int getHores() {return this.h;}

    /** Retorna els minuts de l'Hora. */
    public int getMin() {return this.m;}

    /** Modifica les hores de l'Hora. */
    public void setHores(int novaHora) { this.h = novaHora;}

    /** Modifica els minuts de l'Hora. */
    public void setMin(int nouMinuts) {this.m = nouMinuts;}

    // ALTRES METODES:
    /** Retorna l'Hora en format "h:m".
     */
    public String toString() {
        String hs = "0" + h;
        int aux1 = hs.length();
        String hora = hs.substring(aux1 - 2);

        String ms = "0" + m;
        int aux2 = ms.length();
        String minut = ms.substring(aux2 - 2);

        return hora + ":" + minut;
    }

    /** Retorna true sii o es una Hora que coincideix
     *  en hores i minuts amb l'Hora.
     */
    public boolean equals(Object o) {
        return  o instanceof Hora
        && this.h == ((Hora) o).h
        && this.m == ((Hora) o).m;
    }

    /** Retorna el nombre de minuts transcorreguts
     *  des de les 00:00 fins l'Hora.
     */
    public int aMinuts() {
        int min = m + h * 60;
        return min;
    }

    /** Compara cronologicament l'Hora i altraHora. El resultat es un valor:
     *     - negatiu si l'Hora es anterior a altraHora,
     *     - zero si son iguals,
     *     - positiu si l'Hora es posterior a altraHora.
     */
    public int compareTo(Hora h) {
        return this.aMinuts() - h.aMinuts();
    }
  
    // CONSULTORS I MODIFICADORS:

    

    /** Retorna els minuts de l'Hora. */ 
    
   
    /** Modifica les hores de l'Hora. */ 
    
   
    /** Modifica els minuts de l'Hora. */ 
    
   
    // ALTRES METODES:
    /** Retorna l'Hora en format "h:m".
     */
    
  
    /** Retorna true sii o es una Hora que coincideix
     *  en hores i minuts amb l'Hora. 
     */
    
    
    /** Retorna el nombre de minuts transcorreguts 
     *  des de les 00:00 fins l'Hora. 
     */
    
    
    /** Compara cronologicament l'Hora i altraHora. El resultat es un valor:
     *     - negatiu si l'Hora es anterior a altraHora,
     *     - zero si son iguals,
     *     - positiu si l'Hora es posterior a altraHora.
     */
    

    // ACTIVITAT EXTRA:      
    /** Retorna una Hora a partir de la descripcio textual en format "h:m".
     */
    
  
}
