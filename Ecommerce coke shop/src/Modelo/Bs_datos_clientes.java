package Modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Bs_datos_clientes {
    private HashMap<Integer, Clientes> listaClientes = new HashMap<>();

    public void escribirJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(listaClientes);
        try (FileWriter writer = new FileWriter("clientes.json")) {
            writer.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leerJson() {
        String jsonString = "";

        try (FileReader reader = new FileReader("clientes.json")) {
            StringBuilder builder = new StringBuilder();
            int ch;
            while ((ch = reader.read()) != -1) {
                builder.append((char) ch);
            }
            jsonString = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        listaClientes = gson.fromJson(jsonString, new TypeToken<HashMap<Integer, Clientes>>() {}.getType());
    }


    public String mostrar(){
        leerJson();
        String mensaje="";
        for(Clientes t: listaClientes.values()){
            mensaje += t.toString();
        }
        return mensaje;
    }

    public String registrarClientes(Clientes p){
        this.leerJson();

        String texto = "";
        boolean valido = false;
        for (int i : listaClientes.keySet()) {
            int codigo = listaClientes.get(i).getCodigo();
            int documento = listaClientes.get(i).getDocumento();
            if (codigo == p.getCodigo() || documento == p.getDocumento()) {
                valido = true;
                texto = "Esta persona ya se encuentra registrada";
            }
        }
        if (!valido) {
            listaClientes.put(p.getCodigo(), p);
            texto = "se agrego correctamente";
        }
        escribirJson();
        return texto;
    }


    public String eliminarCliente(int documento) {
        this.leerJson();
        if (listaClientes.containsKey(documento)) {
            listaClientes.remove(documento);
            this.escribirJson();
            return "El cliente fue borrado exitosamente.";
        } else {
            return "No se encontro el cliente a eliminar.";
        }
    }

    public String consultarPorNombre(String nombre){
        leerJson();
        String mensaje="";
        for (Clientes i:listaClientes.values()){
            if (i.getNombre().equals(nombre)){
                mensaje += i.toString();
            }
        }
        return mensaje;
    }

    public String consultarPorDocumento(int documento){
        leerJson();
        String mensaje="";
        for (Clientes i:listaClientes.values()){
            if (documento == i.getDocumento()){
                mensaje += i.toString();
            }
        }
        return mensaje;
    }


    public String validarCodigoModificar(int documento){
        leerJson();
        String mensaje="";
        boolean valido= false;
        for (int i : listaClientes.keySet()){
            int obtenerDocumento=listaClientes.get(i).getDocumento();
            if (obtenerDocumento == documento){
                valido=true;
                mensaje="si";
            }
        }
        if (!valido){
            mensaje="no";
        }

        return mensaje;
    }

    public void modificar(int documentoNuevo,String nombrenuevo,String apellidonuevo,String correoNuevo,String contrasenaNuevo,String estadoNuevo,int telefonoNuevo,String direcionNuevo){
        leerJson();
        for (int i : listaClientes.keySet()){
            int obtenerDocumento=listaClientes.get(i).getDocumento();
            if (obtenerDocumento == documentoNuevo){
                listaClientes.get(i).setNombre(nombrenuevo);
                listaClientes.get(i).setApellido(apellidonuevo);
                listaClientes.get(i).setCorreo(correoNuevo);
                listaClientes.get(i).setContrasena(contrasenaNuevo);
                listaClientes.get(i).setEstado(estadoNuevo);
                listaClientes.get(i).setTelefono(telefonoNuevo);
                listaClientes.get(i).setDireccion(direcionNuevo);

                JOptionPane.showMessageDialog(null, "Los datos se modificaron correctamente");
            }
        }
        escribirJson();
    }





}
