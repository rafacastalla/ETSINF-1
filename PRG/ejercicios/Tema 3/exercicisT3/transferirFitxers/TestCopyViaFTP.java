/**
 * Classe TestCopyViaFTP - permet fer la transferencia 
 * del fitxer /tmp/data a la màquina fileserver.upv.es. 
 * En cas d’error, l'operació s'haurà de reintentar un màxim 
 * de 3 vegades i indicar a l'usuari el número d'intent.
 * @author PRG 
 * @version Curs 2015/16
 */
public class TestCopyViaFTP {
    
    public static void main(String[] args) {
        try{
            String hostName = "fileserver.dsic.upv.es";
            String localFilePath = "/tmp/data";
                    
            CopyViaFTP.copyTo(hostName, localFilePath); 
        }catch(UnableToTransferException e){
            System.out.println(e.getMessage());
        }
    }

}
