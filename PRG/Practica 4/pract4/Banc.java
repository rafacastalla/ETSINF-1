/**
 * Classe Banc per a representar un conjunt de comptes.
 * @author PRG 
 * @version Curs 2015/16
 */
import java.util.*;
import java.io.*;


public class Banc implements Serializable{
    
    public final static int MAX_COMPTES = 100;
    /** Array d'objectes Compte. */
    private Compte[] comptes;
    /** Número actual de comptes i primer índex disponible a l'array comptes. */
    private int numComptes;
    /** Número màxim de comptes. */

    /**
     * Crea un banc sense comptes (pot tenir un màxim de MAX_COMPTES comptes).
     */
    public Banc() {
        this.comptes = new Compte[MAX_COMPTES];
        this.numComptes = 0;
    }

    /**
     * Consultor del número actual de comptes.
     * @return int, número actual de comptes.
     */
    public int getNumComptes() { return numComptes; }
    
    /**
     * Permet inserir el Compte c al banc. Si el banc està complet,
     * duplica el número de comptes que poden haver al banc.
     * @param c Compte a inserir.
     */
    public void inserir(Compte c) {
        if (numComptes >= comptes.length) { duplica(); }  
        comptes[numComptes++] = c;
    }
    
    /**
     * Duplica la grandària de l'array comptes.
     */
    private void duplica() {
        Compte[] aux = new Compte[2 * comptes.length];
        for (int i = 0; i < comptes.length; i++) { aux[i] = comptes[i]; }
        comptes = aux;
    }

    /**
     * Torna el compte amb número de compte n.
     * Si aquest comtpe no existeix, torna null.
     * @param n int que indica el número de compte.
     * @return Compte, el comtpe resultat.
     */
    public Compte getCompte(int n) {
        int i = 0;
        while (i < numComptes && comptes[i].getNumCompte() != n) { i++; }
        if (i < numComptes) { return comptes[i]; }
        else { return null; }
    }

    /**
     * Torna una String amb tota la informació del banc.
     * El format és un compte per línia.
     * @return String.
     */
    public String toString() {
        if (numComptes == 0) { return "No hi ha comptes al banc"; }
        else {
            String res = "";
            for (int i = 0; i < numComptes; i++) { res += comptes[i] + "\n"; }
            return res;
        }
    }
    
    public void carregarFormatText(Scanner f){
        int num;
        double saldo;
        
        Compte compte;
        
        do{
            try{
                num = f.nextInt();
                saldo = f.nextDouble();
                f.nextLine();
                
                if(num < 10000 || num > 99999){
                    System.out.println("Numero ha de tindre 5 digits");
                }else if(saldo < 0){
                     System.out.println("Saldo negatiu");
                }else if(getCompte(num) != null){
                    System.out.println("Conter ja creat");
                }else{
                    compte = new Compte(num, saldo);
                    this.inserir(compte);
                }
                
            }catch(InputMismatchException e){
                f.nextLine();
                System.out.println("Error en les dades");
            }catch(NumberFormatException e){
                System.out.println("Error carregant dades");
            }
        }while(f.hasNext());
    }
    
    public void guardarFormatText(PrintWriter pw){
        if(numComptes > 0){
            pw.println(this.toString());
        }
    }
    
    public void guardarFormatObjecte(ObjectOutputStream os) throws IOException{
        
        if(numComptes > 0){
            os.writeObject(this);
        }
    }
    
    public void carregarFormatObjecte(ObjectInputStream is) throws IOException, ClassNotFoundException{
        
        Banc b = new Banc();
        b = (Banc)is.readObject();
        
        for(int i=0; i<b.getNumComptes(); i++){
            if(getCompte(b.comptes[i].getNumCompte()) == null){
                inserir(b.comptes[i]);
            }
        }
    }
}
