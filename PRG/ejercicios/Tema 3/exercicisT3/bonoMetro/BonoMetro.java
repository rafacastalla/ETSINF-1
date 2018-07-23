/**
 * Classe BonoMetro: representa el títol de transport 
 * amb el que se pot viatjar al metro.
 * 
 * @author PRG 
 * @version Curs 2015/16
 */
public class BonoMetro {
    /** Quantitat per defecte de recàrrega */ 
    public static final int BONO_10 = 10;
    // Un BonoMetro TÉ UN ...
    private int numTiquets;

    /** Crea un BonoMetro amb n tiquets.
     *  @param n int amb el nombre de tiquets.
     */
    public BonoMetro(int n) { numTiquets = n; }
    
    /** Crea un BonoMetro, per defecte, amb 10 tiquets. */
    public BonoMetro() { this(BONO_10); }

    /** Torna el número de viatges disponibles.
     *  @return int, els viatges disponibles.  
     */
    public int getNumTiquets() { return numTiquets; }

    /** Carrega el bonometro amb una quantitat donada de viatges.
     *  @param quantitat int amb el nombre de viatges a carregar.  
     */
    public void recarregar(int quantitat) { numTiquets += quantitat; }

    /** Torna un String amb la informació del bonometro.
     *  @return String.  
     */
    public String toString() { 
        return "Bono amb " + numTiquets + " viatges"; 
    }

    /** Si queden viatges, actualitza el nombre de tiquets 
     *  i torna el missatge "Bono amb xxx tiquets". Si no queden 
     *  viatges torna el missatge "Bono esgotat. Recàrrega'l JA!" 
     *  @return String. 
     */
    public String picar() throws SaldoEsgotatException{          
                if (numTiquets > 0) {
                    numTiquets--;
                    return this.toString();  
                }
                else { 
                    throw new SaldoEsgotatException("Bono esgotat. Recàrrega’l JA!");
                }          
    }    
}
