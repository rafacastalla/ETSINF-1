import java.io.File;
public class TestFile{
    public static void main(String[] args) {
        File f = new File("/home/pcasals/file.txt");
        if (f.exists()) {
            System.out.println("El fitxerexisteix!");
            System.out.println("getName():"+f.getName());
            System.out.println("getParent(): " + f.getParent());
            System.out.println("length(): " + f.length());
        }else {System.err.println("El fitxer NO existeix!"); }
    }
}