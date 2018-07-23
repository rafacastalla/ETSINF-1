
/**
 * Write a description of class MeuPrograma here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MeuPrograma {
    public static void main(String[] args) {  
      //creem una pissarra
      Pissarra manelPissarra = new Pissarra("Pissarra Manel", 500, 300);
      //fem un cercle
      Cercle c1 = new Cercle(25, "groc",55,55);
      //el posem en la pissarra
      manelPissarra.add(c1);
      //creem un rectangle
      Rectangle r1 = new Rectangle(45, 75, "negre", 100, 145);
      //el posem en la pissarra
      manelPissarra.add(r1);
      //creem un triangle
      TrIsosceles t1 = new TrIsosceles(75, 45, "roig", 100, 75);
      //triangle a la pissarra
      manelPissarra.add(t1);
    }
}
