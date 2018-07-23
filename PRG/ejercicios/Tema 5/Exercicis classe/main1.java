public class main1 {
	public static void main(String[] args) {
		
		CuaIntEnla cua  = new CuaIntEnla();
		for(int  i=0 ; i<2;i++){
			cua.encuar(i);
		}
		CuaIntEnla cua2  = new CuaIntEnla();
		for(int  j=0 ; j<2;j++){
			cua2.encuar(j);
		}
		PilaIntEnla pila  = new PilaIntEnla();
		for(int  j=0 ; j<3;j++){
			pila.empilar(j);
		}
		PilaIntEnla pila2  = new PilaIntEnla();
		for(int  j=0 ; j<3;j++){
			pila2.empilar(j);
		}
		
		LlistaPIIntEnla llista  = new LlistaPIIntEnla();
		for(int  j=0 ; j<4;j++){
			llista.inserir(j);
		}
		LlistaPIIntEnla llista2  = new LlistaPIIntEnla();
		for(int  j=0 ; j<3;j++){
			llista2.inserir(j);
		}
		
		LlistaPIIntEnla l4 = interseccio(llista,llista2);
		System.out.println(l4.toString());
	}
		
 	public static int comptar(LlistaPIIntEnla l, int max, int min){
 		int valor = 0;
 			l.inici();
 			while(!l.esFi()){
 				int i = l.recuperar();
 				if(i<max && i>min){
 					valor +=valor;
 				}
 				l.seguent();
 			}
 		return valor;
 	}
 	public static void esborraBase(PilaIntEnla p){
 		if(p.talla() == 1){
 			p.desempilar();
 		}else{
 			if(p.talla()> 1){
 				int i = p.desempilar();
 				esborraBase(p);
 				p.empilar(i);
 			}
 		}
 	}
 	public static LlistaPIIntEnla Unio(LlistaPIIntEnla l1, LlistaPIIntEnla l2){
 		LlistaPIIntEnla unio = new LlistaPIIntEnla();
 		l1.inici();
 		l2.inici();
	 		while(!l1.esFi()&&!l2.esFi()){
	 			if(l1.recuperar() < l2.recuperar()){
	 				unio.inserir(l1.recuperar());
	 				l1.seguent();
	 			}else if (l1.recuperar() > l2.recuperar()){
	 				unio.inserir(l2.recuperar());
	 				l2.seguent();
	 			}else{
	 				unio.inserir(l2.recuperar());
	 				l2.seguent();
	 				l1.seguent();
	 			}	 			
	 		}
	 		while(!l1.esFi()){
	 			unio.inserir(l1.recuperar());
 				l1.seguent();
	 		}
	 		while(!l2.esFi()){
	 			unio.inserir(l2.recuperar());
 				l2.seguent();
	 		}
	 		//Asi l1 sera fi o l2 sera fi o els dos 
	 		return unio;
 	}
 	public static LlistaPIIntEnla unio(LlistaPIIntEnla llista1, LlistaPIIntEnla llista2){
	 	LlistaPIIntEnla li = new LlistaPIIntEnla();
	 	llista1.inici(); 
	 	llista2.inici();
		 	while(!llista1.esFi() && !llista2.esFi()) {
			 	int i = llista1.recuperar();
			 	int j = llista2.recuperar();
			 	
			 	if(i<j){ 
			 		li.inserir(i); 
			 		llista1.seguent(); 
			 	}else if(i>j){ 
			 			li.inserir(j); 
			 			llista2.seguent(); 			 	
			 	}else { 
			 		li.inserir(i); 
			 		llista1.seguent(); 
			 		llista2.seguent(); 
			 	}
		 	}
		 	while(!llista1.esFi()) {
			 	li.inserir(llista1.recuperar());
			 	llista1.seguent();
		 	}
		 	while(!llista2.esFi()) {
			 	li.inserir(llista2.recuperar());
			 	llista2.seguent();
		 	}
		 return li;
 	}
 	public static LlistaPIIntEnla insercio(LlistaPIIntEnla la, LlistaPIIntEnla lb){
 		LlistaPIIntEnla lc = new LlistaPIIntEnla();
 		la.inici();
 		while(!la.esFi()){
 			lb.inici();
 			int i = la.recuperar();
	 		while(!lb.esFi()){
	 			int j = lb.recuperar();
	 			if(i==j){
	 				lc.inserir(i);	 				
	 			}
	 			lb.seguent();
	 		}
	 		la.seguent();	 		
 		}
 		return lc;
 	}
 	
 	
	public static LlistaPIIntEnla interseccio(LlistaPIIntEnla la, LlistaPIIntEnla lb) {
		LlistaPIIntEnla lc = new LlistaPIIntEnla();
		la.inici();
		lb.inici();
		while (!la.esFi() && !lb.esFi()) {
			int a = la.recuperar();
			int b = lb.recuperar();
			if (a < b)
				la.seguent();
			else if (b < a)
				lb.seguent();
			else {
				lc.inserir(a);
				la.seguent();
				lb.seguent();
			}
		}
		return lc;
	}
 }		
