/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author artairg
 */
public class turismo extends vehiculo{
    int n_puertas;

    public turismo() {
    }

    public turismo(int n_puertas, String marca, String matricula, LocalDate fecha, int kilometros, double precio) {
        super(marca, matricula, fecha, kilometros, precio);
        this.n_puertas = n_puertas;
    }

    public int getN_puertas() {
        return n_puertas;
    }

    public void setN_puertas(int n_puertas) {
        this.n_puertas = n_puertas;
    }
    
    @Override
    public String toString() {
        return "turismo{" + "n_puertas=" + n_puertas + " informacion general:" +super.toString()+'}';
    }
    @Override
    public String visualizarBonito(){
        return "Tipo de vehiculo=Turismo"+", marca= " + marca + ", matricula=" + matricula + ", fecha=" + fecha + ", kilometros=" + kilometros + ", precio=" + precio +", Numero de puertas="+n_puertas;
    }
    
    
}
