import java.util.Scanner;
import java.util.Locale;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.EOFException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
/**
 * Write a description of class exercicis here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class exercicis{
    
    public static void main(String[] args){
        try{
            mostra1InfFitxer("hola.txt");
        }catch(FileNotFoundException e){
            System.out.println("Fitcher no trobat");
        }
        
    }
    
    public static void mostra1InfFitxer(String dir)throws FileNotFoundException{
        File f = new File(dir);
        
        System.out.println(f.getAbsolutePath() + " " + f.length());
    }
    
    public static void escriureBinariNums()throws FileNotFoundException, IOException{
        String fitxer = "holabinari.txt";
        int i = 1;
        ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream(new File(fitxer)));
        while(i<=999){
            out.writeInt(i);
            i++;
        }
        out.close();
    }
    
    public static void llegirBinari()throws FileNotFoundException, IOException{
        String fitxer = "holabinari.txt";
        ObjectInputStream in = new ObjectInputStream(
        new FileInputStream(new File(fitxer)));
        int valor = 0;
        try{
            do{
                int val = in.readInt();
                valor += val;
                System.out.println(val);
            }while(true);
        }catch(EOFException e){
             System.out.println("fi del fitxer");
        }finally{
            if(in != null){
                try{
                    in.close();
                    System.out.println("tancat correctament");
                }catch(IOException e){
                    System.out.println("No s'ha tancat correctament");
                }
            }
        }
        System.out.println(valor);
    }
    
    public static void escriureTextNumsLectura()throws FileNotFoundException{
        String fitxer = "holatext.txt";
        int i = 1;
        PrintWriter txt = new PrintWriter(new File(fitxer));
        
        while(i<=999){
            txt.println(i);
            i++;
        }
        txt.close();
        Scanner lecturaFitx = null;
        int valor = 0;
        try{
            lecturaFitx = new Scanner(new File(fitxer)).useLocale(Locale.US);
            while(lecturaFitx.hasNext()){
                 int val = lecturaFitx.nextInt();
                 System.out.println(val);
                 valor += val;
                 lecturaFitx.nextLine();
            } 
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(InputMismatchException e){
            System.out.println("No es un numero");
        }finally{
            if(lecturaFitx != null){                
                    lecturaFitx.close();
                    System.out.println("tancat correctament");
            }
        }
        System.out.println(valor);        
    }
    
    public static void buscarParaules(String paraula, String nomFitx){     
        Scanner lecturaFitx = null;
        String fitxer = nomFitx;
        String par = "";
        int i=1;
        try{
            System.out.println("En el fitxer " + nomFitx + " estan les seguents paraules:");
            lecturaFitx = new Scanner(new File(fitxer));
            
            while(lecturaFitx.hasNextLine()&& !par.equals(paraula)){
                 par = lecturaFitx.next();
                 System.out.println(par);
                 lecturaFitx.nextLine();
                 i++;
            } 
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(InputMismatchException e){
            System.out.println("caracter incorrecte");
        }finally{
            if(lecturaFitx != null){                
                    lecturaFitx.close();
                    System.out.println("tancat correctament");
            }
        }
        if(par.equals(paraula)){
            System.out.println(paraula + " esta en el fitxer " + fitxer + " en la linea " + i);
        }else{System.out.println("La paraula " + paraula + 
            " ,no esta en el fitxer " + fitxer);}    
    }
    
}
