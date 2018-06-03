package arbolgrafico;
import arbolgrafico.Nodo1;

import java.util.*;
import javax.swing.JPanel;

public class ArbodeExpresiones {
      Stack < Nodo1 > pOperandos = new Stack < Nodo1> ();
       Stack < String > pOperadores = new Stack < String > ();
 
    final String blanco;           
    final String operadores;     
   
    public ArbodeExpresiones() {
        
	blanco = " \t";
	operadores = ")+-*/%^(";  
    }

    private Nodo1 raiz;
    
    public Nodo1 getRaiz() {
        return this.raiz;
    }

    public void setRaiz(Nodo1 r) {
        this.raiz = r;
    }
    
    public boolean contruir (String con){
    construirArbol(con);
    return true;
    }
    
    public Nodo1 construirArbol(String expresion) {
    	StringTokenizer tokenizer;
    	String token;
    	tokenizer = new StringTokenizer(expresion, blanco+operadores, true);
    	while (tokenizer.hasMoreTokens()) {
	 	  token = tokenizer.nextToken();
	 	  if (blanco.indexOf(token) >= 0) 
	 		  	;             
	    else if (operadores.indexOf(token) < 0) {
		               
		pOperandos.push( new Nodo1(token));
	    } else if(token.equals(")")) { 
		while (!pOperadores.empty() && !pOperadores.peek().equals("(")) {
		    guardarSubArbol();
		}
		pOperadores.pop();  
	    } else {
		if (!token.equals("(") && !pOperadores.empty()) {
		    String op = (String) pOperadores.peek();
		    while (!op.equals("(") && !pOperadores.empty()
			   && operadores.indexOf(op) >= operadores.indexOf(token)) {
			guardarSubArbol();
			if (!pOperadores.empty()) 
			    op = (String)pOperadores.peek();
		    }
		}
		pOperadores.push(token); 
	    }
	}
	
	raiz = (Nodo1)pOperandos.peek();
	while (!pOperadores.empty()) {
	    if (pOperadores.peek().equals("(")) {
		pOperadores.pop();
	    } else {
	    guardarSubArbol();
	    raiz = (Nodo1) pOperandos.peek() ;
	    }
	}
	return raiz;
    }

    private void guardarSubArbol() {
	Nodo1 op2 = (Nodo1) pOperandos.pop();
	Nodo1 op1 = (Nodo1)pOperandos.pop();
	pOperandos.push( new Nodo1(op2, pOperadores.pop(), op1));

    }

    public void imprime(Nodo1 n) {
	if (n != null) {
	    imprime(n.getNodoDerecho());
            System.out.print(n.getInformacion()+" ");
             imprime(n.getNodoIzquierdo());
		}
    }


    public void imprimePos(Nodo1 n) {
	if (n != null) {
	    imprimePos(n.getNodoIzquierdo());
	    imprimePos(n.getNodoDerecho());
	    System.out.print(n.getInformacion()+" ");
		}
    }
    
    public void imprimePre(Nodo1 n) {
	if (n != null) {
	    System.out.print(n.getInformacion()+" ");
              imprimePre(n.getNodoDerecho());
               imprimePre(n.getNodoIzquierdo());
		}
    }
 public JPanel getdibujo() {
       return new ArbolExpresionGrafico(this);
    }
}

