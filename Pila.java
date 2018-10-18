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
import java.util.Enumeration;

public class Pila implements Serializable{
     Nodo1 ultimo;
    int total;
    
    public Pila(){ total=0; }
    
    public boolean vacia(){return (total==0);}
    public int total(){return total;}
    
    public void push(Object x){
    if (vacia()) ultimo=new Nodo1(x,null);
    else  ultimo=new Nodo1(x,ultimo);
           total++;
    
    }
    
    public Object tope() throws Exception{
    if (!vacia()) {return ultimo.valor;}
    
    else throw new Exception("pila Vacia");
    }
    
   public void pop() throws Exception{
   if (!vacia()) {ultimo=ultimo.enlace;}
   else throw new Exception("Cola Vacia");
   total--;
   }   
   
   
}
