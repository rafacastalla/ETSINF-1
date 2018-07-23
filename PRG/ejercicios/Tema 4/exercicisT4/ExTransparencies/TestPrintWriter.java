import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class TestPrintWriter {
    public static void main(String[] args) {
        String fitxer= "file2.txt";
        try {
            PrintWriter pw = new PrintWriter(new File(fitxer));
            pw.print("Setze jutges d'un jutjat ");
            pw.println(" mengen fetge d'un penjat ");
            pw.println(4.815162342);
            pw.close();
        } catch (FileNotFoundException e) {
            System.err.println("Problemesen obrir el fitxer " + fitxer);
        }
    }
}