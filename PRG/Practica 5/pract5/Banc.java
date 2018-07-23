/**
 * Classe Banc per a representar un conjunt de comptes.
 * @author PRG 
 * @version Curs 2015/16
 */
import java.util.*;
import java.io.*;


public class Banc implements Serializable{
    NodeCompte primer;
    
    /** Número actual de comptes i primer índex disponible a l'array comptes. */
    private int numComptes;
    
    /**
     * Crea un banc sense comptes (pot tenir un màxim de MAX_COMPTES comptes).
     */
    public Banc() {
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
    public void inserir(CompteAp c) {
        NodeCompte actual = primer;
        NodeCompte anterior = null;
        
        while (actual != null && actual.dada.getNumCompte() < c.getNumCompte()){  
            anterior = actual;
            actual = actual.seguent;
        }
        
        NodeCompte nou = new NodeCompte(c, actual);
        if (anterior != null){
             anterior.seguent = nou;
        }else{
            primer = nou;
        }
        numComptes ++;
    }

    /**
     * Torna el compte amb número de compte n.
     * Si aquest comtpe no existeix, torna null.
     * @param n int que indica el número de compte.
     * @return Compte, el comtpe resultat.
     */
    public CompteAp getCompte(int n) {
        NodeCompte aux = primer;
        NodeCompte anterior = null;
        
        while (aux != null && aux.dada.getNumCompte() != n && aux.dada.getNumCompte() < n){  
            anterior = aux;
            aux = aux.seguent;
        }
        
        if(aux != null && aux.dada.getNumCompte() == n){
            return aux.dada;
        }else{
            return null;
        }
    }
    
    public boolean cancelar(int n){
        NodeCompte aux = primer;
        NodeCompte anterior = null;
        
        while (aux != null && aux.dada.getNumCompte() != n && aux.dada.getNumCompte() < n){  
            anterior = aux;
            aux = aux.seguent;
        }
        
        if(aux != null && aux.dada.getNumCompte() == n){
            if(anterior != null){
                anterior.seguent = aux.seguent;
            }else{
                primer = aux.seguent;
            }
            numComptes--;
            return true;
        }else{
            return false;
        }
    }

    /**
     * Torna una String amb tota la informació del banc.
     * El format és un compte per línia.
     * @return String.
     */
    public String toString() {
        NodeCompte aux = primer;
        
        if (numComptes == 0) { return "No hi ha comptes al banc"; }
        else {
            String res = "";
            while (aux != null){
                res += aux.dada + "\n";
                aux = aux.seguent;
            }
            return res;
        }
    }
    
    public void carregarFormatText(Scanner f){
        int num, numApunts;
        double quantitat, saldo;
        
        String[] llegir, aux;
        String line, tipo;
        
        Double[] accio, saldos;
        
        CompteAp compte = null;
        
        
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
                    
                    line = f.nextLine();
                    llegir = line.split("/");
                        
                    numApunts = Integer.parseInt(llegir[1]);
                    
                    for(int i=0; i<numApunts; i++){
                        line = f.nextLine();
                    }
                    f.nextLine();
                    
                }else{
                    
                    line = f.nextLine();
                    llegir = line.split("/");
                        
                    numApunts = Integer.parseInt(llegir[1]);
                    
                    for(int i=0; i<numApunts; i++){
                        line = f.nextLine();
                        llegir = line.split(":");
                        
                        tipo = llegir[0];
                        
                        aux = llegir[1].split("S");
                            
                        quantitat = Double.parseDouble(aux[0]);
                        
                        saldo = Double.parseDouble(llegir[2]);
                        
                        if(i == 0){
                            compte = new CompteAp(num, quantitat);
                            this.inserir(compte);
                        }else{
                            if(tipo.trim().equals(Apunt.INGRES)){
                                compte.ingressar(quantitat);
                            }else if(tipo.trim().equals(Apunt.REINTEGRAMENT)){
                                compte.retirar(quantitat*(-1));
                            }
                        }
                    }
                    f.nextLine();
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
        
        NodeCompte aux = b.primer;
        
        while (aux != null){
            
            if(getCompte(aux.dada.getNumCompte()) == null){
                inserir(aux.dada);
            }
            aux = aux.seguent;
        }
    }
}
