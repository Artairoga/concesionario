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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author artairg
 */
public class TestConcesionario {

    public static void main(String[] args) {
        int decision = 0;
        ArrayList<cliente> ListaClientes = new ArrayList<>();
        cliente c1 = new cliente("12345677H", "c1", "codriguez");
        c1.getVehiculos().add(new turismo(4, "marca", "matricula1", LocalDate.now(), 0, 0));
        c1.getVehiculos().add(new furgoneta(0, 0, "marca", "matricula2", LocalDate.now(), 0, 0));
        ListaClientes.add(c1);
        cliente c2 = new cliente("12345678H", "c2", "aodriguez");
        c2.getVehiculos().add(new deportivo(0, "marca", "matricula3", LocalDate.now(), 0, 0));
        ListaClientes.add(c2);
        cliente c3 = new cliente("12345679H", "c3", "bodriguez");
        c3.getVehiculos().add(new furgoneta(0, 0, "marca", "matricula4", LocalDate.now(), 0, 0));
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
                    Controlador.Controlador.CrearCliente(ListaClientes);//comprobar que ese cliente no exista!!
                    break;
                }
                case 2: {//borrar cliente(solo si existe)
                    Controlador.Controlador.BorrarCliente(ListaClientes, (Controlador.Controlador.IntroducirDatos("Que dni quieres borrar")));//123 tiene que ser una variable introducida por teclado;
                    break;
                }
                case 3: {//listar clientes ordenados dni
                    System.out.println("Lista ordenada por DNI ");
                    Collections.sort(ListaClientes);
                    Controlador.Controlador.ListarArray(ListaClientes);
                    
                    break;
                }
                case 4: {//listar clientes ordenados apellidos
                    System.out.println("Lista ordenadra por Nombre");
                    Controlador.Controlador.ordenarPorNombre(ListaClientes);
                    Controlador.Controlador.ListarArray(ListaClientes);
                    break;
                }
                case 5: {//modificar un cliente(solo si existe)
                    Controlador.Controlador.MenuVehiculos(ListaClientes,Controlador.Controlador.CheckCliente(ListaClientes, (Controlador.Controlador.IntroducirDatos("Que cliente desea modificar"))));
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
