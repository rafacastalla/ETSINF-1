import java.io.Serializable;
import java.util.Locale;
/**
 * Classe CompteAp per a representar un compte bancari amb la informació:
 * número, saldo i apunts (ingressos/reintegraments) realitzats.
 * @author PRG 
 * @version Curs 2015/16
 */
public class CompteAp extends Compte implements Serializable {

    /* COMPLETAR:  atribut apunts */
    CuaApunts apunts;

    /**
     * Constructor que, donats un número de compte i un saldo inicial, 
     * crea un compte, amb un apunt inicial d'ingres. 
     * @param numCompte 
     *      int que indica el número de compte associat a aquest compte.
     *      Ha de ser un enter amb 5 dígits.
     * @param saldoInicial 
     *      double que indica el saldo inicial del compte.
     *      Ha de ser un valor real >=0.
     */
    public CompteAp(int numero, double saldoInicial) {        
        /* COMPLETAR: cridar a constructor de Compte */
        super(numero, saldoInicial);
        /* COMPLETAR: crear la cua d'apunts */
        apunts = new CuaApunts();
        /* COMPLETAR: encuar un Apunt amb la descripció Ingres i la quantitat del saldo inicial */
        apunts.encuar(new Apunt(Apunt.INGRES, saldoInicial));
    }

    /**
     * Permet ingressar diners en el compte i afegir l'apunt.
     * Sobreescriu parcialment a ingressar(double) de Compte.
     * @param quantitat double que indica la quantitat a ingressar.
     *                 Ha de ser un valor real >=0.
     */    
    public void ingressar(double quantitat) {        
        /* COMPLETAR: cridar a ingressar de Compte */
        super.ingressar(quantitat);
        /* COMPLETAR: encuar un Apunt amb la descripció Ingres i la quantitat ingressada */
        apunts.encuar(new Apunt(Apunt.INGRES, quantitat));
    }

    /**
     * Permet retirar diners del compte i afegir l'apunt.
     * Sobreescriu parcialment a retirar(double) de Compte.
     * @param quantitat double que indica la quantitat a retirar.
     *                 Ha de ser un valor real >=0 i <=saldo. 
     */     
    public void retirar(double quantitat) {
        /* COMPLETAR: cridar a retirar de Compte */
        super.retirar(quantitat);
        /* COMPLETAR: encuar un Apunt amb la descripció Reintegrament i la quantitat retirada (amb signe -) */
        apunts.encuar(new Apunt(Apunt.REINTEGRAMENT, quantitat < 0 ? quantitat : -quantitat));
    }

    /**
     * Torna el número d'apunts del compte.
     * @return int, el número d'apunts.
     */
    public int getNumApunts() { /* COMPLETAR */ return apunts.talla();}
    
    /**
     * Torna una String amb la informació dels 
     * k ultims apunts realitzats en el compte.
     * El String resultat tindra k + 1 linies. El format
     * de la primera linia sera "Num. Apunts: k/X\n" indicant
     * que se consulten k dels X apunts del compte.
     * Les k linies seguents (una per cada apunt) constaran 
     * de la descripcio i la quantitat de l'apunt realitzat
     * (separats per ": ") i el saldo del compte despres de 
     * l'apunt. Per exemple, per a un compte amb 3 apunts en la 
     * que se consulten els 2 ultims, el String resultant seria:
     * "Num. Apunts: 2/3\n
     *         Ingres:      45.00   Saldo:     545.00\n
     *  Reintegrament:     -15.00   Saldo:     530.00\n"
     * @param k, int el numero d'apunts.
     * @return String.
     */
    public String ultimsApunts(int k) {
        /* COMPLETAR */
        String res = "";
        Apunt aux;
        double saldo = 0;
        
        if(apunts.esBuida()){
           res = "No hiha apunts"; 
        }else{
            res="Num. Apunts: " + k + "/"+getNumApunts()+"\n";
            
            for(int i=0; i<apunts.talla(); i++){
                aux = apunts.desencuar();
                
                if(i == 0){
                    saldo = aux.getQuantitat();
                }else{
                    saldo += aux.getQuantitat();
                }
                
                if(i > apunts.talla()-k){
                    res += aux + String.format(Locale.US, "   Saldo: %10.2f\n", saldo);
                }
                apunts.encuar(aux);
            }
        }
        
        return res;
    }
    
    /**
     * Torna una String amb la informacio de 
     * tots els apunts realitzats en el compte.
     * El String resultat tindra tantes linies com  
     * apunts mes 1. El format de la primera linia sera:
     * "Num. Apunts: X/X\n" sent X el numero total  
     * d'apunts del compte. Les linies seguents (una per 
     * cada apunt) constaran de la descripcio i la quantitat
     * de l'apunt realitzat (separats per ": ") i el saldo  
     * del compte despres de l'apunt. Per exemple, per a un
     * compte amb 3 apunts, el String resultant seria:
     * "Num. Apunts: 3/3\n
     *         Ingres:     500.00   Saldo:     500.00\n
     *         Ingres:      45.00   Saldo:     545.00\n
     *  Reintegrament:     -15.00   Saldo:     530.00\n"
     * @return String.
     */
    public String apunts() {
        /* COMPLETAR */
        return ultimsApunts(getNumApunts());
    }
    
    /**
     * Torna una String amb el resum del compte
     * (numero i saldo separats per un espai en blanc).
     * @return String.
     */
    public String resum() {
        /* COMPLETAR */
        return super.toString();
    }
    
    /**
     * Torna una String amb tota la informacio del compte.
     * Sobreescriu parcialment al toString() de Compte.
     * @return String.
     */
    public String toString() {
        /* COMPLETAR */
        return super.toString() + "\n" + apunts();
    }
}
