
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Locale;
import java.util.InputMismatchException;


/**
 * Write a description of class Ejercici1Escriptura here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Exercici1Escriptura {
    public static void main (String[] args) {
        Scanner teclat = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Nom de fitxer? ");
        String nomFitxer = teclat.nextLine();
        boolean eixir = false;
        File f = new File(nomFitxer);
        PrintWriter pw = null;
        try{
            pw = new PrintWriter(f);
            do {
                System.out.println("Telefon del contacte? ");
                int tel= teclat.nextInt();
                teclat.nextLine(); // Buidem el buffer
                System.out.println("Nom del contacte? ");
                String nom= teclat.nextLine();   
                pw.println(tel);
                pw.println(nom);                
                System.out.println("Vols continuar? ");
                eixir = teclat.nextLine().toUpperCase().equals("NO");            
            } while (!eixir);           
        } catch (FileNotFoundException e) {
            System.out.println("Error, excepció: " + e);
        } finally {
            if (pw!=null) { pw.close(); }
        }
    }
    
    
}
