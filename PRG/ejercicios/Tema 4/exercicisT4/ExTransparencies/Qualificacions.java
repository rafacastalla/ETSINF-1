import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
public class Qualificacions{
    public static void main(String[] args) {
        String fitxer= "qualificacions.dat", nom = "PRG";
        int conv= 1; double nota = 7.8;
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fitxer));
            out.writeUTF(nom); out.writeInt(conv); out.writeDouble(nota);
            out.close();
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fitxer));
            System.out.println("Valor llegitde nom: " + in.readUTF());
            System.out.println("Valor llegitde convocatòria: " + in.readInt());
            System.out.println("Valor llegitde nota: " + in.readDouble());
            in.close();
        } catch(FileNotFoundException e) {
            System.err.println("Problemes amb el fitxer"+ fitxer+ "." + e.getMessage());
        } catch(IOException e) {
            System.err.println("Problemes en escriure/llegiral/del fitxer" + fitxer);
        }
    }
}