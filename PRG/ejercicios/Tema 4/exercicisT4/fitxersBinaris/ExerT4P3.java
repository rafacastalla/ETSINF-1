import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
/**
 *  Llig un fitxer binari amb els numeros de l'1 al 999 i  
 *  verifica la correccio calculant la suma de les dades
 *  front a la suma dels numeros mitjançant un bucle.
 *
 *  @author PRG
 *  @version Curs 2015/16
 */ 
public class ExerT4P3 {
   
    public static void main(String[] args) {
        String fileName = "test1.bin";
        int sumaB = 0, sumaF = 0;     
        System.out.println("Llegint el fitxer " + fileName);
        try {
            ObjectInputStream in = /* COMPLETAR */;             
            for (int i = 1; i < 1000; i++) { sumaF += /* COMPLETAR - llegir de in*/; }        
            /* COMPLETAR - tancar in */
        
            for (int i = 1; i < 1000; i++) { sumaB += i; }
            String str = "Les dades llegides del fitxer ";
        
            if (sumaB != sumaF) { str += " NO "; }
            str += "son correctes";
            System.err.println(str);
        } catch (FileNotFoundException ex) {
            System.err.println("Error en obrir el fitxer. Rao: " 
                               + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Error en llegir el fitxer. Rao: " 
                               + ex.getMessage());         
        }   
    }   
}