/**
 * Classe-programa per a provar totes les figures definides.
 * Tambén es pot fer una execució pareguda utilitzando
 * el <B>workbench</B> del BlueJ.
 * @author IIP 
 * @version Pràctica 2 - Curs 2015/16
 */
public class ProgramaProva {

    public static void main(String[] args) {        
        // Inicialitzar el lloc de dibuix, donant-li
        // un nom i dimensions:
        Pissarra meuaPissarra = new Pissarra("UNA FINESTRA AL MON", 500, 300);
                
        // Inicialitzar un cercle groc:
        Cercle c = new Cercle(50, "groc", 100, 100);
        // ficar-lo a l'espai de dibuix:
        meuaPissarra.add(c);
        
        // mostrar per pantalla el perímetre del cercle:
        System.out.println("El perímetre del cercle és " + c.perimetre());
              
        // Inicialitzar un rectangle llarg i roig:
        Rectangle r = new Rectangle(100, 10, "roig", 50, 155);
        // ficar-lo a l'espai de dibuix:
        meuaPissarra.add(r);  
        
        // Inicialitzar un triangle isòsceles negre:
        TrIsosceles t = new TrIsosceles(30, 60, "negre", 210, 60);
        // ficar-lo a l'espai de dibuix:
        meuaPissarra.add(t);          
    }
    
} // de ProgramaProva

