/**
 * Classe ExpirationDeadlineException - excepcio llançada per 
 * AuthModule quan la contrassenya caduca en breu.
 * Es una subclasse de RuntimeException, per tant, es una 
 * excepcio no comprovada.
 * @author PRG 
 * @version Curs 2015/16
 */
public class ExpirationDeadlineException extends RuntimeException {
    
    public ExpirationDeadlineException() { super(); }
    
    public ExpirationDeadlineException(String msg) { super(msg); }
}
