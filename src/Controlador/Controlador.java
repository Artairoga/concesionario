/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import java.time.LocalDate;
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
        String dni;
        dni = (JOptionPane.showInputDialog("Que dni tiene el nuevo cliente?"));
        nombre = JOptionPane.showInputDialog("Que nombre tiene el nuevo cliente?");
        apellidos = JOptionPane.showInputDialog("Que apellidos tiene el nuevo cliente?");
        
        if (Objects.isNull(CheckCliente(ListaClientes, dni))) {
            //System.out.println("El objeto no existe,lo creo");
            ListaClientes.add(new cliente(dni, nombre, apellidos));
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe el cliente con dni:" + dni);
        }
    }
    
    public static void BorrarCliente(ArrayList<cliente> ListaClientes, String Buscar) {//
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
    
    public static cliente CheckCliente(ArrayList<cliente> ListaClientes, String Buscar) {
        cliente ClienteTemporal = null;
        //se podria implementat busqueda dicotomica ordenando los arrays por id
        for (int i = 0; i < ListaClientes.size(); i++) {
            if (ListaClientes.get(i).getDni().equals(Buscar)) {
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
        String matricula;
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
                    ListarVehiculos(Cliente);
                    break;
                }
                case 3: {//buscar vehiculo
                    matricula = JOptionPane.showInputDialog("Matricula a buscar?");//meter esto dentro del metodo
                    BuscarVehiculos(listaClientes, matricula);
                    break;
                }
                case 4: {//modificar kms vehiculo
                    //meter esto dentro del metodo
                    ModificarKMVehiculo(listaClientes);
                    break;
                }
                case 5: {//eliminar vehiculo
                    EliminarVehiculo(listaClientes);
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
        char decision;

        //chekear que la matricula no existe
        do {
            matricula = JOptionPane.showInputDialog("Matricula?");
        } while (!Objects.isNull(CheckMatricula(listaClientes, matricula)));//si es null significa que no existe
        //preguntar informacion general
        while (true) {
            marca = JOptionPane.showInputDialog("Marca?");
            fecha = JOptionPane.showInputDialog("Fecha de matriculacion?");
            kilometros = Integer.parseInt(JOptionPane.showInputDialog("Kilometros"));
            precio = Double.parseDouble(JOptionPane.showInputDialog("Precio?"));
            decision = JOptionPane.showInputDialog(null, "T:Turismo D:Deportivo F:Furgoneta").toUpperCase().charAt(0);
            switch (decision) {
                case 'T': {
                    //preguntar informacion especifica
                    n_puertas = Integer.parseInt(JOptionPane.showInputDialog("Cuantas puertas tiene el turismo?"));
                    return new turismo(n_puertas, marca, matricula, LocalDate.parse(fecha), kilometros, precio);
                }
                case 'D': {
                    cc = Double.parseDouble(JOptionPane.showInputDialog("Cuanta cc tiene el deportivo?"));
                    return new deportivo(cc, marca, matricula, LocalDate.parse(fecha), kilometros, precio);
                }
                case 'F': {
                    carga = Integer.parseInt(JOptionPane.showInputDialog("Cuanta carga tiene la furgoneta?"));
                    volumen = Integer.parseInt(JOptionPane.showInputDialog("Cuanta volumen tiene la furgoneta?"));
                    return new furgoneta(carga, volumen, marca, matricula, LocalDate.parse(fecha), kilometros, precio);
                }
            }
        }
    }
    
    public static vehiculo CheckMatricula(ArrayList<cliente> listaClientes, String matricula) {//cambiar boolean por devolver vehiculo que existe :D
        //se podria implementat busqueda dicotomica ordenando los arrays por id
        for (cliente listaC : listaClientes) {
            for (vehiculo listaV : listaC.getVehiculos()) {
                if (listaV.getMatricula().equals(matricula)) {
                    return listaV;
                }
            }
        }
        return null;
    }
    
    public static ArrayList<vehiculo> ListarVehiculos(cliente Cliente) {//hacer que devuelva el arraylist de vehiculos ordenados,crear metodo recorrer array de vehiculos,y listarlos
       //sino hacerlo con que devuelva una string 
        ArrayList<turismo> ts=new ArrayList<>();
        ArrayList<furgoneta> fs=new ArrayList<>();
        ArrayList<deportivo> ds=new ArrayList<>();
        ArrayList<vehiculo> listaCompleta=new ArrayList<>();
        for (vehiculo listaV : Cliente.getVehiculos()) {
            if (listaV instanceof turismo) {
                ts.add((turismo)listaV);
            }else if(listaV instanceof furgoneta){
                fs.add((furgoneta)listaV);
            }else if(listaV instanceof deportivo){
                ds.add((deportivo)listaV);
            }
        }
        listaCompleta.addAll(ts);
        listaCompleta.addAll(fs);
        listaCompleta.addAll(ds);
        for (vehiculo ListaV : listaCompleta) {
            System.out.println(ListaV.toString());
        }
        return listaCompleta;
        
    }
    
    private static void BuscarVehiculos(ArrayList<cliente> listaClientes, String matricula) {
        if (Objects.isNull(CheckMatricula(listaClientes, matricula))) {
            JOptionPane.showMessageDialog(null, "No existe vehículo con la matrícula introducida");
        } else {
            System.out.println((CheckMatricula(listaClientes, matricula)).visualizarPadre());
        }
    }
    
    public static void ModificarKMVehiculo(ArrayList<cliente> listaClientes) {
        String matricula = JOptionPane.showInputDialog("Matricula a buscar?");
        int kilometros = Integer.parseInt(JOptionPane.showInputDialog("Nuevos KM"));
        if (Objects.isNull(CheckMatricula(listaClientes, matricula))) {
            JOptionPane.showMessageDialog(null, "No existe vehículo con la matrícula introducida");
        } else {
            CheckMatricula(listaClientes, matricula).setKilometros(kilometros);
        }
    }
    
    private static void EliminarVehiculo(ArrayList<cliente> listaClientes) {
        String matricula = JOptionPane.showInputDialog("Matricula a buscar?");
        if (Objects.isNull(CheckMatricula(listaClientes, matricula))) {
            JOptionPane.showMessageDialog(null, "No existe vehículo con la matrícula introducida");
        } else {
            for (cliente listaC : listaClientes) {
                for (vehiculo listaV : listaC.getVehiculos()) {
                    if (listaV.getMatricula().equals(matricula)) {
                        listaC.getVehiculos().remove(listaV);
                    }
                }
            }
        }
    }

    
}
