import java.io. FileInputStream ;
import java.io. FileNotFoundException ;
import java.io. FileOutputStream ;
import java.io. IOException ;
import java.io. ObjectInputStream ;
import java.io. ObjectOutputStream ;
public class IOPresioBin {
    /**
     * Escriu en un fitxer binari (nomFitx) els valors de tipus double
     * emmagatzemats en una matriu (presions).
     */
    public static void escriuPresionsBin(double[][] presions, String nomFitx) {
        ObjectOutputStream out = null;
        try {
            out = new  ObjectOutputStream (new  FileOutputStream (nomFitx));
            for (int i = 0; i < presions.length; i++) {
                for (int j = 0; j < presions[i].length; j++) {
                    out. writeDouble (presions[i][j]);
                }
            }
        } catch ( FileNotFoundException  e) {
            System.out.println("ERROR: No s’ha pogut crear el fitxer " + nomFitx);
        } catch ( IOException  e) {
            System.out.println("ERROR: No s’ha pogut escriure en el fitxer " + nomFitx);
        } finally {
            try {
              if (out != null) {  out.close() ; }
            } catch ( IOException  e) {
                System.out.println("ERROR: No s’ha pogut tancar el fitxer " + nomFitx);
            }
        }
    }

    /**
     * Llig des d’un fitxer binari (nomFitx) valors de tipus double que
     * va emmagatzemant en una matriu resultat de dimensions n x n.
     */
    public static double[][] lligPresionsBin(String nomFitx, int n) {
        double[][] aux = new double[n][n];
        ObjectInputStream in = null;
        try {
            in = new  ObjectInputStream (new  FileInputStream (nomFitx));
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    aux[i][j] = in.readDouble();
                }
            }
        } catch ( FileNotFoundException  e) {
            System.out.println("ERROR: No s’ha pogut accedir al fitxer " + nomFitx);
        } catch ( IOException  e ) {
            System.out.println("ERROR: No s’ha pogut llegir del fitxer " + nomFitx);
        } finally {
            try {
                if (in != null) {  in.close() ; }
            } catch ( IOException  e ) {
                System.out.println("ERROR: No s’ha pogut tancar el fitxer " + nomFitx);
            }
        }
        return aux;
    }
}