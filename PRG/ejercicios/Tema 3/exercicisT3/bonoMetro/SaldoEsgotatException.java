/**
 * Classe SaldoEsgotatException - excepcio llançada per 
 * BonoMetro quan al picar no queden viatges disponibles.
 * 
 * @author PRG 
 * @version Curs 2015/16
 */
public class SaldoEsgotatException extends Exception {
    
    public SaldoEsgotatException() { super(); }
    
    public SaldoEsgotatException(String msg) { super(msg); }
}
