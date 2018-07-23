/** Classe Planta: representa un conjunt de llocs de parking en una planta d'un parking.
   * @author IIP
  * @version Curs 2015/2016
  */
public class Planta {
private Lloc[] llocs;
private int planta;
private int llocsLliures;

    /** Constructor que crea una Planta donats un numero 
      * de planta i un numero de llocs per planta.
      * La planta, al principi, esta buida.
      * @param numPlanta int numero de planta, numPlanta >= 0.
      * @param numLlocs int numero de llocs per planta, numLlocs > 0.
      */
public Planta(int numPlanta, int numLlocs){
      
       if(numLlocs >0){
         llocs = new Lloc[numLlocs];
         llocsLliures = numLlocs;
         for(int i=0;i<numLlocs;i++){
             llocs[i] = new Lloc(numPlanta, i);
            }
        
       
    }
      if(numPlanta >=0){
        planta = numPlanta;
    }

    }
    

public int getPlanta(){
    return planta;
}
  
    /** Torna el numero de planta.
      * @return int numero de planta del parking.
      */
public int getLlocsLliures(){
    return llocsLliures;
}
  
    /** Torna el nombre de llocs lliures de la planta.
      * @return int nombre de llocs lliures.
      */
  
    /** Torna si la planta es plena.
      * @return boolean planta plena (sense llocs lliures).
      */

public boolean esPlena(){
    boolean resultat=false;
    if(llocsLliures == 0){
        resultat = true;
    }
    return resultat;
}
public int primerLliure(){
    int primer=-1;
    for (int i=llocs.length-1; i >= 0; i--){
        if(llocs[i].esBuit()){
            primer = i;
        }
    }
    return primer;
}
    /** Torna el primer lloc lliure en la planta, o -1 
      * si no hi ha llocs lliures.
      * @return int, index del primer lloc lliure en la 
      * planta, o -1 si no hi ha llocs lliures.
      */

    // ==== Empra Lloc.esBuit() ====

public Lloc entrarCotxe(String m, Hora h){

  if(esPlena()){
      return null;
    }else{
        int i = primerLliure();
        llocs[i].entrarCotxe(m,h);
        llocsLliures--;
        return llocs[i];
    }
        
 
   
  
}
    /** Entra un cotxe en la planta i torna el seu lloc,
      * o null quan no hi ha llocs lliures
      * Precondicio: el cotxe no hi es a la planta.
      * @param m String matricula del cotxe.
      * @param h Hora hora d'entrada del cotxe.
      * @return Lloc si el cotxe entra, o null en cas contrari.
      */

    // ==== Empra esPlena() i Lloc.entrarCotxe(String, Hora) ====
    
    
    
    public  Lloc cercarCotxe(String m){
        Lloc resultat = null;
        for(int i = 0; i<llocs.length;i++){
            if(llocs[i].esBuit()==false && llocs[i].getMatricula().equals(m)){
                resultat= llocs[i];
            }
        }
        return resultat;
    }

    /** Comprova si un cotxe donat esta en la planta.
      * @param m String matricula del cotxe a buscar.
      * @return Lloc, el lloc que ocupa el cotxe, si es 
      * troba, o null si no es troba.
      */

    // ==== Empra Lloc.esBuit() i Lloc.getMatricula() ====
    
    
    
    
    public int eixirCotxe(String m, Hora h){
     Lloc cotxe = cercarCotxe(m);
           Hora minuts_entra = null;
           int minuts_ix= h.aMinuts();
              if(cotxe !=null){
                      minuts_entra =cotxe.getHoraEntrada();
                      llocsLliures ++;
                      cotxe.eixirCotxe();
                }
                      
                    
                       
            
        
        return minuts_ix-minuts_entra.aMinuts();
    }

    /** Trau el cotxe del parking, tornant quants minuts ha estat.
      * @param m String matricula del cotxe. Precondicio: sempre esta.
      * @param h Hora hora d'eixida. Precondicio: posterior a l'hora 
      *   d'entrada del cotxe.
      * @return int, numero de minuts que el cotxe ha estat en el parking.
      */

    // ==== Empra cercarCotxe(String), Hora.aMinuts(), Lloc.getHoraEntrada() i Lloc.eixirCotxe() ====
    
    
    public int buidarPlanta(Hora h){
        int resultat=0;
        int minuts_entra=0;
           int minuts_ix=h.aMinuts();
        for (int i = 0; i<llocs.length;i++){
            if(llocs[i].getMatricula()!=null){
            minuts_entra = llocs[i].getHoraEntrada().aMinuts();
            resultat += (minuts_ix - minuts_entra);
            //llocs[i].eixirCotxe();
            eixirCotxe(llocs[i].getMatricula(),h);
        }
            
        }
        return resultat;
    }

    /** Buida toda la planta i torna el numero total de 
      * minuts que els cotxes han estat 
      * en la planta fins una hora donada.
      * @param h Hora hora en la que tots els cotxes han 
      *   d'eixir. Precondicio: posterior a l'hora d'entrada.
      * @return int, numero total de minuts transcorreguts.
      */

    // ==== Empra Hora.aMinuts(), Lloc.esBuit(), Lloc.getHoraEntrada() i Lloc.eixirCotxe() ====

        public String toString() {
         String cad = "  " + planta;
         for (int i=0; i < llocs.length; i++){
             cad += " ";
             if(llocs[i].esBuit()){
                 cad += "   " ;
             }
             else{
                 cad += "  X";
             }
         }
         cad += " \n";
        return cad;
      }
    
  
    /** Torna un String amb l'ocupacio del parking, amb 
      * 'X' ocupat, ' ' lliure.<br>
      * Format: <pre> planta (ocupant 3 posicions), espai, 
      * ocupacio ("  X" o "   "), espai, ..., ocupacio 
      * ("  X" o "   "), espai, '\n'</pre>
      * Exemple de format (5 llocs): <pre> "  2   X       X   X      " </pre>
      * @return String, representacio de l'ocupacio de la planta.
      */

    // ==== Empra Lloc.esBuit() ====
  
}
