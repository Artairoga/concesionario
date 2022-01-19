/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.cliente;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author artairg
 */
public class Controlador {

    public static void CrearCliente(ArrayList<cliente> ListaClientes) {
        //preguntar dni nombre apellidos devolver cliente 
        String dni,nombre,apellidos;
        dni=JOptionPane.showInputDialog("Que dni tiene el nuevo cliente?");
        nombre=JOptionPane.showInputDialog("Que nombre tiene el nuevo cliente?");
        apellidos=JOptionPane.showInputDialog("Que apellidos tiene el nuevo cliente?");
        
        if(Objects.isNull(CheckCliente(ListaClientes,dni))){
            System.out.println("El objeto no existe,lo creo");
            ListaClientes.add(new cliente(dni, nombre, apellidos));
        }else{
            JOptionPane.showMessageDialog(null,"Ya existe el cliente con dni:"+dni);
        }
    }

    public static void BorrarCliente(ArrayList<cliente> ListaClientes,String Buscar) {//
        if(Objects.nonNull(CheckCliente(ListaClientes,Buscar))){
            ListaClientes.remove(CheckCliente(ListaClientes,Buscar));
        }else{
            JOptionPane.showMessageDialog(null, "No existe ningun cliente con nombre: "+Buscar);
        }
        
    }

    public static void ListarArray(ArrayList<cliente> ListaClientes) {
        for (cliente ListaN : ListaClientes) {
            System.out.println(ListaN.toString());
        }
    }

    private static cliente CheckCliente(ArrayList<cliente> ListaClientes,String Buscar) {
         cliente ClienteTemporal = null;
        //solucionar problema nombre duplicados
        //se podria implementat busqueda dicotomica ordenando los arrays por id
        for (int i = 0; i < ListaClientes.size(); i++) {
            if (ListaClientes.get(i).getDni().equals(Buscar)) {
                ClienteTemporal = ListaClientes.get(i);
                break;
            }
        }
        return ClienteTemporal;
    }
    
}
