import java.util.NoSuchElementException;
public class LlistaPIIntEnla {
    // referencies al primer, al PI i a l'anterior de la llista
    public NodeInt primer, PI, antPI;    
    public int talla;       // nÃºmero d'elements de la llista
    
    /**
     * Crea una llista buida.
     */
    public LlistaPIIntEnla() {
        primer = null;
        PI = null;
        antPI = null;
        talla = 0;
    }

    /**
     * Comprova si la llista actual estÃ  o no buida.
     * @return boolean, true si la llista estÃ  buida i false en cas contrari.
     */
    public boolean esBuida() { 
        return talla == 0;   // Alternativament: return primer == null;
    }
    
    /**
     * Comprova si el punt d'interÃ¨s estÃ  al final de la llista actual.
     * @return boolean, true si el PI estÃ  al final de la llista i false 
     * en cas contrari.
     */
    public boolean esFi() { return PI == null; }
    
    /**
     * Torna el nÃºmero d'elements de la llista actual.
     * @return int, nÃºmero d'elements de la llista actual.
     */
    public int talla() { return talla; }      

    /**
     * Situa el punt d'interÃ¨s en la primera posiciÃ³ de la llista actual.
     */
    public void inici() { 
        PI = primer; 
        antPI = null; 
    }

    /**
     * DesplaÃ§a el PI una posiciÃ³ cap a la dreta. 
     * @throws NoSuchElementException si el PI es troba al final de la llista.
     */
    public void seguent() { 
        if (PI == null) { 
            throw new NoSuchElementException("Cursor al final");
        }
        antPI = PI; 
        PI = PI.seguent;
    }
    
    /**
     * Torna l'element en el PI. 
     * @throws NoSuchElementException si el PI es troba al final de la llista.
     * @return int, element en el PI de la llista.
     */
    public int recuperar() { 
        if (PI == null) { 
            throw new NoSuchElementException("Cursor al final");
        }
        return PI.dada; 
    }   

    /**
     * Insereix un nou node amb l'element x en la posiciÃ³ anterior al PI. 
     * Si el cursor estÃ  a lâ€™inici, el nou node serÃ  el primer de la 
     * llista. En qualsevol altre cas, el nou node sâ€™insereix entre el 
     * node cursor i el seu node predecessor.
     * @param x, element a afegir en la llista.
     */
    public void inserir(int x) {
        if (PI == primer) { 
            primer = new NodeInt(x, PI); 
            antPI = primer; 
        } 
        else { 
            antPI.seguent = new NodeInt(x, PI); 
            antPI = antPI.seguent; 
        } 
        talla++;
    }
    
    /**
     * Torna i elimina de la llista l'element en el PI. 
     * Si el cursor estÃ  a lâ€™inici, primer sâ€™actualitza al seu node 
     * segÃ¼ent. En qualevol altre cas, els nodes anterior i posterior 
     * al node cursor queden enllaÃ§ats.
     * @throws NoSuchElementException si el PI es troba al final de la llista.
     * @return int, element en el PI de la llista.
     */
    public int eliminar() {
        if (PI == null) { 
            throw new NoSuchElementException("Cursor al final");
        }
        int x = PI.dada; 
        if (PI == primer) { primer = primer.seguent; }
        else { antPI.seguent = PI.seguent; }
        PI = PI.seguent; 
        talla--; 
        return x;
    }
  
