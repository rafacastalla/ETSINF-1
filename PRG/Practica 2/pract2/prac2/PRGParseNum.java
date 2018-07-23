
/**
 * PRGParseNum: Pràctica 2 de PRG, curs 2015-16.
 * 
 * @author (professors IIP - PRG) 
 * @version (curs 2015-16)
 */
public class PRGParseNum {
    
    /*************************** CODI INICIAL  ***************************/
    
    public final static char PUNT = '.';  // Separador part fraccionària.
    public final static char COMA = ',';  // Separador part fraccionària.
    public final static char EXP1 = 'e';  // Separador part exponencial.
    public final static char EXP2 = 'E';  // Separador part exponencial.
    public final static int  BASE = 10;   // Base de numeració per defecte.
    
    /**
     * Torna l'enter associat al caràcter - dígit en c.
     * @param c: char.
     * @return int: valor del dìgit.
     * PRECONDICIÓ: '9' >= c >= '0'
     */
    public static int parseDig(char c) {
        return c - '0';
        // alternativament, es pot fer servir:
        // return Character.getNumericValue(c);
    }
    
    
    /************************* EXEMPLES INICIALS *************************/    
       
    /** Retorna la suma dels dígits continguts en la String que rep.
     * @param s: Cadena de caràcters sobre els quals s'opera.
     * @return int. */
    public static int sumaDigits(String s) {
        // Cas base: String buida
        if (s.length() == 0) { return 0; }
        else {
        // Cas general: String no buida. Tractar substring posterior.
            char c = s.charAt(0);
            if (c >= '0' && c <= '9') {
                return (c - '0') + sumaDigits(s.substring(1));
            }
            else { return sumaDigits(s.substring(1)); }
        }
    }
        
    /** Retorna la suma dels dígits en la String s des de la posició pos.
     * PRECONDICIÓ: pos >= 0.
     * @param s: Cadena de caràcters sobre els quals s'opera.
     * @param pos: posició en s des d'on es treballa.
     * @return int. */
    public static int sumaDigits(String s, int pos) {
        // Cas base: String buida
        if (pos >= s.length()) { return 0; }
        else {
        // Cas general: String no buida. Tractar substring posterior.
            char c = s.charAt(pos);
            if (c >= '0' && c <= '9') {
                return (c - '0') + sumaDigits(s, pos + 1);
            }
            else { return sumaDigits(s, pos + 1); }
        }
    } 
    
    /** Retorna la suma dels dígits continguts en la String que rep.
     * @param s String s: Cadena de caràcters sobre els quals s'opera.
     * @return int. */
    public static int sumaDigits2(String s) {
        // Cas base: String buida
        if (s.length() == 0) { return 0; }
        else {
        // Cas general: String no buida. Tractar substring anterior.
            int len = s.length();
            char c = s.charAt(len - 1);
            if (c >= '0' && c <= '9') {
                return (c - '0') + sumaDigits(s.substring(0, len - 1));
            }
            else { return sumaDigits(s.substring(0, len - 1)); }
        }
    }  
    
    /******************  PROBLEMA A: parseInt(String s) ******************/
        
    /** 
     * PRECONDICIÓ: s conté un enter, >= 0, ben format. 
     */
    public static int parseUnsignedInt(String s) {
        int retornar;
            if(s.length()==1){
                retornar =parseDig(s.charAt(0));
            }else if(s.length()==0){
               retornar = 0;
            }else{
                 retornar = 10 * parseUnsignedInt(s.substring(0, s.length()-1)) + parseDig(s.charAt(s.length()-1)) ;
            }
            return retornar;
    }  
    
    /** 
     * PRECONDICIÓ: s conté un enter, pot ser amb signe, ben format. 
     */    
    public static int parseInt(String s) {
       int retornar = 0;
       if(!s.isEmpty()){
            if(s.charAt(0)=='-'){
           retornar = -1 * parseUnsignedInt(s.substring(1));
        }else if(s.charAt(0)=='+'){
           retornar = parseUnsignedInt(s.substring(1));
        }else{
            retornar = parseUnsignedInt(s);
        }
        
    } 
    return retornar;
}
    
    /****************  PROBLEMA B: parseDouble(String s) *****************/    
    
    /** 
     * PRECONDICIÓ: s conté un nombre en coma flotant ben format. */
    public static int posFracSep(String s) {
        int retornar = -1;
        if(!s.isEmpty()){
            if(s.charAt(s.length()-1) == PUNT || s.charAt(s.length()-1)==COMA){
            retornar = s.length()-1;
            }else if(s.length() > 1){
                retornar = posFracSep(s.substring(0,s.length()-1));
            }
    }
    return retornar;
    }
    
    /** 
     * PRECONDICIÓ: s, conté els dìgits de la part fraccionària
     * d'un valor double ben format. 
     */
    public static double parseFrac(String s) {
        double retornar;
        
        if(posFracSep(s) == -1){
                        retornar = 0.0;
        }else{
           int pos= posFracSep(s);
            int despues=parseUnsignedInt(s.substring(posFracSep(s)+1));
           retornar = despues/(Math.pow(10,(s.length()-1)-pos));
             
        }
        return retornar;
    }
    
    /** 
     * PRECONDICIÓ: s conté un double, ben format, pot ser amb signe, 
     * que pot tenir (o no) part fraccionària. No conté part exponencial.
     */  
    public static double parseDouble(String s)   {
        double retornar =0;
          if(posFracSep(s)!=-1){
          retornar= (double)parseInt(s.substring(0,posFracSep(s)))+parseFrac(s);
        }else{
            retornar= (double)parseInt(s);
        }
        return retornar;
    }
    
    
    /*******************  AMPLIACIONS RECOMANADES  ********************/
    
    
    
    
    
}
