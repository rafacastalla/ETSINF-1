
import java.io.File;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.EOFException;
import java.util.Scanner;
import java.util.Locale;
import java.util.InputMismatchException;



public class Exercici2Lectura {
    public static void main (String[] args) {
        Scanner teclat = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Nom de fitxer? ");
        String nomFitxer = teclat.nextLine();
        File f = new File(nomFitxer);
        
        ObjectInputStream oIS = null;
        try{
            oIS = new ObjectInputStream(new FileInputStream(f));
            try{
                do {
                System.out.println(oIS.readObject());
                } while (true);
            }
            catch (EOFException e){
                System.out.println("Final de Fitxer");}
        }
        catch (ClassNotFoundException e){
            System.out.println("No hi ha dades de tipus obj. serializable");
        }
        catch (IOException e){
            System.out.println("Error al obrir o tractar el fitxer");
        }
        finally {
            if (oIS!=null) {
                try { 
                      oIS.close();  
                      System.out.println("Tancat correctament.");
                } 
                catch (IOException e) { 
                    System.out.println("Problemes al Tancar");
                }            
            }
        }
    }
    
}
