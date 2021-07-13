package Store;

public class Item {
    private String nro_item;
    private Producto producto;
    private int cantidad;

    public Item(String nro_item, Producto producto, int cantidad) {
        this.nro_item = nro_item;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public String getNro_item() {
        return nro_item;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int actualizar_stock_Entrada(){
        return producto.getStock()+cantidad;
    }

    public int actualizar_stock_Salida(){
        return producto.getStock()-cantidad;
    }

    public double calcularValorEntrada(){
        return producto.getPrecioCompra()*cantidad;
    }
    public double calcularValorSalida(){
        return producto.getPrecioVenta()*cantidad;
    }

    @Override
    public String toString() {
        return
                "nro_item='" + nro_item + '\'' +
                ", producto=" + producto.getNombre_producto() +
                ", cantidad=" + cantidad +
                '}';
    }
}
