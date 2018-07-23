import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *  Classe Test: lectura d'un enter i divisió.
 *  MANEL LURBE SEMPERE 
 *  @version Curs 2015/16
 */
public class Test {
  public static void main(String[] args) {
      Scanner tec = new Scanner(System.in);
      boolean valor_correcte=false;
      do{
          try {
            System.out.print("Introdueix un enter: ");
            int valor = tec.nextInt();
            valor_correcte=true;
            System.out.println("DivisiÃ³: " + 5 / valor);
          } catch (InputMismatchException e) {
            System.out.println("AtenciÃ³: no Ã©s un enter");
            valor_correcte=false;
          } catch (ArithmeticException e) {
            System.out.println("AtenciÃ³: no es pot dividir per 0");
            valor_correcte=false;
          } finally {
            tec.nextLine();
         }
      }while(!valor_correcte);
  }
}