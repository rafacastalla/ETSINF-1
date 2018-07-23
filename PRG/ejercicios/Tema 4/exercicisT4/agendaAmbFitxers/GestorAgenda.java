import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Classe GestorAgenda: llanca l'aplicacio de simulacio d'una agenda telefonica,
 * presentant a l'usuari en mode text una interficie basica amb la qual aquest 
 * pot manipular la seua agenda. Per aixo, el seu unic metode public es el main 
 * i en ell es descriuen via menu les opcions de treball que permet l'aplicacio.
 * 
 * @author PRG
 * @version Curs 2015/16
 */
public class GestorAgenda {
    private static final String ERR = "\n***ERROR***: No s'ha pogut ";
    private static final String TANCAR = "tancar el fitxer ";
    private static final String ACCE = "accedir al fitxer ";
    private static final String LLEGIR = "llegir del fitxer ";
    private static final String TIPUS = "llegir per tipus erroni en ";
    private static final String CREAR = "crear el fitxer ";
    private static final String ESCR = "escriure en el fitxer ";
    
    /** 
     *  Programa principal.
     *  @param args String[] 
     */ 
    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        Agenda agendaMeua = new Agenda();
        
        int opc;        
        do {
            opc = menu(teclat);
            switch(opc) {
                case 1: // Mostrar contactes
                    System.out.println("\n" + agendaMeua);
                    break;                        
                case 2: // Afegir un contacte
                    inserirContacte(agendaMeua, teclat);  
                    break;                        
                case 3: // Consultar un contacte
                    recuperarContacte(agendaMeua, teclat);
                    break; 
                case 4: // Carregar agenda des de fitxer        
                    System.out.print("\nNom de fitxer: ");
                    String nomFitxEnt = teclat.nextLine(); 
                        
                    /* Versio fitxer de text */                        
//                Scanner fEnt = null;
//                try {
//                    fEnt = new Scanner(new File(nomFitxEnt));
//                    agendaMeua.carregarFitxerText(fEnt); 
//                } catch (FileNotFoundException e) {
//                    System.out.println(ERR + ACCE + nomFitxEnt);
//                } finally {
//                    if (fEnt != null) fEnt.close();
//                }    
//                break;
                        
                    /* Versio fitxer binari d'objectes */                    
                    ObjectInputStream fEnt = null;
                    try {
                        fEnt = new ObjectInputStream(
                                   new FileInputStream(nomFitxEnt));
                        agendaMeua.carregarFitxerObjecte(fEnt);   
                    } catch (FileNotFoundException e) { 
                        System.out.println(ERR + ACCE + nomFitxEnt);
                    } catch (ClassNotFoundException e) { 
                        System.out.println(ERR + TIPUS + nomFitxEnt);
                    } catch (IOException e) {
                        System.out.println(ERR + LLEGIR + nomFitxEnt);
                    } finally {
                        try {
                            if (fEnt != null) { fEnt.close(); }
                        } catch (IOException e) {
                            System.out.println(ERR + TANCAR + nomFitxEnt);
                        }
                    } 
                    break; 
                    
                case 5: // Guardar agenda en fitxer
                    System.out.print("\nNom de fitxer: ");
                    String nomFitxSort = teclat.nextLine();  
                        
                    /* Versio fitxer de text */                        
//                  PrintWriter fSort = null;
//                  try {
//                      fSort = new PrintWriter(new File(nomFitxSort));
//                      agendaMeua.guardarFitxerText(fSort); 
//                  } catch(FileNotFoundException e) {
//                      System.out.println(ERR + ESCR + nomFitxSort);
//                  } finally {
//                      if (fSort != null) { fSort.close(); }
//                  }
//                  break;   

                    /* Versio fitxer binari d'objectes */
                    ObjectOutputStream fSort = null;
                    try {                            
                        fSort = new ObjectOutputStream(
                                    new FileOutputStream(nomFitxSort));
                        agendaMeua.guardarFitxerObjecte(fSort);  
                    } catch (FileNotFoundException e) {
                        System.out.println(ERR + CREAR + nomFitxSort);
                    } catch (IOException e) {
                        System.out.println(ERR + ESCR + nomFitxSort);
                    } finally {
                        try {
                            if (fSort != null) { fSort.close(); }
                        } catch (IOException e) { 
                            System.out.println(ERR + TANCAR + nomFitxSort);
                        }
                    } 
                    break;     
                        
                case 0: // Finalitzar
                    System.out.println("\nAgenda tancada.");
            }        
        } while (opc != 0);
    }
    
    /** 
     *  Presenta un menu d'opcions per pantalla.
     *  @param teclat Scanner per fer la lectura de l'opcio 
     *  triada des de teclat.  
     *  @return int, torna l'opcio valida triada per l'usuari 
     *  d'entre les opcions possibles.
     */  
    private static int menu(Scanner teclat) {
        int opcio;
        do {
            System.out.println("\n                MENÚ");
            System.out.println("---------------------------------------");
            System.out.println("| 1.- Mostrar contactes               |");
            System.out.println("| 2.- Afegir un contacte              |");
            System.out.println("| 3.- Consultar un contacte           |");
            System.out.println("| 4.- Carregar agenda des de fitxer   |");
            System.out.println("| 5.- Guardar agenda en fitxer        |");
            System.out.println("| 0.- Finalitzar                      |");
            System.out.println("---------------------------------------");
            System.out.print("Tria una opcio: ");
            opcio = teclat.nextInt(); 
            teclat.nextLine();
            if (opcio < 0 || opcio > 5) {
                System.out.println("Opcio incorrecta, torna a intentar-ho");
            }
        } while (opcio < 0 || opcio > 5);
        return opcio;        
    }
    
    /**
     * Metode que afegeix un nou contacte a l'agenda donada.
     * @param a Agenda on s'afegeix un nou contacte.
     * @param teclat Scanner per fer la lectura de dades.
     */
    private static void inserirContacte(Agenda a, Scanner teclat) {
        String nom, telefon;
        // Filtre de dades: Un nom valid per a un Contacte de l'agenda pot 
        // estar compost per qualsevol caracter PERO CAL que tinga una longitud 
        // en l'interval [1...40] i no pot estar repetit
        do {
            System.out.print("\nNom del nou contacte " 
                             + "(minim una lletra i maxim 40): "); 
            nom = teclat.nextLine().trim();
        } while (nom.length() < 1 || nom.length() > 40 
                 || a.getContacte(nom) != null);
        
        // Filtre de dades: Un telefon valid per a un Contacte de l'agenda 
        // CAL que estiga compost per 9 caracters de l'interval ['0'..'9']  
        // PERO el primer d'ells NO pot ser el zero
        do { 
            System.out.print("Telefon del nou contacte (9 digits, "
                             + "el primer d'ells no pot ser 0): "); 
            telefon = teclat.nextLine().trim();
        } while (!telefon.matches("[0-9]+") || telefon.length() != 9 
                 || telefon.charAt(0) == '0');
        
        // Filtre de dades: la forma d'escriure un nom, amb o sense majuscules, 
        // no pot originar informacio redundant en l'agenda, es a dir, no pot  
        // donar lloc a contactes repetits. Per aixo, en l'agenda figuren els 
        // noms dels contactes en majuscules <--> qualsevol nom de contacte que 
        // es llija de teclat es passa a majuscules usant el metode toUpperCase 
        // de la classe String 
        Contacte nou = new Contacte(nom.toUpperCase(), telefon);
        a.inserir(nou);
    }
    
    /**
     * Metode que recupera la informacio associada a un nom d'un contacte de 
     * l'agenda donada.
     * @param a Agenda d'on es recupera un telefon.
     * @param teclat Scanner per fer la lectura de dades.
     */
    private static void recuperarContacte(Agenda a, Scanner teclat) {  
        final String MSG = "A la teua agenda no figura "
                         + "cap contacte amb aquest nom.";
        String nom;
        // Filtre del nom
        do {
            System.out.print("\nNom del contacte del qual " 
                             + "vols coneixer el telefon: "); 
            nom = teclat.nextLine().trim();  
        } while (nom.length() < 1 || nom.length() > 40);
        // Filtre del nom (toUpperCase)
        Contacte c = a.getContacte(nom.toUpperCase()); 
        if (c != null) { System.out.println(c); }
        else {
            System.out.println(MSG);
        }
    }
    
}
