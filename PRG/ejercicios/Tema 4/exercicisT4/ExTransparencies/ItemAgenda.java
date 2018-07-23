import java.io.Serializable;
public class ItemAgenda implements Serializable{
    private String nom; 
    private String tel; 
    private int postal;
    public ItemAgenda(String n, String t, int p) {
        nom = n; tel= t; postal = p;
    }
    public String toString() {
        return nom + ": " + tel+ " (" + postal + ")";
    }
    // altresmètodes...
} // fide la classeItemAgenda