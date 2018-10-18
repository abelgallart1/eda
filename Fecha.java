/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
import java.io.Serializable;
/**
 *
 * @author abel
 */
public class Fecha extends Date implements Serializable{
    int dia,mes,año;
    
public Fecha(int dia,int mes,int año){
super(año,mes,dia);
this.dia=dia;this.mes=mes;this.año=año;
}

public String toString(){return dia+"/"+mes+"/"+año;}
public boolean equals(Fecha otra){return (dia==otra.dia&&mes==otra.mes&&año==otra.año);}
}
