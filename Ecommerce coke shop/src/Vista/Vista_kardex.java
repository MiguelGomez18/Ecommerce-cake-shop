package Vista;
import Controlador.Controlador_Inventario;
import Controlador.Controlador_kardex;

import javax.swing.*;

public class Vista_kardex {

    public Vista_kardex() {
    }

    public int menu() {
        return Integer.parseInt(JOptionPane.showInputDialog("Bienvenido a Ecommerce Cake Shop Master\n1.productos en general\n2.producto por agotarse\n3.salir"));
    }

    public void imprimir(String texto) {
        JOptionPane.showMessageDialog(null, texto);
    }

    public void conectar() {
        Controlador_kardex controlador_kardex = new Controlador_kardex();
        controlador_kardex.Control();
    }
}