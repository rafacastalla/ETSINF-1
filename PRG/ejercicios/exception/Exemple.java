import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Write a description of class Exemple here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exemple
{
    private static String teclat;
    public static int menu(String[] opcions){
        boolean eixir = false;
        int res=-1;
       
        do{
        for(int i=0; i<opcions.length; i++){
            System.out.println(i+".-" + opcions[i]);
        }
        System.out.println("tria opcio: ");
        try{
        res = teclat.nextInt();//<--perill
        eixir = true;
    }
    catch(InputMismatchException e){
        System.out.println("S'ha produit l'excepció: " + e +
        ", trie una altra vegadda");
    }
    finally{
        System.out.println("----------------------");
        teclat.nextLine();
    }
    }while(!eixir);
    return res;
  }
  public static void main(String[] args){
      teclat = new Scanner(System.in);
      String[] opcions ={"cargar","guardar","buscar","salir"};
      System.out.println("opcio triada "+ opcions[menu(opcions)]);
  }
}
