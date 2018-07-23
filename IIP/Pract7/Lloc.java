/** Classe Lloc: defineix l'ocupacio d'un lloc de parking.
  * @author IIP
  * @version Curs 2015/2016
  */
public class Lloc {

    private int planta, lloc;
    private Hora horaEntrada;
    private String matricula;
    public Lloc(int p,int n){
      planta = p;
      lloc = n;
        
    }

    /** Constructor que inicialitza un lloc de parking buit
      * amb un numero de planta i un numero de lloc donats.
      * @param p int numero de planta del lloc.
      * @param n int numero de lloc.
      */
     public Lloc(String m, Hora h, int p,int n){
       planta = p;
       lloc = n;
       horaEntrada = h;
       matricula = m;
        
    }
    
  
    /** Constructor que inicialitza un lloc de parking ocupat.
      * @param m String amb la matricula del cotxe que ocupa el lloc.
      * @param h Hora hora d'entrada del cotxe.
      * @param p int numero de planta del lloc.
      * @param n int numero de lloc.
      * 
      */
     
  public String getMatricula (){
      return this.matricula;
    }
    
  
    /** Torna la matricula. 
      * @return String, matricula del cotxe que ocupa el 
      * lloc, o null si esta buit.
      */
  
public Hora getHoraEntrada(){
    return this.horaEntrada;
}
    /** Torna l'hora d'entrada.
      * @return Hora, hora d'entrada del cotxe en el lloc, o null si esta buit.
      */
  
public int getPlanta(){
    return this.planta;
}
    /** Torna el numero de planta.
      * @return int, numero de planta del lloc.
      */
  
public int getLloc(){
    return this.lloc;
}
    /** Torna el numero de lloc.
      * @return int, numero de lloc.
      */
  
public void setMatricula(String m){
   matricula = m;
}
    /** Actualitza la matricula.
      * @param m String que indica la matricula del cotxe. 
      */
  public void setHoraEntrada(Hora h){
      horaEntrada = h;
    }

    /** Actualitza l'hora d'entrada.
      * @param h Hora que indica l'hora d'entrada del cotxe.
      */
  //-----------------------------------------------------------------------------------------

    /** Entra el cotxe en el lloc.
      * @param m String amb la matricula del cotxe a aparcar en el lloc.
      * @param h Hora que indica l'hora d'entrada del cotxe en el parking.
      */
  
public void entrarCotxe(String m, Hora h){
    matricula = m;
    horaEntrada = h;
    
}

    /** Trau el cotxe del lloc.
      */
  
public void eixirCotxe(){
    matricula = null;
    horaEntrada = null;
    
}
    /** Comprova si el lloc esta buit.
      * @return boolean, true si esta buit, o false en cas contrari.
      */
  
public boolean esBuit(){
    boolean respuesta = true;    
    if(matricula != null){
        respuesta = false;
    }
    return respuesta;
}
public String toString(){
    String retorno;
    if(matricula != null){
        retorno = "Cotxe amb matricula " + matricula.toString() + " en lloc " + planta + "-" + lloc + ", entrada a les " + horaEntrada; 
    }else{
        retorno = "No hi ha cap cotxe en aquest lloc";
    }
  return retorno;
}

    /** Torna un String representant el lloc.<br>
      * Format: "Cotxe amb matricula MATRICULA en lloc 
      * PLANTA-LLOC, entrada a les HORAENTRADA".<br>
          * Si el lloc esta buit, "No hi ha cap cotxe en aquest lloc".
      * @return String, representacio del lloc.
      */
  
}
