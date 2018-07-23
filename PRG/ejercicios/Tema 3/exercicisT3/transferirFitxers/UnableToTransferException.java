/**
 * Classe UnableToTransferException - excepcio llançada per 
 * CopyViaFTP quan no es pot fer la transferencia.
 * 
 * @author PRG 
 * @version Curs 2015/16
 */
public class UnableToTransferException extends Exception {
    
    public UnableToTransferException() { super(); }
    
    public UnableToTransferException(String msg) { super(msg); }
}
