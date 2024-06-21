package Modelo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class BaseDatosInventario {

    private Map<Integer, Inventario> baseDatosInventario;
    String fileNameInventario = "inventario.json";

    public BaseDatosInventario() {
//        baseDatos.put(1,new Inventario("GALLETA","CHOCOLATE",2000,3));
//        baseDatos.put(2,new Inventario("GALLETA","VAINILLA",3000,1));
////        baseDatos.put(3,new Inventario("GALLETA","FRESA",4000,10));

        Gson gson = new Gson();
        Type type_inventario = new TypeToken<Map<Integer, Inventario>>(){}.getType();

        try (FileReader reader_inventario = new FileReader(fileNameInventario)) {
            baseDatosInventario = gson.fromJson(reader_inventario, type_inventario);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (baseDatosInventario == null) {
            baseDatosInventario = new HashMap<>();
        }
        aletarFaltaDeProductos();

    }

    private void guardarArchivoInventario() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(fileNameInventario)) {
            gson.toJson(baseDatosInventario, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String consultarProductoPorCodigo(int codigo){
        String mensaje = "";
        boolean valida = false;
        if (baseDatosInventario.containsKey(codigo)){
            valida = true;
            mensaje+=baseDatosInventario.get(codigo).toString();
        }

        if (!valida){
            mensaje = "Este codigo no se encuentra registrado";
        }

        return mensaje;
    }

    public String consultarProductoPorTipo(String tipo){
        String mensaje = "";
        boolean valida = false;
        for (int iterador : baseDatosInventario.keySet()){
            String tip = baseDatosInventario.get(iterador).getTipo();
            if (tip.equals(tipo)){
                valida = true;
                mensaje+=baseDatosInventario.get(iterador).toString();
            }
        }

        if (!valida){
            mensaje = "No se encuentra este tipo de producto";
        }

        return mensaje;
    }

    public String consultarProductoPorSabor(String tipo,String sabor){
        String mensaje = "";
        boolean valida = false;
        for (int iterador : baseDatosInventario.keySet()){
            String tip = baseDatosInventario.get(iterador).getTipo();
            String sabo = baseDatosInventario.get(iterador).getSabor();
            if (tip.equals(tipo) && sabo.equals(sabor)){
                valida = true;
                mensaje+=baseDatosInventario.get(iterador).toString();
            }
        }

        if (!valida){
            mensaje = "No se encuentra este tipo de producto";
        }

        return mensaje;
    }

    public boolean buscarParaModificar(int codigo) {
        return baseDatosInventario.containsKey(codigo);
    }

    public String mostrarParaModificar(int codigo) {
        String texto = "";
        if (baseDatosInventario.containsKey(codigo)) {
            texto += baseDatosInventario.get(codigo).toString();
        }
        return texto;
    }

    public String modificarProductos(String tipo,String sabor,double precio, int cantidad) {
        String mensaje = "";
        boolean valida = false;
        for (int iterador :baseDatosInventario.keySet()) {
            String tipo_bd = baseDatosInventario.get(iterador).getTipo();
            String sabor_bd = baseDatosInventario.get(iterador).getSabor();
            if (tipo_bd.equals(tipo) && sabor_bd.equals(sabor)) {

                valida = true;

                baseDatosInventario.get(iterador).setPrecio(precio);
                baseDatosInventario.get(iterador).setCantidad(cantidad);

                mensaje = "Ya se ha modificado";
            }
        }

        if (!valida) {
            mensaje = "Producto no encontrado";
        }
        guardarArchivoInventario();
        return mensaje;
    }

    public void aletarFaltaDeProductos() {
        JOptionPane.showMessageDialog(null,"🛑🛑🛑🚩ALERTA🚩🛑🛑🛑");
        for (Inventario i: baseDatosInventario.values()) {
            if (i.getCantidad() == 0) {
                JOptionPane.showMessageDialog(null,"El Producto "+i.getTipo()+" DE "+i.getSabor()+" esta agotado");
            }
            if (i.getCantidad() <= 5 && i.getCantidad() != 0) {
                JOptionPane.showMessageDialog(null,"El Producto "+i.getTipo()+" DE "+i.getSabor()+" esta por agotarse quedan "+i.getCantidad()+" unidades");
            }
        }
    }

    public String registrarProductosEnInventario(Inventario inventario){
        String texto = "";
        boolean valido = false;
        for (int iterador : baseDatosInventario.keySet()) {
            String tipo = baseDatosInventario.get(iterador).getTipo();
            String sabor = baseDatosInventario.get(iterador).getSabor();
            if (tipo.equals(inventario.getTipo()) && sabor.equals(inventario.getSabor())) {
                valido = true;
                texto = "Este producto ya existe";
            }
        }
        if (!valido) {
            int codigo = 1;
            for (int num : baseDatosInventario.keySet()) {
                codigo+=num;
            }
            baseDatosInventario.put(codigo, inventario);
            texto = "Agregada exitosamente";
        }
        guardarArchivoInventario();
        return texto;
    }

    public String mostrar() {
        String texto = "";
        for (Inventario v : baseDatosInventario.values()) {
            texto+=v.toString();
        }
        aletarFaltaDeProductos();
        return texto;
    }

    public Map<Integer, Inventario> getBaseDatosInventario() {
        return baseDatosInventario;
    }

    public void setBaseDatosInventario(Map<Integer, Inventario> baseDatosInventario) {
        this.baseDatosInventario = baseDatosInventario;
    }

    @Override
    public String toString() {
        return "BD_inventario" +
                "baseDatos: " + baseDatosInventario + '\n';
    }
}
