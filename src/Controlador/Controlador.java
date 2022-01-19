/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.cliente;
import Modelo.deportivo;
import Modelo.furgoneta;
import Modelo.turismo;
import Modelo.vehiculo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author artairg
 */
public class Controlador {

    public static void CrearCliente(ArrayList<cliente> ListaClientes) {
        //preguntar dni nombre apellidos devolver cliente 
        String nombre, apellidos;
        int dni;
        dni = Integer.parseInt(JOptionPane.showInputDialog("Que dni tiene el nuevo cliente?"));
        nombre = JOptionPane.showInputDialog("Que nombre tiene el nuevo cliente?");
        apellidos = JOptionPane.showInputDialog("Que apellidos tiene el nuevo cliente?");

        if (Objects.isNull(CheckCliente(ListaClientes, dni))) {
            //System.out.println("El objeto no existe,lo creo");
            ListaClientes.add(new cliente(dni, nombre, apellidos));
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe el cliente con dni:" + dni);
        }
    }

    public static void BorrarCliente(ArrayList<cliente> ListaClientes, int Buscar) {//
        if (Objects.nonNull(CheckCliente(ListaClientes, Buscar))) {
            ListaClientes.remove(CheckCliente(ListaClientes, Buscar));
        } else {
            JOptionPane.showMessageDialog(null, "No existe ningun cliente con nombre: " + Buscar);
        }

    }

    public static void ListarArray(ArrayList<cliente> ListaClientes) {
        for (cliente ListaN : ListaClientes) {
            System.out.println(ListaN.toString());
        }
    }

    public static cliente CheckCliente(ArrayList<cliente> ListaClientes, int Buscar) {
        cliente ClienteTemporal = null;
        //se podria implementat busqueda dicotomica ordenando los arrays por id
        for (int i = 0; i < ListaClientes.size(); i++) {
            if (ListaClientes.get(i).getDni() == Buscar) {
                ClienteTemporal = ListaClientes.get(i);
                break;
            }
        }
        return ClienteTemporal;
    }

    public static String IntroducirDatos(String Pregunta) {
        String respuesta;
        respuesta = JOptionPane.showInputDialog(null, Pregunta);
        return respuesta;

    }

    public static void ordenarPorNombre(ArrayList<cliente> listaClientes) {
        Collections.sort(listaClientes, new Comparator<cliente>() {
            @Override
            public int compare(cliente c1, cliente c2) {
                int string = (c1.getApellido().compareTo(new String(c2.getApellido())));
                return string;
            }
        });
    }

    public static void MenuVehiculos(ArrayList<cliente> listaClientes, cliente Cliente) {
        int decision = 0;
        do {
            decision = Integer.parseInt(IntroducirDatos("1. Nuevo Vehículo\n"
                    + "2. Listar Vehículos:\n"
                    + "3. Buscar Vehículo:\n"
                    + "4. Modificar kms Vehículo:\n"
                    + "5. Eliminar vehiculo\n"
                    + "6. Salir:"));

            switch (decision) {
                case 1: {
                    //crear vehiculo(metodo) devuelva el vehiculo//null
                    Cliente.getVehiculos().add(CrearVehiculo(listaClientes));

                    break;
                }
                case 2: {//listar vehiculos
                    break;
                }
                case 3: {//buscar vehiculo
                    break;
                }
                case 4: {//modificar kms vehiculo
                    break;
                }
                case 5: {//eliminar vehiculo
                    break;
                }
                case 6: {//volver al menu anterior!
                    break;
                }
            }
        } while (decision != 6);

    }

    public static vehiculo CrearVehiculo(ArrayList<cliente> listaClientes) {
        String marca, matricula, fecha;
        int kilometros, n_puertas, carga, volumen;
        double precio, cc;
        
        //chekear que la matricula no existe
        do {
            matricula = JOptionPane.showInputDialog("Matricula?");
        } while (CheckMatricula(listaClientes, matricula));
        //preguntar informacion general
        marca = JOptionPane.showInputDialog("Marca?");
        fecha = JOptionPane.showInputDialog("Fecha de matriculacion?");
        kilometros = Integer.parseInt(JOptionPane.showInputDialog("Kilometros"));
        precio = Double.parseDouble(JOptionPane.showInputDialog("Precio?"));
        switch ((JOptionPane.showInputDialog(null, "T:Turismo D:Deportivo F:Furgoneta")).toUpperCase().charAt(0)) {

            case 'T': {
                //preguntar informacion especifica
                n_puertas = Integer.parseInt(JOptionPane.showInputDialog("Cuantas puertas tiene el turismo?"));
                return new turismo(n_puertas, marca, matricula, fecha, kilometros, precio);
            }
            case 'D': {
                cc = Double.parseDouble(JOptionPane.showInputDialog("Cuanta cc tiene el deportivo?"));
                return new deportivo(cc, marca, matricula, fecha, kilometros, precio);
            }
            case 'F': {
                carga = Integer.parseInt(JOptionPane.showInputDialog("Cuanta carga tiene la furgoneta?"));
                volumen = Integer.parseInt(JOptionPane.showInputDialog("Cuanta volumen tiene la furgoneta?"));
                return new furgoneta(carga, volumen, marca, matricula, fecha, kilometros, precio);
            }
        }
        return null;
    }

    public static boolean CheckMatricula(ArrayList<cliente> listaClientes, String matricula) {//cambiar boolean por devolver vehiculo que existe :D
        //se podria implementat busqueda dicotomica ordenando los arrays por id
        boolean existe = false;
        for (int i = 0; i < listaClientes.size()-1; i++) {
            for (int j = 0; j < listaClientes.get(i).getVehiculos().size()-1; j++) {
                if (listaClientes.get(i).getVehiculos().get(j).getMatricula().equals(matricula)) {
                    existe = true;
                    break;
                }
            }
        }
        return existe;
    }
}
