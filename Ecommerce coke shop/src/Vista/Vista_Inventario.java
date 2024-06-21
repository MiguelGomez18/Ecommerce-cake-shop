package Vista;
import Controlador.Controlador_Inventario;
import javax.swing.*;

public class Vista_Inventario {

    public Vista_Inventario() {
    }

    public int menu(){
        return Integer.parseInt(JOptionPane.showInputDialog("Bienvenido a Ecommerce Cake Shop Master\n1.Mostrar\n2.Consultar por codigo\n3.Consultar por tipo\n4.Consultar tipo/sabor\n5.Modificar producto\n6.agregar producto\n7.Salir"));
    }

    public void imprimir(String texto){
        JOptionPane.showMessageDialog(null,texto);
    }

    public void Conectar(){
        Controlador_Inventario controlador_inventario = new Controlador_Inventario();
        controlador_inventario.Control();
    }

    public  int obtenerCodigo(){
        return Integer.parseInt(JOptionPane.showInputDialog("Digita el codigo: "));
    }

    public String obtenerTipo(){
        return JOptionPane.showInputDialog("Digita el tipo: ").toUpperCase();
    }

    public String obtenerSabor(){
        return JOptionPane.showInputDialog("Digita el sabor: ").toUpperCase();
    }

    public double obtenerPrecio(){
        return Double.parseDouble(JOptionPane.showInputDialog("Digita precio: "));
    }

    public int obtenerCantidad(){
        return Integer.parseInt(JOptionPane.showInputDialog("Digita cantidad: "));
    }

}