    /*************** MÃˆTODES DELS EXERCICIS ******************************/   
    /**
     * MÃ¨tode privat auxiliar que busca la primera ocurrÃ¨ncia de x 
     * des del node aux en endavant; si el troba, mou el PI al node 
     * que contÃ© a x. Si no apareix, el PI no es mou.
     * @param aux NodeInt a partir del qual es fa la cerca
     * @param x int a buscar
     * @return boolean true si el troba i false en cas contrari.
     */
    private boolean buscar(NodeInt aux, int x) { 
        NodeInt ant = null;
        if (aux == this.PI) { ant = this.antPI; }
            while (aux != null && aux.dada != x) {
                ant = aux;
                aux = aux.seguent;
            }
        boolean res = false;
        if (aux != null) {
            this.PI = aux;
            this.antPI = ant;
            res = true;
        }
        return res;
    }
    /**
     * Precondicio llista ordenada sense repetir 
     * @param l1
     * @param l2
     * @return
     */
    public static LlistaPIIntEnla Unio(
            LlistaPIIntEnla l1 ,LlistaPIIntEnla l2){
        LlistaPIIntEnla resultat = new LlistaPIIntEnla();
        System.out.println(l1.toString());
        System.out.println(l2.toString());
        l1.inici();
        l2.inici();
        while(!l1.esFi() && !l2.esFi()){
            if(l1.recuperar() > l2.recuperar()){
                resultat.inserir(l2.recuperar());               
                 l2.seguent();
            }else if (l1.recuperar() < l2.recuperar()){
                resultat.inserir(l1.recuperar());
                l1.seguent();
            }else{
                resultat.inserir(l1.recuperar());
                l1.seguent(); l2.seguent();
            }
        }
        //per cada element de l1 compiar-ho en res
        //per a cada element de l2 si no el trobem en li inserir-ho 
        while(!l1.esFi()){
            resultat.inserir(l1.recuperar());
            l1.seguent();
        }
        while(!l2.esFi()){
            resultat.inserir(l2.recuperar());
            l2.seguent();
        }
        
        return resultat;
        
    }
    public static LlistaPIIntEnla UnioDeConjsOrd(
            LlistaPIIntEnla l1 ,LlistaPIIntEnla l2){
        LlistaPIIntEnla resultat = new LlistaPIIntEnla();
        l1.inici();l2.inici();
        while(!l1.esFi() && !l2.esFi()){
            if(l1.recuperar() > l2.recuperar()){
                resultat.inserir(l2.recuperar());               
                 l2.seguent();
            }else if (l1.recuperar() < l2.recuperar()){
                resultat.inserir(l1.recuperar());
                l1.seguent();
            }else{
                resultat.inserir(l1.recuperar());
                l1.seguent(); l2.seguent();
            }
            
            while(!l1.esFi()){
                resultat.inserir(l1.recuperar());
                l1.seguent();
            }
            while(!l2.esFi()){
                resultat.inserir(l2.recuperar());
                l2.seguent();
            }
        }
        //per cada element de l1 compiar-ho en res
        //per a cada element de l2 si no el trobem en li inserir-ho 
        
        
        return resultat;
        
    }
    /**
     * Sin elemenros repetidos pero desOrdenado , devolver otra lista que sea la Unio de Ambas 
     */
    public static LlistaPIIntEnla UnioDeConjsDes(
            LlistaPIIntEnla l1 ,LlistaPIIntEnla l2){
        /**System.out.println(l2.toString());
        System.out.println();
        System.out.println(l1.toString());
        System.out.println();**/
        
        LlistaPIIntEnla aux = new LlistaPIIntEnla();
        aux=l1;
        
        l2.inici();
        while(!l2.esFi()){
            l1.inici();
            int  x = l2.recuperar();
            while(!l1.esFi() && x!=l1.recuperar()){             
                l1.seguent();
            }
            
            if(l1.esFi()){  
                aux.inserir(x); 
            }           
            l2.seguent();   
        }
        
        //l1.PI=null;
        System.out.println(l1.toString());
                return l1;}
    
    /**
     * Busca la primera ocurrÃ¨ncia de x des del primer node de la llista; 
     * si el troba, mou el PI al node que contÃ© a x. Si no apareix, el PI 
     * no es mou.
     * @param x int a buscar
     * @return boolean true si el troba i false en cas contrari.
     */
    public boolean buscarInici(int x) { return buscar(primer, x); } 
    
    /**
     * Busca la primera ocurrÃ¨ncia de x des del node del PI (inclusivament) 
     * de la llista; si el troba, mou el PI al node que contÃ© a x. Si no 
     * apareix, el PI no es mou.
     * @param x int a buscar
     * @return boolean true si el troba i false en cas contrari.
     */
    public boolean buscarSeguent(int x) { return buscar(PI, x); }
    
    public void concatenar(LlistaPIIntEnla l){
        NodeInt aux=primer,ultim=null;
        while(aux!=null){
            ultim=aux; aux=aux.seguent;
        }
        if(primer==null)primer=l.primer;
        else ultim.seguent =l.primer;
        if(antPI==ultim)PI=l.primer;
        talla+=l.talla;
    }   
    
    /** Insereix un nou element sols si no existeix(sense duplicats).
    * Be al comencament (davant es true), be a la fi (davant es false)
    */
    public void inserirSenseRepetits(int val, boolean davant){
        NodeInt p = primer;
        NodeInt q = null;
        
        while(p.dada != val && p != null){
            q = p;
            p = p.seguent;
        }
        
        if(p == null){
            talla++;
            if(q == null){//no hi ha elements
                primer = new NodeInt(val);
            }else if(davant){//davant
                primer = new NodeInt(val,primer);
            }else{//darrere
                q.seguent = new NodeInt(val);
            }
        }
    }
    
    public String toString() {
        return "LlistaPIIntEnla [primer=" + primer + " \n, PI=" + PI + ", antPI=" + antPI + ", talla=" + talla + "]";
    }   
}