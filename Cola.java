/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abel
 */

import java.io.Serializable;

public class Cola implements Serializable{
    Nodo1 raiz;
    int total;
    public Cola(){ total=0; }
    
    public boolean vacia(){return (total==0);}
    public int total(){return total;}
    
    public void push(Object x){
    if (vacia()) raiz=new Nodo1(x,null);
    else {
    Nodo1 aux=raiz;
    while(aux.enlace!=null)aux=aux.enlace;
    aux.enlace=new Nodo1(x,null);
    
    }
    total++;
    
    }
    
    public Object tope() throws Exception{
    if (!vacia()) return raiz.valor;
    else throw new Exception("Cola Vacia");
    }
    
   public void pop() throws Exception{
   if (!vacia()) raiz=raiz.enlace;
   else throw new Exception("Cola Vacia");
   total--;
   }   
   
   
}
