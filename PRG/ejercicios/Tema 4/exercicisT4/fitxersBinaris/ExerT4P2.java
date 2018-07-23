import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
/**
 *  Crea un fitxer binari amb els numeros de l'1 al 999
 *
 *  @author PRG
 *  @version Curs 2015/16
 */ 
public class ExerT4P2 {
   
    public static void main(String[] args) {
        String fileName = "test1.bin";          
        System.out.println("Creant el fitxer " + fileName);
        try {
            ObjectOutputStream out = /* COMPLETAR */;             
            for (int i = 1; i < 1000; i++) {
                /* COMPLETAR - escriure en out */   
			}				
            /* COMPLETAR - tancar out*/
        } catch (/* COMPLETAR */ ex) {
            System.err.println("Error en obrir el fitxer. Rao: " 
                               + ex.getMessage());
        } catch(/* COMPLETAR */ ex) {
            System.err.println("Error en escriure el fitxer. Rao: " 
                               + ex.getMessage());          
        }
    }   
  
} 