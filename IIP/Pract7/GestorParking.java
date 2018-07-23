import java.util.Scanner;
import java.util.Locale;
/** Clase GestorParking: gestor d'un parking.
  * @author IIP
  * @version Curs 2015/2016
  */
public class GestorParking {
    private static int numPlantes = 5;  
    private static int llocs = 4; 
    private static double cost = 0.05;
    public static Parking park = new Parking(numPlantes, llocs, cost);
    
    /**
     * Mostra un menu d'opcions per pantalla i
     * llig des de teclat una opcio valida.
     * @param tec Scanner que representa el teclat.
     * @return int, opcio valida.
     */  
  private static int menu(Scanner t){
     int opc = 0;
        do {
            System.out.println("\n********* PARKING **********");
            System.out.println(" 1. Entrar cotxe: si el parking no es ple:");
            System.out.println(" 2. Eixir cotxe:");
            System.out.println(" 3. Cercar cotxe:");
            System.out.println(" 4. Mostrar ocupació:");
            System.out.println(" 5. Buidar parking:");
            System.out.println(" 6. Finalitzar aplicació:");
            System.out.println("*****************************");
            System.out.print("Tria una opció: ");
            opc = t.nextInt();
            t.nextLine();
            if (opc < 1 || opc > 6) {
                System.out.println("\nOpcio incorrecta.\n");
            }
        } while (opc < 1 || opc > 6);
        return opc;
    
    }

    /**
     * Lectura des de teclat d'una hora valida.
     * @param tec Scanner que representa el teclat.
     * @return Hora, hora valida.
     */
     private static Hora llegirHora(Scanner tec){
    int h,m;
    do{ 
        System.out.println("Hora: ");
        h = tec.nextInt();
        if(h>23 || h<0){
            System.out.println("Entre 0 i 23");
        }
    }while(h>23 || h<0);
    do{
        System.out.println("Minuts: ");
        m=tec.nextInt();
        if(m>59 || m<0){
            System.out.println("entre 0 i 59");
        }
    }while(m>59 || m<0);
    Hora hora=new Hora(h,m);
    return hora;
  }
    /**
     * Metode principal.
     * @param args String[].  
     * @throws Exception si ocorre algun error d'entrada/eixida.
     */
    public static void main(String [] args) throws Exception {
        Scanner tec = new Scanner(System.in).useLocale(Locale.US);
        int opcio;
        do {
            opcio = menu(tec);
            switch (opcio) {
                case 1: 
                    if(!park.esPle()){
                        System.out.println("\n Matricula del Cotxe:");
                        String mat = tec.nextLine();
                        if(park.cercarCotxe(mat)== null){
                            Hora h = llegirHora(tec);
                            int p =-1;
                            while(p < 0 || p > park.getNumPlantes()){
                                System.out.println("dona un numero de planta vàlid");
                                p = tec.nextInt();
                            }
                            park.entrarCotxe(mat,h,p); 
                            Lloc l = park.cercarCotxe(mat);
                            System.out.println("El teu cotxe està a la planta " + l.getPlanta() +
                            " i al lloc " + l.getLloc());
                        }
                        else{
                            System.out.println("El cotxe ja està en el parking");    
                        }
                    }                       
                    else{
                        System.out.println("No queden llocs lliures en el parking");
                    }
                    break;                        
                case 2: 
                    System.out.println("\n Matricula del Cotxe:");
                    String mat = tec.nextLine();  
                    if(park.cercarCotxe(mat)==null){
                        System.out.println("El cotxe no està al parking");
                    }
                    else{
                        Lloc l = park.cercarCotxe(mat);
                        Hora h = llegirHora(tec);
                        double d = park.eixirCotxe(mat, h);
                        
                        System.out.println("El teu cotxe ha eixit de la planta " + l.getPlanta() +
                            " i al lloc " + l.getLloc() + "a les "+ h + "h i amb un cost de "
                            + d + "€");
                    }
                    break;                        
                case 3: 
                    System.out.println("Matricula del Cotxe:"); 
                    String ma = tec.next();
                    if(park.cercarCotxe(ma) != null){
                        Lloc l = park.cercarCotxe(ma);
                        System.out.println("El teu cotxe està a la planta " + l.getPlanta() +
                            " i al lloc " + l.getLloc());
                    }
                    else{
                        System.out.println("El cotxe no està en el parking");
                    }
                    break;                                               
                case 4: 
                    System.out.println(park.toString());
                    break;  
                case 5: 
                    System.out.println("El parking ja està buit, hem recaudat " + park.buidarParking() + "€");
                    break; 
                case 6: 
                    System.out.println("\n*** Fi Gestor ***");
                    break; 
                default: 
                    System.out.println("\n*** Fi Gestor ***");
            }
        } while (opcio != 6); 
    }
  
}
