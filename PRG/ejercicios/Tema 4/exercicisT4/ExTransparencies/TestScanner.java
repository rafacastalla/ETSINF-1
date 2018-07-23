import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class TestScanner{
    public static void main(String[] args) {
        System.out.println("Es lligen 3 números i una línia de text");
        Scanner scanner= null;
        try {
            scanner = new Scanner(new File("coses.txt"));
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();
            int n3 = scanner.nextInt();
            String linia= scanner.nextLine();
            System.out.println("Elstres números són: "
            + n1 + ", "+ n2 + ", "+ n3);
            System.out.println("La líniaés: " + linia);
        }catch(FileNotFoundException e){
            System.err.println("El fitxerno existeix." + e.getMessage());
        }catch(InputMismatchException e) {
            System.err.println("Error al llegir." + e.getMessage());
        }finally{
            if(scanner != null) { scanner.close(); }
        }
   }
}