import java.util.Scanner;

/**
 *  Classe Practica3.
 *  Una primera classe amb lectura de dades des de teclat, 
 *  i us d'operacions amb int, long, Math i String.
 *  Conte tres errores de compilacio.
 *  @author (IIP. Grau en Informatica. ETSINF, UPV) 
 *  @version (Curs 2015-16)
 */

public class Practica3 {
    
    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        System.out.println("Lectura de teclat d'una hora.");
        System.out.print(" -> Introduiu l'hora (entre 0 i 23): ");
        int h = teclat.nextInt();
        System.out.print(" -> Introduiu els minuts (entre 0 i 59): ");
        int m = teclat.nextInt();
        
        String h2d = "0" + h;
        h2d = h2d.substring(h2d.length() - 2);
        String m2d = "0" + m;
        m2d = m2d.substring(m2d.length() - 2);
        
        System.out.println("Hora introduida: " + h2d + ":" + m2d + "."); 
        
        long t = System.currentTimeMillis() / 60000;
        int hA = (int) ((t % (60 * 24) + 120) / 60);
        int mA = (int) (t %60);
        
        String hA2d = "0" + hA;
        hA2d = hA2d.substring(hA2d.length() - 2);
        String mA2d = "0" + mA;
        mA2d = mA2d.substring(mA2d.length() - 2);
        
        System.out.println("Hora actual: " + hA2d + ":" + mA2d + "."); 
    }    
 
}