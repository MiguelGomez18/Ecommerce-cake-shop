package Modelo;
public class Inventario {
    private String tipo;
    private String sabor;
    private double precio;
    private int cantidad;

    public Inventario(String tipo, String sabor, double precio, int cantidad) {
        this.tipo = tipo;
        this.sabor = sabor;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "\nInventario" +
                "\nTipo " + tipo +
                "\nSabor " + sabor +
                "\nPrecio " + precio +
                "\nCantidad " + cantidad + '\n';
    }
}
