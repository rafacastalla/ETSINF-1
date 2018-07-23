import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;
/**
 * Classe Agenda: representacio d'una agenda telefonica com un grup de  
 * contactes dinamic situats en posicions contigues de memoria. 
 * Es molt important notar que una agenda, per definicio, no conte contactes 
 * repetits o, mes ben dit, noms de contactes repetits. 
 * @author PRG
 * @version Curs 2015/16
 */ 
public class Agenda implements Serializable {
    public static final int MAX = 100; 
    private Contacte[] lArray;
    private int num;
    
    /**
     * Crea una agenda sense contactes (pot tenir un maxim de MAX contactes).
     */
    public Agenda() { lArray = new Contacte[MAX]; num = 0; }
  
    /**
     * Torna el numero actual de contactes.
     * @return int, numero actual de contactes.
     */
    public int getNumContactes() { return num; }
  
    /**
     * Duplica la grandaria de l'array.
     */
    private void duplicaEspai() {
        Contacte[] aux = new Contacte[2 * lArray.length];
        for (int i = 0; i < lArray.length; i++) { aux[i] = lArray[i]; }
        lArray = aux; 
    }
  
    /**
     * Permet inserir el Contacte b a l'agenda. Si l'agenda esta completa,
     * duplica el numero de contactes que poden haver-hi.
     * @param b Contacte a inserir. Es un contacte valid: el nom te una 
     * longitud en l'interval [1...40] i no esta repetit. I el telefon
     * te 9 caracters de l'interval ['0'..'9'] sent el primer d'ells 
     * distint de zero.
     * @param b Contacte a inserir.
     */
    public void inserir(Contacte b) {
        if (num >= lArray.length) { duplicaEspai(); }        
        lArray[num++] = b; 
    }
  
    /**
     * Torna el contacte amb nom nom.
     * Si aquest contacte no existeix, torna null.
     * @param nom String que indica el nom del contacte.
     * @return Contacte, el contacte resultat.
     */
    public Contacte getContacte(String nom) {
        int i = 0;
        while (i < num && !lArray[i].getNom().equals(nom)) { i++; }
        if (i < num)  { return lArray[i]; }
        else { return null; }
    }
    
    /**
     * Torna una String amb tota la informacio de l'agenda.
     * El format es un contacte per linia (nom: telefon).
     * @return String.
     */
    public String toString() {
        String res = "";
        for (int i = 0; i < num; i++) { res += lArray[i] + "\n"; }   
        return res; 
    }  
    
    /**
     * Carrega els contactes de l'agenda a partir d'un fitxer de text.
     * @param f Scanner per a realitzar la lectura des de fitxer.
     */
    public void carregarFitxerText(Scanner f) {         
        while (f.hasNext()) {
            String linia = f.nextLine();
            String[] v = linia.split(":");            
            String nom = v[0];
            String telefon = v[1].trim();
            boolean nomNoValid = nom.length() < 1 || nom.length() > 40;
            boolean telNoValid = !telefon.matches("[0-9]+") 
                || telefon.length() != 9 || telefon.charAt(0) == '0';
            if (nomNoValid || telNoValid) {
                System.out.println("Linia no valida");
            }
            else {
                Contacte c = new Contacte(nom, telefon);
                if (this.getContacte(nom) != null) {
                    System.out.println("El nom " + nom + " ja existeix. "
                                       + "Contacte no inserit");
                }
                else { this.inserir(c); }
            }            
        }
    }
    
    /**
     * Guarda una agenda en un fitxer de text.
     * @param f PrintWriter per a realitzar l'escriptura en fitxer.
     */
    public void guardarFitxerText(PrintWriter f) {  
        /* Primera versio: toString() de Contacte */
        // for (int i = 0; i < num; i++) { f.println(lArray[i]); } 
        
        /* Segona versio: toString() de Agenda */
        if (num > 0) { f.print(this); }  
    }
    
    /**
     * Carrega els contactes de l'agenda a partir d'un fitxer binari d'objectes.
     * @param f ObjectInputStream per a realitzar la lectura des de fitxer.
     * @throws ClassNotFoundException.
     * @throws IOException.
     */
    public void carregarFitxerObjecte(ObjectInputStream f) 
        throws ClassNotFoundException, IOException {
        /* Primera versio: lectura d'objectes Contacte */
//         try {
//             while (true) {
//                 Contacte c = (Contacte) f.readObject();
//                 if (this.getContacte(c.getNom()) != null) {
//                     System.out.println("El nom " + c.getNom() 
//                         + " ja existeix. Contacte no inserit");
//                 }
//                 else { this.inserir(c); }               
//             }
//         } catch(EOFException e) {
//              System.out.println("\nFi de fitxer"); 
//         }
        
        /* Segona versio: lectura d'un objecte Agenda */
        Agenda a = (Agenda) f.readObject();
        for (int i = 0; i < a.num; i++) {
            if (this.getContacte(a.lArray[i].getNom()) != null) {
                System.out.println("El contacte " + a.lArray[i] 
                                   + " ja existeix. " 
                                   + "Contacte no modificat");            
            } 
            else { this.inserir(a.lArray[i]); }
        }
    }
    
    /**
     * Guarda una agenda en un fitxer binari d'objectes.
     * @param f ObjectOutputStream per a realitzar l'escriptura en fitxer.
     * @throws IOException.
     */
    public void guardarFitxerObjecte(ObjectOutputStream f) throws IOException {
        /* Primera versio: escriptura d'objectes Contacte */
       // for (int i = 0; i < num; i++) { f.writeObject(lArray[i]); }
        
        /* Segona versio: escriptura d'un objecte Agenda */
        f.writeObject(this);
    }
}
