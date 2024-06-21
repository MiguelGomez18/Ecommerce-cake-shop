package Vista;
import Controlador.Controlador_Pedidos;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Vista_Pedidos {

    public Vista_Pedidos() {
    }

    public int menu(){
        return Integer.parseInt(JOptionPane.showInputDialog("Bienvenido a Ecommerce Cake Shop Master\n1.Mostrar pedidos\n2.Consultar detalles de pedidos\n3.Consultar pedidos del cliente\n4.Verificar pagos\n5.Modificar estado del pedido\n6.agregar pedido\n7.Eliminar pedido\n8.Salir"));
    }

    public void imprimir(String texto){
        JOptionPane.showMessageDialog(null,texto);
    }

    public void Conectar(){
        Controlador_Pedidos controlador_pedidos = new Controlador_Pedidos();
        controlador_pedidos.Control();
    }

    public  int obtenerCodigo(){
        return Integer.parseInt(JOptionPane.showInputDialog("Digita el codigo: "));
    }

    public String obtenerDestinatario(){
        return JOptionPane.showInputDialog("Digita el destinatario: ").toUpperCase();
    }

    public List<Integer> obtenerProductos(){
        List<Integer> productos = new ArrayList<>();
        String entrada = JOptionPane.showInputDialog("Digita los ID de los productos separados por comas: ");

        if (entrada != null) {
            String[] productoIDs = entrada.split(",");
            for (String productoID : productoIDs) {
                productos.add(Integer.parseInt(productoID));
            }
        }

        return productos;
    }

    public List<Integer> obtenerCantidades(){
        List<Integer> cantidad = new ArrayList<>();
        String entrada = JOptionPane.showInputDialog("Digita la cantidad de los productos separados por comas: ");
        if (entrada != null) {
            String[] cantidadess = entrada.split(",");
            for (String cantidades : cantidadess) {
                cantidad.add(Integer.parseInt(cantidades));
            }
        }
        return cantidad;
    }

    public String obtenerHora(){
        return JOptionPane.showInputDialog("Digita la hora: ");
    }

    public String obtenerDireccion(){
        return JOptionPane.showInputDialog("Digita la direccion: ").toLowerCase();
    }

    public String obtenerEstado(){
        return JOptionPane.showInputDialog("Digita el estado: ").toUpperCase();
    }
}
