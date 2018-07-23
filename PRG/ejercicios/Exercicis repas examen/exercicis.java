
/**
 * Write a description of class exercicis here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class exercicis
{
  private static int simetrics(int m, int a[], int i, int f){
    if(i>f){return -1;}
    else if(i<=f && a[i]+a[f]==m){return i;}
         else{return simetrics(m,a,i+1,f-1);
              }
  }
  
  public static int simetrics(int m, int a[]){
        int i=0;
        int f=a.length-1;
        return simetrics(m,a,i,f);
  }
  
  private static int capicua(int a[], int i, int f){
    if(i>f)return 0;
    else if(i==f)return a[i];
    else if(f>i && a[i]==a[f]) return a[i]+a[f]+capicua(a,i+1,f-1);
    else return 0;
  }
  
  
  public static int capicua(int a[]){
        int i=0;
        int f=a.length-1;
        return capicua(a,i,f);
  }
  /** Torna cert sii a[i..f] esta ordenat ascendentment. Precondicio: i<=f */
  public static boolean esOrdenat(int[] a, int i, int f) {
      if (i==f) return true;
      else {
        int m = (i+f)/2;
        return esOrdenat(a,i,m) && esOrdenat(a,m+1,f) && a[m]<=a[m+1];
      }
  }
  
  public static int sumaCapicua(int[] a, int ini, int fi) {
      if (ini>fi) return 0;
      else if(ini==fi) return a[ini];
      else if (a[ini]!=a[fi]) return 0;
      else return a[ini] + a[fi] + sumaCapicua(a, ini+1, fi-1);
    }
    
  public static int decimalBinari(int n){
      int res;
      if(n<1){return res=n;}
      else return res =(n%2) + decimalBinari(n/2)*10;     
    }
    
  public static int binariDecimal(int n, int exp){
      if(n==0){return 0;}
      else {
        int digit = n % 10;//agafe la xifra
        if(digit==1)return (int)(Math.pow(2, exp)+ binariDecimal(n/10,exp+1));
        else return binariDecimal(n/10,exp+1);
    }
  }
  
  public static int binariDecimalLanzadera(int n){
    return binariDecimal(n,0);
  }
  
  public static int esMenor(int a[],int pos,int x, int m){
    if(pos > a.length-1){ return m; }
    else if(a[pos] < x) { m += 1; 
                          return esMenor(a,pos+1,x,m);}
        else{return esMenor(a,pos+1,x,m);}     
    }
    
  public static void escriuNumeros(int n){
      if(n==0) {System.out.print("0");}
      else {System.out.print(n+" "); escriuNumeros(n-1);System.out.print(" "+n);}
  }
  
  public static boolean sumSim(int ini, int fi, int a[], int x){
      if(ini>fi){   return true;}
      else if(a[ini]+a[fi]==x){return sumSim(ini+1,fi-1,a,x);}
           else{return false;}
    }
    
  public static void binari( int n ) {
     if ( n > 0 ) binari( n/2 );
     System.out.print( n % 2 );
    }

  public static boolean progressioAritmetica(int a[], int x, int i){
    //i es la posició
    if(i==a.length-1){return true;}
    else{
        if(a[i]*x==a[i+1]){return progressioAritmetica(a,x,i+1);}
        else {return false;}
    }
   }
   
  public static void escriureNumsNeg(int n){
   if(n==0){System.out.print("0"+" ");}
   else{ System.out.print("-"+n+" "); 
        escriureNumsNeg(n-1);
        System.out.print(n+" ");}
   }
   
  public static void escriureNums(int n){
   if(n==0){System.out.print("0"+"\n"+"0"+" ");}
   else{ System.out.print(n+" "); 
        escriureNums(n-1);
        System.out.print(n+" ");}
  }
  
  public static boolean sumSimetrics(int ini, int fi, int v[], int x){
    if(ini>fi){return true;}
    else{
        if(ini==fi){return v[ini]+v[fi]==x;}
        else if(v[ini]+v[fi]==x){return sumSim(ini+1,fi-1,v,x);}
        else return false;
    }
    }
    
    
}
