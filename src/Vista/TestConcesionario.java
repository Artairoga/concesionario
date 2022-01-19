/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.cliente;
import Modelo.deportivo;
import Modelo.furgoneta;
import Modelo.turismo;
import Modelo.vehiculo;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author artairg
 */
public class TestConcesionario {

    public static void main(String[] args) {
        int decision = 0;
        ArrayList<cliente> ListaClientes=new ArrayList<>();
        cliente c1 = new cliente("1", "c1", "rodriguez");
        c1.getVehiculos().add(new turismo(4, "marca", "matricula", "fecha", 0, 0));
        c1.getVehiculos().add(new furgoneta(0, 0, "marca", "matricula", "fecha", 0, 0));
        ListaClientes.add(c1);
        cliente c2 = new cliente("2", "c2", "rodriguez");
        c2.getVehiculos().add(new deportivo(0, "marca", "matricula", "fecha", 0, 0));
        ListaClientes.add(c2);
        cliente c3 = new cliente("3", "c3", "rodriguez");
        c3.getVehiculos().add(new furgoneta(0, 0, "marca", "matricula", "fecha", 0, 0));
        ListaClientes.add(c3);

        do {

            decision = Integer.parseInt(JOptionPane.showInputDialog("1.- Incorporar un nuevo cliente.\n"
                    + "2.- Borrar un cliente. \n" 
                    + "3.- Listar datos de los clientes ordenados por dni.\n"
                    + "4.- Listar datos de los clientes ordenados por apellido.\n"
                    + "5.- Modificar un cliente.\n"
                    + "-1.- Salir de la aplicación.\n"));
            switch (decision) {
                case 1: {//add cliente(solo si existe)
                    Controlador.Controlador.CrearCliente(ListaClientes);//comprobar que ese cliente no exita!!
                    break;
                }
                case 2: {//borrar cliente(solo si existe)
                    Controlador.Controlador.BorrarCliente(ListaClientes,"123");//123 tiene que ser una variable introducida por teclado;
                    break;
                }
                case 3: {//listar clientes ordenados dni
                        Controlador.Controlador.ListarArray(ListaClientes);//temporal
                    break;
                }
                case 4: {//listar clientes ordenados apellidos
                    break;
                }
                case 5: {//modificar un cliente(solo si existe)
                    break;
                }
                case -1: {
                    JOptionPane.showMessageDialog(null, "Saliendo!");
                    break;
                }
            }

        } while (decision != -1);
    }
}
