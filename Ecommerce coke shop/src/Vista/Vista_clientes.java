package Vista;

import Controlador.Controlador_clientes;

import javax.swing.*;

public class Vista_clientes {
    public int opcion;
    public int menu(){
        int menuGeneral= Integer.parseInt(JOptionPane.showInputDialog("Bienvenido al gestion de clientes\n1.Registrar clientes\n2.Eliminar clientes\n3.Consultar informacion de clientes\n4.Actualizar informacion de clientes\n5.Cambiar estado del cliente\n6.Restablecer contraseña del cliente\n7.Mostrar\n8.Salir"));
        return menuGeneral;
    }

    public void imprimir (String texto){
        JOptionPane.showMessageDialog(null,texto);
    }
    public void conectar(){
        Controlador_clientes controlador_clientes = new Controlador_clientes();
        controlador_clientes.control();
    }

    public int obtenerCodigo(){
        return Integer.parseInt(JOptionPane.showInputDialog("Digita el codigo"));
    }

    public int obtenerDocumento(){
        return Integer.parseInt(JOptionPane.showInputDialog("Digita el documento"));
    }

    public String obtenerNombre(){
        return JOptionPane.showInputDialog("Digita el nombre").toUpperCase();
    }

    public String obtenerApellido(){
        return JOptionPane.showInputDialog("Digita el apellido").toUpperCase();
    }

    public String obtenerCorreo(){
        return JOptionPane.showInputDialog("Digita el correo");
    }

    public String obtenerContrasena(){
        return JOptionPane.showInputDialog("Digita la contraseña");
    }

    public int obtenerTelefono(){
        return Integer.parseInt(JOptionPane.showInputDialog("Digita el numero de telefono"));
    }
    public String obtenerDireccion(){
        return JOptionPane.showInputDialog("Digita la direccion").toLowerCase();
    }

    public String obtenerEstado(){
        return JOptionPane.showInputDialog("Digita el estado (Habilitado/desabilitado)").toUpperCase();
    }

}
