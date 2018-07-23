
/**
 * Classe GrantAccess - per a concedir l'acces al sistema.
 * 
 * @author PRG 
 * @version Curs 2015/16
 */
public class GrantAccess {
    
    /**
     * Mostra per pantalla un missatge indicant l'autoritzacio per
     * accedir al sistema a un usuari, de nom i contrassenya donats,
     * o el motiu pel qual no s'ha concedit l'acces.
     * @param username String amb el nom d'usuari.
     * @param password String amb la contrassenya.
     * @throws AccessDeniedException quan el nom d'usuari no existeix
     * o la contrassenya no coincideix amb la registrada al sistema.
     */
    public static void grantAccess(String username, String password)
        throws AccessDeniedException {
        try{
            boolean granted = true;
            
            AuthModule.check(username, password);
            System.out.println("Successfully authorized!");
        }catch(InvalidUserException e){
            System.out.println(e.getMessage());
        }catch(InvalidPasswordException e){
            System.out.println(e.getMessage());
        } 
    }
}
