/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 import java.util.ArrayList;
         
public class EDA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     
        Arbol a=new Arbol("a");
         Arbol b=new Arbol("b");
          Arbol c=new Arbol("c");
           Arbol d=new Arbol("d");
            Arbol e=new Arbol("e");
             Arbol f=new Arbol("f");
              Arbol g=new Arbol("g");
               Arbol h=new Arbol("h"); 
               Arbol i=new Arbol("i");
    
    b.addHijo(e);
    b.addHijo(f);
    c.addHijo(g);
    c.addHijo(h);
    d.addHijo(i);
    a.addHijo(b);
    a.addHijo(c);
    a.addHijo(d);
    //a.podarHijo(c);
        System.out.println(a.totalhijos+"total hijos"); 
        System.out.println(a.altura()+"altura");
        System.out.println(a.ancho()+"ancho");
        System.out.println(a.eshoja()+"es hoja"); 
        System.out.println(a.peso()+"peso"); 
        System.out.println(g.nivel()+"nivel");
      
        ArrayList pos=a.camino(h);
        String s="";
       for(int x=0;x<pos.size();x++)
       {s+=((Nodo)pos.get(x)).valor+",";
               }
     System.out.println(s);
    
    }
    
}
