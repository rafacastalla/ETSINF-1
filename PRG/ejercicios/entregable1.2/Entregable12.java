/**
 * Classe Entregable12: metodes recursius numerics, 
 * amb arrays i amb Strings.
 * 
 * @author (ESCRIU ACI Cognoms i nom del/s autor/s) 
 * @version Tema 1 - Sessio 6
 */
public class Entregable12 {
    private Entregable12() { }
    /** Torna un String amb una linia de n >= 0 asteriscs,
     *  acabada per un caracter de canvi de linia.
     *  Precondicio: n >= 0 
     */
    public static String tornaLinia(int n) {
        String res;
        if (n == 0) { res = "\n"; }
        else {
            res = "*" + tornaLinia(n - 1);
        }
        return res;
    }
    
    /** Torna un String que conté un triangle rectangle de n >= 1 
     *  linies d'amplaries decreixents d'asteriscs. 
     *  Exemple la crida trgSuperior(4) tornaria el String
     *  "****\n***\n**\n*\n"
     *  que escrit per pantalla seria:
     *  ****
     *  ***
     *  **
     *  *
     *  nota: Fa servir el metode tornaLinia(int). 
     *  Precondicio: n>=1
     */
    public static String trgSuperior(int n) {
        String res = "";
        if (n == 1) { res = tornaLinia(n); }
        else {
            res = tornaLinia(n) + trgSuperior(n-1);
        }
        return res;        
    }
    
    /** Torna un String que conté un triangle rectangle de n >= 1 
     *  linies d'amplaries decreixents d'asteriscs. 
     *  Exemple la crida trgSuperior(4) tornaria el String
     *  "*\n**\n***\n****\n"
     *  que escrit per pantalla seria:
     *  *
     *  **
     *  ***
     *  ****
     *  nota: Fa servir el metode tornaLinia(int). 
     *  Precondicio: n>=1
     */
    public static String trgInferior(int n) {
        String res = "";
        if (n == 1) { res = tornaLinia(n); }
        else {
            res = trgInferior(n-1) + tornaLinia(n);
        }
        return res;        
    }
    
    /** Comprova si les components de l'array a d'enters
     *  formen una progressio geometrica de rao x.
     *  Precondicio: a.lentgh > 0, pos > 0, x != 0
     *  Crida inicial: progressioGeometrica(a, x, 1);
     */
    public static boolean progressioGeometrica(int[] a, int x, int pos) {
        boolean res = false; 
        if (pos >= a.length-1) {
            res = true;
        } else{
            res = a[pos] == a[pos - 1] * x && progressioGeometrica(a, x, pos + 1);
        }
        
        return res;
    }
    
    /** Metode llançadera para comprovar si les components
     * de l'array a d'enters formen una progressio geometrica 
     * de rao x
     * COPIA LA CRIDA INICIAL INDICADA ABANS
     */
    public static boolean progressioGeometrica(int[] a, int x) {
        boolean res = false; 
        res = progressioGeometrica(a, x, 1);
        return res;
    }
    
    
    /** Torna la String inversa de s.
     *  Precondicio: s !null
     */
    public static String inversa(String s) {
        String res = "";
        if(!s.isEmpty()){res= inversa(s.substring(1)) + s.substring(0,1);}
       return res; 
    }
    
}
