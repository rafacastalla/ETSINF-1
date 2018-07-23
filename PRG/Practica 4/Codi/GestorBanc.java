import java.util.Scanner;
import java.util.Locale; 
/**
 * Classe GestorBanc: clase que prova les classes Banc i Compte. 
 * Utilitza un sistema de menús per a permetre a l'usuari provar 
 * i interactuar amb aquestes classes.
 * @author PRG 
 * @version Curs 2015/16
 */
public class GestorBanc {
    
    private static final String INFO = "Informació del compte: ";
    private static final String ERR = "\n***ERROR***: ";

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in).useLocale(Locale.US);        
        Banc banc = new Banc();              
        Compte compte = null, enc = null;
        int op, numCompte;
        double quantitat;
        
        do {
            op = menu(tec);
            switch(op) {
                case 1: // Crear un nou compte
                    do {
                        numCompte = getNumCompte(tec);
                        enc = banc.getCompte(numCompte);
                        if (enc != null) {                       
                            System.out.println(ERR + "Compte "
                                               + numCompte
                                               + " ja existeix!\n"); 
                        }
                    } while (enc != null);   
                    quantitat = getQuantitat(tec);             
                    compte = new Compte(numCompte, quantitat);
                    banc.inserir(compte);
                    System.out.println(INFO + compte + "\n");                
                    break;
                   
                case 2: // Ingressar en el compte actiu
                    quantitat = getQuantitat(tec);
                    compte.ingressar(quantitat);
                    System.out.println(INFO + compte + "\n");
                    break;
            
                case 3: // Retirar del compte actiu
                    quantitat = getQuantitat(tec);
                    if (quantitat <= compte.getSaldo()) {
                        compte.retirar(quantitat);
                    } else { System.out.println("Saldo insuficient"); }   
                    System.out.println(INFO + compte + "\n");
                    break;
                
                case 4: // Buscar compte
                    numCompte = getNumCompte(tec);
                    enc = banc.getCompte(numCompte);
                    if (enc != null) {
                        compte = enc;
                        System.out.println(INFO + compte + "\n");
                    } else {
                        System.out.println(ERR + "Compte " + numCompte 
                                           + " no trobat!\n");                
                    }
                    break;
            
                case 5: // Mostrar el compte actiu
                    String c = compte.toString();
                    System.out.println(INFO + compte + "\n");
                    break;
                
                case 6: // Mostrar tots els comptes
                    System.out.print("\n\nTOTS ELS COMPTES: \n" + banc 
                                     + "\n\n");
                    break;
            
                case 0: // Finalitzar  
                    System.out.println("\n\nFi!");
                    break;
                default:
                    System.out.println(ERR + "Opcions correctes: [0..6]\n");
            }
        } while (op != 0);
    }

    /**
     * Mostra un menú d'opcions per pantalla i permet 
     * que l'usuari trie una d'elles.
     * @param tec Scanner per a realitzar la lectura.
     * @return int, enter que representa l'opció triada.
     */
    private static int menu(Scanner tec) {
        System.out.println("------------- MENU --------------");
        System.out.println(" 0) Finalitzar");
        System.out.println(" 1) Crear una nou compte");
        System.out.println(" 2) Ingressar en el compte actiu");
        System.out.println(" 3) Retirar del compte actiu");
        System.out.println(" 4) Buscar compte");
        System.out.println(" 5) Mostrar el compte actiu");
        System.out.println(" 6) Mostrar tots els comptes");
        System.out.println("---------------------------------");        
        int opcio = LecturaValida.llegirInt(tec, "    Tria una opció (0 - 6): ",
                                            0, 6);         
        return opcio;
    }
 
    /**
     * Realitza la lectura d'una quantitat vàlida (un valor real >=0).
     * @param tec Scanner per a realitzar la lectura.
     * @return double, real >=0 que representa la quantitat llegida.
     */
    private static double getQuantitat(Scanner tec) {        
        double quantitat = LecturaValida.llegirDoublePos(tec,
                                                         "\nIntrodueix"
                                                         + " la quantitat: "); 
        return quantitat;
    }
  
    /**
     * Realitza la lectura d'un número de compte vàlid (un valor enter
     * de 5 dígits).
     * @param tec Scanner per a realitzar la lectura.
     * @return int, enter de 5 dígits que representa el número 
     * de compte llegit.
     */
    private static int getNumCompte(Scanner tec) {        
        int numCompte = LecturaValida.llegirInt(tec,
                                                "\nIntrodueix"
                                                + " el número de" 
                                                + " compte (de 5 dígits): ",
                                                10000, 99999); 
        return numCompte;
    }
       
}
