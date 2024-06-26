package Controlador;

import Modelo.BaseDatosInventario;
import Modelo.BaseDatosKardex;
import Vista.Vista_kardex;

public class Controlador_kardex {

    BaseDatosKardex nuevoProducto = new BaseDatosKardex();
    Vista_kardex vista = new Vista_kardex();

    public void Control() {
        boolean iterarEnControl = true;
        while (iterarEnControl) {
            int opciones  = vista.menu();
            switch (opciones){
                case 1:
                    vista.imprimir(nuevoProducto.reporteInventarioGeneral());
                    break;
                case 2:
                    vista.imprimir(nuevoProducto.reporteProductosBajoMinimos());
                    break;
                case 3:
                    iterarEnControl = false;
                    break;

            }
        }
    }

}

