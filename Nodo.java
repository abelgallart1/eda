/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 
import java.util.ArrayList;
import java.io.Serializable;

public class Nodo implements Serializable{
Nodo padre;
Object valor;
ArrayList hijos;
      
public Nodo(Object x){
valor=x;
hijos=new ArrayList();
padre=null;
}

public Nodo(Object x,Nodo padre){
valor=x;
this.padre=padre;
hijos=new ArrayList();
}

public Nodo(Object x, Nodo padre, ArrayList hijos){
valor=x;
this.padre=padre;
this.hijos=hijos;
}

}
