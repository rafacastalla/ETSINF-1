import java.io.*;
public class GestorProva{
    public static void main(String[] args) {
        ItemAgenda i1 = new ItemAgenda("CarlesPla", "622115611", 46022);
        ItemAgenda i2 = new ItemAgenda("Olivia", "963221153", 46010);
        ItemAgenda i3 = new ItemAgenda("Joan Duato", "913651228", 18011);
        Agenda a1 = new Agenda();
        a1.insertar(i1); a1.insertar(i2); a1.insertar(i3);
        // Guardarimostrarl’Agendaa1:
        a1.guardarAgenda("agenda1.dat");
        System.out.println("AGENDA EMMAGATZEMADA:");
        System.out.println(a1);
        // Recuperardel fitxerimostrarl’Agendallegida:
        Agenda rec= Agenda.recuperarAgenda("agenda1.dat");
        System.out.println("AGENDA RECUPERADA:"); System.out.println(rec);
    }
} // fide la classeGestorProva