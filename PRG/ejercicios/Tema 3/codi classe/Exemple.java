import java.util.Scanner;
import java.util.InputMismatchException;

public class Exemple {
    
    private static Scanner teclat;
    
    private static int menu(String[] opcions)
                    throws ForaDelsLimitsException    {
       
        boolean eixir = false;
        int res = -1;
        do{            
            for (int i=0; i<opcions.length; i++){
                System.out.println(i + ".- " + opcions[i]);
            }            
            System.out.println("Trie opcio: ");
            try {
                res = teclat.nextInt();  //<- PERILL!!!          
                eixir = true;
            }     
            catch (InputMismatchException e){
                System.out.println("S'ha produit l'excepcio : " + e +
                                   ", trie un altra vegada");
            }
            finally { 
                System.out.println("----------"); 
                teclat.nextLine(); 
            }
        } while (!eixir);
        if (res<0 || res >=opcions.length) {
            throw new ForaDelsLimitsException(res + " esta Fora dels Limits");
        }
        return res;
    }
    public static void main (String[] args){
        teclat = new Scanner(System.in);
        String[] opcions = {"cargar","guardar","buscar","salir"};
        int i;
        try{  
            i = menu(opcions); 
             System.out.println("Opcio triada: "+ opcions[i]); 
        }
        catch (ForaDelsLimitsException e) {
            System.out.println(e.getMessage());
        }  
//         catch (InputMismatchException e){
//                 System.out.println("S'ha produit l'excepcio : " + e +
//                                    ", trie un altra vegada");
//             }
        
    }
}
