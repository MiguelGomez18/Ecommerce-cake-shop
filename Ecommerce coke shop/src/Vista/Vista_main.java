package Vista;

import Controlador.Controlador_kardex;
import Controlador.Controlador_main;

import javax.swing.*;

public class Vista_main {

    public Vista_main(){

    }

    public void conectar() {
        Controlador_main controlador_main = new Controlador_main();
        controlador_main.Control_padre();
    }

    public int menu() {
        return Integer.parseInt(JOptionPane.showInputDialog("Bienvenido a Ecommerce Cake Shop Master\n1.Modulo inventario\n2.Modulo Clientes\n3.Modulo Pedidos\n4.Modulo kardex\n5.salir"));
    }


}
