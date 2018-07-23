import java.io. File ;
import java.io. FileNotFoundException ;
import java.io. PrintWriter ;
import java.util. InputMismatchException ;
import java.util.Locale;
import java.util. Scanner ;
public class IOPresioText {
    /**
     * Escriu en un fitxer de text (nomFitx) els valors de tipus double
     * emmagatzemats en una matriu (presions).
     * Cada fila de la matriu s’escriu en una línea del fitxer i
     * els valors de cada fila s’escriuen separats per espais en blanc.
     */
    public static void escriuPresions(double[][] presions, String nomFitx) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new  File ( nomFitx ));
            for (int i = 0; i < presions.length; i++) {
                for (int j = 0; j < presions[i].length; j++) {
                    pw. print (presions[i][j] + " ");
                }
                pw. println() ;
            }
        } catch ( FileNotFoundException  e) {
            System.out.println("ERROR: No s’ha pogut escriure en el fitxer " + nomFitx);
        } finally {
            if (pw != null) {  pw.close() ; }
        }
    }

    /**
     * Llig des d’un fitxer de text (nomFitx) valors de tipus double (amb el "."
     * com separador decimal) que va emmagatzemant en una matriu resultat de
     * dimensions n x n.
     */
    public static double[][] lligPresions(String nomFitx, int n) {
        double[][] aux = new double[n][n];
        Scanner sc = null;
        try {
            sc = new  Scanner (new  File (nomFitx)). useLocale ( Locale.US );
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    try {
                        aux[i][j] = sc.nextDouble();
                    } catch ( InputMismatchException  e) {
                        System.out.println("ERROR: Dada no vàlida. Ha de ser un valor de tipus double");
                    }
                }
            }
        } catch ( FileNotFoundException  e) {
            System.out.println("ERROR: No s’ha pogut accedir al fitxer " + nomFitx);
        } finally {
            if (sc != null) { sc.close(); }
        }
        return aux;
    }
}