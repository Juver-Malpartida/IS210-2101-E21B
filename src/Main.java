import Documents.DocumentSalida;
import Documents.Documento;
import Documents.DocumentoIngreso;
import Store.*;
import Users.Usuario;
import Users.UsuarioAdministrador;
import Users.UsuarioAlmacenero;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {

        Almacen almacen= new Almacen();
        //Registrar Usuarios
        Usuario u1= new UsuarioAlmacenero("Alm001","Pedro","Garcia","12345678");
        Usuario u2= new UsuarioAlmacenero("Alm002","Juan","Lopez","45678944");
        Usuario u3=new UsuarioAlmacenero("Alm003","Ana","Huaman","89758454");
        Usuario u4=new UsuarioAdministrador("Adm001","Diego","Perez","57896542");
        Usuario u5=new UsuarioAdministrador("Adm002","Pietro","Gonzales","42352047");
        //Registrar Producto
        Producto p1 = new Producto("P001","Detergente",150,8,10);
        Producto p2 = new Producto("P002","Arroz",100,18,21);
        Producto p3 = new Producto("P003","Aceite",250,9.2,10);
        Producto p4 = new Producto("P004","Azucar",300,4,5.5);
        Producto p5 = new Producto("P005","Gaseosa",250,7,8.5);
        //Registrar ITEM
        Item item1=new Item("I001",p1,150);
        Item item2=new Item("I002",p2,100);
        Item item3=new Item("I003",p3,140);
        Item item4=new Item("I004",p4,110);
        Item item5=new Item("I005",p5,105);
        //Registrar Documentos
        Documento doc1= new DocumentoIngreso("DE001",u1,"15/01/2019",item1,"Provee1");
        Documento doc2= new DocumentoIngreso("DE002",u2,"11/04/2019",item5,"Provee2");
        Documento doc3= new DocumentoIngreso("DE003",u3,"11/01/2019",item4,"Provee3");
        Documento doc4= new DocumentSalida("DS001",u3,"10/01/2019",item3,"Clien1");
        Documento doc5= new DocumentSalida("DS002",u2,"19/03/2019",item2,"Clien2");
        Documento doc6= new DocumentSalida("DS003",u1,"20/07/2019",item1,"Clien3");
        almacen.registrar_Documentos(doc1);
        almacen.registrar_Documentos(doc2);
        almacen.registrar_Documentos(doc3);
        almacen.registrar_Documentos(doc4);
        almacen.registrar_Documentos(doc5);
        almacen.registrar_Documentos(doc6);
        almacen.registrar_usuario(u1);
        almacen.registrar_usuario(u2);
        almacen.registrar_usuario(u3);
        almacen.registrar_usuario(u4);
        almacen.registrar_usuario(u5);
        almacen.registrar_Producto(p1);
        almacen.registrar_Producto(p2);
        almacen.registrar_Producto(p3);
        almacen.registrar_Producto(p4);
        almacen.registrar_Producto(p5);

        System.out.println("Lista de Empleados");
        System.out.println("------------------");
        almacen.listarTrabajadores();
        System.out.println("\t");
        System.out.println("Lista de Producto");
        System.out.println("-----------------");
        almacen.listarProducto();
        System.out.println("\t");
        System.out.println("Lista de Documentos");
        System.out.println("-------------------");
        almacen.listarDocumentos();

        System.out.println("\t");
        System.out.println("Buscar x Nombre Producto");
        System.out.println("------------------------");
        try{
            almacen.buscarxproducto("Detergente");
        }catch (ExceptionProductoNoEncontrado ex){
            System.out.println("El Producto no Existe");
        }

        System.out.println("\t");
        System.out.println("Buscar x Codigo Producto");
        System.out.println("------------------------");
        try{
            almacen.buscarxproductoxcodigo("P005");
        }catch (ExceptionCodigoProductoNoEncontrado ex){
            System.out.println("El Producto no Existe");
        }

        System.out.println("\t");
        System.out.println("Buscar Productos en rango de fechas");
        System.out.println("------------------------");
        try{
            almacen.buscarProductosEnRango("Detergente", "01/01/2019", "24/07/2019");
        }catch (ExceptionProductoNoEncontrado ex){
            System.out.println("El Producto no Existe");
        }

        System.out.println("\t");
        System.out.println("Buscar Documentos x Usuario");
        System.out.println("---------------------------");
        try{
            almacen.DocumentoxUsuario("Juan");
        }catch (ExceptionUsuarioNoExiste ex){
            System.out.println("Nombre de Usuario No Existe");
        }

        System.out.println("\t");
        System.out.println("Buscar Por Proveedor");
        System.out.println("--------------------");
        try {
            almacen.ProveedorxIngreso("Provee1");
        }catch (ExceptionProveedorNoEncontrado ex1){
            System.out.println("Proveedor no encontrado");
        }
        System.out.println("\t");
        System.out.println("Buscar Por Cliente");
        System.out.println("------------------");
        try {
            almacen.ClientexSalida("Clien1");
        }catch (ExceptionClienteNoEncontrado ex1){
            System.out.println("Cliente no encontrado");
        }
        System.out.println("\t");
        System.out.println("Mayor Cantidad de Producto x Salida");
        System.out.println("-----------------------------------");
        Documento mayorproducto=almacen.MayorCantidadxSalida();
        System.out.println(mayorproducto);

        System.out.println("\t");
        System.out.println("La Suma de Compras de Productos");
        double sumaCompras=almacen.ValorxIngreso();
        System.out.println("El Total de Compra es: S/. "+ sumaCompras);
        System.out.println("La Suma de Ventas de Productos");
        double sumaVentas=almacen.ValorxSalida();
        System.out.println("El Total de Ventas es: S/. "+ sumaVentas);


    }
}
