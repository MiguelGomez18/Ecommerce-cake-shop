package Modelo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class BaseDatosPedidos extends BaseDatosInventario {

    private Map<Integer, Pedido> baseDatosPedidos;
    private Map<Integer, Inventario> baseDatosInventario = super.getBaseDatosInventario();
    String fileNamePedido = "pedidos.json";
    String fileNameInventario = "inventario.json";

    public BaseDatosPedidos() {

        Gson gson = new Gson();
        Type type_pedido = new  TypeToken<Map<Integer, Pedido>>(){}.getType();

        try (FileReader reader_pedido = new FileReader(fileNamePedido)) {
            baseDatosPedidos = gson.fromJson(reader_pedido, type_pedido);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (baseDatosPedidos == null) {
            baseDatosPedidos = new HashMap<>();
        }
        super.aletarFaltaDeProductos();
    }

    private void guardarArchivoPedido() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(fileNamePedido)) {
            gson.toJson(baseDatosPedidos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void guardarArchivoInventario() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(fileNameInventario)) {
            gson.toJson(baseDatosInventario, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String verificarPago() {
        String texto = "";
        boolean validar=false;
        for (Pedido p: baseDatosPedidos.values()) {
            if (p.getTotal()!=0) {
                validar=true;
                texto += p.toString();
            }
        }

        if (!validar) {
            texto="PAGOS EXITOSOS";
        }

        return texto;
    }

    public String eliminarPedido(int codigo) {
        String texto = "";
        boolean valido = false;
        if (baseDatosPedidos.containsKey(codigo)) {
            baseDatosPedidos.remove(codigo);
            valido = true;
            texto = "Se ha eliminado";
        }

        if (!valido) {
            texto = "NO existe ese ID";
        }
        guardarArchivoPedido();
        return texto;
    }

    public String registrarPedido(int codigo, Pedido pedido){
        String texto = "";
        if (baseDatosPedidos.containsKey(codigo)) {
            texto = "Este producto ya existe";
        } else {
            double total = 0;
            for (int p : pedido.getProductos()) {
                if (baseDatosInventario.containsKey(p)) {
                    double precio = baseDatosInventario.get(p).getPrecio();
                    List<Integer> cantidades = pedido.getCantidad();
                    int cantidad = cantidades.get(pedido.getProductos().indexOf(p));
                    int canti = baseDatosInventario.get(p).getCantidad();
                    canti-=cantidad;
                    baseDatosInventario.get(p).setCantidad(canti);
                    total += precio * cantidad;
                }
            }
            pedido.setTotal(total);
            baseDatosPedidos.put(codigo, pedido);
            texto = "Agregado exitosamente";
        }
        guardarArchivoInventario();
        guardarArchivoPedido();
        return texto;
    }

    public String mostrarDetallesPedido(String destinatario) {
        String texto = "";
        boolean validar=false;
        for (Pedido p: baseDatosPedidos.values()) {
            if (p.getDestinatario().equals(destinatario)) {
                validar=true;
                texto += p.toString();
            }
        }

        if (!validar) {
            texto="Destinario inexistente";
        }

        return texto;
    }

    public boolean buscarParaModificarEstado(int codigo) {
        return baseDatosPedidos.containsKey(codigo);
    }

    public String mostrarParaModificarEstado(int codigo) {
        String texto = "";
        if (baseDatosPedidos.containsKey(codigo)) {
            texto += baseDatosPedidos.get(codigo).toString();
        }
        return texto;
    }

    public String modificarEstadoPedido(int codigo, String estado) {
        String mensaje = "";
        boolean valida = false;
        if (baseDatosPedidos.containsKey(codigo)) {
            valida = true;
            baseDatosPedidos.get(codigo).setEstado(estado);
            mensaje = "Ya se ha modificado";
        }

        if (!valida) {
            mensaje = "Pedido no encontrado";
        }
        guardarArchivoPedido();
        return mensaje;
    }

    public String mostrarPedidosCliente(String destinatario) {
        String texto = "";
        boolean validar = false;
        for (int p: baseDatosPedidos.keySet()) {
            String destinatario_bd = baseDatosPedidos.get(p).getDestinatario();
            if (destinatario_bd.equals(destinatario)) {
                texto += baseDatosPedidos.get(p).toString();
                validar=true;
            }

        }
        if (!validar) {
            texto="Destinatario no encontrado";
        }
        return texto;
    }

    public String mostrarPedidos() {
        String texto = "";
        for (Pedido p: baseDatosPedidos.values()) {
            texto += p.toString();
        }
        return texto;
    }
}
