package Controlador;

import Modelo.BaseDatosInventario;
import Modelo.BaseDatosPedidos;
import Modelo.Pedido;
import Vista.Vista_Pedidos;
import java.util.List;

public class Controlador_Pedidos {

    BaseDatosPedidos baseDatos = new BaseDatosPedidos();
    Vista_Pedidos vista = new Vista_Pedidos();

    public void Control() {
        int opciones = 0;

        boolean iterarEnControl = true;

        while (iterarEnControl){
            opciones = vista.menu();
            switch (opciones){
                case 1:
                    vista.imprimir(baseDatos.mostrarPedidos());
                    break;
                case 2:
                    String destinatario = vista.obtenerDestinatario();
                    vista.imprimir(baseDatos.mostrarDetallesPedido(destinatario));
                    break;
                case 3:
                    String destinatario2 = vista.obtenerDestinatario();
                    vista.imprimir(baseDatos.mostrarPedidosCliente(destinatario2));
                    break;
                case 4:
                    vista.imprimir(baseDatos.verificarPago());
                    break;
                case 5:
                    int codigo = vista.obtenerCodigo();
                    boolean valida = baseDatos.buscarParaModificar(codigo);
                    if (valida) {
                        vista.imprimir(baseDatos.mostrarParaModificarEstado(codigo));
                        String estado = vista.obtenerEstado();
                        vista.imprimir(baseDatos.modificarEstadoPedido(codigo,estado));
                    } else {
                        vista.imprimir("Pedido no encontrado");
                    }
                    break;
                case 6:
                    int codigo1 = vista.obtenerCodigo();
                    String destinatario3 = vista.obtenerDestinatario();
                    List<Integer> productos = vista.obtenerProductos();
                    List<Integer> cantidades = vista.obtenerCantidades();
                    String hora = vista.obtenerHora();
                    String direccion = vista.obtenerDireccion();
                    Pedido pedido = new Pedido(destinatario3,productos,cantidades,hora,direccion,0,"PREPARACION");
                    vista.imprimir(baseDatos.registrarPedido(codigo1,pedido));
                    break;
                case 7:
                    int codigo2 = vista.obtenerCodigo();
                    vista.imprimir(baseDatos.eliminarPedido(codigo2));
                    break;
                case 8:
                    iterarEnControl=false;
                    vista.imprimir("Saliste del programa");
                    break;
            }
        }
    }

}
