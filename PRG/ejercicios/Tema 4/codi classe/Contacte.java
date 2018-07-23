import java.io.Serializable;
public class Contacte implements Serializable{
     public String nomContacte;
     public int telContacte;
     
     public Contacte(String s, int n) {
         nomContacte = s;
         telContacte = n;
     }

    public String toString() {
        return nomContacte + "\t" + telContacte;
    }
}
