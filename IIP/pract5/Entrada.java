/** Classe Entrada.
 *  Practica 5 - IIP - ETSINF - UPV
 *  
 *  @author  
 *  @version Curs 2015/16
 */
public class Entrada {
    // Definicio CONSTANTS per a calcular el preu de l'entrada:
    // Preu Base a partir del qual es calcula el preu final
    public static final double PREU_BASE = 7.60;
   
    // Descompte per espectador major de 65 anys (SENIOR)
    public static final int SENIOR = 65;
    public static final double DESCOMPTE_SENIOR = 0.3;
   
    // Descompte per ser el dia de l'espectador 
    public static final double DESCOMPTE_DIA_ESPECTADOR = 0.8;
  
    // Descompte per ser festiu
   public static final double DESCOMPTE_FESTIU = 1.2;
    
    // Descompte per ser vespra de festiu
   public static final double DESCOMPTE_VISPERA_FESTIU = 1.1;
  
    // Descompte per ser client
   public static final double DESCOMPTE_CLIENT = 0.8;
   
    // Definicio d'ATRIBUTS d'INSTANCIA PRIVATS
    private String titol;
    private String cinema;
    private Hora horaSessio;
    
    /** Crea una Entrada amb titol t, cinema c, hores hs,
     *  i minuts ms de la sessio.
     */
    public Entrada(String t, String c, int hs, int ms) {
   
     titol = t; cinema = c; horaSessio = new Hora(hs, ms);
   
    }  

    /** Torna el <b>titol</b> de la pel.licula de l'Entrada. */
    public String getTitol() { return titol; }
    
    /** Torna el <b>cinema</b> de l'Entrada. */
    public String getCinema() { return cinema; }
 
    /** Torna l'<b>hora</b> de la sessio de l'Entrada. */
    public Hora getHoraSessio() { return horaSessio; }
   
    /** Actualitza a <b>t</b> el titol de la pelicula de l'Entrada. */
    public void setTitol(String nouTitol) { titol = nouTitol; }
    
    /** Actualitza a <b>c</b> el cinema de l'Entrada. */
    public void setCinema(String c) { cinema = c; }
    
    /** Actualitza a <b>hs</b> l'hora de la sessio de l'Entrada. */
    public void setHoraSessio(Hora novaHoraSessio) { horaSessio = novaHoraSessio; }
    
    /** Torna un String amb les dades de l'Entrada. 
     *  El format de l'eixida es com el de l'exemple seguent:
     *   "Anochece en La India", projectada en Cines Babel, a les 22:30
     *   Preu base: 7.60 euros
     */
    public String toString() {
        return "\"" + titol + "\", projectada en " + cinema + ", a les " 
               + horaSessio + "\nPreu base: " + PREU_BASE + " euros";
    }

    /** Comprova si o es una Entrada amb les mateixes dades 
     *  que l'Entrada actual. */
    public boolean equals(Object o) {
       return (o instanceof Entrada) && //comprova que son del mateix tipus
            this.titol.equals(((Entrada) o).getTitol()) &&
            this.cinema.equals(((Entrada) o).getCinema()) &&
            this.horaSessio.equals(((Entrada) o).getHoraSessio());
    }
   
    /** Calcula el preu final de l'Entrada aplicant al preu base 
     *  els descomptes segons l'edat de l'espectador, el dia de 
     *  la sessio (espectador, festiu o vespra) i si te targeta 
     *  de client o no.
     */ 
    public double preuFinal(int edat, boolean diaEspectador, boolean festiu, 
                            boolean vespra, boolean targetaClient) {
     double res = PREU_BASE;
     
     if(edat >= SENIOR){ res = DESCOMPTE_SENIOR * res; }
     else {
         if(diaEspectador) { res = DESCOMPTE_DIA_ESPECTADOR * res; }
         else{
               if(festiu) { res = DESCOMPTE_FESTIU * res; }
             else if (vespra) { res = DESCOMPTE_VISPERA_FESTIU * res; }
             if(targetaClient) { res = DESCOMPTE_CLIENT * res; }
            }
     }
     return res * 100 / 100.0;
    }
             
}