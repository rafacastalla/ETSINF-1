/** Classe AlgorismesMesurables: classe d'utilitats amb els metodes a analitzar.
 * @author PRG ETSInf
 * @version Curs 2015-2016
 */
public class AlgorismesMesurables {

    /** Cerca lineal
     *  @param a array d'enters
     *  @param e element a buscar
     *  @return int, posicio d'e en a o -1 si e no esta en a
     */
    public static int cercaLineal(int[] a, int e) {
        int i = 0;
        while (i < a.length && (a[i] != e)) { i++; }
        if (i < a.length) { return i; }
        else { return -1; }
    }
  
    /** Metode d'ordenacio per seleccio
     *  @param a array d'enters
     */
    public static void seleccio(int[] a) {
        int posMin, aux;
        for (int i = 0; i < a.length - 1; i++) {
            posMin = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[posMin]) { posMin = j; }
            }
            aux = a[posMin];
            a[posMin] = a[i];
            a[i] = aux;
        }
    }
  
    /** Metode d'ordenacio per insercio
     *  @param a array d'enters
     */
    public static void insercio(int[] a) {
        int aux;
        for (int i = 1; i < a.length; i++) {
            int j = i - 1; aux = a[i];
            while (j >= 0 && a[j] > aux) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = aux;
        }
    } 
  
    /** mergeSort: metode d'ordenacio
     *  @param a array d'enters
     *  @param i posicio inicial a considerar
     *  @param f posicio final a considerar
     */ 
    public static void mergeSort(int[] a, int i, int f) {
        int h;
        if (i < f) {
            h = (f + i) / 2;
            mergeSort(a, i, h);
            mergeSort(a, h + 1, f);
            mesclaNatural(a, i, h, f);
        }
    }

    /** Mescla natural per a mergesort
     *  @param a array d'enters
     *  @param i posicio inicial a considerar
     *  @param f posicio final a considerar
     *  @param h posicio meitat a considerar
     */ 
    private static void mesclaNatural(int[] a, int i, int h, int f) {
        int[] aux = new int[f - i + 1];
        int k = 0, iaux = i, jaux = h + 1, kaux;
        while (iaux <= h && jaux <= f) {
            if (a[iaux] < a[jaux]) { aux[k] = a[iaux]; iaux++; }
            else { aux[k] = a[jaux]; jaux++; }
            k++;
        }
        while (iaux <= h) { aux[k] = a[iaux]; iaux++; k++; }
        while (jaux <= f) { aux[k] = a[jaux]; jaux++; k++; }

        kaux = 0;
        for (iaux = i; iaux <= f; iaux++) {
            a[iaux] = aux[kaux];
            kaux++;
        }
    }
}
