/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author artairg
 */
public class cliente implements Comparable<cliente> {

    String  nombre, apellido;
    int dni;
    ArrayList<vehiculo> vehiculos = new ArrayList<>();

    public cliente() {
    }

    public cliente(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.vehiculos = vehiculos;
    }

    public cliente(int dni, String nombre, String apellido, ArrayList<vehiculo> vehiculos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.vehiculos = vehiculos;
    }

    public int getDni() {
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
    
    public int compareTo(cliente a) {//ordenar lista por enteros
        if (dni < a.dni) {
            return -1;
        } else if (dni == a.dni) {
            return 0;
        } else {
            return 1;

        }
    }

    @Override
    public String toString() {
        return "cliente{" + "dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", vehiculos=" + vehiculos + '}';
    }

}
