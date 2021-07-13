package Store;

import Documents.Documento;
import Users.Usuario;
import Store.Producto;

public class Almacen {
   Usuario[] usuarioss;
    Producto[] productoss;
    Documento[] documentoss;
    int cantidadDocumentos;
    int cantidadProductos;
    int cantidadusuarios;
    static final int maxdocumentos=1000;
    static final int maxusuarios=5;
    static final int maxproductos=5;
    Item[] itemss;
    int cantidaditem;
    static final int maxitem=5;

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
    //public Almacen() {

    //}

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
}
