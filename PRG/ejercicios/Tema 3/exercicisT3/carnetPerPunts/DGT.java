import java.util.Scanner;
/**
 * Classe DGT - per a aplicar la penalitzacio a un CarnetDeConduir.
 * 
 * @author PRG 
 * @version Curs 2015/16
 */
public class DGT {
    
    /**
     * Aplica la penalitzacio a un carnet de conduir donat i 
     * mostra per pantalla un missatge d'error si la penalitzacio 
     * de punts comporta la retirada immediata del carnet.
     * @param c CarnetDeConduir al que s'aplica la penalitzacio.
     * @param tec Scanner per a llegir des de l'entrada estandard.
     */
    public static void multar(CarnetDeConduir c, Scanner tec){
        try{
            System.out.print("Introdueix la penalització: ");
            int penalitzacio = tec.nextInt();
            
            c.llevarPunts(penalitzacio);    
        }catch(RetiradaImmediataCarnet e){
            System.out.print(e.getMessage());
        }
    }    
    
}
