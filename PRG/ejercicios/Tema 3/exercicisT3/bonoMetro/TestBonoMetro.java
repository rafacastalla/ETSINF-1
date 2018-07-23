/**
 * Classe TestBonoMetro - permet comprovar la funcionalitat
 * de la classe BonoMetro.
 * 
 * @author PRG 
 * @version Curs 2015/16
 */
public class TestBonoMetro {
    public static void main(String[] args){
        BonoMetro b = new BonoMetro(3);
        try{
            for (int i = 1; i <= 4; i++) {
                System.out.println("Picant el viatge #" + i);
                b.picar();            
            }
        }catch(SaldoEsgotatException e){
            System.out.println(e.getMessage());
        }
    }    
}
