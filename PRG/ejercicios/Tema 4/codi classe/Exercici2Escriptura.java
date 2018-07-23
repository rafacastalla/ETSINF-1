
import java.io.File;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Locale;
import java.util.InputMismatchException;


/**
 * Write a description of class Ejercici1Escriptura here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Exercici2Escriptura {
    public static void main (String[] args) {
        Scanner teclat = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Nom de fitxer? ");
        String nomFitxer = teclat.nextLine();
        boolean eixir = false;
        File f = new File(nomFitxer);
        ObjectOutputStream oOS = null;
        try{
            oOS = new ObjectOutputStream(new FileOutputStream(f));
            do {
                System.out.println("Telefon del contacte? ");
                int tel= teclat.nextInt();
                teclat.nextLine(); // Buidem el buffer
                System.out.println("Nom del contacte? ");
                String nom = teclat.nextLine();   
                Contacte c = new Contacte(nom, tel);
                oOS.writeObject(c);
                System.out.println("Vols continuar? ");
                eixir = teclat.nextLine().toUpperCase().equals("NO");            
            } while (!eixir);     
        } catch (IOException e  ) {
            System.out.println("Error, excepció: " + e);
        } finally {
            if (oOS!=null) {
                try { 
                      oOS.close();  
                      System.out.println("Guardat correctament.");
                } 
                catch (IOException e) { 
                    System.out.println("Problemes al guardar");
                }            
            }
        }
    }
}
