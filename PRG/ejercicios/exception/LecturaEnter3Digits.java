import java.util.Scanner;
/**
 *  Classe LecturaEnter3Digits: lectura d'un enter de 3 dígits.
 *  MANEL LURBE SEMPERE 
 *  @version Curs 2015/16
 */
public class LecturaEnter3Digits {
	/**
     * Llig des d'un Scanner i torna un valor enter en l'interval [lInf..lSup].
     * @param t Scanner per a lectura des de teclat.
     * @param m String per a petició de valor.
     * @param lInf int que indica el límit inferior de l'interval de lectura.
     * @param lSup int que indica el límit superior de l'interval de lectura. 
     * @return int, enter llegit en l'interval [lInf..lSup].
     */
    public static int llegirInt(Scanner t, String m, int lInf, int lSup) {
        System.out.print(m);
        int res = t.nextInt();
        return res;
    }
    
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        int num = llegirInt(tec, "Introdueix un número de 3 dígits: ", 
                            100, 999);
        System.out.println("El número llegit és: " + num);
    }
}