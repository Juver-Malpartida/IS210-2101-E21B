package Store;

import Documents.DocumentSalida;
import Documents.Documento;
import Documents.DocumentoIngreso;
import Users.Usuario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

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

    public void buscarxproducto(String nom_prod) throws ExceptionProductoNoEncontrado {
        boolean encontrado = false;
        for(int i = 0; i < cantidadProductos;i++) {
            Producto producto = productoss[i];
            if (producto.getNombre_producto().equals(nom_prod)) {
                System.out.println(producto);
                encontrado = true;
            }
        }
        if (!encontrado) {
            throw new ExceptionProductoNoEncontrado();
        }
    }

    public void buscarxproductoxcodigo(String cod_prod) throws ExceptionCodigoProductoNoEncontrado {
        boolean encontrado = false;
            for(int i = 0; i < cantidadProductos;i++) {
                Producto producto = productoss[i];
                if (producto.getIdproducto().equals(cod_prod)) {
                    System.out.println(producto);
                    encontrado = true;
                }
            }
        if (!encontrado) {
            throw new ExceptionCodigoProductoNoEncontrado();
        }
    }

    public void buscarProductosEnRango(String nom_prod, String fechaInicio, String fechaFin) throws ExceptionProductoNoEncontrado {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setLenient(false);
        Date fechaInicioObj, fechaFinObj;
        try {
            fechaInicioObj = simpleDateFormat.parse( fechaInicio );
            fechaFinObj = simpleDateFormat.parse( fechaFin );
        } catch (ParseException e) {
            System.out.println("Fecha invalida. El formato es dd/MM/yyyy");
            return;
        }

        if (fechaFinObj.before(fechaInicioObj)) {
            System.out.println("Rango de fechas invalido. La fecha de inicio debe ser menor que la fecha fin.");
        }

        boolean encontrado = false;
        for(int i = 0; i < cantidadDocumentos;i++) {
            Documento documento = documentoss[i];
            Producto producto = documento.getItem().getProducto();
            Date fechaDocumento = documento.getFecha();
            boolean isDocumentInRange = (fechaDocumento.before(fechaFinObj) || fechaDocumento.equals(fechaFinObj)) && (fechaDocumento.after(fechaInicioObj) || fechaDocumento.equals(fechaInicioObj));
            if (producto.getNombre_producto().equals(nom_prod) && isDocumentInRange) {
                System.out.println(documento);
                encontrado = true;
            }
        }
        if (!encontrado) {
            throw new ExceptionProductoNoEncontrado();
        }
    }

    public void ProveedorxIngreso(String proveedor)throws ExceptionProveedorNoEncontrado{
        boolean encontrado = false;
        for (int i=0 ;i<cantidadDocumentos; i++){
            Documento entrada= documentoss[i];
            if(entrada instanceof DocumentoIngreso){
                if (((DocumentoIngreso) entrada).getProveedor().equals(proveedor)) {
                    encontrado = true;
                    System.out.println(entrada);
                }
            }

        }
        if (!encontrado) {
            throw new ExceptionProveedorNoEncontrado();
        }
    }

    public void ClientexSalida(String cliente)throws ExceptionClienteNoEncontrado{
        boolean encontrado = false;
        for (int i=0 ;i<cantidadDocumentos; i++){
            Documento salida= documentoss[i];
            if(salida instanceof DocumentSalida){
                if (((DocumentSalida) salida).getCliente().equals(cliente)) {
                    encontrado = true;
                    System.out.println(salida);
                }
            }
        }
        if (!encontrado) {
            throw new ExceptionClienteNoEncontrado();
        }
    }

    public void DocumentoxUsuario(String usuario) throws ExceptionUsuarioNoExiste{
        boolean encontrado = false;
        for (int i=0 ;i<cantidadDocumentos; i++){
            if(documentoss[i].getUsuario().getNombres().equals(usuario)){
                encontrado = true;
                System.out.println(documentoss[i]);
            }
        }
        if (!encontrado) {
            throw new ExceptionUsuarioNoExiste();
        }
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
