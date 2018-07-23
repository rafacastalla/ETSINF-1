import java.io.File;
/**
 *  Mostra informacio basica sobre un fitxer (nom, directori i tamany en kbytes)
 * 
 *  @author PRG
 *  @version Curs 2015/16
 */ 
public class ExerT4P1 {
  
    public static void main(String[] args) { 
        if (args.length != 1) { 
            System.err.println("Especifica el nom d'un fitxer");    
        }
        else {      
            String filePath = args[0];      
            File f = /* COMPLETAR */;
            if (f.isFile()) {
                System.out.println("Nom del fitxer: " + /* COMPLETAR */);
                System.out.println("Directori: " + /* COMPLETAR */);
                System.out.println("Tamany (kbytes): " + /* COMPLETAR */);  
                System.out.println("Ruta absoluta: " + /* COMPLETAR */);
            }     
        }   
    }
}