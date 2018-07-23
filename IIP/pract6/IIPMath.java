/**
 * La clase IIPMath implementa algunas operaciones matematicas:
 * IIPMath.sqrt(double) e IIPMath.log(double).
 *
 * @author ()
 * @version ()
 */
public class IIPMath {
    
    // A COMPLETAR
   public final static double LOG_2 = 0.6931471805599453;
        
    /**
     * Devuelve la raiz cuadrada de x >= 0, con error epsilon > 0. 
     * A COMPLETAR COMENTARIO
     */
    public static double sqrt(double x, double epsilon) {
      
       double tanterior;
          double tactual = (((1+x)/2) + (x/((1+x)/2)))/2;
         
         do{
             tanterior = tactual;
             tactual = ((tanterior +(x/tanterior))/2);
            }while(tanterior-tactual > epsilon);
              
        return tactual;
        
        
    }            

    /**
     * Devuelve la raiz cuadrada de x >= 0 con error 1e-15. 
     * A COMPLETAR COMENTARIO
     */
    public static double sqrt(double x) {    
     double epsilon = 1e-15;
      return sqrt(x,epsilon);
        
        
    }  
                    
    /* ******************************************************** */
    /* ******************************************************** */
    /* ******************************************************** */
                
    /**
     * Devuelve log(z), 1/2 <= z < 1, con error epsilon > 0.
     * A COMPLETAR COMENTARIO
     */
    public static double logBase(double z, double epsilon) {
        double y = (1-z)/(1+z);
        double ycuadrat = y*y;
        double tanterior=0;
          double tactual=y;
          int k=1;
          double suma =y;
        
         
         while(tactual > epsilon){
             tanterior = tactual;
             tactual = ycuadrat*(2*k-1)/(2*k+1)*tanterior;
            k++;
            suma += tactual;
            }
        return -2*suma;
        
    }
            
    /**
     * Devuelve log(x), x > 0, con error epsilon > 0.
     * A COMPLETAR COMENTARIO
     */
    public static double log(double x, double epsilon) {
        
        int m =0;
        double z = x;
        double devolver;
        if(z == 1){
              devolver = 0;
        }else {
          while (z >= 1){
              z = z / 2;
              m++;
            }
        
            while (z < 0.5){
                z = z * 2;
                m--;
            }
        }
        devolver = m * LOG_2 + logBase(z,epsilon);
        
        return devolver;
    }
   
    
    public static double log(double x) {    
        
      double epsilon = 1e-15;
        
        return log(x,epsilon);
                        
}
}