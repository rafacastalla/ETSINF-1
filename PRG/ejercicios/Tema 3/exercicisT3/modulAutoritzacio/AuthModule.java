
/**
 * Classe AuthModule - implementa un modul d'autoritzacio 
 * basat en usuaris i contrassenyes registrats. 
 * 
 * @author PRG 
 * @version Curs 2015/16
 */
public class AuthModule {
    public static String user = "PEPE";
    public static String pass = "NABO";
    /**
     * Comprova si un usuari, de nom i contrassenya donats, 
     * esta registrat al sistema.
     * @param username String amb el nom d'usuari.
     * @param password String amb la contrassenya.
     * @throws InvalidUserException si el nom d'usuari no existeix.
     * @throws InvalidPasswordException si el nom d'usuari existeix pero 
     * la contrassenya no coincideix amb la registrada en el sistema.
     * @throws ExpirationDeadlineException si la contrassenya caduca en breu.
     */
    public static void check(String username, String password)
        throws InvalidUserException, InvalidPasswordException, 
        ExpirationDeadlineException {
         if(user != username){
             throw new InvalidUserException("usuari incorrecte");
         }else if(pass != password){
             throw new InvalidPasswordException("contraseña incorrecta");
         }
    }
}
