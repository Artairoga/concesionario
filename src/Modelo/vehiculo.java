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
public abstract class vehiculo implements Comparable<vehiculo>{
    String marca,matricula;
    int kilometros;
    double precio;
    LocalDate fecha;  
    public vehiculo() {
    }

    public vehiculo(String marca, String matricula, LocalDate fecha, int kilometros, double precio) {
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
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
    
    public int compareTo(vehiculo o) {
        return fecha.compareTo(o.fecha);
    }
}
