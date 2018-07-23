/**
 * Classe AccessDeniedException - excepcio llançada per
 * GrantAccess quan el nom d'usuari no existeix o la 
 * contrassenya no coincideix amb la registrada al sistema.
 * 
 * @author PRG 
 * @version Curs 2015/16
 */
public class AccessDeniedException extends Exception {
    
    public AccessDeniedException() { super(); }
    
    public AccessDeniedException(String msg) { super(msg); }
}
