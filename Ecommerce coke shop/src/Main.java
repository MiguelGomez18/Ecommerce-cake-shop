import Vista.Vista_Inventario;
import Vista.Vista_Pedidos;
import Vista.Vista_clientes;

public class Main {
    public static void main(String[] args) {
//        Vista_Inventario v = new Vista_Inventario();
//        v.Conectar();
//        Vista_Pedidos v = new Vista_Pedidos();
//        v.Conectar();
        Vista_clientes vista_clientes = new Vista_clientes();
        vista_clientes.conectar();
    }
} 