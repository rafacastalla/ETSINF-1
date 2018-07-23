/**
 * Classe InvalidPasswordException - excepcio llançada per 
 * AuthModule quan el nom d'usuari existeix pero la contrassenya 
 * no coincideix amb la registrada en el sistema.
 * 
 * @author PRG 
 * @version Curs 2015/16
 */
public class InvalidPasswordException extends Exception {
    
    public InvalidPasswordException() { super(); }
    
    public InvalidPasswordException(String msg) { super(msg); }
}
