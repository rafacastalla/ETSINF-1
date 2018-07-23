/**
 * Classe Pelicules
 * 
 * @author PRG
 * @version Curs 2015/16
 */
public class Pelicules {
    
    /**
     * Mostra, donat un llistat d'actors i una pel.licula,
     * el repartiment d'actors de la pel.licula.
     * @param llista Actor[] amb una llista d'actors.
     * @param pelicula String amb el titol d'una pel.licula.
     */
    public static void mostrarRepartiment(Actor[] llista, String pelicula) {
        for (int i = 0; i <= llista.length; i++) {
            if (llista[i].getPelicula() == pelicula) {
                System.out.println(llista[i].toString());
            }
        }
    }
    
}
