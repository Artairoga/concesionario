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
public class deportivo extends vehiculo {
    double cilindrada;

    public deportivo() {
    }

    public deportivo(double cilindrada, String marca, String matricula,LocalDate fecha, int kilometros, double precio) {
        super(marca, matricula, fecha, kilometros, precio);
        this.cilindrada = cilindrada;
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }
    
    @Override
    public String toString() {
        return "deportivo{" + "cilindrada=" + cilindrada +" informacion general:" + super.toString()+'}';
    }
    @Override
    public String visualizarBonito(){
        return "Tipo de vehiculo=Deportivo"+", marca= " + marca + ", matricula=" + matricula + ", fecha=" + fecha + ", kilometros=" + kilometros + ", precio=" + precio +", CentrimetosCubicos=" +cilindrada;
    }
    
}
