package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String destinatario;
    private List<Integer> productos;
    private List<Integer> cantidad;
    private String hora;
    private String direccion;
    private double total;
    private String estado;

    public Pedido() {
        this.productos = new ArrayList<>();
        this.cantidad = new ArrayList<>();
    }

    public Pedido(String destinatario, List<Integer> productos, List<Integer> cantidad, String hora, String direccion, double total, String estado) {
        this.destinatario = destinatario;
        this.productos = productos;
        this.cantidad = cantidad;
        this.hora = hora;
        this.direccion = direccion;
        this.total = total;
        this.estado = estado;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public List<Integer> getProductos() {
        return productos;
    }

    public void setProductos(List<Integer> productos) {
        this.productos = productos;
    }

    public List<Integer> getCantidad() {
        return cantidad;
    }

    public void setCantidad(List<Integer> cantidad) {
        this.cantidad = cantidad;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "\nPedido" +
                "\nDestinatario: " + destinatario +
                "\nProductos: " + productos +
                "\nCantidad: " + cantidad +
                "\nHora: " + hora +
                "\nDireccion: " + direccion +
                "\nTotal neto: $" + total +
                "\nEstado: " + estado + '\n';
    }


}
