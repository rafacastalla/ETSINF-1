import java.io.*;
public class Agenda implements Serializable {
    public static final int MAX = 8;
    private ItemAgenda[] lArray; 
    private int num;
    
    public Agenda(){ 
        lArray= new ItemAgenda[MAX]; 
        num = 0; 
    }
    
    public void insertar(ItemAgenda b) {
        if (num>= lArray.length) { dupEspai(); }
        lArray[num++] = b;
    }
    
    public String toString() {
        String res = "";
        for (inti= 0; i< num; i++) { res += lArray[i] + "\n"; }
        res += "=================================";
        return res;
    }
    // Altresmètodesde la classe... com esborrar, recuperarPerNom, etc.
    // en la classeAgenda ...
    public void guardarAgenda(String fitxer) {
        try {
            FileOutputStream fos= new FileOutputStream(fitxer);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(this); oos.close();
        } catch (IOException ex) {
        System.err.println("Error en guardar: " + ex.getMessage()); }
    }
    
    public static Agenda recuperarAgenda(String fitxer) {
        Agenda aux = null;
        try {
            FileInputStream fis= new FileInputStream(fitxer);
            ObjectInputStream ois= new ObjectInputStream(fis);
            aux = (Agenda) ois.readObject(); ois.close();
        } catch (IOException ex) {
            System.err.println("Error al recuperar: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println("Error de tipus: " + ex.getMessage()); 
        }
        return aux;
    }
} // fide la classeAgenda