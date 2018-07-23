import java.util.*;
import java.io.*;
import lectura.LecturaValida;
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
        CompteAp compte = null, enc = null;
        
        int op, numCompte;
        double quantitat;
        boolean hiHaError = false;
        
        do {
            op = menu(tec);
            hiHaError = false;
            
            switch(op) {
                
                case 1: // Crear un nou compte
                    do {
                        numCompte = getNumCompte(tec);
                        enc = banc.getCompte(numCompte);
                        if (enc != null) {                       
                            System.out.println(ERR + "Compte " + numCompte + " ja existeix!\n"); 
                        }
                    } while (enc != null);
                    
                    quantitat = getQuantitat(tec);             
                    compte = new CompteAp(numCompte, quantitat);
                    banc.inserir(compte);
                    System.out.println(INFO + compte + "\n");
                    
                    break;
                   
                case 2: // Ingressar en el compte actiu
                    try {
                        quantitat = getQuantitat(tec);
                        compte.ingressar(quantitat);
                        hiHaError = false;
                        System.out.println(INFO + compte + "\n");
                        
                    } catch (NullPointerException e) {
                        System.out.println("ERROR: No hi ha cap compte actiu! Primer busca'l o crea un nou compte");   
                    }
                    
                    break;
            
                case 3: // Retirar del compte actiu
                    try {
                        quantitat = getQuantitat(tec);
                        compte.retirar(quantitat);
                        hiHaError = false;
                        System.out.println(INFO + compte + "\n");
                        
                    } catch (NullPointerException e) {
                        System.out.println("ERROR: No hi ha cap compte actiu! Primer busca'l o crea un nou compte");   
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());   
                    }
                    
                    break;
                
                case 4: // Buscar compte
                    numCompte = getNumCompte(tec);
                    enc = banc.getCompte(numCompte);
                    
                    if (enc != null) {
                        compte = enc;
                        System.out.println(INFO + compte + "\n");
                    } else {
                        System.out.println(ERR + "Compte " + numCompte + " no trobat!\n");                
                    }
                    
                    break;
            
                case 5: // Mostrar el compte actiu
                    try {
                        String c = compte.toString();
                        hiHaError = false;
                        System.out.println(INFO + compte + "\n");
                        
                    } catch (NullPointerException e) {
                        System.out.println("ERROR: No hi ha cap compte actiu! Primer busca'l o crea un nou compte");   
                    }
                    
                    break;
                
                case 6: // Mostrar tots els comptes
                    System.out.print("\n\nTOTS ELS COMPTES: \n" + banc + "\n\n");
                    break;
                    
                case 7: // Carregar comptes
                    
                    Scanner f = null;
                    
                    try{
                        System.out.println("Nom del fitxer? ");
                        String nomFitxer = tec.nextLine();
                        
                        
                        File file = new File(nomFitxer);
                        f = new Scanner(file).useLocale(Locale.US);
                        
                        banc.carregarFormatText(f);
                        
                    }catch(FileNotFoundException e){
                        System.out.println("Error: " + e);
                        
                    }catch(InputMismatchException e){
                        System.out.println("Error: " + e);
                        
                    }finally{
                        if(f != null){ f.close();}
                    }
                    break;
                    
                case 8: // Carregar comptes
                    
                    PrintWriter pw = null;
                    
                    try{
                        System.out.println("Nom del fitxer? ");
                        String nomFitxer = tec.nextLine();
                        
                        File file = new File(nomFitxer);
                        pw = new PrintWriter(file);
                        
                        banc.guardarFormatText(pw);
                        
                    }catch(FileNotFoundException e){
                        System.out.println("Error: " + e);
                        
                    }catch(InputMismatchException e){
                        System.out.println("Error: " + e);
                        
                    }finally{
                        if(pw != null){ pw.close();}
                    }
                    break;
                    
                case 9:
                    
                    ObjectOutputStream os = null;

                    try{
                        System.out.println("Nom del fitxer");
                        String nom = tec.nextLine();
                        
                        os = new ObjectOutputStream(new FileOutputStream(nom));
                        
                        banc.guardarFormatObjecte(os);
                        
                    }catch(FileNotFoundException e){
                        System.out.println("No s'ha trobat el fitxer");
                        
                    }catch(IOException e){
                        System.out.println("Error" + e);
                        
                    }finally{
                        try{
                            if(os != null) os.close();
                            
                        }catch(IOException e){
                            System.out.println("El fitxer no s'ha pogut tancar");
                        }
                    }
                   
                    break;
                    
                case 10: 
                    
                    ObjectInputStream is = null;

                    try{
                        System.out.println("Nom del fitxer");
                        String nom = tec.nextLine();
                        
                        is = new ObjectInputStream(new FileInputStream(nom));
                        
                        banc.carregarFormatObjecte(is);
                        
                    }catch(FileNotFoundException e){
                        System.out.println("No s'ha trobat el fitxer");
                        
                    }catch(ClassNotFoundException e){
                        System.out.println("Error" + e);
                        
                    }catch(IOException e){
                        System.out.println("Error" + e);
                        
                    }finally{
                        try{
                            if(is != null) is.close();
                            
                        }catch(IOException e){
                            System.out.println("El fitxer no s'ha pogut tancar");
                        }
                    }
                    
                    break;
                    
                case 11: // Cancel.lar compte
                    numCompte = getNumCompte(tec);
                    enc = banc.getCompte(numCompte);
                    
                    if (enc != null) {
                        banc.cancelar(numCompte);
                    } else {
                        System.out.println(ERR + "Compte " + numCompte + " no trobat!\n");                
                    }
                    
                    break;
                
                case 12: // Mostrar ultims k apunts
                    if(compte == null){
                        System.out.println("No hiha un compte actiu");
                    }else{
                        int numApunts = getNumApunts(tec, compte);
                        System.out.println(compte.ultimsApunts(numApunts));
                    }
                    break;
                    
                case 0: // Finalitzar  
                    System.out.println("\n\nFi!");
                    break;
                    
                default:
                    System.out.println(ERR + "Opcions correctes: [0..6]\n");
            }
        } while (op != 0 && !hiHaError);
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
        System.out.println(" 7) Carregar comptes de fitxer de text");
        System.out.println(" 8) Guardar comptes en fitxer de text");
        System.out.println(" 9) Guardar comptes en fitxer binari");
        System.out.println(" 10) Carregar comptes de fitxer binari");
        System.out.println(" 11) Cancel.lar compte");
        System.out.println(" 12) Mostrar el ultims k apunts del compte actiu");
        System.out.println("---------------------------------");        
        int opcio = LecturaValida.llegirInt(tec, "    Tria una opció (0 - 12): ", 0, 12);
        System.out.println("");
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
    
    private static int getNumApunts(Scanner tec, CompteAp compte){
        int numCompte = LecturaValida.llegirInt(tec,
                                                "\nIntrodueix"
                                                + " el número de" 
                                                + " apunts a mostrar "
                                                + "(del 1 al " + compte.getNumApunts() + "): ",
                                                1, compte.getNumApunts());
        return numCompte;
    }
       
}
