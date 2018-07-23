import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Escriu en un fitxer de text els numeros de l'1 al 999 i posteriorment 
 * els torna a llegir d'aquest fitxer per tal de sumar-los, verificant que 
 * el resultat es correcte.
 * 
 * @author PRG
 * @version Curs 2015/16
 */ 
public class ExerT4P4 {
    
    /**
     * Suma els enters en l'interval [1,n[
     * @param n int.
     * @return int.
     */
    public static int sumaNumeros(int n) {
        int suma = 0;
        for (int i = 1; i < n; i++) { suma += i; }
        return suma;
    }
  
    public static void main(String[] args) {
        String fitxer = "test1.txt";
        int suma = 0;  
        try {
            System.out.println("Escrivint fitxer " + fitxer);
            PrintWriter pw = /* COMPLETAR */;
            for (int i = 1; i < 1000; i++) { /* COMPLETAR - Escriure en pw */ }
            /* COMPLETAR - Tancar pw*/
   
            System.out.println("Llegint del fitxer " + fitxer);
            Scanner scanner = /* COMPLETAR */
            while (/* COMPLETAR */) { suma += /* COMPLETAR - Llegir de scanner*/; }     
            /* COMPLETAR - Tancar scanner*/
   
            System.out.print("Els valors llegits");
            if (suma != sumaNumeros(1000)) { System.out.print(" NO"); }
            System.out.println(" son correctes");      
        } catch (FileNotFoundException ex) {
            System.err.println("Problemes en obrir el fitxer " 
                               + fitxer + ". Rao: " + ex.getMessage());
        }  
    }   
  
}