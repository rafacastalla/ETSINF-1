/**
 * Classe InvalidUserException excepcio llançada per 
 * AuthModule quan el nom d'usuari no existeix al sistema.
 * 
 * @author PRG 
 * @version Curs 2015/16
 */
public class InvalidUserException extends Exception {
    
    public InvalidUserException() { super(); }
    
    public InvalidUserException(String msg) { super(msg); }
}
