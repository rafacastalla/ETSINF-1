// Importa la classe Graph2D (en el paquet graphIIP).
import graphIIP.Graph2D;
// Importa la classe Color (en el paquet java.awt) per poder
// canviar els colors dels elements que es representen.
import java.awt.Color;

/**
 * Graph2DTest prova simple de la classe Graph2D.
 * Dibuixa les funcions Math.sin(x) i Math.sin(x)/x.
 * 
 * @author (IIP-PRG-DSIC-ETSINF. pmarques)
 * @version (curs 2015-16)
 */
public class Graph2DTest {
        
    /** Dibuixar sin(x) i sin(x)/x amb
     * x en [-1.0: +PI*4] i f(x) en [-1.10 : +1.10].
     * Representació mitjançant punts consecutius.
     */    
    public static void test1() {
        double xMin = -1.0;
        double xMax = Math.PI * 4;
        double yMin = -1.10;
        double yMax = +1.10;
        
        Graph2D gd1 = new Graph2D(xMin, xMax , yMin, yMax);
                                    
        double delta = (xMax - xMin) / Graph2D.INI_WIDTH;        
        for (double x = xMin; x <= xMax; x = x + delta) {
            double y = Math.sin(x);
            gd1.drawPoint(x, y, Color.BLUE, 2);
        }
        
        // Canviar el color amb el que es dibuixa d'ara endavant:
        gd1.setForgrColor(Color.GREEN);
        // Canviar la grossària d'ara endavant:
        gd1.setThickness(3);
        for (double x = xMin; x <= xMax; x = x + delta) {
            double y = Math.sin(x) / x;
            gd1.drawPoint(x, y);
            
            // o equivalentment (sense canviar valors abans):
            // gd1.drawPoint(x, y, Color.GREEN, 2);
        }        
    }
    
    public static void main(String[] argv) {
        // Executar el test 1:
        test1();
    }
 
}
