package Modelo;

public class Clientes {
    private int codigo;
    private int documento;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private int telefono;
    private String direccion;
    private String estado;

    public Clientes() {
    }

    public Clientes(int codigo, int documento, String nombre, String apellido, String correo, String contrasena, int telefono, String direccion,String estado) {
        this.codigo = codigo;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
    }

    public Clientes(int codigo, int documento, String nombre, String apellido, String correo, String contrasena,String estado, int telefono, String direccion) {
        this.codigo = codigo;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "---Clientes---\n" +
                "\nCodigo: " + codigo +
                "\nDocumento: " + documento +
                "\nNombre: " + nombre +
                "\nApellido: " + apellido +
                "\nCorreo: " + correo +
                "\nContrasena: " + contrasena +
                "\nTelefono: " + telefono +
                "\nDireccion: " + direccion +
                "\nEstado: " + estado + '\n';

    }
}
