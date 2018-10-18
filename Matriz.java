/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
/**
 *
 * @author abel
 */
public class Matriz implements Cloneable,Serializable{
     public int n;      //dimensión
    private double[][] x;
    
    public Matriz(int n) {
        this.n=n;  x=new double[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){ x[i][j]=0.0; }
        }
    }
    public Matriz(double[][] x) {this.x=x;n=x.length; }
//otras funciones miembro
 
    public Object clone(){
        Matriz obj=null;
        try{
//llama a clone de la clase base Object
            obj=(Matriz)super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println(" no se puede duplicar");
        }
//copia la matriz bidimensional
        obj.x=(double[][])obj.x.clone();
        for(int i=0; i<obj.x.length; i++){
            obj.x[i]=(double[])obj.x[i].clone();
        }
        return obj;
    }

 public double traza(){
     
     //Se denomina traza de una matriz cuadrada a la suma de los elementos de su diagonal principal.

        double tr=0.0;
        for(int i=0; i<n; i++){
            tr+=x[i][i];
        }
        return tr;
    }

 //Se obtiene otra matriz c en la que sus elementos cij son las suma de los correspondientes elementos de las matrices a y b, 
 //es decir  cij=aij+bij
  
 public static Matriz suma(Matriz a, Matriz b){
        Matriz resultado=new Matriz(a.n);
        for(int i=0; i<a.n; i++){
            for(int j=0; j<a.n; j++){
                resultado.x[i][j]=a.x[i][j]+b.x[i][j];
            }
        }
        return resultado;
    }
 
 //dos matrices de dimensiones m x n y n x q, dando como resultado una matriz de dimensiones m x q
 //Los elementos cij se obtienen multiplicando los elementos aik de la fila i por los elementos akj de la columna j, y sumando 
 //los resultados.


  public static Matriz producto(Matriz a, Matriz b){
        Matriz resultado=new Matriz(a.n);
        for(int i=0; i<a.n; i++){
            for(int j=0; j<a.n; j++){
                for(int k=0; k<a.n; k++){
                    resultado.x[i][j]+=a.x[i][k]*b.x[k][j];
                }
            }
        }
        return resultado;
    }
 
  
  //El producto de un escalar (número real) por una matriz que da como resultado
  //otra matriz cuyos elementos están todos multiplicados por dicho escalar. 
  //Se define también la operación conmutativa
  
  public static Matriz producto(double d, Matriz a){
        Matriz resultado=new Matriz(a.n);
        for(int i=0; i<a.n; i++){
            for(int j=0; j<a.n; j++){
                resultado.x[i][j]=a.x[i][j]*d;
            }
        }
        return resultado;
    }
 
  
  //Al multiplicar una matriz cuadrada de dimensión n, por un vector columna de la misma dimensión
  //obtenemos otro vector columna. Cada elemento del vector resultante se obtiene multiplicando los 
  //elementos de una fila de la matriz por los correspondientes elementos del vector columna y se 
  //suman los resultados 
  
public static Vector producto(Matriz a, Vector v){
        int n=v.n;  
        Vector b=new Vector(n);
        for(int i=0; i<n; i++){
            for(int k=0; k<n; k++){
                b.x[i]+=a.x[i][k]*v.x[k];
            }
        }
        return b;
    }


//Al multiplicar un vector fila por una matriz cuadrada de la misma dimensión obtenemos otro vector fila
 public static Vector producto(Vector v, Matriz a){
        int n=v.n; 
        Vector b=new Vector(n);
        for(int j=0; j<n; j++){
            for(int k=0; k<n; k++){
                b.x[j]+=v.x[k]*a.x[k][j];
            }
        }
        return b;
    }

 //Una matriz traspuesta de otra matriz es aquella que tiene los mismos elementos pero dispuestos en forma distinta.
// Las columnas de la matriz original se transforman en filas de la matriz traspuesta.
 public static Matriz traspuesta(Matriz a){
        int n=a.n;
        Matriz resultado=new Matriz(a.n);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                resultado.x[i][j]=a.x[j][i];
            }
        }
        return resultado;
    }
 
public double determinante(){
     //triangularizacion de la matriz metodo gauss   
    
     Matriz a=(Matriz)clone();
        for(int k=0; k<n-1; k++){
            for(int i=k+1; i<n; i++){
                for(int j=k; j<n; j++){
                    a.x[i][j]-=a.x[i][k]*a.x[k][j]/a.x[k][k];
                }
            }
        }
        
        //calculo del determinante
        double deter=1.0;
        for(int i=0; i<n; i++){
            deter*=a.x[i][i];
        }
        return deter;
    }

public Matriz gauss(){
Matriz a=(Matriz)clone();
        for(int k=0; k<n-1; k++){
            for(int i=k+1; i<n; i++){
                for(int j=k; j<n; j++){
                    a.x[i][j]-=a.x[i][k]*a.x[k][j]/a.x[k][k];
                }
            }
        }
        return a;
}

 
 public static Matriz inversa(Matriz d){
        int n=d.n;  			//dimensión de la matriz
        Matriz a=(Matriz)d.clone();	//La matriz a es una copia de d
        Matriz b=new Matriz(n);   	//matriz de los términos independientes
        Matriz c=new Matriz(n);   	//matriz de las incógnitas
//matriz unidad
        for(int i=0; i<n; i++){
            b.x[i][i]=1.0;
        }
//transformación de la matriz y de los términos independientes
        for(int k=0; k<n-1; k++){
            for(int i=k+1; i<n; i++){
//términos independientes
                for(int s=0; s<n; s++){
                    b.x[i][s]-=a.x[i][k]*b.x[k][s]/a.x[k][k];
                }
//elementos de la matriz
                for(int j=k+1; j<n; j++){
                    a.x[i][j]-=a.x[i][k]*a.x[k][j]/a.x[k][k];
                }
            }
        }
//cálculo de las incógnitas, elementos de la matriz inversa
        for(int s=0; s<n; s++){
            c.x[n-1][s]=b.x[n-1][s]/a.x[n-1][n-1];
            for(int i=n-2; i>=0; i--){
                c.x[i][s]=b.x[i][s]/a.x[i][i];
                for(int k=n-1; k>i; k--){
                    c.x[i][s]-=a.x[i][k]*c.x[k][s]/a.x[i][i];
                }
            }
        }
        return c;
    }

 public double[] polCaracteristico(){
        Matriz pot=new Matriz(n);
//matriz unidad
        for(int i=0; i<n; i++){
            pot.x[i][i]=1.0;
        }
        double[] p=new double[n+1];
        double[] s=new double[n+1];
//potencias de la matriz y traza 
       for(int i=1; i<=n; i++){
            pot=Matriz.producto(pot, this);
            s[i]=pot.traza();
        }
//coeficientes del polinomio característico
        p[0]=1.0;
        p[1]=-s[1];
        for(int i=2; i<=n; i++){
            p[i]=-s[i]/i;
            for(int j=1; j<i; j++){
                p[i]-=s[i-j]*p[j]/i;
            }
        }
        return p;
    }

 public String toString(){
        String texto="\n";
        for(int i=0; i<x.length; i++){
            for(int j=0; j<x[0].length ; j++){
                texto+="\t "+x[i][j];
            }
            texto+="\n";
        }
        texto+="\n";
        return texto;
  }
 
 
}
