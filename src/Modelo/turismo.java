/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author artairg
 */
public class turismo extends vehiculo{
    int n_puertas;

    public turismo() {
    }

    public turismo(int n_puertas, String marca, String matricula, String fecha, int kilometros, double precio) {
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
    
    
    
}
