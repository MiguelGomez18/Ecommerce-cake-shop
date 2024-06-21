package Controlador;

import Modelo.Bs_datos_clientes;
import Modelo.Clientes;
import Vista.Vista_clientes;

import javax.swing.*;

public class Controlador_clientes {
    Vista_clientes vista_clientes = new Vista_clientes();
    Bs_datos_clientes bs_datos_clientes = new Bs_datos_clientes();
    Clientes clientes = new Clientes();

    public void control(){
        int op = 0;
        boolean control = true;

        while (control){
            op = vista_clientes.menu();

            switch (op){
                case 1:
                    int codigo = vista_clientes.obtenerCodigo();
                    int documento = vista_clientes.obtenerDocumento();
                    String nombre = vista_clientes.obtenerNombre();
                    String apellido = vista_clientes.obtenerApellido();
                    String correo = vista_clientes.obtenerCorreo();
                    String contrasena = vista_clientes.obtenerContrasena();
                    int telefono = vista_clientes.obtenerTelefono();
                    String direccion = vista_clientes.obtenerDireccion();

                    Clientes clientes1 = new Clientes(codigo,documento,nombre,apellido,correo,contrasena,telefono,direccion,"HABILITADO");
                    String mensaje = bs_datos_clientes.registrarClientes(clientes1);
                    vista_clientes.imprimir(mensaje);

                    break;

                case 2:
                    int codigoEliminar= vista_clientes.obtenerCodigo();
                    bs_datos_clientes.eliminarCliente(codigoEliminar);
                    vista_clientes.imprimir(bs_datos_clientes.mostrar());
                    break;
                case 3:
                    int menuConsulta = Integer.parseInt(JOptionPane.showInputDialog("¿Vas a consultar por?\n1.Por nombre \n2.Por documento"));
                    if (menuConsulta == 1){
                        String nombreConsulta = vista_clientes.obtenerNombre();
                        vista_clientes.imprimir(bs_datos_clientes.consultarPorNombre(nombreConsulta));
                    }
                    if (menuConsulta == 2){
                        int documentoConsulta = vista_clientes.obtenerDocumento();
                        bs_datos_clientes.consultarPorDocumento(documentoConsulta);
                        vista_clientes.imprimir(bs_datos_clientes.consultarPorDocumento(documentoConsulta));
                    }
                    break;
                case 4:
                    int documentoModificar = vista_clientes.obtenerDocumento();
                    String validarCodigo = bs_datos_clientes.validarCodigoModificar(documentoModificar);

                    if (validarCodigo.equals("si")){
                        String nombreNuevo = vista_clientes.obtenerNombre();
                        String apellidoNuevo = vista_clientes.obtenerApellido();
                        String correoNuevo = vista_clientes.obtenerCorreo();
                        String contrasenaNuevo = vista_clientes.obtenerContrasena();
                        String estadoNuevo = vista_clientes.obtenerEstado();
                        int telefonoNuevo = vista_clientes.obtenerTelefono();
                        String direccionNuevo = vista_clientes.obtenerDireccion();

                        bs_datos_clientes.modificar(documentoModificar,nombreNuevo,apellidoNuevo,correoNuevo,contrasenaNuevo,estadoNuevo,telefonoNuevo,direccionNuevo);

                    } else {
                        vista_clientes.imprimir("Documento no encontrado");
                    }
                    break;

                case 7:
                    vista_clientes.imprimir(bs_datos_clientes.mostrar());
                    break;
                case 8:
                    vista_clientes.imprimir("Saliendo del programa");
                    control=false;
                    break;
            }
        }
    }
}
