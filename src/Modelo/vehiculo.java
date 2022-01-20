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
public abstract class vehiculo {
    String marca,matricula,fecha;
    int kilometros;
    double precio;
    public vehiculo() {
    }

    public vehiculo(String marca, String matricula, String fecha, int kilometros, double precio) {
        this.marca = marca;
        this.matricula = matricula;
        this.fecha = fecha;
        this.kilometros = kilometros;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "vehiculo{" + "marca=" + marca + ", matricula=" + matricula + ", fecha=" + fecha + ", kilometros=" + kilometros + ", precio=" + precio + '}';
    }
    
    public String visualizarBonito(){
        return "vehiculo{" + "marca=" + marca + ", matricula=" + matricula + ", fecha=" + fecha + ", kilometros=" + kilometros + ", precio=" + precio + '}';
    }
    public String visualizarPadre(){
        return "vehiculo{" + "marca=" + marca + ", matricula=" + matricula + ", fecha=" + fecha + ", kilometros=" + kilometros + ", precio=" + precio + '}';
    }
    
}
