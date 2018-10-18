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
public class Polinomio implements Serializable{
   
    protected int[] coeficientes;
    protected  int grado;

	public Polinomio(int g){
		if (g < 0) {
      coeficientes = new int[1];
      coeficientes[0] = 0;
      grado = 0;
    } else {
      coeficientes = new int[g + 1];
      for(int i = 0; i <= g; i++){
        coeficientes[i] = 0;
        grado = g;
      }
    }
	}

	public Polinomio(int[] coef, int g){
    if (g < 0) {
      coeficientes = new int[1];
      coeficientes[0] = 0;
      grado = 0;
    } else {
      coeficientes = new int[g + 1];
      for(int i = 0; i <= g; i++){
        coeficientes[i] = coef[i];
        grado = g;
      }
    }
  }

  public int grado() {
  	return this.grado;
  }

  // regresa c = a + b
  public Polinomio suma(Polinomio b) {
    Polinomio a = this;
    int grado = Math.max(a.grado, b.grado);
    Polinomio c = new Polinomio(grado);
    for (int i = 0; i <= a.grado; i++){
    	c.coeficientes[i] += a.coeficientes[i];
    }
    for (int i = 0; i <= b.grado; i++){
    	c.coeficientes[i] += b.coeficientes[i];
    }
    return c;
  }

  public Polinomio multiplicaEscalar(int escalar){
  	Polinomio a = this;
  	for(int i = 0; i <= a.grado; i++){
  		a.coeficientes[i] *= escalar;
  	}

  	return a;
  }

  public int evaluar(int x) {
    int valor = 0;
    for (int i = this.grado; i >= 0; i--){
    	valor = this.coeficientes[i] + (x * valor);
    }
    return valor;
  }

  public String toString() {
    if (grado ==  0) return "" + coeficientes[0];
    if (grado ==  1) return coeficientes[1] + "x + " + coeficientes[0];
    String s = coeficientes[grado] + "x^" + grado;
    for (int i = grado-1; i >= 0; i--) {
      if (coeficientes[i] == 0) continue;
      else if (coeficientes[i]  > 0) s = s + " + " + ( coeficientes[i]);
      else if (coeficientes[i]  < 0) s = s + " - " + (-coeficientes[i]);
      if (i == 1) s = s + "x";
      else if (i >  1) s = s + "x^" + i;
    }
    return s;
  }


    }