/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author artairg
 */
public class cliente implements Comparable<cliente> {

    String nombre, apellido, dni;
    ArrayList<vehiculo> vehiculos = new ArrayList<>();

    public cliente() {
    }

    public cliente(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.vehiculos = vehiculos;
    }

    public cliente(String dni, String nombre, String apellido, ArrayList<vehiculo> vehiculos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.vehiculos = vehiculos;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public ArrayList<vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<vehiculo> vehiculo) {
        this.vehiculos = vehiculo;
    }

    @Override
    public String toString() {
        return "cliente{" + "dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", vehiculos=" + vehiculos + '}';
    }

    @Override
    public int compareTo(cliente o) {
        return dni.compareTo(o.dni);
    }
}
