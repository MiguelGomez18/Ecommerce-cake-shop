package Modelo;

import java.util.Map;

public class BaseDatosKardex extends BaseDatosInventario {
   
    private Map<Integer, Inventario> baseDatosInventario = super.getBaseDatosInventario();




    public String reporteInventarioGeneral() {
        String reporte = "Tipo Sabor Cantidad Precio Unitario Valor Total\n";
        for (Inventario inventario : baseDatosInventario.values()) {
            double valorTotal = inventario.getCantidad() * inventario.getPrecio();
            reporte += inventario.getTipo() + " " +
                    inventario.getSabor() + " " +
                    inventario.getCantidad() + " " +
                    inventario.getPrecio() + " " +
                    valorTotal + "\n";
        }
        return reporte;
    }


    public String reporteProductosBajoMinimos() {
        int nivelMinimo = 3;
        String reporte = "Tipo Sabor Cantidad\n";
        for (Inventario inventario : baseDatosInventario.values()) {
            if (inventario.getCantidad() < nivelMinimo) {
                reporte += inventario.getTipo() + " " +
                        inventario.getSabor() + " " +
                        inventario.getCantidad() + "\n";
            }
        }
        return reporte;
    }





}