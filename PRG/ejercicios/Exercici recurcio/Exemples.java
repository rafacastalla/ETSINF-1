
/**
 * Write a description of class recurcio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exemples
{
    /**
     * Exemple 1: recorregut ascendent per a sumar tots els elements d'un array de double, des d'inici fins a fi.
     * 
     * precondició 0 <= inici < elArray.length && 
     *             0 <= fi <= elArray.length
     */
   public static double sumarArrayAscendent(double[] elArray, int inici, int fi){
       double resultat = 0;
       //primer pas: identificar cas base
       if(inici > fi){resultat = 0;}
       //segon pas: solucio cas recursiu i recurrencia
       else{ resultat = elArray[inici] +
             sumarArrayAscendent(elArray, 
                                 inici+1,//retallem el array
                                 fi);
           }
       return resultat;
    }
    
     /**
     * Exemple 2: recorregut ascendent per a sumar tots els elements d'un array de double, des de fi fins a inici.
     * 
     * precondició 0 <= inici < elArray.length && 
     *             -1 <= fi < elArray.length
     */
   public static double sumarArrayDescendent(double[] elArray, int inici, int fi){
       double resultat = 0;
       //primer pas: identificar cas base
       if(inici > fi){resultat = 0;}
       //segon pas: solucio cas recursiu i recurrencia
       else{ resultat = elArray[fi] +
             sumarArrayDescendent(elArray, 
                                 inici,
                                 fi-1);//retallem el array
           }
       return resultat;
    }
    
     /**
     * Exemple 3: cerca ascendent per a sumar tots els elements d'un array de double, des d'inici fins a fi.
     * 
     * precondició 0 <= inici <= elArray.length && 
     *             0 <= fi < elArray.length
     */
   public static int primer0(double[] elArray, int inici, int fi){
       int resultat;
       //primer pas: identificar cas base
       if(inici > fi){resultat = -1;}//fora del array
       //segon pas: solucio cas recursiu i recurrencia
       else{ if(elArray[inici]==0.0){resultat = inici;}
             else {
                 resultat = primer0(elArray, inici+1/*retalle l'array*/, fi);
                }
           }
       return resultat;
    }
    
   public static int primer0desc(double[] elArray, int inici, int fi){
       int resultat;
       //primer pas: identificar cas base
       if(inici > fi){resultat = -1;}//fora del array
       //segon pas: solucio cas recursiu i recurrencia
       else{ if(elArray[fi]==0.0){resultat = fi;}
             else {
                 resultat = primer0desc(elArray, inici, fi-1/*retalle l'array*/);
                }
           }
       return resultat;
   }
   
   public static int buscaBinR(String[] a, String dato, int ini, int fin){
       int res;
       if(ini>fin){res=-1;}
       else{
           int mitad = (ini + fin) / 2;
           int comp = a[mitad].compareTo(dato);
           if(comp == 0){res = mitad;}
           else{if(comp<0) {
                    res= buscaBinR(a, dato, mitad + 1, fin);
                }else{
                    res = buscaBinR(a, dato, ini, mitad-1);
                }
           }
      }
      return res;
   }
  
   public static void ejercicio10(int n){
       int res;
       if(n<10){System.out.print(n);}
       else{System.out.print(n%10);
            ejercicio10(n/10);
       }       
   }
   
   public static int ejercicio10Bis(int n){
       int res;
       if(n<10){res = n;}
       else{
            int aux = (int) Math.log10(n);
            res = (n%10) * (int) Math.pow(10, aux)
            + ejercicio10Bis(n/10);
       }
       return res;
   }
   
   public static long ejercicio11(int n){
       long res;
       if(n<=1){res=n;}
       else {
           res= n%2 + ejercicio11(n/2)*10;
        }
       return res;
   }
   
   public static boolean ejercicio13(String a){
       boolean res = false;
       
       
       return res;
    }
   
   private static boolean esCapicua(String[] a){
       return esCapicua(a, 0, a.length-1);
    } //per a que l'usuari no vega el metode esCapicua posem privat aquest i creem un nou public que cride al proxim
   
   private static boolean esCapicua(String[] a, int ini, int fin){
       boolean res;
       if(ini>=fin){res = true;}
       else{
          res = a[ini].equals(a[fin])
              && esCapicua(a, ini+1, fin-1);
              /*res = esCapicua(a, ini+1, fin-1) && !a[ini].equals(a[fin]); MAJOR EFICIÈNCIA*/
        }
       return res;
   } 

}
