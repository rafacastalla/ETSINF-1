import java.util.Scanner;
import java.util.Locale;
/**
 * PruebaIIPMath permite que el usuario compare el valor devuelto por
 * sus funciones sqrt(x) (raíz cuadrada de x) y log(x) (logaritmo natural de x)
 * conlos proporcionados por el Java en su librería Math.
 * 
 * @author (IIP-PRG-DSIC-ETSINF. pmarques)
 * @version (curs 2015-16)
 */
public class PruebaIIPMath {
    
    /** No se pueden crear objetos de este tipo. */
    private PruebaIIPMath() { }    
    
    public static void main(String[] args) {
        
        Scanner tcl = new Scanner(System.in).useLocale(Locale.US);
        
        System.out.println("Comparación de sqrt y log (IIPMath y Math).");
        System.out.println("Para acabar introduce un valor 0 o negativo.\n");
        
        System.out.print("Valor: ");
        double valor = tcl.nextDouble();        
        
        while (valor > 0) { 
            
            double xr1 = IIPMath.sqrt(valor);
            double xr2 = Math.sqrt(valor); 
            
            System.out.printf(Locale.US, "%14s %+1.16e %6s %+1.16e %8s %1.3g%n",
                            "RAÍZ-- IIPMath:", xr1, "Math:", xr2, "|Diff|:",
                            Math.abs(xr1 - xr2));
            
            double xl1 = IIPMath.log(valor);
            double xl2 = Math.log(valor);  
            
            System.out.printf(Locale.US, "%14s %+1.16e %6s %+1.16e %8s %1.3g%n",
                            "LOG -- IIPMath:", xl1, "Math:", xl2, "|Diff|:",
                            Math.abs(xl1 - xl2));
                
            System.out.printf("%1$20s %2$20s %2$20s%n", " ", 
                              "-----------------");
            
            System.out.print("Valor: ");
            valor = tcl.nextDouble();
        }
    }
         
            
}
