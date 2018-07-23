/** Classe MesuraOrdenacio: Estudi empiric de costs dels metodes d'ordenacio.
 *  @author PRG ETSInf
 *  @version Curs 2015-2016
 */
import java.util.*;

class MesuraOrdenacio {
    // Constants que defineixen els parametres de mesura
    public static final int MAXTALLA = 100000, INITALLA = 10000; 
    public static final int INCRTALLA = 10000, REPETICIONS = 50;
    public static final double NMS = 1e3;  // relacio micro - nanosegons
  
    /* Genera un array d'int de talla t amb valors compresos entre 0 i t-1.
     * @param int la talla
     * @result int[] l'array generat
     */
    private static int[] crearArrayAleatori(int t) { 
        int[] a = new int[t];
        
        for (int i = 0; i < t; i++) {
            a[i] = (int) Math.floor(Math.random() * t);
        }
        return a;      
    }
  
    /* Genera un array d'int de talla t ordenat de forma creixent.
     * @param int la talla
     * @result int[] l'array generat
     */
    private static int[] crearArrayOrdCreixent(int t) { 
        int[] a = new int[t];
        
        for (int i = 0; i < t; i++) {
            a[i] = i;
        }
        return a;
    }

    /* Genera un array d'int de talla t ordenat de forma decreixent.
     * @param int la talla
     * @result int[] l'array generat
     */
    private static int[] crearArrayOrdDecreixent(int t) { 
        int[] a = new int[t];
        
        for (int i = 0; i < t; i++) {
            a[i] = t-i;
        }
        return a;     
    }

    public static void mesuraSeleccio() {
        
        long ti = 0, tf = 0, tt = 0; // Temps inicial, final i total        
        // Imprimir capçalera de resultats
        System.out.println("# Ordenacio Seleccio. Temps en microsegons");
        System.out.println("# Talla    Promedi  ");
        System.out.println("#-------------------");
        
        int t = 0;
        double temps = 0;
        
        for(t = INITALLA; t <= MAXTALLA; t += INCRTALLA){
            
            int[] a;
            
            tt = 0;
            for (int r = 0; r < REPETICIONS; r++) {
                a = crearArrayAleatori(t);
                ti = System.nanoTime();      // Temps inicial
                AlgorismesMesurables.seleccio(a);
                tf = System.nanoTime();      // Temps final
                tt += (tf - ti);             // Actualitzar temps acumulat
            }
            temps = temps + (double) tt / REPETICIONS;  // Temps promedi
            
            System.out.printf(Locale.US, "%8d   %6.2f\n", t, temps / NMS);
        }
    }

    public static void mesuraInsercio() { 
        long ti = 0, tf = 0, tt = 0; // Temps inicial, final i total        
        // Imprimir capçalera de resultats
        System.out.println("# Ordenacio insercio. Temps en microsegons");
        System.out.println("# Talla    Pitjor   Millor   Promedi");
        System.out.println("#--------------------------------------");

        // Aquest bucle repeteix el proces per a distintes talles
        for (int t = INITALLA; t <= MAXTALLA; t += INCRTALLA) {
            // Crear l'array
            int[] a;
      
            // Estudi del cas pitjor: cercar un que no estiga, per exemple -1
            tt = 0;                          // Temps acumulat inicial a 0
            for (int r = 0; r < REPETICIONS; r++) {
                a = crearArrayOrdDecreixent(t);
                ti = System.nanoTime();      // Temps inicial
                AlgorismesMesurables.insercio(a);
                tf = System.nanoTime();      // Temps final
                tt += (tf - ti);             // Actualitzar temps acumulat
            }
            double tPitjor = (double) tt / REPETICIONS;  // Temps promedi 
                                                         // del cas pitjor
            
            // Estudi del cas millor: cercar a[0]
            // OJO: Com es massa rapid, les repeticions s'inclouen 
            // en la mesura de temps
            tt = 0;
            for (int r = 0; r < REPETICIONS; r++) {
                a = crearArrayOrdCreixent(t);
                ti = System.nanoTime();      // Temps inicial
                AlgorismesMesurables.insercio(a);
                tf = System.nanoTime();      // Temps final
                tt += (tf - ti);             // Actualitzar temps acumulat
            }
            double tMillor = (double) tt / REPETICIONS; // Temps promedi 
                                                               // del cas millor
            
            // Estudi del cas promedi: cercar un numero aleatori entre 0 i t-1
            tt = 0;                        // Temps acumulat inicial a 0
            for (int r = 0; r < REPETICIONS; r++) {
                a = crearArrayAleatori(t);
                ti = System.nanoTime();  // Temps inicial
                AlgorismesMesurables.insercio(a);
                tf = System.nanoTime();  // Temps final
                tt += (tf - ti);         // Actualitzar temps acumulat
            }
            double tPromed = (double) tt / REPETICIONS; // Temps promedi 
                                                        // del cas promedi

            // Imprimir resultats
            System.out.printf(Locale.US, "%8d   %6.2f     %4.2f  %8.2f\n", 
                              t, tPitjor / NMS, tMillor / NMS, tPromed / NMS);
        }
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
