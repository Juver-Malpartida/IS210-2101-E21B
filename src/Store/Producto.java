package Store;

public class Producto {
    private String idproducto;
    private String nombre_producto;
    private int stock;
    private double precioCompra;
    private double precioVenta;


    public Producto(String idproducto, String nombre_producto, int stock, double precioCompra, double precioVenta) {
        this.idproducto = idproducto;
        this.nombre_producto = nombre_producto;
        this.stock = stock;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    public String getIdproducto() {
        return idproducto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idproducto='" + idproducto + '\'' +
                ", nombre_producto='" + nombre_producto + '\'' +
                ", stock=" + stock +
                ", precioCompra=" + precioCompra +
                ", precioVenta=" + precioVenta +
                '}';
    }
}
