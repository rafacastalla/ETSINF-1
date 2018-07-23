import java.util.Scanner;
import java.util.Locale;
import java.util.InputMismatchException;
/**
 * Classe LecturaValida: classe d'utilitats per a realitzar la lectura
 * vàlida de dades de tipus primitius des de l'entrada estàndard.
 * 
 * @author PRG 
 * @version Curs 2015/16
 */
public class LecturaValida {

    /**
     * Llig des d'un Scanner i torna un valor real positiu.
     * @param tec Scanner per a lectura des de teclat.
     * @param missatge String per a petició de valor.
     * @return double, real positiu llegit.
     */    
    public static double llegirDoublePos(Scanner tec, String missatge) {
        double res = 0.0;
        do {
            System.out.print(missatge);
            res = tec.nextDouble();
            tec.nextLine();
        } while (res < 0);
        return res;
    }

    /**
     * Llig des d'un Scanner i torna un valor enter.
     * @param tec Scanner per a lectura des de teclat.
     * @param missatge String per a petició de valor.
     * @return int, enter llegit.
     */
    public static int llegirInt(Scanner tec, String missatge) {
        int res = 0;
        boolean hiHaError = true; 
        do {
            try {
                System.out.print(missatge);
                res = tec.nextInt();
                hiHaError = false;
            } catch (InputMismatchException e) {
                System.out.println("Asegura't d'introduir un enter vàlid!"
                                   + " Intenta-ho de nou ...");   
            } finally {
                tec.nextLine();
            }
        } while (hiHaError);
        return res;
    }

    /**
     * Llig des d'un Scanner i torna un valor enter en l'interval 
     * [lInferior..lSuperior]  tal que Integer.MIN_VALUE<=lInferior 
     * i lSuperior<=Integer.MAX_VALUE.
     * @param tec Scanner per a lectura des de teclat.
     * @param missatge String per a petició de valor.
     * @param lInferior int que indica el límit inferior de l'interval
     * de lectura.
     * @param lSuperior int que indica el límit superior de l'interval
     * de lectura.
     * @return int, enter llegit en l'interval [lInferior..lSuperior].
     */    
    public static int llegirInt(Scanner tec, String missatge, int lInferior,
                                int lSuperior) {
        int res = 0;
        System.out.print(missatge);
        res = tec.nextInt(); 
        tec.nextLine();
        return res;
    }  
   
}