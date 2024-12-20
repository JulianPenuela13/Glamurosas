
package Modelo;


public class Productos {
    
    private int id;
    private String codigo;
    private String nombre;
    private String provedor;
    private int stock;
    private double precio;
    private double preciocompra;

    public Productos() {
    }

    public Productos(int id, String codigo, String nombre, String provedor, int stock, double precio, double preciocompra) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.provedor = provedor;
        this.stock = stock;
        this.precio = precio;
        this.preciocompra = preciocompra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvedor() {
        return provedor;
    }

    public void setProvedor(String provedor) {
        this.provedor = provedor;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPreciocompra() {
        return preciocompra;
    }

    public void setPreciocompra(double preciocompra) {
        this.preciocompra = preciocompra;
    }

    
    
    
    
}
