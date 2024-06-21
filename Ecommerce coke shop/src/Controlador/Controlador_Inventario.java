package Controlador;

import Modelo.BaseDatosInventario;
import Modelo.Inventario;
import Vista.Vista_Inventario;

public class Controlador_Inventario {

    BaseDatosInventario nuevoProducto = new BaseDatosInventario();
    Vista_Inventario vista = new Vista_Inventario();

    public void Control() {
        boolean iterarEnControl = true;

        while (iterarEnControl) {
            int opciones = vista.menu();
            switch (opciones) {
                case 1:
                    vista.imprimir(nuevoProducto.mostrar());
                    break;
                case 2:
                    int codigoConsultar = vista.obtenerCodigo();
                    vista.imprimir(nuevoProducto.consultarProductoPorCodigo(codigoConsultar));
                    break;
                case 3:
                    String tipoConsultar = vista.obtenerTipo();
                    vista.imprimir(nuevoProducto.consultarProductoPorTipo(tipoConsultar));
                    break;
                case 4:
                    String tipoSaborConsultar = vista.obtenerTipo();
                    String saborConsultar = vista.obtenerSabor();
                    vista.imprimir(nuevoProducto.consultarProductoPorSabor(tipoSaborConsultar, saborConsultar));
                    break;
                case 5:
                    int codigoModificar = vista.obtenerCodigo();
                    if (nuevoProducto.buscarParaModificar(codigoModificar)) {
                        vista.imprimir(nuevoProducto.mostrarParaModificar(codigoModificar));
                        String nuevoTipo = vista.obtenerTipo();
                        String nuevoSabor = vista.obtenerSabor();
                        double nuevoPrecio = vista.obtenerPrecio();
                        int nuevaCantidad = vista.obtenerCantidad();
                        vista.imprimir(nuevoProducto.modificarProductos(nuevoTipo, nuevoSabor, nuevoPrecio, nuevaCantidad));
                    } else {
                        vista.imprimir("Producto no encontrado para modificar.");
                    }
                    break;
                case 6:
                    String tipoNuevo = vista.obtenerTipo();
                    String saborNuevo = vista.obtenerSabor();
                    double precioNuevo = vista.obtenerPrecio();
                    int cantidadNueva = vista.obtenerCantidad();
                    Inventario nuevoInventario = new Inventario(tipoNuevo, saborNuevo, precioNuevo, cantidadNueva);
                    vista.imprimir(nuevoProducto.registrarProductosEnInventario(nuevoInventario));
                    break;

                case 7:
                    iterarEnControl = false;
                    break;

            }
        }
    }
}
