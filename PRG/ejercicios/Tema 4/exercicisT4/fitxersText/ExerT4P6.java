import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Elimina totes les ocurrencies d'una determinada paraula 
 * en un fitxer de text.
 * 
 * @author PRG
 * @version Curs 2015/16
 */ 
public class ExerT4P6 {  

    /**
     * Elimina les ocurrencies d'una paraula en un fitxer 
     * de text donat, escrivint en un altre fitxer de text.
     * @param s Scanner que representa el fitxer d'on llegir.
     * @param w String que representa la paraula a eliminar.
     * @param pw PrintWriter que representa el fitxer on escriure.
     */  
    public static void elimina(Scanner s, String w, PrintWriter pw) {
        /* COMPLETAR */
    }
      
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Introdueix la ruta a un fitxer de text "
                               + "i la paraula a eliminar");     
        }
        else {
            String f1 =  args[0];
            String paraula = args[1];       
            System.out.println("Eliminant totes les ocurrencies de " + paraula 
                               + " al fitxer: " + f1);
            try {
                Scanner s = /* COMPLETAR */;
                File f2 = new File(/* COMPLETAR */);
                PrintWriter pw = /* COMPLETAR */;
                elimina(s, paraula, pw);
                s.close();
                pw.close();
            } catch (FileNotFoundException ex) {
                System.out.println("El fitxer " + f1 + " no existeix.");  
            }
        }
    }           
}  