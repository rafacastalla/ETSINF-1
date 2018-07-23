/** Classe MesuraOrdenacio: Estudi empiric de costs dels metodes d'ordenacio.
 *  @author PRG ETSInf
 *  @version Curs 2015-2016
 */
class MesuraOrdenacio {
    // Constants que defineixen els parametres de mesura
  
    /* Genera un array d'int de talla t amb valors compresos entre 0 i t-1.
     * @param int la talla
     * @result int[] l'array generat
     */
    private static int[] crearArrayAleatori(int t) { 
        // Completar        
    }
  
    /* Genera un array d'int de talla t ordenat de forma creixent.
     * @param int la talla
     * @result int[] l'array generat
     */
    private static int[] crearArrayOrdCreixent(int t) { 
        // Completar        
    }

    /* Genera un array d'int de talla t ordenat de forma decreixent.
     * @param int la talla
     * @result int[] l'array generat
     */
    private static int[] crearArrayOrdDecreixent(int t) { 
        // Completar        
    }

    public static void mesuraSeleccio() { 
        // Completar
    }

    public static void mesuraInsercio() { 
        // Completar
    }
  
    public static void mesuraMergeSort() { 
        // Completar
    }

    public static void us() {
        System.out.println("Us: java MesuraOrdenacio numero_algorisme");
        System.out.println("   on numero_algorisme es:");
        System.out.println("   1 -> Insercio");
        System.out.println("   2 -> Seleccio");
        System.out.println("   3 -> MergeSort");
    }

    public static void main(String[] args) {        
        if (args.length != 1) {
            us();            
        }
        else {
            try {
                int a = Integer.parseInt(args[0]);
                switch (a) {
                    case 1: 
                        mesuraInsercio();
                        break;
                    case 2: 
                        mesuraSeleccio();
                        break;
                    case 3: 
                        mesuraMergeSort();
                        break;
                    default: 
                        us();
                }
            } catch (Exception e) {
                us(); 
            }
        }
    }
}
