import java.util.*;
import java.io.*;
/** Classe Parking: representa un conjunt de plantes d'un parking junt amb el cost per minut.
  * @author IIP
  * @version Curs 2015/2016
  */
public class Parking {
  
    // ATRIBUTS
    private Planta[] plantes;
    private int numLlocs;
    private double cost;
    

    /** Constructor que crea un parking a partir del numero de plantes, 
      * numero de llocs per planta, i cost en euros per minut.
      * El parking, al principi, esta buit.
      * @param p int numero de plantes, p > 0.
      * @param n int numero de llocs per planta, n > 0.
      * @param c double cost en euros per minut, c > 0.
      */
     public Parking(int p, int n, double c){
         if (p>0){
             plantes = new Planta[p];
             for(int i=0; i < p ;i++){
                 plantes[i]=new Planta(i, n);
                }
               
            }
            if(n>0){
                numLlocs = n;
            }
            if (c>0){
                cost = c;
            }
        }
  

    /** Constructor que crea un parking a partir de les dades d'un fitxer 
      * el nom del qual es passa com a parametre.<br>
      * Format del fitxer:
      * <pre>
      * plantes llocs
      * cost
      * planta matricula hores minuts
      * ...
      * planta matricula hores minuts
      * </pre>
      * Les dades son correctes (no hi ha cotxes ni 
      * llocs repetits, plantes no completes i correctes, 
      * i hores correctes). 
      * @param nomFitx String nom del fitxer amb les dades.
      * @throws Exception si ocorre algun error d'entrada/eixida. 
      */
    public Parking(String nomFitx) throws Exception {
        Scanner in = new Scanner(new File(nomFitx)).useLocale(Locale.US);
        int p = in.nextInt(), n = in.nextInt(); 
        double c = in.nextDouble();

        plantes = new Planta[p];
        for (int i = 0; i < p; i++) {
            plantes[i] = new Planta(i, n);
        }
        numLlocs = n;
        cost = c;

        String mat; 
        int h, m;
        while (in.hasNext()) {
            p = in.nextInt(); 
            mat = in.next(); 
            h = in.nextInt(); 
            m = in.nextInt();
            plantes[p].entrarCotxe(mat, new Hora(h, m));
        }

        in.close();
    }
public int getNumPlantes(){
    return plantes.length;
}
    /** Torna el numero de plantes.
      * @return int, numero de plantes del parking.
      */
     public int getNumLlocs(){
         return numLlocs;
        }
  

    /** Torna el numero de llocs per planta.
      * @return int, numero de llocs per planta en el parking.
      */
  
public double getCost(){
    return cost;
}
    /** Torna el cost.
      * @return double, cost del parking (euros/minut).
      */
  
public void setCost(double c){
    if(c > 0){
    this.cost = c;
}
}
    /** Actualitza el cost.
      * @param c double nou cost (euros/minut) del parking, c > 0.
      */
  
public boolean esPle(){
    boolean ple = true;
    int i=0;
    while(i <plantes.length && ple == true){
        if(!plantes[i].esPlena()){
            ple = false;
        }
        i++;
    }
    return ple;
}
    /** Verifica si el parking es ple.
      * @return boolean true si es ple, false si no.
      */
  
    // ==== Empra Planta.esBuida() ====
 public Lloc entrarCotxe(String m, Hora h, int p){
        Lloc retornar = null;
        int i=0;
         
          
      if(!esPle()){
        retornar = plantes[p].entrarCotxe(m,h);
        
        while(retornar ==null){
            if(p+i<plantes.length && !plantes[p+i].esPlena()){
                retornar = plantes[p+i].entrarCotxe(m,h);
            }else if(p-i >= 0 && !plantes[p-i].esPlena()){
                retornar = plantes[p-i].entrarCotxe(m,h);
            }
  
            i++;
        }
          
        }
        return retornar;
    }

    /** Entra un coche donats la seua matricula, la seua 
      * hora d'entrada i un numero de planta de preferencia, 
      * i torna el lloc on el cotxe entra, o null en un 
      * altre cas. Precondicio: cotxe no present.
      * Si la planta de preferencia no esta disponible, 
      * busca llocs lliures en les plantes mes properes.
      * @param m String matricula del cotxe a entrar.
      * @param h Hora hora d'entrada del cotxe.
      * @param p int planta de preferencia.
      * @return Lloc si el cotxe entra, o null en cas contrari.
      */
  
    // ==== Empra Planta.entrarCotxe(String, Hora) ====
    
     public Lloc cercarCotxe(String m){
         Lloc retornar=null;
         int i=0;
    
        while( i < plantes.length && retornar == null){
             
          retornar = plantes[i].cercarCotxe(m);
          i++;
        }
        
            return retornar;
        }

    /** Comprova si un cotxe de matricula donada esta en el parking. 
      * @param m String matricula del cotxe a cercar.
      * @return Lloc, lloc ocupat pel cotxe, si es troba, o null si no es troba.
      */
  
    // ==== Empra Planta.cercarCotxe(String) ====
    
    
     public double eixirCotxe(String m, Hora h){
         int minuts=0;
      int i=0;
      boolean esta = false;
        while(i< plantes.length && esta ==false){
             if(plantes[i].cercarCotxe(m) !=null){
         minuts = plantes[i].eixirCotxe(m,h) ;
         esta = true;
        }
        i++;
    }
        return cost * minuts;
        }
        

    /** Trau el cotxe del parking i torna el seu cost.
      * @param m String matricula del cotxe a eixir. Precondicio: sempre esta.
      * @param h Hora hora d'eixida del cotxe. 
      * Precondicio: posterior a l'hora d'entrada.
      * @return double, cost en euros a pagar.
      */

    // ==== Empra Planta.cercarCotxe(String) i Planta.eixirCotxe(String, Hora) ====
    
  public double buidarParking(){
      Hora h= new Hora(23,59);
      int resultat =0;
      for(int i=0; i<plantes.length;i++){
          resultat +=plantes[i].buidarPlanta(h);
        }
        return resultat*cost;
    }
    /** Buida tot el parking, suposant que son les 23:59,
      * i calcula i torna el cost total.
      * @return double, cost total en euros a pagar per 
      * tots els cotxes que ixen del parking.
      */
    
    // ==== Empra Planta.buidarPlanta(Hora) ====
  
    /** Torna un String que representa l'ocupacio del 
      * parking, amb 'X' ocupat, ' ' lliure.
      * Ha de colocar un encapsalament amb els numeros de lloc 
      * corresponents.<br>
      * Exemple: <pre>
      *          "      0   1   2   3   4 
      *             0   X   X       X    
      *             1       X   X       X
      *             2   X   X             " </pre>
      * @return String, representacio del parking.
      */
  
     public String toString(){
         String cadena="      0   1   2   3   4 \n";
         for(int i=0;i<plantes.length;i++){
             cadena += plantes[i].toString();
            }
            return cadena;
        }
    // ==== Empra Planta.toString() ====
  
}
