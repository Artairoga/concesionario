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
public class furgoneta extends vehiculo {

    int carga, volumen;

    public furgoneta() {
    }

    public furgoneta(int carga, int volumen, String marca, String matricula, String fecha, int kilometros, double precio) {
        super(marca, matricula, fecha, kilometros, precio);
        this.carga = carga;
        this.volumen = volumen;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    @Override
    public String toString() {
        return "furgoneta{" + "carga=" + carga + ", volumen=" + volumen + " informacion general:" + super.toString() + '}';
    }

    @Override
    public String visualizarBonito() {
        return "Tipo de vehiculo=Furgoneta" + ", marca= " + marca + ", matricula=" + matricula + ", fecha=" + fecha + ", kilometros=" + kilometros + ", precio=" + precio + ", Carga=" + carga+", Volumen="+volumen;
    }

}
