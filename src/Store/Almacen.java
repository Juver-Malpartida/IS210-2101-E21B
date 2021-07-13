package Store;

import Documents.DocumentSalida;
import Documents.Documento;
import Documents.DocumentoIngreso;
import Users.Usuario;

import java.util.Collections;

public class Almacen {
    Usuario[] usuarioss;
    Producto[] productoss;
    Documento[] documentoss;
    Item[] itemss;
    int cantidadDocumentos;
    int cantidadProductos;
    int cantidadusuarios;
    int cantidaditem;
    static final int maxdocumentos=1000;
    static final int maxusuarios=1000;
    static final int maxproductos=1000;
    static final int maxitem=1000;

    public Almacen() {
        this.itemss=new Item[maxitem];
        this.cantidaditem=0;
        this.usuarioss=new Usuario[maxusuarios];
        this.cantidadusuarios=0;
        this.productoss=new Producto[maxproductos];
        this.cantidadProductos=0;
        this.documentoss=new Documento[maxdocumentos];
        this.cantidadDocumentos=0;
    }

    //REGISTRAR
    public void registrar_usuario(Usuario user){
        usuarioss[cantidadusuarios]=user;
        cantidadusuarios++;
    }

    public void registrar_Producto(Producto product){
        productoss[cantidadProductos]=product;
        cantidadProductos++;
    }

    public void registrar_Documentos(Documento document){
        documentoss[cantidadDocumentos]=document;
        cantidadDocumentos++;
    }

    //LISTAR
    public void listarTrabajadores(){
        for(int i = 0; i < cantidadusuarios;i++){
            System.out.println(usuarioss[i]);
        }
    }

    public void listarProducto(){
        for(int i = 0; i < cantidadProductos;i++){
            System.out.println(productoss[i]);
        }
    }

    public void listarDocumentos(){
        for(int i=0;i<cantidadDocumentos;i++){
            System.out.println(documentoss[i]);
        }
    }
    public void registrar_Item(Item it){
        itemss[cantidaditem]=it;
        cantidaditem++;
    }

    public void listaritem(){
        for(int i = 0; i < cantidaditem;i++){
            System.out.println(itemss[i]);
        }
    }

    public Producto buscarxproducto(String nom_prod) throws ExceptionProductoNoEncontrado {
        for(int i = 0; i < cantidadProductos;i++) {
            Producto producto = productoss[i];
            if (producto.getNombre_producto().equals(nom_prod)) {
                return producto;
            }
        }
        throw new ExceptionProductoNoEncontrado();
    }

    public Producto buscarxproductoxcodigo(String cod_prod) throws ExceptionCodigoProductoNoEncontrado {
            for(int i = 0; i < cantidadProductos;i++) {
                Producto producto = productoss[i];
                if (producto.getIdproducto().equals(cod_prod)) {
                    return producto;
                }
            }
        throw new ExceptionCodigoProductoNoEncontrado();
    }

    public Documento ProveedorxIngreso(String proveedor)throws ExceptionProveedorNoEncontrado{
        for (int i=0 ;i<cantidadDocumentos; i++){
            Documento entrada= documentoss[i];
            if(entrada instanceof DocumentoIngreso){
                if (((DocumentoIngreso) entrada).getProveedor().equals(proveedor)) {
                    System.out.println(entrada);
                }
            }

        }
        throw new ExceptionProveedorNoEncontrado();
    }

    public Documento ClientexSalida(String cliente)throws ExceptionClienteNoEncontrado{
        for (int i=0 ;i<cantidadDocumentos; i++){
            Documento salida= documentoss[i];
            if(salida instanceof DocumentSalida){
                if (((DocumentSalida) salida).getCliente().equals(cliente)) {
                    System.out.println(salida);
                }
            }/*else {
                throw new ExceptionProveedorNoEncontrado();
            }*/

        }
        throw new ExceptionClienteNoEncontrado();
    }

    public Documento DocumentoxUsuario(String usuario) throws ExceptionUsuarioNoExiste{
        for (int i=0 ;i<cantidadDocumentos; i++){
            if(documentoss[i].getUsuario().getNombres().equals(usuario)){
                System.out.println(documentoss[i]);
            }
        }
        throw new ExceptionUsuarioNoExiste();
    }

    public Documento MayorCantidadxSalida(){
        double mayorPuntaje=0;
        Documento mayocantidad=null;
        for(Documento document:documentoss){
            if(document instanceof DocumentSalida){
                if(document.getItem().getCantidad()>mayorPuntaje){
                    mayorPuntaje=document.getItem().getCantidad();
                    mayocantidad=document;
                }
            }
        }
        return mayocantidad;
    }

    public double ValorxIngreso(){
        double sumaIngreso=0;
        for (int i=0;i<cantidadDocumentos;i++){
            if(documentoss[i] instanceof DocumentoIngreso){
                sumaIngreso=sumaIngreso+documentoss[i].getItem().calcularValorEntrada();
            }
        }
        return sumaIngreso;
    }
    public double ValorxSalida(){
        double sumaSalida=0;
        for (int i=0;i<cantidadDocumentos;i++){
            if(documentoss[i] instanceof DocumentSalida){
                sumaSalida=sumaSalida+documentoss[i].getItem().calcularValorSalida();
            }
        }
        return sumaSalida;
    }




}
