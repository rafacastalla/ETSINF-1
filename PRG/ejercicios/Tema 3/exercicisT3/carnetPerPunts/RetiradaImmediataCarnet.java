/**
 * Classe RetiradaImmediataCarnet - excepcio llançada per 
 * CarnetDeConduir quan el nombre de punts es zero o negatiu.
 * 
 * @author PRG 
 * @version Curs 2015/16
 */
public class RetiradaImmediataCarnet extends Exception {
    
    public RetiradaImmediataCarnet() { super(); }
    
    public RetiradaImmediataCarnet(String msg) { super(msg); }
}
