import java.util.Scanner;
import java.util.Locale;
/** Classe VendaEntrades.
 *  Practica 5 - IIP - ETSINF - UPV
 *  
 *  @author  
 *  @version Curs 2015/16
 */
public class VendaEntrades {

    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in).useLocale(Locale.US);

        // Lectura de les dades i creacio de l'Entrada
        System.out.println("Caracteristiques de l'entrada: ");
        System.out.print(" Titol: ");
        String titol = teclat.nextLine();
        System.out.println( " Cinema: ");
        String cinema = teclat.nextLine();
        System.out.println( " Hora: ");
        int hora = teclat.nextInt();
        System.out.println( " Minuts: ");
        int minuts = teclat.nextInt();
   
        Entrada e = new Entrada(titol, cinema, hora, minuts);

        // Lectura de dades per a aplicar descomptes
        // variables a utilitzar inicialitzades per defecte a false
        boolean diaEspectador = false, festiu = false, 
                vespra = false, targetaClient = false;
        
        System.out.print("Edat? ");
        int edat = teclat.nextInt();
        if (edat >= e.SENIOR) { }
        else /*edat < 65*/{
            System.out.print("Es el dia de l'espectador? ");
            String res = teclat.next();
            if (res.equals("SI")) {diaEspectador = true;}
            else { 
                System.out.println(" Es festiu? ");
                String resu = teclat.next();
                if (resu.equals("SI")) {festiu = true;}
                else { 
                    System.out.println(" Es vespra de festiu? ");
                    String resul = teclat.next();
                    if (resul.equals("SI")) {vespra = true;}
                
                }
                 System.out.println(" Eres soci i client? ");
                 String result = teclat.next();
                 if (result.equals("SI")) targetaClient = true;
            }
        }
    
        // Calcul del preu final de l'Entrada e, 
        // invocant al metode preuFinal
        double pFinal = e.preuFinal(edat, diaEspectador, festiu, vespra, targetaClient);

        System.out.println("El preu final de l'entrada es: "  
                           + String.format("%.2f", pFinal) + " euros");
    }
}