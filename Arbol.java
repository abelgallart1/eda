/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;

public  class Arbol {
Nodo raiz;    
int totalhijos;
public Arbol(Object x){
raiz=new Nodo(x);
raiz.hijos=new ArrayList();
raiz.padre=null;
totalhijos=0;
}    

public Arbol(Nodo raiz){
this.raiz=raiz;
totalhijos=raiz.hijos.size();
}
 
public void addValor(Object x){raiz.valor=x;}

public void addHijo(Arbol x){
    x.raiz.padre=this.raiz;
    
    raiz.hijos.add(x.raiz);totalhijos++;}

public void podarHijo(Arbol x){
    for(int i=0;i<raiz.hijos.size();i++)
    {Nodo aux=(Nodo)raiz.hijos.get(i);
    if (aux.valor.equals(x.raiz.valor)) {aux.padre=null;raiz.hijos.remove(i);totalhijos--;}
    
    }    
  }

public boolean eshoja(){return(raiz.hijos.isEmpty());}

public ArrayList hijos(){return raiz.hijos;}

public int altura(){
if (eshoja()) return 1;
else{int max=0;
   for(int i=0;i<raiz.hijos.size();i++)
    {Nodo hijo=(Nodo)raiz.hijos.get(i);
      Arbol h=new Arbol(hijo);
      int aux=h.altura();
      if (aux>max) max=aux;
    }
    return max+1;
    }
     

   }

public int peso(){
    if (eshoja()) return 1;
    else{int suma=1;
    for(int i=0;i<raiz.hijos.size();i++)
    {Arbol hijo=new Arbol((Nodo)raiz.hijos.get(i));
      suma+=hijo.peso();
    }
   return suma;
       }
    }

public ArrayList preOrden(){
 
    ArrayList res=new ArrayList();

    if (eshoja()) res.add(raiz);
    else{res.add(raiz);
         for(int i=0;i<raiz.hijos.size();i++)
         {Arbol aux=new Arbol((Nodo)raiz.hijos.get(i));
         ArrayList x=aux.preOrden();
         for(int j=0;j<x.size();j++)
           res.add(x.get(j));
         }  
    
         }
         
  return res;
}

public ArrayList posOrden(){
 
    ArrayList res=new ArrayList();

    if (eshoja()) res.add(raiz);
    else{  for(int i=0;i<raiz.hijos.size();i++)
            {Arbol aux=new Arbol((Nodo)raiz.hijos.get(i));
              ArrayList x=aux.posOrden();
                for(int j=0;j<x.size();j++) res.add(x.get(j));
             }  
            res.add(raiz);
         }
         
  return res;
}

public ArrayList inOrden(){
 
    ArrayList res=new ArrayList();

    if (eshoja()) res.add(raiz);
    else{  for(int i=0;i<raiz.hijos.size()/2;i++)
            {Arbol aux=new Arbol((Nodo)raiz.hijos.get(i));
              ArrayList x=aux.inOrden();
                for(int j=0;j<x.size();j++) res.add(x.get(j));
             }  
          res.add(raiz);
         
          for(int i=raiz.hijos.size()/2;i<raiz.hijos.size();i++)
            {Arbol aux=new Arbol((Nodo)raiz.hijos.get(i));
              ArrayList x=aux.inOrden();
                for(int j=0;j<x.size();j++) res.add(x.get(j));
             } 
    
    }
         
  return res;
}


public ArrayList hojas(){
  ArrayList res=new ArrayList();
    if (eshoja()){ res.add(raiz);
                 return res;}
 else {
      for(int i=0;i<raiz.hijos.size();i++)
          {Nodo aux=(Nodo)raiz.hijos.get(i);
           ArrayList x=new Arbol(aux).hojas();
           for(int j=0;j<x.size();j++)
           res.add((Nodo)x.get(j));
           
          }
       return res;
   }

}

public int ancho() {return hojas().size();}

public int nivel(){
int c=0;
Nodo aux=new Nodo(raiz.valor,raiz.padre);
while(aux.padre!=null){aux.padre=aux.padre.padre;c++;}
return c;
}
  
public Nodo buscar(Arbol x){
ArrayList aux=posOrden();
for(int i=0;i<aux.size();i++)
{if (x.raiz.valor.equals(((Nodo)aux.get(i)).valor)) return (Nodo)aux.get(i);
}
return null; 
}

public ArrayList camino(Arbol x){
Nodo aux=buscar(x);
if (aux==null) return null;
ArrayList res=new ArrayList();
while(aux!=null) {res.add(aux);aux=aux.padre;}

return res;
}
}

    
