/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author abel
 */
public class Vector {
   public int n;      //dimensión
    double[] x;
    
    public Vector(int n) {
        this.n=n;
        x=new double[n];
        for(int i=0; i<n; i++){
            x[i]=0.0;
        }
    }
    public Vector(double[] x) {
        this.x=x;
        n=x.length;
    }
//otras funciones miembro  
    public String toString(){
    String s="";
    for(int i=0;i<x.length;i++)
     s+=x[i]+",";    
    return s;
    }

}
